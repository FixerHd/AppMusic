package dominio;

import java.util.ArrayList;

public class DatosTabla {

	private ArrayList<String> titulos = new ArrayList<String>();
	private ArrayList<String> interpretes = new ArrayList<String>();
	private ArrayList<String> estilos = new ArrayList<String>();
	private ArrayList<Boolean> favoritas = new ArrayList<Boolean>();
	private ArrayList<String> ids = new ArrayList<String>();
	
	public ArrayList<String> getIds() {
		return ids;
	}
	public void setIds(ArrayList<String> ids) {
		this.ids = ids;
	}
	public ArrayList<String> getTitulos() {
		return titulos;
	}
	public void setTitulos(ArrayList<String> titulos) {
		this.titulos = titulos;
	}
	public ArrayList<String> getInterpretes() {
		return interpretes;
	}
	public void setInterpretes(ArrayList<String> interpretes) {
		this.interpretes = interpretes;
	}
	public ArrayList<String> getEstilos() {
		return estilos;
	}
	public void setEstilos(ArrayList<String> estilos) {
		this.estilos = estilos;
	}
	public ArrayList<Boolean> getFavoritas() {
		return favoritas;
	}
	public void setFavoritas(ArrayList<Boolean> favoritas) {
		this.favoritas = favoritas;
	}
}
