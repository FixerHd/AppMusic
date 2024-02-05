package ventanas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.BoxLayout;
import java.awt.FlowLayout;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

import java.awt.GridLayout;
import java.awt.BorderLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import javax.swing.JTextField;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.ImageIcon;
import com.toedter.calendar.JCalendar;
import com.toedter.calendar.JDateChooser;

import Controlador.AppMusic;

import javax.swing.JPasswordField;
import java.awt.Font;
import java.awt.Toolkit;

public class Registro extends JFrame {

	private static final long serialVersionUID = 1L;
	private static Registro unicaInstancia;
	private JPanel contentPane;
	private JPanel panel;
	private JButton btnNewButton;
	private JPanel panel_1;
	private JTextField txtUsuario;
	private JTextField txtNombreCompleto;
	private JLabel lblNewLabel;
	private JButton btnNewButton_1;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JDateChooser dateChooser;
	private JPasswordField passwordField;

	// Singleton
	public static Registro getInstancia() {
		if (unicaInstancia == null) {
			unicaInstancia = new Registro();
			AppMusic.getUnicaInstancia().getVentanas().add(unicaInstancia);
		}
		return unicaInstancia;
	}
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel("com.jtattoo.plaf.hifi.HiFiLookAndFeel");
					Registro frame = new Registro();
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
	public Registro() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Registro.class.getResource("/recursos/Singletune_16.png")));
		setTitle("Registro");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 550, 250);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		panel = new JPanel();
		contentPane.add(panel, BorderLayout.SOUTH);

		btnNewButton_1 = new JButton("Volver");
		btnNewButton_1.setIcon(new ImageIcon(Registro.class.getResource("/recursos/flecha-hacia-atras.png")));
		btnNewButton_1.addActionListener(ev -> {
			Selector.getInstancia().setVisible(true);
			setVisible(false);
		});
		panel.add(btnNewButton_1);

		btnNewButton = new JButton("Registro");
		btnNewButton.setIcon(new ImageIcon(Registro.class.getResource("/recursos/anadir.png")));
		btnNewButton.addActionListener(ev -> {
			Principal.getInstancia().setVisible(true);
			setVisible(false);
		});
		panel.add(btnNewButton);

		panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.CENTER);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[] { 15, 100, 100, 100, 100, 15, 0 };
		gbl_panel_1.rowHeights = new int[] { 15, 35, 15, 35, 15, 35, 15, 0 };
		gbl_panel_1.columnWeights = new double[] { 1.0, 0.0, 1.0, 0.0, 1.0, 1.0, Double.MIN_VALUE };
		gbl_panel_1.rowWeights = new double[] { 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE };
		panel_1.setLayout(gbl_panel_1);

		lblNewLabel_1 = new JLabel("Usuario:");
		lblNewLabel_1.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 14));
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_1.gridx = 1;
		gbc_lblNewLabel_1.gridy = 1;
		panel_1.add(lblNewLabel_1, gbc_lblNewLabel_1);

		JTextField txtUsuario = new HintTextField("Usuario");
		txtUsuario.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints gbc_txtUsuario = new GridBagConstraints();
		gbc_txtUsuario.insets = new Insets(0, 0, 5, 5);
		gbc_txtUsuario.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtUsuario.gridx = 2;
		gbc_txtUsuario.gridy = 1;
		panel_1.add(txtUsuario, gbc_txtUsuario);
		txtUsuario.setColumns(10);

		lblNewLabel_3 = new JLabel("Contraseña:");
		lblNewLabel_3.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 14));
		GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
		gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_3.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_3.gridx = 3;
		gbc_lblNewLabel_3.gridy = 1;
		panel_1.add(lblNewLabel_3, gbc_lblNewLabel_3);

		JTextField passwordField = new HintTextField("Contraseña");
		passwordField.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints gbc_passwordField = new GridBagConstraints();
		gbc_passwordField.insets = new Insets(0, 0, 5, 5);
		gbc_passwordField.fill = GridBagConstraints.HORIZONTAL;
		gbc_passwordField.gridx = 4;
		gbc_passwordField.gridy = 1;
		panel_1.add(passwordField, gbc_passwordField);

		lblNewLabel_2 = new JLabel("Nombre:");
		lblNewLabel_2.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 14));
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_2.gridx = 1;
		gbc_lblNewLabel_2.gridy = 3;
		panel_1.add(lblNewLabel_2, gbc_lblNewLabel_2);

		JTextField txtNombreCompleto = new HintTextField("Nombre completo");
		txtNombreCompleto.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtNombreCompleto.setHorizontalAlignment(SwingConstants.LEFT);
		GridBagConstraints gbc_txtNombreCompleto = new GridBagConstraints();
		gbc_txtNombreCompleto.insets = new Insets(0, 0, 5, 5);
		gbc_txtNombreCompleto.gridwidth = 3;
		gbc_txtNombreCompleto.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtNombreCompleto.gridx = 2;
		gbc_txtNombreCompleto.gridy = 3;
		panel_1.add(txtNombreCompleto, gbc_txtNombreCompleto);
		txtNombreCompleto.setColumns(10);

		lblNewLabel = new JLabel("Fecha Nacimiento:");
		lblNewLabel.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 14));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 3;
		gbc_lblNewLabel.gridy = 5;
		panel_1.add(lblNewLabel, gbc_lblNewLabel);

		dateChooser = new JDateChooser();
		GridBagConstraints gbc_dateChooser = new GridBagConstraints();
		gbc_dateChooser.insets = new Insets(0, 0, 5, 5);
		gbc_dateChooser.fill = GridBagConstraints.HORIZONTAL;
		gbc_dateChooser.gridx = 4;
		gbc_dateChooser.gridy = 5;
		panel_1.add(dateChooser, gbc_dateChooser);
	}

}
