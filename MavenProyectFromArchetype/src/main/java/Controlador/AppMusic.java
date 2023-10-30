package Controlador;

import javax.swing.JFrame;

public class AppMusic {
	
	// Atributos compartidos
	private JFrame ventanaActual;
	
	private AppMusic(JFrame Ventana) {
		this.ventanaActual = Ventana;
	}
	
	public void cambiar_ventana(JFrame Ventana) {
		ventanaActual.setVisible(false);
		ventanaActual = Ventana;
		ventanaActual.setVisible(true);
	}

}
