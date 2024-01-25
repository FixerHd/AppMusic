package Controlador;

import java.util.Date;
import java.util.List;

import javax.swing.JFrame;

import dominio.Cancion;
import dominio.Playlist;
import dominio.RepositorioCanciones;
import dominio.RepositorioUsuarios;
import dominio.Usuario;
import persistencia.DAOException;
import persistencia.FactoriaDAO;
import persistencia.IAdaptadorUsuarioDAO;
import persistencia.IAdaptadorCancionDAO;
import persistencia.IAdaptadorPlaylistDAO;

public class AppMusic {
	
	private static AppMusic unicaInstancia;

	// Atributos compartidos
	private JFrame Login;
	private JFrame LoginGit;
	private JFrame Registro;
	private JFrame Selector;
	private JFrame Principal;
	private JFrame PlaylistnaActual;
	
	private IAdaptadorUsuarioDAO adaptadorUsuario;
	private IAdaptadorCancionDAO adaptadorCancion;
	private IAdaptadorPlaylistDAO adaptadorPlaylist;

	private RepositorioUsuarios catalogoUsuarios;
	private RepositorioCanciones catalogoCanciones;

	private AppMusic() {
		inicializarAdaptadores(); // debe ser la primera linea para evitar error
		  // de sincronización
		inicializarCatalogos();
	}
	
	public void Iniciarventanas(JFrame Login, JFrame LoginGit, JFrame Registro, JFrame Selector, JFrame Principal) {
		this.Login = Login;
		this.LoginGit = LoginGit;
		this.Registro = Registro;
		this.Selector = Selector;
		this.Principal = Principal;
		this.PlaylistnaActual = this.Selector;
	}
	
	public static AppMusic getUnicaInstancia() {
		if (unicaInstancia == null)
			unicaInstancia = new AppMusic();
		return unicaInstancia;
	}

	public void cambiar_Playlistna(String Playlistna) {
		PlaylistnaActual.setVisible(false);
		switch (Playlistna) {
		case "Login":
			PlaylistnaActual = Login;
			break;
		case "LoginGit":
			PlaylistnaActual = LoginGit;
			break;
		case "Registro":
			PlaylistnaActual = Registro;
			break;
		case "Selector":
			PlaylistnaActual = Selector;
			break;
		case "Principal":
			PlaylistnaActual = Principal;
			break;
		default:
			// TODO: Error
			break;
		}
		PlaylistnaActual.setVisible(true);
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
		catalogoUsuarios = RepositorioUsuarios.getUnicaInstancia();
		catalogoCanciones = RepositorioCanciones.getUnicaInstancia();
	}

	public boolean existeUsuario(String nombre) {
		return RepositorioUsuarios.getUnicaInstancia().getUsuario(nombre) != null;
	}

	public List<Cancion> getCanciones() {
		return catalogoCanciones.getCanciones();
	}
	public List<Usuario> getUsuarios() {
		return catalogoUsuarios.getUsuarios();
	}

}
