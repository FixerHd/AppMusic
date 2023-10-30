package dominio;

public class DescuentoJovenes implements Descuento {

	@Override
	public double calcDescuento(double precio) {
		
		return precio*0.5;
	}

}
