package umu.tds.maven.apps.MavenProyectFromArchetype;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;



import dominio.*;

public class TestCatalogoUsuarios {

	 private CatalogoCanciones catalogo;
	    private Cancion cancion1;
	    private Cancion cancion2;

	    @Before
	    public void setUp() {


	        catalogo = CatalogoCanciones.getUnicaInstancia();

	        cancion1 = new Cancion("Song1", "ruta/ruta");
	        cancion2 = new Cancion("Song2", "ruta/ruta");

	        catalogo.addCancion(cancion1);
	        catalogo.addCancion(cancion2);
	    }

	    @Test
	    public void testGetUnicaInstancia() {
	        CatalogoCanciones catalogo2 = CatalogoCanciones.getUnicaInstancia();
	        assertSame(catalogo, catalogo2);
	    }

	    @Test
	    public void testGetCanciones() {
	        List<Cancion> canciones = catalogo.getCanciones();
	        assertTrue(canciones.contains(cancion1));
	        assertTrue(canciones.contains(cancion2));
	    }


	    @Test
	    public void testGetCancionByNombre() {
	        assertEquals(cancion1, catalogo.getCancion("Song1"));
	        assertEquals(cancion2, catalogo.getCancion("Song2"));
	    }

	    @Test
	    public void testAddCancion(){
	        Cancion cancion3 = new Cancion("Song3", "ruta/ruta");
	        catalogo.addCancion(cancion3);
	        assertEquals(cancion3, catalogo.getCancion("Song3"));
	    }

	    @Test
	    public void testRemoveCancion() {
	        catalogo.removeCancion(cancion1);
	        assertNull(catalogo.getCancion("Song1"));
	    }

}
