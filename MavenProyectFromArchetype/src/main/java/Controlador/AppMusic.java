package Controlador;

import java.awt.Container;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;
import java.util.stream.Collectors;
import java.util.Iterator;

import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.ListModel;
import javax.swing.UIManager;

import Utilidades.Constantes;
import dominio.Cancion;
import dominio.Playlist;
import dominio.CatalogoCanciones;
import dominio.CatalogoUsuarios;
import dominio.DatosLista;
import dominio.DatosTabla;
import dominio.Usuario;
import persistencia.DAOException;
import persistencia.FactoriaDAO;
import persistencia.IAdaptadorUsuarioDAO;
import ventanas.Login;
import persistencia.IAdaptadorCancionDAO;
import persistencia.IAdaptadorPlaylistDAO;

public class AppMusic {

	private static AppMusic unicaInstancia;

	// Atributos compartidos
	private IAdaptadorUsuarioDAO adaptadorUsuario;
	private IAdaptadorCancionDAO adaptadorCancion;
	private IAdaptadorPlaylistDAO adaptadorPlaylist;

	private static String estilo = Constantes.ESTILO_POR_DEFECTO;
	public ReentrantLock playLock = new ReentrantLock();

	// vestigio
	private ArrayList<JFrame> lista_ventanas = new ArrayList<JFrame>();

	private CatalogoUsuarios catalogoUsuarios;
	private CatalogoCanciones catalogoCanciones;
	private Usuario usuarioActivo;

	public AppMusic() {
		// Debe ser la primera linea para evitar error de sincronización
		inicializarAdaptadores();
		inicializarCatalogos();
		//playLock.unlock();
	}

	public static AppMusic getUnicaInstancia() {
		if (unicaInstancia == null) {
			unicaInstancia = new AppMusic();
		}
		return unicaInstancia;
	}
	
	public ReentrantLock getPlayLock() {
		return playLock;
	}

	public ArrayList<JFrame> getVentanas() {
		return lista_ventanas;
	}

	public static String getEstilo() {
		return estilo;
	}

	public void setEstilo(String estilo) {

		// Si el estilo eslegido es el acutal, no hacer nada
		if (estilo.equals(AppMusic.estilo)) {
		} else {

			// Se elimina la instancia de la ventana Principal
			ventanas.Principal.getInstancia().removeInstancia();

			// Se filtran los estilos manualmente.
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
			ventanas.Principal.getInstancia().setVisible(true);
		}

	}

	public void registrarUsuario(Usuario Usuario) {
		adaptadorUsuario.registrarUsuario(Usuario);
		catalogoUsuarios.addUsuario(Usuario);
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
		return catalogoUsuarios.exists(usuario, contraseña);
	}

	public boolean verficarUsuarioGit(String usuario, String contraseña) {
		// TODO Auto-generated method stub
		return false;
	}

	public int registrarUsuario(String usuario, String email, String contraseña, String fecha, String nombre_completo) {
		// Prueba tonta, comprobar las constantes en "ventanas.Constantes"
		int resultado = Constantes.OKAY;
		catalogoUsuarios.addUsuario(usuario, email, contraseña, fecha);
		// TODO Auto-generated method stub
		return resultado;
	}

	public void showPopup(Container container, String mensaje) {
		JOptionPane.showMessageDialog(container, mensaje, Constantes.NOMBRE_APLICACION, JOptionPane.INFORMATION_MESSAGE,
				null);
	}

	public DatosTabla buscarCanciones(String titulo, String interprete, Object estilo, boolean favoritas) {
		// La idea es devolver los datos dentro de la estructura de datos
		DatosTabla nuevos_datos = new DatosTabla();
		/* 
		nuevos_datos.getTitulos().add("fart1");
		nuevos_datos.getInterpretes().add("Visen");
		nuevos_datos.getEstilos().add("fart2");
		nuevos_datos.getFavoritas().add(false);
		*/
		catalogoCanciones.getCanciones().forEach(c -> {
			if (c.getTitulo().contains(titulo) && c.getInterprete().contains(interprete)
					&& c.getEstilomusical().contains((String) estilo) && c.isFavorita() == favoritas) {
				nuevos_datos.getTitulos().add(c.getTitulo());
				nuevos_datos.getInterpretes().add(c.getInterprete());
				nuevos_datos.getEstilos().add(c.getEstilomusical());
				nuevos_datos.getFavoritas().add(c.isFavorita());
			}
		});
		// TODO Auto-generated method stub
		return nuevos_datos;
	}

	public DatosTabla buscarTendencias() {
		// La idea es devolver los datos dentro de la estructura de datos
		DatosTabla nuevos_datos = new DatosTabla();
		/* 
		nuevos_datos.getTitulos().add("fart3");
		nuevos_datos.getInterpretes().add("Valentus");
		nuevos_datos.getEstilos().add("fart4");
		nuevos_datos.getFavoritas().add(true);
		*/
		List<Cancion> cancionesOrdenadas = catalogoCanciones.cancionesOrdenadas();

		for (Cancion c : cancionesOrdenadas) {
    	nuevos_datos.getTitulos().add(c.getTitulo());
    	nuevos_datos.getInterpretes().add(c.getInterprete());
    	nuevos_datos.getEstilos().add(c.getEstilomusical());
    	nuevos_datos.getFavoritas().add(c.isFavorita());
		}

		return nuevos_datos;

	}

	public DatosTabla buscarRecientes() {
		// La idea es devolver los datos dentro de la estructura de datos
		DatosTabla nuevos_datos = new DatosTabla();
		/* 
		nuevos_datos.getTitulos().add("fart5");
		nuevos_datos.getInterpretes().add("Valentus");
		nuevos_datos.getEstilos().add("fart6");
		nuevos_datos.getFavoritas().add(true);
		*/
		for(Playlist p : usuarioActivo.getPlaylists()){
			if(p.getNombre().equals("recientes")){
				for(Cancion c : p.getCanciones()){
					nuevos_datos.getTitulos().add(c.getTitulo());
					nuevos_datos.getInterpretes().add(c.getInterprete());
					nuevos_datos.getEstilos().add(c.getEstilomusical());
					nuevos_datos.getFavoritas().add(c.isFavorita());
				}
				break;
			}
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
		/* 
		nuevos_datos.getNombres().add("farts");
		nuevos_datos.getIdentificadores().add("Visen");
		*/
		for(Playlist p : usuarioActivo.getPlaylists()){
			nuevos_datos.getNombres().add(p.getNombre());
			nuevos_datos.getIdentificadores().add(Integer.valueOf(p.getId()).toString());
		}
		// TODO Auto-generated method stub
		return nuevos_datos;
	}

	public DatosTabla getPlaylist(String selectedValue) {
		// La idea es devolver los datos dentro de la estructura de datos
		DatosTabla nuevos_datos = new DatosTabla();
		/*
		nuevos_datos.getTitulos().add("fart7");
		nuevos_datos.getInterpretes().add("VicenVives");
		nuevos_datos.getEstilos().add("fart8");
		nuevos_datos.getFavoritas().add(false);
		 */
		for(Playlist p : usuarioActivo.getPlaylists()){
			if(p.getNombre().equals(selectedValue)){
				for(Cancion c : p.getCanciones()){
					nuevos_datos.getTitulos().add(c.getTitulo());
					nuevos_datos.getInterpretes().add(c.getInterprete());
					nuevos_datos.getEstilos().add(c.getEstilomusical());
					nuevos_datos.getFavoritas().add(c.isFavorita());
				}
				break;
			}
		}
		return nuevos_datos;
	}

	/**
	 * Creates a PDF document.
	 * @return true if the PDF document is created successfully, false otherwise.
	 */
	public boolean crearPDF() {
		// TODO: Implement PDF creation logic
		return false;
	}

	/**
	 * Checks if the active user has the specified playlist.
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
	 * Adds a new playlist with the specified title to the active user's playlist list.
	 * @param titulo The title of the playlist to add.
	 * @return true if the playlist is added successfully, false otherwise.
	 */
	public boolean añadirPlaylist(String titulo) {
		Playlist nuevaPlaylist = new Playlist(titulo);
		usuarioActivo.addPlaylist(nuevaPlaylist);
		return true;
	}

	public boolean eliminarPlaylist(String playlist) {
		// Se quiere eliminar la playlist con el titulo recibido de la lista de playlists del usuario activo
		Iterator<Playlist> iterator = usuarioActivo.getPlaylists().iterator();
		while (iterator.hasNext()) {
			Playlist p = iterator.next();
			if (p.getNombre().equals(playlist)) {
				iterator.remove();
				return true;
			}
		}
		return false;
	}

	public boolean eliminarCancionPlaylist(String titulo, String playlist) {
		// Se quiere eliminar la cancion con el titulo recivido de la playlist recivida
		// del usuario activo
		// TODO Auto-generated method stub
		for(Playlist p : usuarioActivo.getPlaylists()){
			if(p.getNombre().equals(playlist)){
				Iterator<Cancion> iterator = p.getCanciones().iterator()
				while (iterator.hasNext()) {
					Cancion c = iterator.next();
					if (c.getTitulo().equals(titulo)) {
						iterator.remove();
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
		// TODO Auto-generated method stub
		for(Playlist p : usuarioActivo.getPlaylists()){
			if(p.getNombre().equals(playlist)){
				datos.getTitulos().clear();
				datos.getEstilos().clear();
				datos.getInterpretes().clear();
				datos.getFavoritas().clear();
				for(Cancion c : p.getCanciones()){
					datos.getTitulos().add(c.getTitulo());
					datos.getInterpretes().add(c.getInterprete());
					datos.getEstilos().add(c.getEstilomusical());
					datos.getFavoritas().add(c.isFavorita());
				}
				break;
			}
		}
		return false;
	}

	public void añadirCancionPlaylist(String playlist, Object valueAt) {
		// TODO Auto-generated method stub
		for(Playlist p : usuarioActivo.getPlaylists()){
			if(p.getNombre().equals(playlist)){
				p.addCancion((Cancion)valueAt);
				}
				break;
			}
		}

}

