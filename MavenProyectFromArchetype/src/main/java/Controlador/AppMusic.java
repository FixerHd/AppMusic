package Controlador;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;

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
	
	private static final String ESTILO_POR_DEFECTO = "com.jtattoo.plaf.texture.TextureLookAndFeel";

	private static AppMusic unicaInstancia;

	// Atributos compartidos
	private IAdaptadorUsuarioDAO adaptadorUsuario;
	private IAdaptadorCancionDAO adaptadorCancion;
	private IAdaptadorPlaylistDAO adaptadorPlaylist;
	
	private static String estilo = ESTILO_POR_DEFECTO;
	private ArrayList<JFrame> lista_ventanas = new ArrayList<JFrame>();
	private ArrayList<JPanel> lista_paneles = new ArrayList<JPanel>();

	private CatalogoUsuarios catalogoUsuarios;
	private CatalogoCanciones catalogoCanciones;

	public AppMusic() {
		inicializarAdaptadores(); // debe ser la primera linea para evitar error
		// de sincronización
		inicializarCatalogos();
	}

	public static AppMusic getUnicaInstancia() {
		if (unicaInstancia == null) {
			unicaInstancia = new AppMusic();
		}	
		return unicaInstancia;
	}
	
	public ArrayList<JPanel> getLista_paneles() {
		return lista_paneles;
	}
	
	public ArrayList<JFrame> getVentanas() {
		return lista_ventanas;
	}

	public static String getEstilo() {
		return estilo;
	}
	
	public void setEstilo(String estilo) {
		if (estilo.equals("Devil")) {
			
		} else {
			AppMusic.estilo = "com.jtattoo.plaf." + estilo.toLowerCase() + "." + estilo + "LookAndFeel";
			try {
				UIManager.setLookAndFeel(AppMusic.estilo);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		ventanas.Principal.getInstancia().setVisible(false);
		for (JFrame v : lista_ventanas) {
			v.revalidate();
			v.repaint();
		}
		ventanas.Principal.getInstancia().setVisible(true);
		
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

}
