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
import javax.swing.ListSelectionModel;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import Controlador.AppMusic;
import Utilidades.Constantes;

import java.awt.BorderLayout;

public class PanelGestion extends JPanel {

	private static final long serialVersionUID = 1L;
	private JButton Botón_Seleccionar;
	private JButton Botón_Eliminar;
	private JTable table;
	private JButton Botón_Eliminar_Canción;
	private JPanel panel;
	private JPanel Panel_Reproducción;
	private JLabel Choose_previous;
	private JLabel Restart;
	private JLabel Play_Stop;
	private JLabel Choose_next;
	private JCheckBox Botón_Favoritas;
	private JButton Botón_Crear;

	public PanelGestion() {
		super();

		this.setBorder(new TitledBorder(null, "Gesti\u00F3n", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GridBagLayout gbl_panel_3 = new GridBagLayout();
		gbl_panel_3.columnWidths = new int[] { 30, 70, 10, 10, 70, 0, 10, 70, 30, 0 };
		gbl_panel_3.rowHeights = new int[] { 10, 0, 10, 0, 10, 0, 10, 0, 10, 0 };
		gbl_panel_3.columnWeights = new double[] { 0.0, 0.0, 1.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		gbl_panel_3.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		this.setLayout(gbl_panel_3);

		JTextField Texto_Título = new HintTextField("Nombre completo");
		Texto_Título.setText("Título");
		GridBagConstraints gbc_Texto_Título = new GridBagConstraints();
		gbc_Texto_Título.gridwidth = 5;
		gbc_Texto_Título.insets = new Insets(0, 0, 5, 5);
		gbc_Texto_Título.fill = GridBagConstraints.HORIZONTAL;
		gbc_Texto_Título.gridx = 1;
		gbc_Texto_Título.gridy = 1;
		this.add(Texto_Título, gbc_Texto_Título);
		Texto_Título.setColumns(10);
		
				Botón_Seleccionar = new JButton("Seleccionar");
				Botón_Seleccionar.setToolTipText("Al presionar este botón, se selecciona la playlist escrita en \"titulo\" para mostrarla en la tabla. En caso de que no exista saltará una ventana de selección");
				GridBagConstraints gbc_Botón_Seleccionar = new GridBagConstraints();
				gbc_Botón_Seleccionar.gridwidth = 2;
				gbc_Botón_Seleccionar.fill = GridBagConstraints.HORIZONTAL;
				gbc_Botón_Seleccionar.insets = new Insets(0, 0, 5, 5);
				gbc_Botón_Seleccionar.gridx = 1;
				gbc_Botón_Seleccionar.gridy = 3;
				Botón_Seleccionar.addActionListener(ev -> {
					if (!Texto_Título.getText().isEmpty()) {
						
					} else {
						AppMusic.getUnicaInstancia().showPopup(this, Constantes.ERROR_BUSQUEDA_TITULO_MENSAJE);
					}
				});
				
				Botón_Favoritas = new JCheckBox("Favoritas");
				GridBagConstraints gbc_Botón_Favoritas = new GridBagConstraints();
				gbc_Botón_Favoritas.anchor = GridBagConstraints.WEST;
				gbc_Botón_Favoritas.insets = new Insets(0, 0, 5, 5);
				gbc_Botón_Favoritas.gridx = 7;
				gbc_Botón_Favoritas.gridy = 1;
				add(Botón_Favoritas, gbc_Botón_Favoritas);
				this.add(Botón_Seleccionar, gbc_Botón_Seleccionar);
		
		Botón_Crear = new JButton("Crear");
		Botón_Crear.setToolTipText("Si no existe una playlist con el nombre escrito en \"titulo\", pulsando este botón se crea");
		GridBagConstraints gbc_Botón_Crear = new GridBagConstraints();
		gbc_Botón_Crear.gridwidth = 2;
		gbc_Botón_Crear.fill = GridBagConstraints.HORIZONTAL;
		gbc_Botón_Crear.insets = new Insets(0, 0, 5, 5);
		gbc_Botón_Crear.gridx = 4;
		gbc_Botón_Crear.gridy = 3;
		add(Botón_Crear, gbc_Botón_Crear);

		Botón_Eliminar = new JButton("Eliminar");
		Botón_Eliminar.setToolTipText("Al pulsar este botón se elimina la playlist escrita en \"titulo\". En caso de que no exista, saltará una ventana de selección");
		GridBagConstraints gbc_Botón_Eliminar = new GridBagConstraints();
		gbc_Botón_Eliminar.fill = GridBagConstraints.HORIZONTAL;
		gbc_Botón_Eliminar.insets = new Insets(0, 0, 5, 5);
		gbc_Botón_Eliminar.gridx = 7;
		gbc_Botón_Eliminar.gridy = 3;
		this.add(Botón_Eliminar, gbc_Botón_Eliminar);

		table = new AppTabla();
		JScrollPane scrollPane = new JScrollPane(table);
		
		GridBagConstraints gbc_table = new GridBagConstraints();
		gbc_table.gridwidth = 7;
		gbc_table.insets = new Insets(0, 0, 5, 5);
		gbc_table.fill = GridBagConstraints.BOTH;
		gbc_table.gridx = 1;
		gbc_table.gridy = 5;
		this.add(scrollPane, gbc_table);

		panel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.fill = GridBagConstraints.HORIZONTAL;
		gbc_panel.gridwidth = 5;
		gbc_panel.insets = new Insets(0, 0, 5, 5);
		gbc_panel.gridx = 1;
		gbc_panel.gridy = 7;
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

		Botón_Eliminar_Canción = new JButton("Eliminar Canción");
		Botón_Eliminar_Canción.setToolTipText("Al presionar este botón se eliminar la canción seleccionada en la tabla");
		GridBagConstraints gbc_Botón_Eliminar_Canción = new GridBagConstraints();
		gbc_Botón_Eliminar_Canción.fill = GridBagConstraints.HORIZONTAL;
		gbc_Botón_Eliminar_Canción.insets = new Insets(0, 0, 5, 5);
		gbc_Botón_Eliminar_Canción.gridx = 7;
		gbc_Botón_Eliminar_Canción.gridy = 7;
		this.add(Botón_Eliminar_Canción, gbc_Botón_Eliminar_Canción);

		this.setVisible(true);

	}
}
