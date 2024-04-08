package ventanas;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.LayoutManager;
import java.awt.Toolkit;
import java.util.ArrayList;
import java.util.List;

import javax.swing.AbstractListModel;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JToggleButton;
import javax.swing.ListSelectionModel;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import Controlador.AppMusic;
import Utilidades.Constantes;
import dominio.DatosLista;
import dominio.DatosTabla;

import java.awt.BorderLayout;
import javax.swing.border.LineBorder;
import java.awt.Color;

import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;

public class PanelResultado extends JPanel implements PlayObserver {

	private static final long serialVersionUID = 1L;
	private JTable table;
	private JPanel panel;
	private JPanel Panel_Reproducción;
	private JLabel Play_Stop;
	private String playlist = null;
	private JScrollPane scrollPane;
	private JToggleButton Boton_Play_Stop;

	public PanelResultado() {
		super();
		
		this.setBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(0, 0, 0)));
		GridBagLayout gbl_panel_3 = new GridBagLayout();
		gbl_panel_3.columnWidths = new int[] { 10, 0, 198, 0, 10, 70, 10, 0 };
		gbl_panel_3.rowHeights = new int[] { 10, 0, 10, 0, 10, 0 };
		gbl_panel_3.columnWeights = new double[] { 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		gbl_panel_3.rowWeights = new double[] { 0.0, 1.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		this.setLayout(gbl_panel_3);

		table = new AppTabla();
		scrollPane = new JScrollPane(table);
		
		GridBagConstraints gbc_table = new GridBagConstraints();
		gbc_table.gridwidth = 5;
		gbc_table.insets = new Insets(0, 0, 5, 5);
		gbc_table.fill = GridBagConstraints.BOTH;
		gbc_table.gridx = 1;
		gbc_table.gridy = 1;
		this.add(scrollPane, gbc_table);

		panel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.gridwidth = 2;
		gbc_panel.insets = new Insets(0, 0, 5, 5);
		gbc_panel.gridx = 2;
		gbc_panel.gridy = 3;
		add(panel, gbc_panel);
		panel.setLayout(new BorderLayout(0, 0));

		Panel_Reproducción = new PanelReproduccion();
		panel.add(Panel_Reproducción, BorderLayout.NORTH);

		JButton Añadir_Canción = new JButton("Añadir a Lista");
		GridBagConstraints gbc_Eliminar_Canción = new GridBagConstraints();
		gbc_Eliminar_Canción.fill = GridBagConstraints.HORIZONTAL;
		gbc_Eliminar_Canción.insets = new Insets(0, 0, 5, 5);
		gbc_Eliminar_Canción.gridx = 5;
		gbc_Eliminar_Canción.gridy = 3;
		Añadir_Canción.addActionListener(ev -> {
			playlist = (String) PanelBuscar.getInstancia().getSelección_Playlist().getSelectedItem();
			if (playlist != null) {
			AppMusic.getUnicaInstancia().añadirCancionPlaylist(playlist, table.getValueAt(table.getSelectedRow(),0));
			playlist = null;
			}
		});
		this.add(Añadir_Canción, gbc_Eliminar_Canción);
	}
	
	public void setPlaylist(String playlist) {
		this.playlist = playlist;
	}
	
	public JTable getTable() {
		return table;
	}
	
	public void setTable(DatosTabla datos) {
		table = new AppTabla(datos);
		this.remove(scrollPane);
		scrollPane = new JScrollPane(table);
		GridBagConstraints gbc_table = new GridBagConstraints();
		gbc_table.gridwidth = 5;
		gbc_table.insets = new Insets(0, 0, 5, 5);
		gbc_table.fill = GridBagConstraints.BOTH;
		gbc_table.gridx = 1;
		gbc_table.gridy = 1;
		this.add(scrollPane, gbc_table);
	}

	@Override
	public void update() {
		Play_Stop.setIcon(new ImageIcon(PanelResultado.class.getResource("/recursos/jugar.png")));
		Boton_Play_Stop.setSelected(false);
	}

}
