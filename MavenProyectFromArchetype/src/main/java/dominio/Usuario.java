package dominio;

import java.util.Date;
import java.util.LinkedList;

import Controlador.AppMusic;

public class Usuario {
	private int id;
    private String nombre;
    private String email;
    private String password;
    private String fechaNacimiento;
    private boolean premium;
    private LinkedList<Playlist> playlists;
    private Descuento desc;


    public Usuario(String nombre, String email, String contraseña, String fechanac) {
        this.nombre = nombre;
        this.email = email;
        this.password = contraseña;
        this.fechaNacimiento = fechanac;
        premium=false;
        playlists=new LinkedList<Playlist>();
    }


    public void realizarPago() {
    	premium=true;
    }
    
    public void addPlaylist(Playlist p) {
    	playlists.add(p);
    }


	public String getNombre() {
		// TODO Auto-generated method stub
		return nombre;
	}


	public String getEmail() {
		// TODO Auto-generated method stub
		return email;
	}


	public String getPassword() {
		// TODO Auto-generated method stub
		return password;
	}


	public LinkedList<Playlist> getPlaylists() {
		return playlists;
	}


	public String getFechaNacimiento() {
		// TODO Auto-generated method stub
		return fechaNacimiento;
	}


	public String getPremium() {
		// TODO Auto-generated method stub
		return Boolean.toString(premium);
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}


	public void setPremium(String premium2) {
		// TODO Auto-generated method stub
		premium = Boolean.valueOf(premium2);
	}
	
	public void setPlaylists(LinkedList<Playlist> playlists2) {
		// TODO Auto-generated method stub
		playlists = playlists2;
	}
	
	public void Registrarse() {
		playlists.add(new Playlist("recientes"));
		//chochon
	}
	
	public void AnadirRecientes(Cancion c) {
		playlists.get(0).addCancion(c);
		
	}



}

