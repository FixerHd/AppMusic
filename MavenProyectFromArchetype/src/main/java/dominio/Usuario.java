package dominio;

import java.util.HashSet;

public class Usuario {
    private String nombre;
    private String email;
    private String contraseña;
    private String fechanac;
    private boolean premium;
    private HashSet<Playlist> playlists;
    private Descuento desc;


    public Usuario(String nombre, String email, String contraseña, String fechanac) {
        this.nombre = nombre;
        this.email = email;
        this.contraseña = contraseña;
        this.fechanac = fechanac;
        premium=false;
        playlists=new HashSet<Playlist>();
    }


    public void realizarPago() {
    	premium=true;
    }
    
    public void addPlaylist(Playlist p) {
    	playlists.add(p);
    }


}

