package dao;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import tds.driver.FactoriaServicioPersistencia;
import tds.driver.ServicioPersistencia;
import dominio.Cancion;
import beans.Entidad;
import beans.Propiedad;

/**
 * 
 * Clase que implementa el Adaptador DAO concreto de Cancion para el tipo H2.
 * 
 */
public final class TDSCancionDAO implements CancionDAO {

	private static final String Cancion = "Cancion";

	private static final String TITULO = "titulo";
	private static final String RUTAFICHERO = "rutaFichero";
	private static final String NUMREPRODUCCIONES = "numReproducciones";

	private ServicioPersistencia servPersistencia;
	private SimpleDateFormat dateFormat;

	public TDSCancionDAO() {
		servPersistencia = FactoriaServicioPersistencia.getInstance().getServicioPersistencia();
	}

	private Cancion entidadToCancion(Entidad eCancion) {

		String titulo = servPersistencia.recuperarPropiedadEntidad(eCancion, TITULO);
		String rutaFichero = servPersistencia.recuperarPropiedadEntidad(eCancion, RUTAFICHERO);
		String numReproducciones = servPersistencia.recuperarPropiedadEntidad(eCancion, NUMREPRODUCCIONES);
		
		Cancion Cancion = new Cancion(titulo, rutaFichero);
		Cancion.setId(eCancion.getId());
		Cancion.setnumReproducciones(Integer.parseInt(numReproducciones));

		return Cancion;
	}

	private Entidad CancionToEntidad(Cancion Cancion) {
		Entidad eCancion = new Entidad();
		eCancion.settitulo(Cancion);

		eCancion.setPropiedades(new ArrayList<Propiedad>(Arrays.asList(new Propiedad(titulo, Cancion.gettitulo()),
				new Propiedad(rutaFichero, Cancion.getrutaFichero()),
				 new Propiedad(numReproducciones, Cancion.getnumReproducciones()),
				new Propiedad(FECHA_NACIMIENTO, Cancion.getFechaNacimiento()), new Propiedad(PREMIUM, Cancion.getPremium()), new Propiedad(PLAYLISTS, Cancion.getPlayliststoEntity()))));
		return eCancion;
	}

	public void create(Cancion Cancion) {
		Entidad eCancion = this.CancionToEntidad(Cancion);
		eCancion = servPersistencia.registrarEntidad(eCancion);
		Cancion.setId(eCancion.getId());
	}

	public boolean delete(Cancion Cancion) {
		Entidad eCancion;
		eCancion = servPersistencia.recuperarEntidad(Cancion.getId());

		return servPersistencia.borrarEntidad(eCancion);
	}

	/**
	 * Permite que un Cancion modifique su perfil: numReproducciones y rutaFichero
	 */
	public void update(Cancion Cancion) {
		Entidad eCancion = servPersistencia.recuperarEntidad(Cancion.getId());

		for (Propiedad prop : eCancion.getPropiedades()) {
			if (prop.gettitulo().equals(numReproducciones)) {
				prop.setValor(Cancion.getnumReproducciones());
			} else if (prop.gettitulo().equals(rutaFichero)) {
				prop.setValor(Cancion.getrutaFichero());
			} else if (prop.gettitulo().equals(titulo)) {
				prop.setValor(Cancion.gettitulo());
			} else if (prop.gettitulo().equals(FECHA_NACIMIENTO)) {
				prop.setValor(dateFormat.format(Cancion.getFechaNacimiento()));
			} else if (prop.gettitulo().equals(PREMIUM)) {
				prop.setValor(Cancion.getPremium());
			} else if (prop.gettitulo().equals(PLAYLISTS)) {
				prop.setValor((Cancion.getPlayliststoEntity()));
			}
			servPersistencia.modificarPropiedad(prop);
		}
	}

	public Cancion get(int id) {
		Entidad eCancion = servPersistencia.recuperarEntidad(id);

		return entidadToCancion(eCancion);
	}

	public List<Cancion> getAll() {
		List<Entidad> entidades = servPersistencia.recuperarEntidades(Cancion);

		List<Cancion> Cancions = new LinkedList<Cancion>();
		for (Entidad eCancion : entidades) {
			Cancions.add(get(eCancion.getId()));
		}

		return Cancions;
	}

}