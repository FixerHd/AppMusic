package persistencia;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

import tds.driver.FactoriaServicioPersistencia;
import tds.driver.ServicioPersistencia;
import beans.Entidad;
import beans.Propiedad;

import dominio.Usuario;
import dominio.Playlist;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;
import tds.driver.FactoriaServicioPersistencia;
import tds.driver.ServicioPersistencia;
import beans.Entidad;
import beans.Propiedad;
import dominio.Usuario;
import dominio.Playlist;

//Usa un pool para evitar problemas doble referencia con Playlists
public class AdaptadorUsuarioTDS implements IAdaptadorUsuarioDAO {
	private static ServicioPersistencia servPersistencia;
	private static AdaptadorUsuarioTDS unicaInstancia = null;

	public static AdaptadorUsuarioTDS getUnicaInstancia() { // patron singleton
		if (unicaInstancia == null)
			return new AdaptadorUsuarioTDS();
		else
			return unicaInstancia;
	}

	private AdaptadorUsuarioTDS() {
		servPersistencia = FactoriaServicioPersistencia.getInstance().getServicioPersistencia();
	}

	/* cuando se registra un Usuario se le asigna un identificador �nico */
	public void registrarUsuario(Usuario Usuario) {
		Entidad eUsuario = null;

		// Si la entidad esta registrada no la registra de nuevo
		try {
			eUsuario = servPersistencia.recuperarEntidad(Usuario.getId());
		} catch (NullPointerException e) {}
		if (eUsuario != null) return;

		// registrar primero los atributos que son objetos
		AdaptadorPlaylistTDS adaptadorPlaylist = AdaptadorPlaylistTDS.getUnicaInstancia();
		for (Playlist p : Usuario.getPlaylists())
			adaptadorPlaylist.registrarPlaylist(p);

		// crear entidad Usuario
		eUsuario = new Entidad();
		eUsuario.setNombre("Usuario");
		eUsuario.setPropiedades(new ArrayList<Propiedad>(
				Arrays.asList(new Propiedad("nombre", Usuario.getNombre()), new Propiedad("email", Usuario.getEmail()), new Propiedad("password", Usuario.getPassword()), new Propiedad("fechaNacimiento", Usuario.getFechaNacimiento()), new Propiedad("premium", Usuario.getPremium()),
						new Propiedad("playlists", obtenerIdPlaylist(Usuario.getPlaylists())), new Propiedad("recientes", obtenerIdPlaylistReciente(Usuario.getRecientes())))));

		// registrar entidad Usuario
		eUsuario = servPersistencia.registrarEntidad(eUsuario);
		// asignar identificador unico
		// Se aprovecha el que genera el servicio de persistencia
		Usuario.setId(eUsuario.getId());
	}

	public void borrarUsuario(Usuario Usuario) {
		// No se comprueban restricciones de integridad con Playlist
		Entidad eUsuario = servPersistencia.recuperarEntidad(Usuario.getId());

		servPersistencia.borrarEntidad(eUsuario);
	}

	public void modificarUsuario(Usuario Usuario) {

		Entidad eUsuario = servPersistencia.recuperarEntidad(Usuario.getId());

		for (Propiedad prop : eUsuario.getPropiedades()) {
			if (prop.getNombre().equals("Id")) {
				prop.setValor(String.valueOf(Usuario.getId()));
			} else if (prop.getNombre().equals("nombre")) {
				prop.setValor(Usuario.getNombre());
			} else if (prop.getNombre().equals("email")) {
				prop.setValor(Usuario.getEmail());
			} else if (prop.getNombre().equals("password")) {
				prop.setValor(Usuario.getEmail());
			} else if (prop.getNombre().equals("fechaNacimiento")) {
				prop.setValor(Usuario.getFechaNacimiento());
			} else if (prop.getNombre().equals("premium")) {
				prop.setValor(Usuario.getEmail());
			} else if (prop.getNombre().equals("playlists")) {
				String Playlists = obtenerIdPlaylist(Usuario.getPlaylists());
				prop.setValor(Playlists);
			}  else if (prop.getNombre().equals("recientes")) {
				String re = obtenerIdPlaylistReciente(Usuario.getRecientes());
				prop.setValor(re);
			}
			servPersistencia.modificarPropiedad(prop);
		}

	}

	public Usuario recuperarUsuario(int Id) {

		// Si la entidad est� en el pool la devuelve directamente
		if (PoolDAO.getUnicaInstancia().contiene(Id))
			return (Usuario) PoolDAO.getUnicaInstancia().getObjeto(Id);

		// si no, la recupera de la base de datos
		Entidad eUsuario;
		List<Playlist> Playlists = new LinkedList<Playlist>();
		Playlist recientes = new Playlist("Recientes");
		String nombre;
		String email;
		String password;
		String fechaNacimiento;
		String premium;

		// recuperar entidad
		eUsuario = servPersistencia.recuperarEntidad(Id);

		// recuperar propiedades que no son objetos
		nombre = servPersistencia.recuperarPropiedadEntidad(eUsuario, "nombre");
		email = servPersistencia.recuperarPropiedadEntidad(eUsuario, "email");
		password = servPersistencia.recuperarPropiedadEntidad(eUsuario, "password");
		fechaNacimiento = servPersistencia.recuperarPropiedadEntidad(eUsuario, "fechaNacimiento");
		premium = servPersistencia.recuperarPropiedadEntidad(eUsuario, "premium");


		Usuario Usuario = new Usuario(nombre, email, password, fechaNacimiento);
		Usuario.setId(Id);
		Usuario.setPremium(premium);

		// IMPORTANTE:a�adir el Usuario al pool antes de llamar a otros
		// adaptadores
		PoolDAO.getUnicaInstancia().addObjeto(Id, Usuario);

		// recuperar propiedades que son objetos llamando a adaptadores
		// Playlists
		Playlists = obtenerPlaylistsDesdeIds(servPersistencia.recuperarPropiedadEntidad(eUsuario, "playlists"));

		recientes = obtenerPlaylistRecienteDesdeId(servPersistencia.recuperarPropiedadEntidad(eUsuario, "recientes"));

		Usuario.setRecientes(recientes);

		for (Playlist v : Playlists)
			Usuario.addPlaylist(v);

		return Usuario;
	}

	public List<Usuario> recuperarTodosUsuarios() {

		List<Entidad> eUsuarios = servPersistencia.recuperarEntidades("Usuario");
		List<Usuario> Usuarios = new LinkedList<Usuario>();

		for (Entidad eUsuario : eUsuarios) {
			Usuarios.add(recuperarUsuario(eUsuario.getId()));
		}
		return Usuarios;
	}

	// -------------------Funciones auxiliares-----------------------------
	private String obtenerIdPlaylist(List<Playlist> listaPlaylist) {
		String aux = "";
		for (Playlist p : listaPlaylist) {
			aux += p.getId() + " ";
		}
		return aux.trim();
	}

	private String obtenerIdPlaylistReciente(Playlist p) {
		return Integer.toString(p.getId());
	}

	private Playlist obtenerPlaylistRecienteDesdeId(String Playlist) {
		AdaptadorPlaylistTDS adaptadorP = AdaptadorPlaylistTDS.getUnicaInstancia();
		if (Playlist != null) return adaptadorP.recuperarPlaylist(Integer.valueOf(Playlist));
		else return new Playlist("Recientes");
	}

	private List<Playlist> obtenerPlaylistsDesdeIds(String Playlists) {

		List<Playlist> listaPlaylists = new LinkedList<Playlist>();
		StringTokenizer strTok = new StringTokenizer(Playlists, " ");
		AdaptadorPlaylistTDS adaptadorP = AdaptadorPlaylistTDS.getUnicaInstancia();
		while (strTok.hasMoreTokens()) {
			listaPlaylists.add(adaptadorP.recuperarPlaylist(Integer.valueOf((String) strTok.nextElement())));
		}
		return listaPlaylists;
	}
}
