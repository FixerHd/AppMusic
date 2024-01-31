package ventanas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.UIManager;

import Controlador.AppMusic;

public class Lanzador {

	private JFrame frame;

	/**
	 * Launch the application
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel("com.jtattoo.plaf.hifi.HiFiLookAndFeel");
					Selector selector = new Selector();
					Login login = new Login();
					LoginGit loginGit = new LoginGit();
					Registro registro = new Registro();
					Principal principal = new Principal();
					selector.setVisible(true);
					login.setVisible(false);
					registro.setVisible(false);
					principal.setVisible(false);
					AppMusic AppMusic = Controlador.AppMusic.getUnicaInstancia();
					AppMusic.Iniciarventanas(login, loginGit, registro, selector, principal);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Lanzador() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
