package ventanas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.JPanel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.BoxLayout;
import java.awt.GridLayout;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Color;
import javax.swing.border.CompoundBorder;
import javax.swing.border.BevelBorder;
import javax.swing.ImageIcon;
import java.awt.Component;
import javax.swing.border.EtchedBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.MatteBorder;
import javax.swing.border.LineBorder;

public class Login {

	private JFrame frmLogin;
	private JTextField txtUsuario;
	private JTextField txtContrasea;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel("com.jtattoo.plaf.texture.TextureLookAndFeel");
					Login window = new Login();
					window.frmLogin.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Login() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmLogin = new JFrame("AppMusic");
		frmLogin.setTitle("Login");
		frmLogin.setVisible(true);
		frmLogin.setBounds(100, 100, 400, 250);
		frmLogin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmLogin.getContentPane().setLayout(new BorderLayout(0, 0));
		
		JPanel Bottons_panel = new JPanel();
		frmLogin.getContentPane().add(Bottons_panel, BorderLayout.SOUTH);
		
		JButton btnNewButton = new JButton("Login");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton.setIcon(new ImageIcon(Login.class.getResource("/recursos/usuario.png")));
		btnNewButton.addActionListener(ev -> {
			
		});
		Bottons_panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Login con GitHub");
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton_1.setIcon(new ImageIcon(Login.class.getResource("/recursos/github.png")));
		Bottons_panel.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Registro");
		btnNewButton_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton_2.setIcon(new ImageIcon(Login.class.getResource("/recursos/editar.png")));
		btnNewButton_2.addActionListener(ev -> {
			// Crea y muestra la VentanaRegistro cuando se presiona el botón
			Registro VentanaRegistro = new Registro();
            VentanaRegistro.setVisible(true);
            frmLogin.setVisible(false);
		});
		Bottons_panel.add(btnNewButton_2);
		
		JPanel Title_panel = new JPanel();
		Title_panel.setBorder(null);
		frmLogin.getContentPane().add(Title_panel, BorderLayout.NORTH);
		GridBagLayout gbl_Title_panel = new GridBagLayout();
		gbl_Title_panel.columnWidths = new int[]{0, 175, 0, 0};
		gbl_Title_panel.rowHeights = new int[]{51, 0, 0};
		gbl_Title_panel.columnWeights = new double[]{1.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_Title_panel.rowWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		Title_panel.setLayout(gbl_Title_panel);
		
		JPanel Space_panel_1 = new JPanel();
		GridBagConstraints gbc_Space_panel_1 = new GridBagConstraints();
		gbc_Space_panel_1.insets = new Insets(0, 0, 5, 5);
		gbc_Space_panel_1.fill = GridBagConstraints.BOTH;
		gbc_Space_panel_1.gridx = 0;
		gbc_Space_panel_1.gridy = 0;
		Title_panel.add(Space_panel_1, gbc_Space_panel_1);
		
		JPanel Name_panel = new JPanel();
		Name_panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		GridBagConstraints gbc_Name_panel = new GridBagConstraints();
		gbc_Name_panel.insets = new Insets(0, 0, 5, 5);
		gbc_Name_panel.fill = GridBagConstraints.BOTH;
		gbc_Name_panel.gridx = 1;
		gbc_Name_panel.gridy = 0;
		Title_panel.add(Name_panel, gbc_Name_panel);
		
		JLabel lblNewLabel = new JLabel("AppMusic");
		lblNewLabel.setFont(new Font("Source Sans Pro Black", Font.PLAIN, 40));
		Name_panel.add(lblNewLabel);
		
		JPanel Space_panel_2 = new JPanel();
		GridBagConstraints gbc_Space_panel_2 = new GridBagConstraints();
		gbc_Space_panel_2.insets = new Insets(0, 0, 5, 0);
		gbc_Space_panel_2.fill = GridBagConstraints.BOTH;
		gbc_Space_panel_2.gridx = 2;
		gbc_Space_panel_2.gridy = 0;
		Title_panel.add(Space_panel_2, gbc_Space_panel_2);
		
		JPanel Text_panel = new JPanel();
		Text_panel.setBorder(null);
		frmLogin.getContentPane().add(Text_panel, BorderLayout.CENTER);
		GridBagLayout gbl_Text_panel = new GridBagLayout();
		gbl_Text_panel.columnWidths = new int[]{50, 80, 0, 200, 50, 0};
		gbl_Text_panel.rowHeights = new int[]{15, 35, 15, 35, 15, 0};
		gbl_Text_panel.columnWeights = new double[]{1.0, 0.0, 0.0, 1.0, 1.0, Double.MIN_VALUE};
		gbl_Text_panel.rowWeights = new double[]{1.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		Text_panel.setLayout(gbl_Text_panel);
		
		JLabel lblNewLabel_1 = new JLabel("Usuario:");
		lblNewLabel_1.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 16));
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 1;
		gbc_lblNewLabel_1.gridy = 1;
		Text_panel.add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		txtUsuario = new JTextField();
		txtUsuario.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtUsuario.setText("Usuario");
		GridBagConstraints gbc_txtUsuario = new GridBagConstraints();
		gbc_txtUsuario.fill = GridBagConstraints.BOTH;
		gbc_txtUsuario.insets = new Insets(0, 0, 5, 5);
		gbc_txtUsuario.gridx = 3;
		gbc_txtUsuario.gridy = 1;
		Text_panel.add(txtUsuario, gbc_txtUsuario);
		txtUsuario.setColumns(4);
		
		JLabel lblNewLabel_2 = new JLabel("Contraseña:");
		lblNewLabel_2.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 16));
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2.gridx = 1;
		gbc_lblNewLabel_2.gridy = 3;
		Text_panel.add(lblNewLabel_2, gbc_lblNewLabel_2);
		
		txtContrasea = new JTextField();
		txtContrasea.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtContrasea.setSelectedTextColor(new Color(255, 255, 255));
		txtContrasea.setText("Contraseña");
		GridBagConstraints gbc_txtContrasea = new GridBagConstraints();
		gbc_txtContrasea.insets = new Insets(0, 0, 5, 5);
		gbc_txtContrasea.fill = GridBagConstraints.BOTH;
		gbc_txtContrasea.gridx = 3;
		gbc_txtContrasea.gridy = 3;
		Text_panel.add(txtContrasea, gbc_txtContrasea);
		txtContrasea.setColumns(10);
		
	}
	
	public void setVisible() {
		frmLogin.setVisible(true);
	}

}
