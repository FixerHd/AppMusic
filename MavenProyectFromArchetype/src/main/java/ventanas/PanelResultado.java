package ventanas;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import Controlador.AppMusic;
import dominio.DatosTabla;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.border.EtchedBorder;

public class PanelResultado extends JPanel implements NextPreviousObserver {

	private static final long serialVersionUID = 1L;
	private AppTabla table;
	private JPanel panel;
	private PanelReproduccionMP3 Panel_Reproducción;
	private String playlist = null;
	private JScrollPane scrollPane;

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

		Panel_Reproducción = new PanelReproduccionMP3(this);
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
				AppMusic.getUnicaInstancia().añadirCancionPlaylist(playlist,
						table.getValueAt(table.getSelectedRow(), 0));
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
	public void nextUpdate() {
		String ruta = AppMusic.getUnicaInstancia().buscarRutaCancion(table.nextCancionId());
		Panel_Reproducción.playCancion(ruta);
	}

	@Override
	public void previousUpdate() {
		String ruta = AppMusic.getUnicaInstancia().buscarRutaCancion(table.previousCancionId());
		Panel_Reproducción.playCancion(ruta);
	}

}
