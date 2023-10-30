package dominio;

public class Cancion {
    private String titulo;
    private String rutaFichero;
    private int numReproducciones;
    private EstiloMusical est;

    public Cancion(String titulo, String rutaFichero, int numReproducciones) {
        this.titulo = titulo;
        this.rutaFichero = rutaFichero;
        this.numReproducciones = numReproducciones;
    
    }

 
}
