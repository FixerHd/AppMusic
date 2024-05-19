package dominio;

import java.util.ArrayList;

public class DatosTabla {

	private ArrayList<String> titulos = new ArrayList<String>();
	private ArrayList<String> interpretes = new ArrayList<String>();
	private ArrayList<String> estilos = new ArrayList<String>();
	private ArrayList<Integer> ids = new ArrayList<Integer>();
	
	public ArrayList<Integer> getIds() {
		return ids;
	}
	public void setIds(ArrayList<Integer> ids) {
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
}
