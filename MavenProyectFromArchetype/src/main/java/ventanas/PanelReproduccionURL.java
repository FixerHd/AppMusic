package ventanas;

import javax.swing.ImageIcon;

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
		if (rutaCancion == null)
			return false;
		boolean resultado = AppMusic.getUnicaInstancia().reproducircancionURL(rutaCancion);
		if (resultado == false) {
			AppMusic.getUnicaInstancia().showPopup(Utilidades.Constantes.ERROR_PLAY_URL_MENSAJE);
		} else {
			this.playService.notifyPlaylist();
			Play_Stop.setIcon(new ImageIcon(PanelResultado.class.getResource("/recursos/pausa.png")));
			Play_Stop.setSelected(true);
			AppMusic.getUnicaInstancia().addView(rutaCancion);
			revalidate();
			repaint();
		}
		return resultado;
	}

	public boolean playCancion(String cancion) {
		boolean resultado = AppMusic.getUnicaInstancia().reproducircancionURL(cancion);
		if (resultado == false) {
			AppMusic.getUnicaInstancia().showPopup(Utilidades.Constantes.ERROR_PLAY_URL_MENSAJE);
		} else {
			// Solo si se consigue reproducir la canción se establece la canción recibida
			// como la canción a reproducir
			this.playService.notifyPlaylist();
			this.rutaCancion = cancion;
			Play_Stop.setIcon(new ImageIcon(PanelResultado.class.getResource("/recursos/pausa.png")));
			Play_Stop.setSelected(true);
			AppMusic.getUnicaInstancia().addView(rutaCancion);
			revalidate();
			repaint();
		}
		return resultado;
	}

}