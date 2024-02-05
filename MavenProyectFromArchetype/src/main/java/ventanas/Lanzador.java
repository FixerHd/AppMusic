package ventanas;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import Controlador.AppMusic;

public class Lanzador {

	public static void main(String[] args) {

		AppMusic.getUnicaInstancia().setEstilo(AppMusic.getEstilo());
		Selector.getInstancia().setVisible(true);
	}

}
