package ventanas;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.LayoutManager;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import Controlador.AppMusic;

import java.awt.BorderLayout;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.border.EtchedBorder;

public class PanelRecientes extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTable table;
	private JPanel panel;
	private JPanel Panel_Reproducción;
	private JLabel Choose_previous;
	private JLabel Restart;
	private JLabel Play_Stop;
	private JLabel Choose_next;

	public PanelRecientes() {
		super();

		this.setBorder(new TitledBorder(null, "Recientes", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GridBagLayout gbl_panel_3 = new GridBagLayout();
		gbl_panel_3.columnWidths = new int[] { 10, 0, 278, 0, 10, 0 };
		gbl_panel_3.rowHeights = new int[] { 10, 0, 10, 0, 10, 0 };
		gbl_panel_3.columnWeights = new double[] { 0.0, 0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE };
		gbl_panel_3.rowWeights = new double[] { 0.0, 1.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		this.setLayout(gbl_panel_3);

		table = new JTable();
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setModel(new DefaultTableModel(new Object[][] { { null, null, null, null }, },
				new String[] { "Titulo", "Interprete", "Estilo", "" }) {
			Class[] columnTypes = new Class[] { Object.class, Object.class, Object.class, Boolean.class };

			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}

			boolean[] columnEditables = new boolean[] { false, false, false, true };

			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		GridBagConstraints gbc_table = new GridBagConstraints();
		gbc_table.gridwidth = 3;
		gbc_table.insets = new Insets(0, 0, 5, 5);
		gbc_table.fill = GridBagConstraints.BOTH;
		gbc_table.gridx = 1;
		gbc_table.gridy = 1;
		this.add(table, gbc_table);

		panel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.gridwidth = 2;
		gbc_panel.insets = new Insets(0, 0, 5, 5);
		gbc_panel.gridx = 2;
		gbc_panel.gridy = 3;
		add(panel, gbc_panel);
		panel.setLayout(new BorderLayout(0, 0));

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
		Choose_previous.setIcon(new ImageIcon(PanelRecientes.class.getResource("/recursos/anterior.png")));
		GridBagConstraints gbc_Choose_previous = new GridBagConstraints();
		gbc_Choose_previous.anchor = GridBagConstraints.NORTHWEST;
		gbc_Choose_previous.insets = new Insets(0, 0, 0, 5);
		gbc_Choose_previous.gridx = 1;
		gbc_Choose_previous.gridy = 0;
		Panel_Reproducción.add(Choose_previous, gbc_Choose_previous);

		Restart = new JLabel("");
		Restart.setIcon(
				new ImageIcon(PanelRecientes.class.getResource("/recursos/forma-cuadrada-negra-redondeada.png")));
		GridBagConstraints gbc_Restart = new GridBagConstraints();
		gbc_Restart.anchor = GridBagConstraints.NORTHWEST;
		gbc_Restart.insets = new Insets(0, 0, 0, 5);
		gbc_Restart.gridx = 3;
		gbc_Restart.gridy = 0;
		Panel_Reproducción.add(Restart, gbc_Restart);

		Play_Stop = new JLabel("");
		Play_Stop.setIcon(new ImageIcon(PanelRecientes.class.getResource("/recursos/jugar.png")));
		GridBagConstraints gbc_Play_Stop = new GridBagConstraints();
		gbc_Play_Stop.anchor = GridBagConstraints.NORTHWEST;
		gbc_Play_Stop.insets = new Insets(0, 0, 0, 5);
		gbc_Play_Stop.gridx = 5;
		gbc_Play_Stop.gridy = 0;
		Panel_Reproducción.add(Play_Stop, gbc_Play_Stop);

		Choose_next = new JLabel("");
		Choose_next.setIcon(new ImageIcon(PanelRecientes.class.getResource("/recursos/proximo.png")));
		GridBagConstraints gbc_Choose_next = new GridBagConstraints();
		gbc_Choose_next.anchor = GridBagConstraints.NORTHWEST;
		gbc_Choose_next.insets = new Insets(0, 0, 0, 5);
		gbc_Choose_next.gridx = 7;
		gbc_Choose_next.gridy = 0;
		Panel_Reproducción.add(Choose_next, gbc_Choose_next);

		this.setVisible(true);

	}

}
