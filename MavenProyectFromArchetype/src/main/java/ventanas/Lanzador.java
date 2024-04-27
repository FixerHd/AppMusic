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