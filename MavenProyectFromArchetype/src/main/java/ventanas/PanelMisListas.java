package ventanas;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.LayoutManager;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import Controlador.AppMusic;
import dominio.DatosTabla;

import java.awt.BorderLayout;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.border.EtchedBorder;

public class PanelMisListas extends JPanel {

	private static final long serialVersionUID = 1L;
	private JPanel panel;
	private JPanel Panel_Reproducción;
	private JLabel Choose_previous;
	private JLabel Restart;
	private JLabel Play_Stop;
	private JLabel Choose_next;
	private PanelListas panelListas;

	public PanelMisListas() {
		super();

		this.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "MisPlaylists", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		GridBagLayout gbl_panel_3 = new GridBagLayout();
		gbl_panel_3.columnWidths = new int[] { 10, 278, 0, 10, 0 };
		gbl_panel_3.rowHeights = new int[] { 10, 0, 10, 0, 10, 0 };
		gbl_panel_3.columnWeights = new double[] { 0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE };
		gbl_panel_3.rowWeights = new double[] { 0.0, 1.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		this.setLayout(gbl_panel_3);

		panel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.gridwidth = 2;
		gbc_panel.insets = new Insets(0, 0, 5, 5);
		gbc_panel.gridx = 1;
		gbc_panel.gridy = 3;
		add(panel, gbc_panel);
		panel.setLayout(new BorderLayout(0, 0));
		
		panelListas = new PanelListas();
		GridBagConstraints gbc_listas = new GridBagConstraints();
		gbc_listas.gridwidth = 2;
		gbc_listas.fill = GridBagConstraints.BOTH;
		gbc_listas.insets = new Insets(0, 0, 5, 5);
		gbc_listas.gridx = 1;
		gbc_listas.gridy = 1;
		add(panelListas, gbc_listas);

		Panel_Reproducción = new JPanel();
		panel.add(Panel_Reproducción, BorderLayout.NORTH);
		GridBagLayout gbl_Panel_Reproducción = new GridBagLayout();
		gbl_Panel_Reproducción.columnWidths = new int[] { 10, 32, 10, 32, 10, 32, 10, 32, 10, 0 };
		gbl_Panel_Reproducción.rowHeights = new int[] { 32, 0 };
		gbl_Panel_Reproducción.columnWeights = new double[] { 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0,
				Double.MIN_VALUE };
		gbl_Panel_Reproducción.rowWeights = new double[] { 0.0, Double.MIN_VALUE };
		Panel_Reproducción.setLayout(gbl_Panel_Reproducción);

		Choose_previous = new JLabel("");
		Choose_previous.setIcon(new ImageIcon(PanelMisListas.class.getResource("/recursos/anterior.png")));
		GridBagConstraints gbc_Choose_previous = new GridBagConstraints();
		gbc_Choose_previous.anchor = GridBagConstraints.NORTHWEST;
		gbc_Choose_previous.insets = new Insets(0, 0, 0, 5);
		gbc_Choose_previous.gridx = 1;
		gbc_Choose_previous.gridy = 0;
		Panel_Reproducción.add(Choose_previous, gbc_Choose_previous);

		Restart = new JLabel("");
		Restart.setIcon(
				new ImageIcon(PanelMisListas.class.getResource("/recursos/forma-cuadrada-negra-redondeada.png")));
		GridBagConstraints gbc_Restart = new GridBagConstraints();
		gbc_Restart.anchor = GridBagConstraints.NORTHWEST;
		gbc_Restart.insets = new Insets(0, 0, 0, 5);
		gbc_Restart.gridx = 3;
		gbc_Restart.gridy = 0;
		Panel_Reproducción.add(Restart, gbc_Restart);

		Play_Stop = new JLabel("");
		Play_Stop.setIcon(new ImageIcon(PanelMisListas.class.getResource("/recursos/jugar.png")));
		GridBagConstraints gbc_Play_Stop = new GridBagConstraints();
		gbc_Play_Stop.anchor = GridBagConstraints.NORTHWEST;
		gbc_Play_Stop.insets = new Insets(0, 0, 0, 5);
		gbc_Play_Stop.gridx = 5;
		gbc_Play_Stop.gridy = 0;
		Panel_Reproducción.add(Play_Stop, gbc_Play_Stop);

		Choose_next = new JLabel("");
		Choose_next.setIcon(new ImageIcon(PanelMisListas.class.getResource("/recursos/proximo.png")));
		GridBagConstraints gbc_Choose_next = new GridBagConstraints();
		gbc_Choose_next.anchor = GridBagConstraints.NORTHWEST;
		gbc_Choose_next.insets = new Insets(0, 0, 0, 5);
		gbc_Choose_next.gridx = 7;
		gbc_Choose_next.gridy = 0;
		Panel_Reproducción.add(Choose_next, gbc_Choose_next);

		this.setVisible(true);

	}
	
	public JList<String> getLista() {
		return panelListas.getLista();
	}
	
	public void setLista(List<String> new_values) {
		panelListas.setLista(new_values);
	}
	
	public JTable getTable() {
		return panelListas.getTable();
	}
	
	public void setTable(DatosTabla datos) {
		panelListas.setTable(datos);
	}

}
