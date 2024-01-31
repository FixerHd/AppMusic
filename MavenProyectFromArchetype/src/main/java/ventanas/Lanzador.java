package ventanas;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import Controlador.AppMusic;

public class Lanzador {
	
	private static final String LAF = "com.jtattoo.plaf.hifi.HiFiLookAndFeel";
	private static final String ALT_LAF = "com.jtattoo.plaf.texture.TextureLookAndFeel";
	private static boolean alternativa = true;

	public static void main(String[] args) {
		if (alternativa) {
			try {
				UIManager.setLookAndFeel(ALT_LAF);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else {
			try {
				UIManager.setLookAndFeel(LAF);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		Selector frame = new Selector();
		frame.setVisible(true);
		AppMusic controlador = new AppMusic();
	}

}
