package dominio;

import java.util.LinkedList;

public class Playlist {
	private String nombre;
	private int id;
	private LinkedList<Cancion> canciones;

	public Playlist(String nombre) {
		this.nombre = nombre;
		this.canciones = new LinkedList<Cancion>();
	}

	public LinkedList<Cancion> getCanciones() {
		return canciones;
	}

	public void addCancion(Cancion cancion) {
		canciones.add(cancion);
	}

	public void setCanciones(String canciones2) {
		// TODO Auto-generated method stub

	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setCanciones(LinkedList<Cancion> canciones) {
		this.canciones = canciones;
	}

	public void eliminarUltimaCancion() {
		canciones.removeLast();
	}

	public void borrarCanciones() {
		canciones.removeAll(canciones);
	}



}
