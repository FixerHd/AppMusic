package ventanas;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import Controlador.AppMusic;
import Utilidades.Constantes;
import dominio.DatosLista;
import dominio.DatosTabla;

import java.awt.BorderLayout;

public class PanelGestion extends JPanel {

	private static final long serialVersionUID = 1L;
	private JPanel panel;
	private JScrollPane scrollPane;
	private PanelListas panelLista;

	public PanelGestion() {
		super();

		this.setBorder(new TitledBorder(null, "Gesti\u00F3n", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GridBagLayout gbl_panel_3 = new GridBagLayout();
		gbl_panel_3.columnWidths = new int[] { 30, 70, 10, 10, 70, 0, 10, 70, 30, 0 };
		gbl_panel_3.rowHeights = new int[] { 10, 0, 10, 0, 10, 0, 10, 0, 10, 0 };
		gbl_panel_3.columnWeights = new double[] { 0.0, 0.0, 1.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		gbl_panel_3.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		this.setLayout(gbl_panel_3);

		JTextField Texto_Título = new HintTextField("Título");
		GridBagConstraints gbc_Texto_Título = new GridBagConstraints();
		gbc_Texto_Título.gridwidth = 5;
		gbc_Texto_Título.insets = new Insets(0, 0, 5, 5);
		gbc_Texto_Título.fill = GridBagConstraints.HORIZONTAL;
		gbc_Texto_Título.gridx = 1;
		gbc_Texto_Título.gridy = 1;
		this.add(Texto_Título, gbc_Texto_Título);
		Texto_Título.setColumns(10);

		JCheckBox Boton_Favoritas = new JCheckBox("Favoritas");
		GridBagConstraints gbc_Boton_Favoritas = new GridBagConstraints();
		gbc_Boton_Favoritas.anchor = GridBagConstraints.WEST;
		gbc_Boton_Favoritas.insets = new Insets(0, 0, 5, 5);
		gbc_Boton_Favoritas.gridx = 7;
		gbc_Boton_Favoritas.gridy = 1;
		Boton_Favoritas.addActionListener(ev -> {
			
		});
		add(Boton_Favoritas, gbc_Boton_Favoritas);

		JButton Boton_Crear = new JButton("Crear");
		Boton_Crear.setToolTipText(
				"Si no existe una playlist con el nombre escrito en \"titulo\", pulsando este boton se crea");
		GridBagConstraints gbc_Boton_Crear = new GridBagConstraints();
		gbc_Boton_Crear.gridwidth = 2;
		gbc_Boton_Crear.fill = GridBagConstraints.HORIZONTAL;
		gbc_Boton_Crear.insets = new Insets(0, 0, 5, 5);
		gbc_Boton_Crear.gridx = 1;
		gbc_Boton_Crear.gridy = 3;
		Boton_Crear.addActionListener(ev -> {
			String titulo = Texto_Título.getText();
			if (!titulo.isEmpty()) {
				añadirPlaylist(titulo);
			} else {
				AppMusic.getUnicaInstancia().showPopup(Principal.getInstancia(), Constantes.ERROR_TITULO_VACIO_MENSAJE);
			}
		});
		add(Boton_Crear, gbc_Boton_Crear);

		panelLista = new PanelListas();
		GridBagConstraints gbc_panelListas = new GridBagConstraints();
		gbc_panelListas.gridwidth = 7;
		gbc_panelListas.insets = new Insets(0, 0, 5, 5);
		gbc_panelListas.fill = GridBagConstraints.BOTH;
		gbc_panelListas.gridx = 1;
		gbc_panelListas.gridy = 5;
		DatosLista datos = AppMusic.getUnicaInstancia().getMisPlaylists(Boton_Favoritas.isSelected());
		if (datos != null) {
			panelLista.setLista(datos.getNombres());
			this.add(panelLista);
			this.revalidate();
			this.repaint();
		} else {
			AppMusic.getUnicaInstancia().showPopup(Principal.getInstancia(), Constantes.ERROR_LISTA_VACIA_MENSAJE);
		}
		add(panelLista, gbc_panelListas);

		JButton Boton_Eliminar = new JButton("Eliminar");
		Boton_Eliminar.setToolTipText("Al pulsar este boton se elimina la playlist seleccionada en la lista");
		GridBagConstraints gbc_Boton_Eliminar = new GridBagConstraints();
		gbc_Boton_Eliminar.gridwidth = 2;
		gbc_Boton_Eliminar.fill = GridBagConstraints.HORIZONTAL;
		gbc_Boton_Eliminar.insets = new Insets(0, 0, 5, 5);
		gbc_Boton_Eliminar.gridx = 4;
		gbc_Boton_Eliminar.gridy = 3;
		Boton_Eliminar.addActionListener(ev -> {
			eliminarPlaylist(panelLista.getLista().getSelectedValue());
		});
		add(Boton_Eliminar, gbc_Boton_Eliminar);
		
		JButton Boton_Guardar = new JButton("Guardar");
		Boton_Guardar.setToolTipText("Al pulsar este boton se guardan los cambios realizados en la playlist seleccionada");
		GridBagConstraints gbc_Boton_Guardar = new GridBagConstraints();
		gbc_Boton_Guardar.insets = new Insets(0, 0, 5, 5);
		gbc_Boton_Guardar.fill = GridBagConstraints.HORIZONTAL;
		gbc_Boton_Guardar.gridx = 7;
		gbc_Boton_Guardar.gridy = 3;
		Boton_Guardar.addActionListener(ev -> {
			actualizarPlaylist();
		});
		add(Boton_Guardar, gbc_Boton_Guardar);

		panel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.fill = GridBagConstraints.HORIZONTAL;
		gbc_panel.gridwidth = 5;
		gbc_panel.insets = new Insets(0, 0, 5, 5);
		gbc_panel.gridx = 1;
		gbc_panel.gridy = 7;
		add(panel, gbc_panel);
		panel.setLayout(new BorderLayout(0, 0));

		JPanel Panel_Reproducción = new JPanel();
		panel.add(Panel_Reproducción, BorderLayout.NORTH);
		GridBagLayout gbl_Panel_Reproducción = new GridBagLayout();
		gbl_Panel_Reproducción.columnWidths = new int[] { 10, 32, 10, 32, 10, 32, 10, 32, 10, 0 };
		gbl_Panel_Reproducción.rowHeights = new int[] { 32, 0 };
		gbl_Panel_Reproducción.columnWeights = new double[] { 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0,
				Double.MIN_VALUE };
		gbl_Panel_Reproducción.rowWeights = new double[] { 0.0, Double.MIN_VALUE };
		Panel_Reproducción.setLayout(gbl_Panel_Reproducción);

		JLabel Choose_previous = new JLabel("");
		Choose_previous.setIcon(new ImageIcon(PanelGestion.class.getResource("/recursos/anterior.png")));
		GridBagConstraints gbc_Choose_previous = new GridBagConstraints();
		gbc_Choose_previous.anchor = GridBagConstraints.NORTHWEST;
		gbc_Choose_previous.insets = new Insets(0, 0, 0, 5);
		gbc_Choose_previous.gridx = 1;
		gbc_Choose_previous.gridy = 0;
		Panel_Reproducción.add(Choose_previous, gbc_Choose_previous);

		JLabel Restart = new JLabel("");
		Restart.setIcon(new ImageIcon(PanelGestion.class.getResource("/recursos/forma-cuadrada-negra-redondeada.png")));
		GridBagConstraints gbc_Restart = new GridBagConstraints();
		gbc_Restart.anchor = GridBagConstraints.NORTHWEST;
		gbc_Restart.insets = new Insets(0, 0, 0, 5);
		gbc_Restart.gridx = 3;
		gbc_Restart.gridy = 0;
		Panel_Reproducción.add(Restart, gbc_Restart);

		JLabel Play_Stop = new JLabel("");
		Play_Stop.setIcon(new ImageIcon(PanelGestion.class.getResource("/recursos/jugar.png")));
		GridBagConstraints gbc_Play_Stop = new GridBagConstraints();
		gbc_Play_Stop.anchor = GridBagConstraints.NORTHWEST;
		gbc_Play_Stop.insets = new Insets(0, 0, 0, 5);
		gbc_Play_Stop.gridx = 5;
		gbc_Play_Stop.gridy = 0;
		Panel_Reproducción.add(Play_Stop, gbc_Play_Stop);

		JLabel Choose_next = new JLabel("");
		Choose_next.setIcon(new ImageIcon(PanelGestion.class.getResource("/recursos/proximo.png")));
		GridBagConstraints gbc_Choose_next = new GridBagConstraints();
		gbc_Choose_next.anchor = GridBagConstraints.NORTHWEST;
		gbc_Choose_next.insets = new Insets(0, 0, 0, 5);
		gbc_Choose_next.gridx = 7;
		gbc_Choose_next.gridy = 0;
		Panel_Reproducción.add(Choose_next, gbc_Choose_next);

		JButton Boton_Eliminar_Canción = new JButton("Eliminar Canción");
		Boton_Eliminar_Canción
				.setToolTipText("Al presionar este Boton se eliminar la canción seleccionada en la tabla");
		GridBagConstraints gbc_Boton_Eliminar_Canción = new GridBagConstraints();
		gbc_Boton_Eliminar_Canción.fill = GridBagConstraints.HORIZONTAL;
		gbc_Boton_Eliminar_Canción.insets = new Insets(0, 0, 5, 5);
		gbc_Boton_Eliminar_Canción.gridx = 7;
		gbc_Boton_Eliminar_Canción.gridy = 7;
		Boton_Eliminar_Canción.addActionListener(ev -> {
			((DefaultTableModel)panelLista.getTable().getModel()).removeRow(panelLista.getTable().getSelectedRow());
		});
		this.add(Boton_Eliminar_Canción, gbc_Boton_Eliminar_Canción);

		this.setVisible(true);

	}

	private void actualizarPlaylist() {
		DatosTabla datos = new DatosTabla();
		JTable table = panelLista.getTable();
		for (int i = 0; i < panelLista.getTable().getRowCount(); i++) {
			datos.getTitulos().add((String)table.getValueAt(i, 0));
			datos.getInterpretes().add((String)table.getValueAt(i, 1));
			datos.getEstilos().add((String)table.getValueAt(i, 2));
			datos.getFavoritas().add((boolean)table.getValueAt(i, 3));
		}
		if (AppMusic.getUnicaInstancia().actualizarPlaylist(panelLista.getLista().getSelectedValue(), datos)) {
			AppMusic.getUnicaInstancia().showPopup(Principal.getInstancia(), Constantes.EXITO_ACTUALIZAR_PLAYLIST_MENSAJE);
		} else {
			AppMusic.getUnicaInstancia().showPopup(Principal.getInstancia(), Constantes.ERROR_ACTUALIZAR_PLAYLIST_MENSAJE);
		}
	}

	private void añadirPlaylist(String titulo) {
		if (AppMusic.getUnicaInstancia().añadirPlaylist(titulo)) {
			AppMusic.getUnicaInstancia().showPopup(Principal.getInstancia(), Constantes.EXITO_CREAR_PLAYLIST_MENSAJE);
		} else {
			AppMusic.getUnicaInstancia().showPopup(Principal.getInstancia(), Constantes.ERROR_CREAR_PLAYLIST_MENSAJE);
		}
	}

	private void eliminarPlaylist(String titulo) {
		if (AppMusic.getUnicaInstancia().eliminarPlaylist(titulo)) {
			AppMusic.getUnicaInstancia().showPopup(Principal.getInstancia(),
					Constantes.EXITO_ELIMINAR_PLAYLIST_MENSAJE);
		} else {
			AppMusic.getUnicaInstancia().showPopup(Principal.getInstancia(),
					Constantes.ERROR_ELIMINAR_PLAYLIST_MENSAJE);
		}
	}

	public JTable getTable() {
		return panelLista.getTable();
	}

	public void setTable(DatosTabla datos) {
		panelLista.setTable(datos);
		this.remove(scrollPane);
		scrollPane = new JScrollPane(panelLista.getTable());
		GridBagConstraints gbc_table = new GridBagConstraints();
		gbc_table.gridwidth = 3;
		gbc_table.insets = new Insets(0, 0, 5, 5);
		gbc_table.fill = GridBagConstraints.BOTH;
		gbc_table.gridx = 1;
		gbc_table.gridy = 1;
		this.add(scrollPane, gbc_table);
	}
}
