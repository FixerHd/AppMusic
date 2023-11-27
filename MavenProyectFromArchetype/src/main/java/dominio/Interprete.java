package dominio;

import java.util.HashSet;

public class Interprete {
	
	private String nombre;
	
	public Interprete(String name) {
		nombre=name;
	}
	
	public HashSet<Cancion> getCanciones() {
		return AppMusic.getCancionesInterprete(this);
	}

}
