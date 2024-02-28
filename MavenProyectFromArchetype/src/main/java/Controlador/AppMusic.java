package Controlador;

import java.awt.Container;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

import Utilidades.Constantes;
import dominio.Cancion;
import dominio.Playlist;
import dominio.CatalogoCanciones;
import dominio.CatalogoUsuarios;
import dominio.Usuario;
import persistencia.DAOException;
import persistencia.FactoriaDAO;
import persistencia.IAdaptadorUsuarioDAO;
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
		int resultado = Constantes.ERROR_REGISTRO_CAMPOS;
		if (usuario.compareTo("a") == 0) {
			resultado = Constantes.OKAY;
		}
		// TODO Auto-generated method stub
		return resultado;
	}

	public void showPopup(Container container, String mensaje) {
		JOptionPane.showMessageDialog(container, mensaje, Constantes.NOMBRE_APLICACION, JOptionPane.INFORMATION_MESSAGE, null);
	}

	public Object buscarCanciones(String interprete, String titulo, Object estilo, boolean favoritas) {
		// TODO Auto-generated method stub
		return null;
	}

}
