package ventanas;

import Controlador.AppMusic;

public class PanelReproduccionURL extends PanelReproduccion {

	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 */
	public PanelReproduccionURL(NextPreviousObserver nextPreviousObserver) {
		super(nextPreviousObserver);
	}

	public boolean playCancion() {
		if (cancionActual == null)
			return false;
		boolean resultado = dominio.Reproductor.getUnicaInstancia().playCancion(cancionActual);
		if (resultado == false) {
			AppMusic.getUnicaInstancia().showPopup(this, Utilidades.Constantes.ERROR_PLAY_URL_MENSAJE);
		} else {
			Play_Stop.setSelected(true);
		}
		return resultado;
	}

	public boolean playCancion(String cancion) {
		boolean resultado = dominio.Reproductor.getUnicaInstancia().playCancion(cancion);
		if (resultado == false) {
			AppMusic.getUnicaInstancia().showPopup(this, Utilidades.Constantes.ERROR_PLAY_URL_MENSAJE);
		} else {
			// Solo si se consigue reproducir la canción se establece la canción recibida
			// como la canción a reproducir
			this.cancionActual = cancion;
			Play_Stop.setSelected(true);
		}
		return resultado;
	}

	public boolean stopCancion() {
		if (cancionActual == null)
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