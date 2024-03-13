package Controlador;

import java.awt.Container;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;

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

	// vestigio
	private ArrayList<JFrame> lista_ventanas = new ArrayList<JFrame>();

	private CatalogoUsuarios catalogoUsuarios;
	private CatalogoCanciones catalogoCanciones;
	private Usuario usuarioActivo;

	public AppMusic() {
		// Debe ser la primera linea para evitar error de sincronización
		inicializarAdaptadores();
		inicializarCatalogos();
	}

	public static AppMusic getUnicaInstancia() {
		if (unicaInstancia == null) {
			unicaInstancia = new AppMusic();
		}
		return unicaInstancia;
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
		nuevos_datos.getTitulos().add("fart1");
		nuevos_datos.getInterpretes().add("Visen");
		nuevos_datos.getEstilos().add("fart2");
		nuevos_datos.getFavoritas().add(false);
		// TODO Auto-generated method stub
		return nuevos_datos;
	}

	public DatosTabla buscarTendencias() {
		// La idea es devolver los datos dentro de la estructura de datos
		DatosTabla nuevos_datos = new DatosTabla();
		nuevos_datos.getTitulos().add("fart3");
		nuevos_datos.getInterpretes().add("Vicento");
		nuevos_datos.getEstilos().add("fart4");
		nuevos_datos.getFavoritas().add(false);
		// TODO Auto-generated method stub
		return nuevos_datos;
	}

	public DatosTabla buscarRecientes() {
		// La idea es devolver los datos dentro de la estructura de datos
		DatosTabla nuevos_datos = new DatosTabla();
		nuevos_datos.getTitulos().add("fart5");
		nuevos_datos.getInterpretes().add("Valentus");
		nuevos_datos.getEstilos().add("fart6");
		nuevos_datos.getFavoritas().add(true);
		// TODO Auto-generated method stub
		return nuevos_datos;
	}

	public DatosLista getMisPlaylists(boolean favoritas) {
		// La idea es devolver los nombres y los identificadores
		DatosLista nuevos_datos = new DatosLista();
		nuevos_datos.getNombres().add("farts");
		nuevos_datos.getIdentificadores().add("Visen");
		// TODO Auto-generated method stub
		return nuevos_datos;
	}

	public DatosTabla getPlaylist(String selectedValue) {
		// La idea es devolver los datos dentro de la estructura de datos
		DatosTabla nuevos_datos = new DatosTabla();
		nuevos_datos.getTitulos().add("fart7");
		nuevos_datos.getInterpretes().add("VicenVives");
		nuevos_datos.getEstilos().add("fart8");
		nuevos_datos.getFavoritas().add(false);
		// TODO Auto-generated method stub
		return nuevos_datos;
	}

	public boolean crearPDF() {
		// Se quiere crear un documento PDF 
		// TODO Auto-generated method stub
		return false;
	}

	public boolean existePlaylist(String playlist) {
		// El objetivo es buscar si el usuario activo tiene la playlist pasada por
		// parametro
		// TODO Auto-generated method stub
		return false;
	}

	public boolean añadirPlaylist(String titulo) {
		// Se quiere crea una nueva playlist con el titulo recivido en la lista de
		// playlists del usuario activo
		// TODO Auto-generated method stub
		return false;
	}

	public boolean eliminarPlaylist(String playlist) {
		// Se quiere eliminar la playlist con el titulo recivido de la lista de
		// playlists del usuario activo
		// TODO Auto-generated method stub
		return false;
	}

	public boolean eliminarCancionPlaylist(String titulo, String playlist) {
		// Se quiere eliminar la cancion con el titulo recivido de la playlist recivida
		// del usuario activo
		// TODO Auto-generated method stub
		return false;

	}

	public boolean actualizarPlaylist(String playlist, DatosTabla datos) {
		// Se quiere actualizar la playlist del usuario activo recivida con los datos
		// recividos
		// TODO Auto-generated method stub
		return false;
	}

	public void añadirCancionPlaylist(String playlist, Object valueAt) {
		// TODO Auto-generated method stub
		
	}
}
