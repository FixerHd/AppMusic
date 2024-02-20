package ventanas;

import javax.swing.UIManager;

import Controlador.AppMusic;

public class Lanzador {

	public static void main(String[] args) {

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