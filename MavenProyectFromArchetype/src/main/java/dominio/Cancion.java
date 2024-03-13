package dominio;

public class Cancion {
    private String titulo;
    private String rutaFichero;
    private int numReproducciones;
    private String estilomusical;
    private String interprete;
    private int id;
	private boolean favorita;

    public Cancion(String titulo, String rutaFichero) {
        this.titulo = titulo;
        this.rutaFichero = rutaFichero;
        this.numReproducciones = 0;
    
    }

	public void setEstilomusical(String estilomusical) {
		this.estilomusical = estilomusical;
	}

	public void setInterprete(String interprete) {
		this.interprete = interprete;
	}

	public void setId(int id) {
		this.id=id;
		
	}

	public void setnumReproducciones(int parseInt) {
		numReproducciones=parseInt;
		
	}

	public Integer getId() {
		// TODO Auto-generated method stub
		return id;
	}

	public String getTitulo() {
		// TODO Auto-generated method stub
		return titulo;
	}

	public String getrutaFichero() {
		// TODO Auto-generated method stub
		return rutaFichero;
	}

	public int getnumReproducciones() {
		// TODO Auto-generated method stub
		return numReproducciones;
	}

	public String getInterprete() {
		return interprete;
	}

	public String getEstilomusical() {
		return estilomusical;
	}

    public Boolean isFavorita() {
        return favorita;
    }

    public void setFavorita(Boolean valueOf) {
        favorita=valueOf;
    }

 
}
