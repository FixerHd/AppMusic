package ventanas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.BoxLayout;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.Component;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.border.TitledBorder;
import javax.swing.JTextField;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import org.eclipse.persistence.internal.libraries.asm.commons.StaticInitMerger;

import Controlador.AppMusic;

import javax.swing.ListSelectionModel;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import javax.swing.JToggleButton;
import javax.swing.JSeparator;
import java.awt.Font;
import javax.swing.SwingConstants;
import pulsador.Luz;

public class Principal extends JFrame {

	private static final long serialVersionUID = 1L;
	private static Principal unicaInstancia;
	private JPanel contentPane;
	private JTextField txtInterprete;
	private JTextField txtTitulo;
	private JTextField textField;
	private JTable table;
	private JTextField textField_1;
	private JTable table_1;
	private static JPanel Columna;
	private JPanel Principal;
	private JPanel Layout;

	// Singleton
	public static Principal getInstancia() {
		if (unicaInstancia == null) {
			unicaInstancia = new Principal();
			AppMusic.getUnicaInstancia().getVentanas().add(unicaInstancia);
		}
		return unicaInstancia;
	}

	public void removeInstancia() {
		unicaInstancia.setVisible(false);
		unicaInstancia.removeAll();
		unicaInstancia.dispose();
		unicaInstancia = null;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel("com.jtattoo.plaf.texture.TextureLookAndFeel");
					Principal frame = new Principal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Principal() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Principal.class.getResource("/recursos/Singletune_16.png")));
		setTitle("Single Tune");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 450);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		Columna = new JPanel();
		Columna.setBorder(new LineBorder(new Color(0, 0, 0), 3, true));
		contentPane.add(Columna, BorderLayout.WEST);
		GridBagLayout gbl_Columna = new GridBagLayout();
		gbl_Columna.columnWidths = new int[] { 32, 60, 0 };
		gbl_Columna.rowHeights = new int[] { 10, 32, 10, 32, 10, 32, 10, 32, 10, 32, 10, 0, 0, 0, 32, 10, 0 };
		gbl_Columna.columnWeights = new double[] { 1.0, 0.0, Double.MIN_VALUE };
		gbl_Columna.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0,
				0.0, 0.0, Double.MIN_VALUE };
		Columna.setLayout(gbl_Columna);

		Principal = new JPanel();
		contentPane.add(Principal, BorderLayout.CENTER);
		Principal.setLayout(new BoxLayout(Principal, BoxLayout.Y_AXIS));

		JLabel Lupa = new JLabel("");
		Lupa.setIcon(new ImageIcon(Principal.class.getResource("/recursos/lupa.png")));
		GridBagConstraints gbc_Lupa = new GridBagConstraints();
		gbc_Lupa.insets = new Insets(0, 0, 5, 5);
		gbc_Lupa.gridx = 0;
		gbc_Lupa.gridy = 1;
		Columna.add(Lupa, gbc_Lupa);

		JToggleButton Botón_Buscar = new JToggleButton("Buscar");
		PanelBuscar panelBuscar = new PanelBuscar();
		GridBagConstraints gbc_Botón_Buscar = new GridBagConstraints();
		gbc_Botón_Buscar.fill = GridBagConstraints.HORIZONTAL;
		gbc_Botón_Buscar.insets = new Insets(0, 0, 5, 0);
		gbc_Botón_Buscar.gridx = 1;
		gbc_Botón_Buscar.gridy = 1;
		Botón_Buscar.addActionListener(ev -> {
			if (!Botón_Buscar.isSelected()) {
				Principal.remove(panelBuscar);
				Columna.revalidate();
				Columna.repaint();
			} else {
				Principal.add(panelBuscar);
				Columna.revalidate();
				Columna.repaint();
			}
		});
		Columna.add(Botón_Buscar, gbc_Botón_Buscar);

		JLabel Gestión = new JLabel("");
		Gestión.setIcon(new ImageIcon(Principal.class.getResource("/recursos/editar_2.png")));
		GridBagConstraints gbc_Gestión = new GridBagConstraints();
		gbc_Gestión.insets = new Insets(0, 0, 5, 5);
		gbc_Gestión.gridx = 0;
		gbc_Gestión.gridy = 3;
		Columna.add(Gestión, gbc_Gestión);

		PanelGestion panelGestion = new PanelGestion();
		JToggleButton Botón_Gestión = new JToggleButton("Gestion Playlist");
		GridBagConstraints gbc_Botón_Gestión = new GridBagConstraints();
		gbc_Botón_Gestión.insets = new Insets(0, 0, 5, 0);
		gbc_Botón_Gestión.gridx = 1;
		gbc_Botón_Gestión.gridy = 3;
		Botón_Gestión.addActionListener(ev -> {
			if (!Botón_Gestión.isSelected()) {
				Principal.remove(panelGestion);
				Columna.revalidate();
				Columna.repaint();
			} else {
				Principal.add(panelGestion, BorderLayout.NORTH);
				Columna.revalidate();
				Columna.repaint();
			}
		});
		Columna.add(Botón_Gestión, gbc_Botón_Gestión);

		JLabel Recientes = new JLabel("");
		Recientes.setIcon(new ImageIcon(Principal.class.getResource("/recursos/reciente.png")));
		GridBagConstraints gbc_Recientes = new GridBagConstraints();
		gbc_Recientes.insets = new Insets(0, 0, 5, 5);
		gbc_Recientes.gridx = 0;
		gbc_Recientes.gridy = 5;
		Columna.add(Recientes, gbc_Recientes);

		JToggleButton Botón_Recientes = new JToggleButton("Recientes");
		PanelRecientes panelRecientes = new PanelRecientes();
		GridBagConstraints gbc_Botón_Recientes = new GridBagConstraints();
		gbc_Botón_Recientes.fill = GridBagConstraints.HORIZONTAL;
		gbc_Botón_Recientes.insets = new Insets(0, 0, 5, 0);
		gbc_Botón_Recientes.gridx = 1;
		gbc_Botón_Recientes.gridy = 5;
		Botón_Recientes.addActionListener(ev -> {
			if (!Botón_Recientes.isSelected()) {
				Principal.remove(panelRecientes);
				Columna.revalidate();
				Columna.repaint();
			} else {
				Principal.add(panelRecientes);
				Columna.revalidate();
				Columna.repaint();
			}
		});
		Columna.add(Botón_Recientes, gbc_Botón_Recientes);

		JLabel Playlists = new JLabel("");
		Playlists.setIcon(new ImageIcon(Principal.class.getResource("/recursos/lista.png")));
		GridBagConstraints gbc_Playlists = new GridBagConstraints();
		gbc_Playlists.insets = new Insets(0, 0, 5, 5);
		gbc_Playlists.gridx = 0;
		gbc_Playlists.gridy = 7;
		Columna.add(Playlists, gbc_Playlists);

		JToggleButton Botón_Playlists = new JToggleButton("Mis Playlists");
		PanelListas panelLista = new PanelListas();
		GridBagConstraints gbc_Botón_Playlists = new GridBagConstraints();
		gbc_Botón_Playlists.fill = GridBagConstraints.HORIZONTAL;
		gbc_Botón_Playlists.insets = new Insets(0, 0, 5, 0);
		gbc_Botón_Playlists.gridx = 1;
		gbc_Botón_Playlists.gridy = 7;
		Botón_Playlists.addActionListener(ev -> {
			if (!Botón_Recientes.isSelected()) {
				Principal.remove(panelLista);
				Columna.revalidate();
				Columna.repaint();
			} else {
				Principal.add(panelLista);
				Columna.revalidate();
				Columna.repaint();
			}
		});
		Columna.add(Botón_Playlists, gbc_Botón_Playlists);
		
		JLabel Premium = new JLabel("");
		Premium.setIcon(new ImageIcon(Principal.class.getResource("/recursos/calidad-premium.png")));
		GridBagConstraints gbc_Premium = new GridBagConstraints();
		gbc_Premium.insets = new Insets(0, 0, 5, 5);
		gbc_Premium.gridx = 0;
		gbc_Premium.gridy = 9;
		Columna.add(Premium, gbc_Premium);

		JButton Botón_Premium = new JButton("Premium");
		GridBagConstraints gbc_Botón_Premium = new GridBagConstraints();
		gbc_Botón_Premium.fill = GridBagConstraints.HORIZONTAL;
		gbc_Botón_Premium.insets = new Insets(0, 0, 5, 0);
		gbc_Botón_Premium.gridx = 1;
		gbc_Botón_Premium.gridy = 9;
		Columna.add(Botón_Premium, gbc_Botón_Premium);
		Botón_Premium.addActionListener(ev -> {

			gbl_Columna.columnWidths = new int[] { 32, 60, 0 };
			gbl_Columna.rowHeights = new int[] { 10, 32, 10, 32, 10, 32, 10, 32, 10, 32, 10, 32, 10, 0, 32, 10, 0 };
			gbl_Columna.columnWeights = new double[] { 1.0, 0.0, Double.MIN_VALUE };
			gbl_Columna.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
					1.0, 0.0, 0.0, Double.MIN_VALUE };

			Columna.remove(Botón_Premium);
			Columna.remove(Premium);
			
			JLabel PDF = new JLabel("");
			PDF.setIcon(new ImageIcon(Principal.class.getResource("/recursos/archivo-pdf.png")));
			GridBagConstraints gbc_PDF = new GridBagConstraints();
			gbc_PDF.insets = new Insets(0, 0, 5, 5);
			gbc_PDF.gridx = 0;
			gbc_PDF.gridy = 9;
			Columna.add(PDF, gbc_PDF);

			JButton Botón_PDF = new JButton("Generar PDF");
			GridBagConstraints gbc_Botón_PDF = new GridBagConstraints();
			gbc_Botón_PDF.fill = GridBagConstraints.HORIZONTAL;
			gbc_Botón_PDF.gridx = 1;
			gbc_Botón_PDF.gridy = 9;
			gbc_Botón_PDF.gridwidth = 1;
			Columna.setLayout(gbl_Columna);
			Columna.add(Botón_PDF, gbc_Botón_PDF);
			
			JLabel Tendencias = new JLabel("");
			Tendencias.setIcon(new ImageIcon(Principal.class.getResource("/recursos/fuego.png")));
			GridBagConstraints gbc_Tendencias = new GridBagConstraints();
			gbc_Tendencias.insets = new Insets(0, 0, 5, 5);
			gbc_Tendencias.gridx = 0;
			gbc_Tendencias.gridy = 11;
			Columna.add(Tendencias, gbc_Tendencias);

			JButton Botón_Tendencias = new JButton("Tendencias");
			GridBagConstraints gbc_Botón_Tendencias = new GridBagConstraints();
			gbc_Botón_Tendencias.fill = GridBagConstraints.HORIZONTAL;
			gbc_Botón_Tendencias.gridx = 1;
			gbc_Botón_Tendencias.gridy = 11;
			gbc_Botón_Tendencias.gridwidth = 1;
			Columna.setLayout(gbl_Columna);
			Columna.add(Botón_Tendencias, gbc_Botón_Tendencias);

			Columna.revalidate();
			Columna.repaint();
		});

		JButton Botón_Logout = new JButton("Logout");
		GridBagConstraints gbc_Botón_Logout = new GridBagConstraints();
		gbc_Botón_Logout.insets = new Insets(0, 0, 5, 0);
		gbc_Botón_Logout.fill = GridBagConstraints.HORIZONTAL;
		gbc_Botón_Logout.gridx = 1;
		gbc_Botón_Logout.gridy = 14;
		Botón_Logout.addActionListener(ev -> {
			Selector.getInstancia().setVisible(true);
			getInstancia().setVisible(false);
		});
		
		JLabel Logout = new JLabel("");
		Logout.setIcon(new ImageIcon(Principal.class.getResource("/recursos/cerrar-sesion.png")));
		GridBagConstraints gbc_Logout = new GridBagConstraints();
		gbc_Logout.insets = new Insets(0, 0, 5, 5);
		gbc_Logout.gridx = 0;
		gbc_Logout.gridy = 14;
		Columna.add(Logout, gbc_Logout);
		Columna.add(Botón_Logout, gbc_Botón_Logout);

		/*
		 * JLabel Opciones_label = new JLabel(""); Opciones_label.setIcon(new
		 * ImageIcon(Principal.class.getResource("/recursos/configuracion.png")));
		 * GridBagConstraints gbc_Opciones = new GridBagConstraints();
		 * gbc_Opciones.insets = new Insets(0, 0, 5, 5); gbc_Opciones.gridx = 0;
		 * gbc_Opciones.gridy = 12; Columna.add(Opciones_label, gbc_Opciones);
		 */

		/*
		 * JButton Botón_Opciones = new JButton("Opciones"); GridBagConstraints
		 * gbc_Botón_Opciones = new GridBagConstraints(); gbc_Botón_Opciones.fill =
		 * GridBagConstraints.HORIZONTAL; gbc_Botón_Opciones.insets = new Insets(0, 0,
		 * 5, 0); gbc_Botón_Opciones.gridx = 1; gbc_Botón_Opciones.gridy = 12;
		 * Botón_Opciones.addActionListener(ev -> {
		 * Opciones.getInstancia().setVisible(true); setVisible(false); });
		 * Columna.add(Botón_Opciones, gbc_Botón_Opciones);
		 */

		Layout = new JPanel();
		Principal.add(Layout);
		Layout.setLayout(new FlowLayout(FlowLayout.RIGHT, 5, 5));

		PanelEstilos panelEstilos = new PanelEstilos();
		Layout.add(panelEstilos);
		
		Luz luz = new Luz();
		luz.setEncendido(true);
		luz.setColor(new Color(0, 128, 0));
		Layout.add(luz);

	}

}
