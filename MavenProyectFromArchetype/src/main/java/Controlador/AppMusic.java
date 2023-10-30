package Controlador;

import javax.swing.JFrame;

public class AppMusic {

	// Atributos compartidos
	private JFrame Login;
	private JFrame LoginGit;
	private JFrame Registro;
	private JFrame Selector;
	private JFrame Principal;
	private JFrame ventanaActual;

	public AppMusic(JFrame Login, JFrame LoginGit, JFrame Registro, JFrame Selector, JFrame Principal) {
		this.Login = Login;
		this.LoginGit = LoginGit;
		this.Registro = Registro;
		this.Selector = Selector;
		this.Principal = Principal;
		this.ventanaActual = this.Selector;
	}

	public void cambiar_ventana(String Ventana) {
		ventanaActual.setVisible(false);
		switch (Ventana) {
		case "Login":
			ventanaActual = Login;
			break;
		case "LoginGit":
			ventanaActual = LoginGit;
			break;
		case "Registro":
			ventanaActual = Registro;
			break;
		case "Selector":
			ventanaActual = Selector;
			break;
		case "Principal":
			ventanaActual = Principal;
			break;
		default:
			// TODO: Error
			break;
		}
		ventanaActual.setVisible(true);
	}

}
