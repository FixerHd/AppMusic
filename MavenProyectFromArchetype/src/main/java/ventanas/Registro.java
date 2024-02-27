package ventanas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

import java.awt.BorderLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import javax.swing.JTextField;
import java.awt.Insets;
import java.awt.Rectangle;

import javax.swing.JLabel;
import javax.swing.ImageIcon;
import com.toedter.calendar.JDateChooser;

import Controlador.AppMusic;

import java.awt.Font;
import java.awt.Toolkit;

public class Registro extends JFrame {

	private static final long serialVersionUID = 1L;
	private static Registro unicaInstancia;
	private static final int X = 100;
	private static final int Y = 100;
	private static final int WIDTH = 550;
	private static final int HEIGHT = 275;
	private JPanel contentPane;
	private JPanel panel;
	private JButton btnNewButton;
	private JPanel panel_1;
	private JLabel Fecha_Nacimiento;
	private JButton btnNewButton_1;
	private JLabel Usuario;
	private JLabel Nombre;
	private JLabel Contraseña;
	private JDateChooser Seleccionador_Fecha;
	private JLabel Email;
	private HintTextField Texto_Email;

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
		setBounds(X, Y, WIDTH, HEIGHT);
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

		panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.CENTER);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[] { 15, 100, 100, 100, 100, 15, 0 };
		gbl_panel_1.rowHeights = new int[] { 15, 15, 35, 0, 15, 35, 15, 35, 15, 35, 15, 15, 0 };
		gbl_panel_1.columnWeights = new double[] { 1.0, 0.0, 1.0, 0.0, 1.0, 1.0, Double.MIN_VALUE };
		gbl_panel_1.rowWeights = new double[] { 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE };
		panel_1.setLayout(gbl_panel_1);

		Usuario = new JLabel("Usuario:");
		Usuario.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 14));
		GridBagConstraints gbc_Usuario = new GridBagConstraints();
		gbc_Usuario.insets = new Insets(0, 0, 5, 5);
		gbc_Usuario.anchor = GridBagConstraints.EAST;
		gbc_Usuario.gridx = 1;
		gbc_Usuario.gridy = 2;
		panel_1.add(Usuario, gbc_Usuario);

		JTextField Texto_Usuario = new HintTextField("Usuario");
		GridBagConstraints gbc_Texto_Usuario = new GridBagConstraints();
		gbc_Texto_Usuario.insets = new Insets(0, 0, 5, 5);
		gbc_Texto_Usuario.fill = GridBagConstraints.HORIZONTAL;
		gbc_Texto_Usuario.gridx = 2;
		gbc_Texto_Usuario.gridy = 2;
		panel_1.add(Texto_Usuario, gbc_Texto_Usuario);
		Texto_Usuario.setColumns(10);

		Contraseña = new JLabel("Contraseña:");
		Contraseña.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 14));
		GridBagConstraints gbc_Contraseña = new GridBagConstraints();
		gbc_Contraseña.insets = new Insets(0, 0, 5, 5);
		gbc_Contraseña.anchor = GridBagConstraints.EAST;
		gbc_Contraseña.gridx = 3;
		gbc_Contraseña.gridy = 2;
		panel_1.add(Contraseña, gbc_Contraseña);

		JTextField Texto_Contraseña = new HintTextField("Contraseña");
		GridBagConstraints gbc_Texto_Contraseña = new GridBagConstraints();
		gbc_Texto_Contraseña.insets = new Insets(0, 0, 5, 5);
		gbc_Texto_Contraseña.fill = GridBagConstraints.HORIZONTAL;
		gbc_Texto_Contraseña.gridx = 4;
		gbc_Texto_Contraseña.gridy = 2;
		panel_1.add(Texto_Contraseña, gbc_Texto_Contraseña);

		Nombre = new JLabel("Nombre:");
		Nombre.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 14));
		GridBagConstraints gbc_Nombre = new GridBagConstraints();
		gbc_Nombre.insets = new Insets(0, 0, 5, 5);
		gbc_Nombre.anchor = GridBagConstraints.EAST;
		gbc_Nombre.gridx = 1;
		gbc_Nombre.gridy = 5;
		panel_1.add(Nombre, gbc_Nombre);

		JTextField Texto_Nombre = new HintTextField("Nombre completo");
		Texto_Nombre.setHorizontalAlignment(SwingConstants.LEFT);
		GridBagConstraints gbc_Texto_Nombre = new GridBagConstraints();
		gbc_Texto_Nombre.insets = new Insets(0, 0, 5, 5);
		gbc_Texto_Nombre.gridwidth = 3;
		gbc_Texto_Nombre.fill = GridBagConstraints.HORIZONTAL;
		gbc_Texto_Nombre.gridx = 2;
		gbc_Texto_Nombre.gridy = 5;
		panel_1.add(Texto_Nombre, gbc_Texto_Nombre);
		Texto_Nombre.setColumns(10);
		
		Email = new JLabel("Email:");
		Email.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 14));
		GridBagConstraints gbc_Email = new GridBagConstraints();
		gbc_Email.anchor = GridBagConstraints.EAST;
		gbc_Email.insets = new Insets(0, 0, 5, 5);
		gbc_Email.gridx = 1;
		gbc_Email.gridy = 7;
		panel_1.add(Email, gbc_Email);
		
		Texto_Email = new HintTextField("Email");
		GridBagConstraints gbc_Texto_Email = new GridBagConstraints();
		gbc_Texto_Email.gridwidth = 3;
		gbc_Texto_Email.insets = new Insets(0, 0, 5, 5);
		gbc_Texto_Email.fill = GridBagConstraints.HORIZONTAL;
		gbc_Texto_Email.gridx = 2;
		gbc_Texto_Email.gridy = 7;
		panel_1.add(Texto_Email, gbc_Texto_Email);

		Fecha_Nacimiento = new JLabel("Fecha Nacimiento:");
		Fecha_Nacimiento.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 14));
		GridBagConstraints gbc_Fecha_Nacimiento = new GridBagConstraints();
		gbc_Fecha_Nacimiento.anchor = GridBagConstraints.EAST;
		gbc_Fecha_Nacimiento.insets = new Insets(0, 0, 5, 5);
		gbc_Fecha_Nacimiento.gridx = 3;
		gbc_Fecha_Nacimiento.gridy = 9;
		panel_1.add(Fecha_Nacimiento, gbc_Fecha_Nacimiento);

		Seleccionador_Fecha = new JDateChooser();
		GridBagConstraints gbc_Seleccionador_Fecha = new GridBagConstraints();
		gbc_Seleccionador_Fecha.insets = new Insets(0, 0, 5, 5);
		gbc_Seleccionador_Fecha.fill = GridBagConstraints.HORIZONTAL;
		gbc_Seleccionador_Fecha.gridx = 4;
		gbc_Seleccionador_Fecha.gridy = 9;
		panel_1.add(Seleccionador_Fecha, gbc_Seleccionador_Fecha);
		
		btnNewButton = new JButton("Registro");
		btnNewButton.setIcon(new ImageIcon(Registro.class.getResource("/recursos/anadir.png")));
		btnNewButton.addActionListener(ev -> {
			if(AppMusic.getUnicaInstancia().registrarUsuario(Texto_Nombre.getText(), Texto_Email.getText(), Texto_Contraseña.getText(), Seleccionador_Fecha.getDateFormatString())) {
				Principal.getInstancia().setVisible(true);
				setVisible(false);
			}
			Rectangle r = new Rectangle(X + WIDTH/2 - 250/2, Y + HEIGHT/2 - 100/2, 250, 100);
			AppPopup p = new AppPopup(Constantes.ERROR_INICIO_SESION, r);
			p.setVisible(true);
		});
		panel.add(btnNewButton);
	}

}
