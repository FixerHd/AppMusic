package ventanas;

import javax.swing.ImageIcon;

import Controlador.AppMusic;

public class PanelReproduccionMP3 extends PanelReproduccion {

	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 */
	public PanelReproduccionMP3(NextPreviousObserver nextPreviousObserver, RutaObserver rutaObserver) {
		super(nextPreviousObserver, rutaObserver);
	}

	public boolean playCancion() {
		rutaCancion = this.rutaService.notifyObserver();
		this.playService.notifyPlaylist();
		if (rutaCancion == null)
			return false;
		boolean resultado = AppMusic.getUnicaInstancia().reproducircancion(rutaCancion);
		if (resultado == false) {
			AppMusic.getUnicaInstancia().showPopup(Utilidades.Constantes.ERROR_PLAY_MP3_MENSAJE);
		} else {
			Play_Stop.setIcon(new ImageIcon(PanelResultado.class.getResource("/recursos/pausa.png")));
			Play_Stop.setSelected(true);
			addView(rutaCancion);
			addRecientes(rutaCancion);
			revalidate();
			repaint();
		}
		return resultado;
	}

	public boolean playCancion(String rutaCancionMP3) {
		this.playService.notifyPlaylist();
		boolean resultado = AppMusic.getUnicaInstancia().reproducircancion(rutaCancionMP3);
		if (resultado == false) {
			AppMusic.getUnicaInstancia().showPopup(Utilidades.Constantes.ERROR_PLAY_MP3_MENSAJE);
		} else {
			// Solo si se consigue reproducir la canción se establece la canción recibida
			// como la canción a reproducir
			Play_Stop.setIcon(new ImageIcon(PanelResultado.class.getResource("/recursos/pausa.png")));
			this.rutaCancion = rutaCancionMP3;
			Play_Stop.setSelected(true);
			addView(rutaCancion);
			revalidate();
			repaint();
		}
		return resultado;
	}

}