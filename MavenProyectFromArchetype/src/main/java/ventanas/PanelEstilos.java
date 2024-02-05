package ventanas;

import javax.swing.JPanel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.border.TitledBorder;

import Controlador.AppMusic;

import javax.swing.BoxLayout;
import java.awt.FlowLayout;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.border.CompoundBorder;
import javax.swing.UIManager;
import java.awt.Color;
import javax.swing.border.EtchedBorder;

public class PanelEstilos extends JPanel {

	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 */
	public PanelEstilos() {
		setBorder(
				new TitledBorder(
						new TitledBorder(
								new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255),
										new Color(160, 160, 160)),
								"", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)),
						"Estilo", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		setLayout(new BorderLayout(0, 0));

		JComboBox comboBox = new JComboBox();
		comboBox.setModel(
				new DefaultComboBoxModel(new String[] { "Texture", "HiFi", "Acry", "Aero", "Mint", "Devil" }));
		comboBox.addActionListener(ev -> {
			AppMusic.getUnicaInstancia().setEstilo((String) comboBox.getSelectedItem());
			this.revalidate();
			this.repaint();
		});
		add(comboBox, BorderLayout.CENTER);

	}

}
