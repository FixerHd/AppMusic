package ventanas;

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
		boolean resultado = dominio.Reproductor.getUnicaInstancia().playCancion(cancion);
		if (resultado == false) {
			AppMusic.getUnicaInstancia().showPopup(this, Utilidades.Constantes.ERROR_PLAY_MP3_MENSAJE);
		} else {
			Play_Stop.setSelected(true);
		}
		return resultado;
	}

	public boolean playCancion(String cancionMP3) {
		boolean resultado = dominio.Reproductor.getUnicaInstancia().playCancion(cancionMP3);
		if (resultado == false) {
			AppMusic.getUnicaInstancia().showPopup(this, Utilidades.Constantes.ERROR_PLAY_MP3_MENSAJE);
		} else {
			// Solo si se consigue reproducir la canción se establece la canción recibida
			// como la canción a reproducir
			this.cancion = cancionMP3;
			Play_Stop.setSelected(true);
		}
		return resultado;
	}

	public boolean stopCancion() {
		if (cancion == null)
			return false;
		boolean resultado = dominio.Reproductor.getUnicaInstancia().stopCancion();
		if (resultado == false) {
			AppMusic.getUnicaInstancia().showPopup(this, Utilidades.Constantes.ERROR_STOP_MENSAJE);
		} else {
			Play_Stop.setSelected(false);
		}
		return resultado;
	}
}