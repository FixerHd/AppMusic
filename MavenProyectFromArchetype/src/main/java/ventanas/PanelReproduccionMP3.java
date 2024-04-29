package ventanas;

import javax.swing.ImageIcon;

import Controlador.AppMusic;

public class PanelReproduccionMP3 extends PanelReproduccion {

	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 */
	public PanelReproduccionMP3(NextPreviousObserver nextPreviousObserver) {
		super(nextPreviousObserver);
	}

	public boolean playCancion(){
		if (cancion == null)
			return false;
		boolean resultado = AppMusic.getUnicaInstancia().reproducircancion(cancion);
		if (resultado == false) {
			AppMusic.getUnicaInstancia().showPopup(this, Utilidades.Constantes.ERROR_PLAY_MP3_MENSAJE);
		} else {
			this.playService.notifyPlaylist();
			Play_Stop.setIcon(new ImageIcon(PanelResultado.class.getResource("/recursos/pausa.png")));
			Play_Stop.setSelected(true);
		}
		return resultado;
	}

	public boolean playCancion(String rutaCancionMP3) {
		boolean resultado = AppMusic.getUnicaInstancia().reproducircancion(rutaCancionMP3);
		if (resultado == false) {
			AppMusic.getUnicaInstancia().showPopup(this, Utilidades.Constantes.ERROR_PLAY_MP3_MENSAJE);
		} else {
			// Solo si se consigue reproducir la canción se establece la canción recibida
			// como la canción a reproducir
			this.playService.notifyPlaylist();
			Play_Stop.setIcon(new ImageIcon(PanelResultado.class.getResource("/recursos/pausa.png")));
			this.cancion = rutaCancionMP3;
			Play_Stop.setSelected(true);
		}
		return resultado;
	}

	public boolean stopCancion() {
		if (cancion == null)
			return false;
		boolean resultado = AppMusic.getUnicaInstancia().stopCancion();
		if (resultado == false) {
			AppMusic.getUnicaInstancia().showPopup(this, Utilidades.Constantes.ERROR_STOP_MENSAJE);
		} else {
			Play_Stop.setIcon(new ImageIcon(PanelResultado.class.getResource("/recursos/jugar.png")));
			Play_Stop.setSelected(false);
		}
		return resultado;
	}
}