package ventanas.Inicio;

import javax.swing.JFrame;

public abstract class AppVentana extends JFrame {

	protected static final long serialVersionUID = 1L;
	protected static AppVentana unicaInstancia;

	public AppVentana() {}
	
	public void removeInstancia() {
		unicaInstancia.setVisible(false);
		unicaInstancia.removeAll();
		unicaInstancia.dispose();
		unicaInstancia = null;
	}

}
