package ventanas.Inicio;

import javax.swing.UIManager;

import Controlador.AppMusic;
import java.io.FileNotFoundException;
import java.net.MalformedURLException;

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