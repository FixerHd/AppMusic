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
import java.awt.BorderLayout;

public class PanelGestion extends JPanel {
	
	private static final long serialVersionUID = 1L;
	private JButton Crear;
	private JCheckBox Favoritas_check;
	private JButton Eliminar;
	private JTable table;
	private JButton Eliminar_Canción;
	private JPanel panel;
	private JPanel Panel_Reproducción;
	private JLabel Choose_previous;
	private JLabel Restart;
	private JLabel Play_Stop;
	private JLabel Choose_next;
	
	public PanelGestion() {
		super();
		
		this.setBorder(new TitledBorder(null, "Gesti\u00F3n", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GridBagLayout gbl_panel_3 = new GridBagLayout();
		gbl_panel_3.columnWidths = new int[]{30, 15, 178, 0, 10, 70, 30, 0};
		gbl_panel_3.rowHeights = new int[]{10, 0, 10, 0, 10, 0, 10, 0, 10, 0};
		gbl_panel_3.columnWeights = new double[]{0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panel_3.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		this.setLayout(gbl_panel_3);
		
		JTextField Título = new HintTextField("Nombre completo");
		Título.setText("Título");
		GridBagConstraints gbc_Título = new GridBagConstraints();
		gbc_Título.gridwidth = 3;
		gbc_Título.insets = new Insets(0, 0, 5, 5);
		gbc_Título.fill = GridBagConstraints.HORIZONTAL;
		gbc_Título.gridx = 1;
		gbc_Título.gridy = 1;
		this.add(Título, gbc_Título);
		Título.setColumns(10);
		
		Crear = new JButton("Crear");
		GridBagConstraints gbc_Crear = new GridBagConstraints();
		gbc_Crear.fill = GridBagConstraints.HORIZONTAL;
		gbc_Crear.insets = new Insets(0, 0, 5, 5);
		gbc_Crear.gridx = 5;
		gbc_Crear.gridy = 1;
		this.add(Crear, gbc_Crear);
		
		Favoritas_check = new JCheckBox("Favoritas");
		GridBagConstraints gbc_Favoritas_check = new GridBagConstraints();
		gbc_Favoritas_check.fill = GridBagConstraints.VERTICAL;
		gbc_Favoritas_check.anchor = GridBagConstraints.WEST;
		gbc_Favoritas_check.gridwidth = 3;
		gbc_Favoritas_check.insets = new Insets(0, 0, 5, 5);
		gbc_Favoritas_check.gridx = 1;
		gbc_Favoritas_check.gridy = 3;
		this.add(Favoritas_check, gbc_Favoritas_check);
		
		Eliminar = new JButton("Eliminar");
		GridBagConstraints gbc_Eliminar = new GridBagConstraints();
		gbc_Eliminar.fill = GridBagConstraints.HORIZONTAL;
		gbc_Eliminar.insets = new Insets(0, 0, 5, 5);
		gbc_Eliminar.gridx = 5;
		gbc_Eliminar.gridy = 3;
		this.add(Eliminar, gbc_Eliminar);
		
		table = new JTable();
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null},
			},
			new String[] {
				"Titulo", "Interprete", "Estilo", ""
			}
		) {
			Class[] columnTypes = new Class[] {
				Object.class, Object.class, Object.class, Boolean.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
			boolean[] columnEditables = new boolean[] {
				false, false, false, true
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		GridBagConstraints gbc_table = new GridBagConstraints();
		gbc_table.gridwidth = 5;
		gbc_table.insets = new Insets(0, 0, 5, 5);
		gbc_table.fill = GridBagConstraints.BOTH;
		gbc_table.gridx = 1;
		gbc_table.gridy = 5;
		this.add(table, gbc_table);
		
		panel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.gridwidth = 2;
		gbc_panel.insets = new Insets(0, 0, 5, 5);
		gbc_panel.gridx = 2;
		gbc_panel.gridy = 7;
		add(panel, gbc_panel);
		panel.setLayout(new BorderLayout(0, 0));
		
		Panel_Reproducción = new JPanel();
		panel.add(Panel_Reproducción, BorderLayout.NORTH);
		GridBagLayout gbl_Panel_Reproducción = new GridBagLayout();
		gbl_Panel_Reproducción.columnWidths = new int[]{10, 32, 10, 32, 10, 32, 10, 32, 10, 0};
		gbl_Panel_Reproducción.rowHeights = new int[]{32, 0};
		gbl_Panel_Reproducción.columnWeights = new double[]{1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_Panel_Reproducción.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		Panel_Reproducción.setLayout(gbl_Panel_Reproducción);
		
		Choose_previous = new JLabel("");
		Choose_previous.setIcon(new ImageIcon(PanelGestion.class.getResource("/recursos/anterior.png")));
		GridBagConstraints gbc_Choose_previous = new GridBagConstraints();
		gbc_Choose_previous.anchor = GridBagConstraints.NORTHWEST;
		gbc_Choose_previous.insets = new Insets(0, 0, 0, 5);
		gbc_Choose_previous.gridx = 1;
		gbc_Choose_previous.gridy = 0;
		Panel_Reproducción.add(Choose_previous, gbc_Choose_previous);
		
		Restart = new JLabel("");
		Restart.setIcon(new ImageIcon(PanelGestion.class.getResource("/recursos/forma-cuadrada-negra-redondeada.png")));
		GridBagConstraints gbc_Restart = new GridBagConstraints();
		gbc_Restart.anchor = GridBagConstraints.NORTHWEST;
		gbc_Restart.insets = new Insets(0, 0, 0, 5);
		gbc_Restart.gridx = 3;
		gbc_Restart.gridy = 0;
		Panel_Reproducción.add(Restart, gbc_Restart);
		
		Play_Stop = new JLabel("");
		Play_Stop.setIcon(new ImageIcon(PanelGestion.class.getResource("/recursos/jugar.png")));
		GridBagConstraints gbc_Play_Stop = new GridBagConstraints();
		gbc_Play_Stop.anchor = GridBagConstraints.NORTHWEST;
		gbc_Play_Stop.insets = new Insets(0, 0, 0, 5);
		gbc_Play_Stop.gridx = 5;
		gbc_Play_Stop.gridy = 0;
		Panel_Reproducción.add(Play_Stop, gbc_Play_Stop);
		
		Choose_next = new JLabel("");
		Choose_next.setIcon(new ImageIcon(PanelGestion.class.getResource("/recursos/proximo.png")));
		GridBagConstraints gbc_Choose_next = new GridBagConstraints();
		gbc_Choose_next.anchor = GridBagConstraints.NORTHWEST;
		gbc_Choose_next.insets = new Insets(0, 0, 0, 5);
		gbc_Choose_next.gridx = 7;
		gbc_Choose_next.gridy = 0;
		Panel_Reproducción.add(Choose_next, gbc_Choose_next);
		
		Eliminar_Canción = new JButton("Eliminar Canción");
		GridBagConstraints gbc_Eliminar_Canción = new GridBagConstraints();
		gbc_Eliminar_Canción.fill = GridBagConstraints.HORIZONTAL;
		gbc_Eliminar_Canción.insets = new Insets(0, 0, 5, 5);
		gbc_Eliminar_Canción.gridx = 5;
		gbc_Eliminar_Canción.gridy = 7;
		this.add(Eliminar_Canción, gbc_Eliminar_Canción);
	}

}
