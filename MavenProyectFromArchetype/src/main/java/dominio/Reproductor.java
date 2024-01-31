package dominio;

public class Reproductor {

    private static Reproductor instancia;

    private Reproductor() {
    }

    public static Reproductor getUnicaInstancia() {
        if (instancia == null) {
            instancia = new Reproductor();
        }
        return instancia;
    }

    public void Play() {
    }
    
}

