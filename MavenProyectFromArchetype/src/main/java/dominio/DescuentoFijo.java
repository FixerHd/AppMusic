package dominio;

public class DescuentoFijo implements Descuento {

	@Override
	public double calcDescuento(double precio) {
		
		return precio*0.7;
	}

}
