package ventanas;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JToggleButton;
import javax.swing.border.TitledBorder;

import Controlador.AppMusic;

public abstract class PanelReproduccion extends JPanel implements PlayObserver {

	private static final long serialVersionUID = 1L;
	protected String cancion = null;
	protected JToggleButton Play_Stop;
	protected JButton Choose_previous;
	protected JButton Choose_next;
	protected JButton Restart;
	protected PlayNotificationService playService = AppMusic.getUnicaInstancia().getPlayService();
	protected NextPreviousNotificationService nextPreviousService;

	/**
	 * Create the panel.
	 */
	public PanelReproduccion(NextPreviousObserver nextPreviousObserver) {
		this.nextPreviousService = new NextPreviousNotificationService(nextPreviousObserver);
		this.playService.subscribe(this);
		setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));

		GridBagLayout gbl_Panel_Reproducción = new GridBagLayout();
		gbl_Panel_Reproducción.columnWidths = new int[] { 1, 0, 32, 10, 32, 10, 32, 10, 32, 0, 1, 0 };
		gbl_Panel_Reproducción.rowHeights = new int[] { 1, 32, 0 };
		gbl_Panel_Reproducción.columnWeights = new double[] { 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0,
				Double.MIN_VALUE };
		gbl_Panel_Reproducción.rowWeights = new double[] { 0.0, 0.0, Double.MIN_VALUE };
		this.setLayout(gbl_Panel_Reproducción);

		Choose_previous = new JButton("");
		Choose_previous.setIcon(new ImageIcon(PanelResultado.class.getResource("/recursos/anterior.png")));
		GridBagConstraints gbc_Choose_previous = new GridBagConstraints();
		gbc_Choose_previous.anchor = GridBagConstraints.NORTHWEST;
		gbc_Choose_previous.insets = new Insets(0, 0, 0, 5);
		gbc_Choose_previous.gridx = 2;
		gbc_Choose_previous.gridy = 1;
		Choose_previous.addActionListener(ev -> {
			nextPreviousService.notifyPrevious();
		});
		this.add(Choose_previous, gbc_Choose_previous);

		Restart = new JButton("");
		Restart.setIcon(
				new ImageIcon(PanelResultado.class.getResource("/recursos/forma-cuadrada-negra-redondeada.png")));
		GridBagConstraints gbc_Restart = new GridBagConstraints();
		gbc_Restart.anchor = GridBagConstraints.NORTHWEST;
		gbc_Restart.insets = new Insets(0, 0, 0, 5);
		gbc_Restart.gridx = 4;
		gbc_Restart.gridy = 1;
		this.add(Restart, gbc_Restart);

		Play_Stop = new JToggleButton("");
		Play_Stop.setIcon(new ImageIcon(PanelResultado.class.getResource("/recursos/jugar.png")));
		GridBagConstraints gbc_Play_Stop = new GridBagConstraints();
		gbc_Play_Stop.anchor = GridBagConstraints.NORTHWEST;
		gbc_Play_Stop.insets = new Insets(0, 0, 0, 5);
		gbc_Play_Stop.gridx = 6;
		gbc_Play_Stop.gridy = 1;
		Play_Stop.addActionListener(ev -> {
			if (!Play_Stop.isSelected()) {
				Play_Stop.setIcon(new ImageIcon(PanelResultado.class.getResource("/recursos/jugar.png")));
				if (stopCancion()) {
					Play_Stop.setIcon(new ImageIcon(PanelResultado.class.getResource("/recursos/jugar.png")));
				}
			} else {
				Play_Stop.setIcon(new ImageIcon(PanelResultado.class.getResource("/recursos/pausa.png")));
				if (playCancion()) {
					this.playService.notifyPlaylist();
					Play_Stop.setIcon(new ImageIcon(PanelResultado.class.getResource("/recursos/pausa.png")));
				}
			}
		});
		this.add(Play_Stop, gbc_Play_Stop);

		Choose_next = new JButton("");
		Choose_next.setIcon(new ImageIcon(PanelRecientes.class.getResource("/recursos/proximo.png")));
		GridBagConstraints gbc_Choose_next = new GridBagConstraints();
		gbc_Choose_next.anchor = GridBagConstraints.NORTHWEST;
		gbc_Choose_next.insets = new Insets(0, 0, 0, 5);
		gbc_Choose_next.gridx = 8;
		gbc_Choose_next.gridy = 1;
		Choose_next.addActionListener(ev -> {
			nextPreviousService.notifyNext();
		});
		this.add(Choose_next, gbc_Choose_next);
	}

	public JToggleButton getPlay_Stop() {
		return Play_Stop;
	}

	public String getCancion() {
		return cancion;
	}

	public void setCancion(String cancion) {
		this.cancion = cancion;
	}

	public abstract boolean playCancion();

	public abstract boolean playCancion(String cancion);

	public abstract boolean stopCancion();

	@Override
	public void update() {
		Play_Stop.setSelected(false);
		Play_Stop.setIcon(new ImageIcon(PanelResultado.class.getResource("/recursos/jugar.png")));
		revalidate();
		repaint();
	}

}
