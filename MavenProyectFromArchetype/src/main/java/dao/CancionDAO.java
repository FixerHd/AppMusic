package dao;

import java.util.List;

import dominio.Cancion;

public interface CancionDAO {
	
	void create(Cancion cancion);
	boolean delete(Cancion cancion);
	void update(Cancion cancion);
	Cancion get(int id);
	List<Cancion> getAll();
	
}
