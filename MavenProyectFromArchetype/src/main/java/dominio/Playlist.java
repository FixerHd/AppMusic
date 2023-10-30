package dominio;

import java.util.HashSet;

public class Playlist {
    private String nombre;
    private HashSet<Cancion> canciones;

    public Playlist(String nombre) {
        this.nombre = nombre;
        this.canciones = new HashSet<Cancion>();
    }


    public HashSet<Cancion> getCanciones() {
        return canciones;
    }



    public void addCancion(Cancion cancion) {
        canciones.add(cancion);
    }
    
    
}
