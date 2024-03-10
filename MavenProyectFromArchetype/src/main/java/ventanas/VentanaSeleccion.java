package ventanas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;

import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.ImageIcon;

import Controlador.AppMusic;
import Utilidades.Constantes;
import dominio.DatosLista;
import dominio.DatosTabla;

import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.io.FileFilter;
import java.util.List;

import javax.swing.JToggleButton;
import pulsador.Luz;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;

public class VentanaSeleccion extends JFrame {

	private static final long serialVersionUID = 1L;
	private static final int X = 100;
	private static final int Y = 100;
	private static final int WIDTH = 45;
	private static final int HEIGHT = 300;
	private JPanel contentPane;
	private JList<String> lista;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel("com.jtattoo.plaf.texture.TextureLookAndFeel");
					VentanaSeleccion frame = new VentanaSeleccion(new PanelResultado());
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
	public VentanaSeleccion(PanelResultado ventana_padre) {
		setIconImage(Toolkit.getDefaultToolkit().getImage(VentanaSeleccion.class.getResource("/recursos/Singletune_16.png")));
		setTitle("Seleccion");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(X, Y, WIDTH, HEIGHT);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		lista = new JList<String>();
		lista.setVisibleRowCount(4);
		lista.setValueIsAdjusting(true);
		lista.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		DatosLista datos = AppMusic.getUnicaInstancia().getMisPlaylists(false);
		if (datos != null) {
			setLista(datos.getNombres());
			this.revalidate();
			this.repaint();
		} else {
			AppMusic.getUnicaInstancia().showPopup(Principal.getInstancia(), Constantes.ERROR_LISTA_VACIA_MENSAJE);
		}
		lista.addListSelectionListener(ev -> {
			ventana_padre.setPlaylist(lista.getSelectedValue());
			ventana_padre.setEnabled(true);
			dispose();
		});
		JScrollPane scrollPane = new JScrollPane(lista);
		contentPane.add(scrollPane, BorderLayout.CENTER);
		
		JLabel lblNewLabel = new JLabel("Selecciona una playlist");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblNewLabel, BorderLayout.NORTH);

	}
	
	public JList<String> getLista() {
		return lista;
	}
	
	public void setLista(List<String> new_values) {
		DefaultListModel<String> model = new DefaultListModel<String>();
		for (String s : new_values) {
			model.addElement(s);
		}
		this.lista.setModel(model);
	}

}
