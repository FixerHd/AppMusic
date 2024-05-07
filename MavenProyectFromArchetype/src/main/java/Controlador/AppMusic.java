package Controlador;

import java.awt.Container;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Iterator;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

import org.kohsuke.github.GHUser;
import org.kohsuke.github.GitHub;
import org.kohsuke.github.GitHubBuilder;

import Utilidades.Constantes;
import Utilidades.CargadorCanciones;
import dominio.Cancion;
import dominio.Playlist;
import dominio.Reproductor;
import dominio.CatalogoCanciones;
import dominio.CatalogoUsuarios;
import dominio.DatosLista;
import dominio.DatosTabla;
import dominio.Descuento;
import dominio.DescuentoFijo;
import dominio.DescuentoJovenes;
import dominio.Usuario;
import persistencia.DAOException;
import persistencia.FactoriaDAO;
import persistencia.IAdaptadorUsuarioDAO;
import ventanas.PlayNotificationService;
import persistencia.IAdaptadorCancionDAO;
import persistencia.IAdaptadorPlaylistDAO;

import java.io.FileOutputStream;

import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

public class AppMusic {

	private static AppMusic unicaInstancia;

	// Atributos compartidos
	private IAdaptadorUsuarioDAO adaptadorUsuario; // No se utiliza actualmente
	private IAdaptadorCancionDAO adaptadorCancion;
	private IAdaptadorPlaylistDAO adaptadorPlaylist;

	private static String estilo = Constantes.ESTILO_POR_DEFECTO;

	// vestigio
	private ArrayList<JFrame> ventanasActivas = new ArrayList<JFrame>();

	private CatalogoUsuarios catalogoUsuarios;
	private CatalogoCanciones catalogoCanciones;
	private Usuario usuarioActivo;

	public Usuario getUsuarioActivo() {
		return usuarioActivo;
	}

	private PlayNotificationService playService = new PlayNotificationService();

	public AppMusic() {
		// Debe ser la primera linea para evitar error de sincronización
		inicializarAdaptadores();
		inicializarCatalogos();
		try {
			CargadorCanciones.INSTANCE.cargarCanciones();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static AppMusic getUnicaInstancia() {
		if (unicaInstancia == null) {
			unicaInstancia = new AppMusic();
		}
		return unicaInstancia;
	}

	public PlayNotificationService getPlayService() {
		return playService;
	}

	public ArrayList<JFrame> getVentanas() {
		return ventanasActivas;
	}

	public String getEstilo() {
		return estilo;
	}

	public void setEstilo(String estilo) {

		// Si el estilo eslegido es el acutal, no hacer nada
		if (estilo.equals(AppMusic.estilo)) {
		} else {

			// Se eliminan todas las instancias de las ventanas
			limpiarVentanas();

			if (estilo.equals("Devil")) { // Estilos especiales
				// TODO
			} else { // Estilos normales
				AppMusic.estilo = estilo;
				estilo = "com.jtattoo.plaf." + estilo.toLowerCase() + "." + estilo + "LookAndFeel";
				try {
					UIManager.setLookAndFeel(estilo);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			// Y se vuelve a crear la instancia, pero ahora con el nuevo estilo seleccionado
			mostrarVentanaPrincipal();
		}
	}

	public void limpiarVentanas() {
		// Se incluyen manualmente debido a problemas de herencia
		ventanas.Principal.getInstancia().removeInstancia();
		ventanas.Inicio.Selector.getInstancia().removeInstancia();
		ventanas.Inicio.Login.getInstancia().removeInstancia();
		ventanas.Inicio.LoginGit.getInstancia().removeInstancia();
		ventanas.Inicio.Registro.getInstancia().removeInstancia();
	}

	public void mostrarVentanaPrincipal() {
		limpiarVentanas();
		ventanas.Principal.getInstancia().setVisible(true);
	}

	public void registrarCancion(Cancion Cancion) {
		adaptadorCancion.registrarCancion(Cancion);

		catalogoCanciones.addCancion(Cancion);
	}

	public void registrarPlaylist(Playlist Playlist) {

		adaptadorPlaylist.registrarPlaylist(Playlist);
	}

	private void inicializarAdaptadores() {
		FactoriaDAO factoria = null;
		try {
			factoria = FactoriaDAO.getInstancia(FactoriaDAO.DAO_TDS);
		} catch (DAOException e) {
			e.printStackTrace();
		}
		adaptadorUsuario = factoria.getUsuarioDAO();
		adaptadorCancion = factoria.getCancionDAO();
		adaptadorPlaylist = factoria.getPlaylistDAO();
	}

	private void inicializarCatalogos() {
		catalogoUsuarios = CatalogoUsuarios.getUnicaInstancia();
		catalogoCanciones = CatalogoCanciones.getUnicaInstancia();
	}

	public boolean existeUsuario(String nombre) {
		return CatalogoUsuarios.getUnicaInstancia().getUsuario(nombre) != null;
	}

	public List<Cancion> getCanciones() {
		return catalogoCanciones.getCanciones();
	}

	public List<Usuario> getUsuarios() {
		return catalogoUsuarios.getUsuarios();
	}

	public boolean verficarUsuario(String usuario, String contraseña) {
		usuarioActivo = catalogoUsuarios.exists(usuario, contraseña);
		return usuarioActivo != null;
	}

	public boolean verficarUsuarioGit(String usuario, String contraseña) {
		try {
			GitHub github = GitHubBuilder.fromEnvironment().build();

			if (github.isCredentialValid()) {
				GHUser ghuser = github.getMyself();
				System.out.println("Validado! " + ghuser.getLogin());
				System.out.println("¿Login válido?: true");
				usuarioActivo = catalogoUsuarios.addUsuario(usuario, null, contraseña, null);

				return (ghuser.getLogin().equals(usuario) && github.isCredentialValid());
			}
			return false;

		} catch (IOException e) {
			e.printStackTrace();
		}

		return false;
	}

	public int registrarUsuario(String usuario, String email, String contraseña, Date fecha, String nombre_completo,
			String desc) {
		String s_fecha = fecha.toString();
		if (usuario.isEmpty() || email.isEmpty() || contraseña.isEmpty() || s_fecha.isEmpty()
				|| nombre_completo.isEmpty()) {
			return Constantes.ERROR_REGISTRO_CAMPOS;
		}
		if (usuario.equals("Usuario") || email.equals("Email") || contraseña.equals("Contraseña")
				|| fecha.equals("d MMM y") || nombre_completo.equals("Nombre completo")) {
			return Constantes.ERROR_REGISTRO_CAMPOS;
		}
		if (catalogoUsuarios.emailEnUso(email)) {
			return Constantes.ERROR_REGISTRO_CORREO;
		}
		if (fecha.after(new Date())) {
			return Constantes.ERROR_REGISTRO_FECHA;
		}
		Descuento descuento = null;
		if (desc == Utilidades.Constantes.DESCUENTOS[1]) {
			descuento = new DescuentoFijo();
		} else if (desc == Utilidades.Constantes.DESCUENTOS[2]) {
			descuento = new DescuentoJovenes();
		} else {
			return Constantes.ERROR_REGISTRO_DESCUENTO;
		}
		Usuario usuario2 = catalogoUsuarios.addUsuario(usuario, email, contraseña, s_fecha);
		setDescuentoUsuario(usuario2, descuento);
		return Constantes.OKAY;
	}

	public void showPopup(Container container, String mensaje) {
		JOptionPane.showMessageDialog(container, mensaje, Constantes.NOMBRE_APLICACION, JOptionPane.INFORMATION_MESSAGE,
				null);
	}

	public DatosTabla buscarCanciones(String titulo, String interprete, String estilo, boolean favorita) {
		// La idea es devolver los datos dentro de la estructura de datos
		DatosTabla nuevos_datos = new DatosTabla();
		catalogoCanciones.getCanciones().forEach(c -> {
			if (c.getTitulo().startsWith(titulo) && c.getInterprete().startsWith(interprete)) {
				if (c.getEstilomusical().isEmpty() || c.getEstilomusical() == estilo) {
					añadirDatosTabla(c, nuevos_datos);
				}
			}
		});
		return nuevos_datos;
	}

	public DatosTabla buscarTendencias() {
		DatosTabla nuevos_datos = new DatosTabla();
		List<Cancion> cancionesOrdenadas = catalogoCanciones.cancionesOrdenadas();

		cancionesOrdenadas.stream().limit(10).forEach(c -> {
			añadirDatosTabla(c, nuevos_datos);
		});

		return nuevos_datos;
	}

	public DatosTabla buscarRecientes() {
		DatosTabla nuevos_datos = new DatosTabla();
		for (Cancion c : usuarioActivo.getRecientes().getCanciones()) {
			añadirDatosTabla(c, nuevos_datos);
		}
		return nuevos_datos;
	}

	/**
	 * @param favoritas
	 * @return
	 */
	public DatosLista getMisPlaylists(boolean favoritas) {
		// La idea es devolver los nombres y los identificadores
		DatosLista nuevos_datos = new DatosLista();
		for (Playlist p : usuarioActivo.getPlaylists()) {
			nuevos_datos.getNombres().add(p.getNombre());
			nuevos_datos.getIdentificadores().add(Integer.valueOf(p.getId()).toString());
		}
		return nuevos_datos;
	}

	public DatosTabla getPlaylist(String selectedValue) {
		// La idea es devolver los datos dentro de la estructura de datos
		DatosTabla nuevos_datos = new DatosTabla();
		for (Playlist p : usuarioActivo.getPlaylists()) {
			if (p.getNombre().equals(selectedValue)) {
				for (Cancion c : p.getCanciones()) {
					añadirDatosTabla(c, nuevos_datos);
				}
				break;
			}
		}
		return nuevos_datos;
	}

	/**
	 * Creates a PDF document.
	 * 
	 * @return true if the PDF document is created successfully, false otherwise.
	 */
	public boolean crearPDF() {
		try {
			// Obtener el nombre del usuario activo
			String nombreUsuario = usuarioActivo.getNombre();

			// Crear el documento PDF
			Document document = new Document();
			PdfWriter.getInstance(document, new FileOutputStream(nombreUsuario + ".pdf"));
			document.open();

			// Agregar el título del documento
			Paragraph titulo = new Paragraph("Playlists de " + nombreUsuario);
			titulo.setAlignment(Element.ALIGN_CENTER);
			titulo.setSpacingAfter(20);
			document.add(titulo);

			// Recorrer las playlists del usuario activo
			for (Playlist playlist : usuarioActivo.getPlaylists()) {
				// Agregar el nombre de la playlist
				Paragraph nombrePlaylist = new Paragraph("Playlist: " + playlist.getNombre());
				nombrePlaylist.setSpacingAfter(10);
				document.add(nombrePlaylist);

				// Crear una tabla para mostrar las canciones de la playlist
				PdfPTable tablaCanciones = new PdfPTable(3);
				tablaCanciones.setWidthPercentage(100);
				tablaCanciones.setSpacingAfter(10);

				// Agregar encabezados de columna
				tablaCanciones.addCell("Título");
				tablaCanciones.addCell("Intérprete");
				tablaCanciones.addCell("Estilo");

				// Recorrer las canciones de la playlist
				for (Cancion cancion : playlist.getCanciones()) {
					tablaCanciones.addCell(cancion.getTitulo());
					tablaCanciones.addCell(cancion.getInterprete());
					tablaCanciones.addCell(cancion.getEstilomusical());
				}

				// Agregar la tabla de canciones al documento
				document.add(tablaCanciones);
			}

			// Cerrar el documento
			document.close();

			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	/**
	 * Checks if the active user has the specified playlist.
	 * 
	 * @param playlist The playlist to check.
	 * @return true if the active user has the playlist, false otherwise.
	 */
	public boolean existePlaylist(String playlist) {
		for (Playlist p : usuarioActivo.getPlaylists()) {
			if (p.getNombre().equals(playlist)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Adds a new playlist with the specified title to the active user's playlist
	 * list.
	 * 
	 * @param titulo The title of the playlist to add.
	 * @return true if the playlist is added successfully, false otherwise.
	 */
	public boolean añadirPlaylist(String titulo) {
		Playlist nuevaPlaylist = new Playlist(titulo);
		usuarioActivo.addPlaylist(nuevaPlaylist);
		adaptadorPlaylist.registrarPlaylist(nuevaPlaylist);
		return true;
	}

	public boolean eliminarPlaylist(String playlist) {
		// Se quiere eliminar la playlist con el titulo recibido de la lista de
		// playlists del usuario activo
		Iterator<Playlist> iterator = usuarioActivo.getPlaylists().iterator();
		while (iterator.hasNext()) {
			Playlist p = iterator.next();
			if (p.getNombre().equals(playlist)) {
				iterator.remove();
				adaptadorPlaylist.borrarPlaylist(p);
				return true;
			}
		}
		return false;
	}

	public boolean eliminarCancionPlaylist(String titulo, String playlist) {
		// Se quiere eliminar la cancion con el titulo recivido de la playlist recivida
		// del usuario activo
		for (Playlist p : usuarioActivo.getPlaylists()) {
			if (p.getNombre().equals(playlist)) {
				Iterator<Cancion> iterator = p.getCanciones().iterator();
				while (iterator.hasNext()) {
					Cancion c = iterator.next();
					if (c.getTitulo().equals(titulo)) {
						iterator.remove();
						adaptadorPlaylist.modificarPlaylist(p);
						return true;
					}
				}
			}
		}
		return false;
	}

	public boolean actualizarPlaylist(String playlist, DatosTabla datos) {
		// Se quiere actualizar la playlist del usuario activo recivida con los datos
		// recividos
		for (Playlist p : usuarioActivo.getPlaylists()) {
			if (p.getNombre().equals(playlist)) {
				limpiarPlaylist(datos);
				for (Cancion c : p.getCanciones()) {
					añadirDatosTabla(c, datos);
				}
				break;
			}
		}
		return false;
	}

	public void añadirCancionPlaylist(String playlist, Object valueAt) {
		for (Playlist p : usuarioActivo.getPlaylists()) {
			if (p.getNombre().equals(playlist)) {
				p.addCancion((Cancion) valueAt);
				adaptadorPlaylist.modificarPlaylist(p);
			}
			break;
		}
	}

	public String buscarRutaCancion(int id) {
		return catalogoCanciones.getCancion(id).getrutaFichero();
	}

	public boolean añadirCancion(String rutaFichero) {
		try {
			// Extraer el nombre del archivo de la ruta del fichero
			String nombreFichero = new java.io.File(rutaFichero).getName();

			// Dividir el nombre del archivo en el intérprete y el título
			String[] partes = nombreFichero.split("-");
			if (partes.length < 2) {
				throw new IllegalArgumentException("El nombre del fichero debe estar en formato interprete-titulo");
			}
			String interprete = partes[0].trim();
			String titulo = partes[1].trim();

			// Crear la nueva canción con el intérprete y el título
			Cancion nuevaCancion = new Cancion(rutaFichero, titulo);
			nuevaCancion.setInterprete(interprete);

			// Registrar la canción y añadirla al catálogo
			adaptadorCancion.registrarCancion(nuevaCancion);
			catalogoCanciones.addCancion(nuevaCancion);
		} catch (Exception e) {
			return false;
		}
		return false;
	}

	public boolean reproducircancion(String rutaFichero) {
		return Reproductor.getUnicaInstancia().playCancionFich(rutaFichero);
	}

	public boolean reproducircancionURL(String i) {
		return Reproductor.getUnicaInstancia().playCancion(i);
	}

	public boolean stopCancion() {
		return Reproductor.getUnicaInstancia().stopCancion();
	}

	public Descuento getDescuentoUsuario() {
		return usuarioActivo.getDesc();
	}

	public void setDescuentoUsuario(Usuario usuario, Descuento desc) {
		usuario.setDesc(desc);
	}

	public boolean limpiarPlaylist(DatosTabla datos) {
		try {
			datos.getTitulos().clear();
			datos.getEstilos().clear();
			datos.getInterpretes().clear();
			datos.getFavoritas().clear();
			datos.getIds().clear();
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	public boolean añadirDatosTabla(Cancion c, DatosTabla datos) {
		try {
			datos.getTitulos().add(c.getTitulo());
			datos.getInterpretes().add(c.getInterprete());
			datos.getEstilos().add(c.getEstilomusical());
			datos.getIds().add(c.getId());
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	public boolean isUsuarioActivoPremium() {
		return usuarioActivo.isPremium();
	}

	public boolean setUsuarioActivoPremium() {
		usuarioActivo.setPremiumtrue();
		return true;
	}

}
