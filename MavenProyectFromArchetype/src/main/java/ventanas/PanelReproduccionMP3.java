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
		return auxPlayCancion(rutaCancion);
	}

	public boolean playCancion(String rutaCancionMP3) {
		boolean resultado = auxPlayCancion(rutaCancionMP3);
		// Solo si se consigue reproducir la canción se establece la canción recibida
		// como la canción a reproducir
		if (resultado) {
			this.rutaCancion = rutaCancionMP3;
		}
		return resultado;
	}
	
	private boolean auxPlayCancion(String cancion){
		this.playService.notifyPlaylist();
		if (rutaCancion == null)
			return false;
		boolean resultado = AppMusic.getUnicaInstancia().reproducircancion(rutaCancion);
		if (resultado == false) {
			AppMusic.getUnicaInstancia().showPopup(Utilidades.Constantes.ERROR_PLAY_MP3_MENSAJE);
		} else {
			Play_Stop.setIcon(new ImageIcon(PanelResultado.class.getResource("/recursos/pausa.png")));
			Play_Stop.setSelected(true);
			revalidate();
			repaint();
		}
		return resultado;
	}

}