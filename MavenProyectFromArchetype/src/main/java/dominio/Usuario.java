package dominio;

import java.util.HashSet;

public class Usuario {
	private int id;
    private String nombre;
    private String email;
    private String password;
    private String fechaNacimiento;
    private boolean premium;
    private HashSet<Playlist> playlists;
    private Descuento desc;


    public Usuario(String nombre, String email, String contraseña, String fechanac) {
        this.nombre = nombre;
        this.email = email;
        this.password = contraseña;
        this.fechaNacimiento = fechanac;
        premium=false;
        playlists=new HashSet<Playlist>();
    }


    public void realizarPago() {
    	premium=true;
    }
    
    public void addPlaylist(Playlist p) {
    	playlists.add(p);
    }


	public String getNombre() {
		// TODO Auto-generated method stub
		return null;
	}


	public String getEmail() {
		// TODO Auto-generated method stub
		return null;
	}


	public String getPassword() {
		// TODO Auto-generated method stub
		return null;
	}


	public String getPlayliststoEntity() {
		// TODO Auto-generated method stub
		return null;
	}


	public String getFechaNacimiento() {
		// TODO Auto-generated method stub
		return null;
	}


	public String getPremium() {
		// TODO Auto-generated method stub
		return null;
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}


}

