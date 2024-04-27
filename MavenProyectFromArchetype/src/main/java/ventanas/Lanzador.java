package ventanas;


import javax.swing.UIManager;

import Controlador.AppMusic;
import dominio.Reproductor;
import umu.tds.componente.MapperCancionesXMLtoJava;
import umu.tds.test.TestPlay;
import java.io.File;
import java.io.FileNotFoundException;
import java.net.MalformedURLException;
import java.net.URL;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

public class Lanzador {

	public static void main(String[] args) throws FileNotFoundException, MalformedURLException {
		
		String tempPath = System.getProperty("user.dir");
		
		MapperCancionesXMLtoJava.cargarCanciones(tempPath + "/canciones.xml");
		
		//Reproductor.getUnicaInstancia().playCancion("https://dn720300.ca.archive.org/0/items/va-caribe-mix-ibiza-2015-2015/04.%20Amador%20Rivas%20-%20Mandanga%20Style%20%28Jose%20AM%20%26%20Albert%20Kick%20Remix%29.mp3");
		
		String estilo = "com.jtattoo.plaf." + AppMusic.getEstilo().toLowerCase() + "." + AppMusic.getEstilo()
				+ "LookAndFeel";
		try {
			UIManager.setLookAndFeel(estilo);
		} catch (Exception e) {
			e.printStackTrace();
		}
		Selector.getInstancia().setVisible(true);
		
		
	
	}

}