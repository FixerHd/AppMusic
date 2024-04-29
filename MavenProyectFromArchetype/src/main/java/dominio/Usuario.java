package dominio;

import java.util.LinkedList;

public class Usuario {
	private int id;
	private String nombre;
	private String email;
	private String password;
	private String fechaNacimiento;
	private boolean premium;
	private LinkedList<Playlist> playlists;
	private Descuento desc;
	private Playlist recientes;

	public Usuario(String nombre, String email, String contraseña, String fechanac) {
		this.nombre = nombre;
		this.email = email;
		this.password = contraseña;
		this.fechaNacimiento = fechanac;
		premium = false;
		playlists = new LinkedList<Playlist>();
		recientes = new Playlist("Recientes");
	}

	public void realizarPago() {
		premium = true;
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
		recientes = playlists.get(0);
	}

	public void AnadirRecientes(Cancion c) {
		recientes.addCancion(c);

	}

	public void setRecientes(Playlist recientes) {
		this.recientes = recientes;
	}

	public Playlist getRecientes() {
		return recientes;
	}

	public Descuento getDesc() {
		return desc;
	}

	public void setDesc(Descuento desc) {
		this.desc = desc;
	}

}
