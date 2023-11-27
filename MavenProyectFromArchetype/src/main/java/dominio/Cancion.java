package dominio;

public class Cancion {
    private String titulo;
    private String rutaFichero;
    private int numReproducciones;
    private EstiloMusical est;
    private int id;

    public Cancion(String titulo, String rutaFichero) {
        this.titulo = titulo;
        this.rutaFichero = rutaFichero;
        this.numReproducciones = 0;
    
    }

	public void setId(int id) {
		this.id=id;
		
	}

	public void setnumReproducciones(int parseInt) {
		numReproducciones=parseInt;
		
	}

 
}
