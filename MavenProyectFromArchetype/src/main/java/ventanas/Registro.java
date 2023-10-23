package ventanas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.BoxLayout;
import java.awt.FlowLayout;
import javax.swing.SwingConstants;
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

public class Registro extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPanel panel;
	private JButton btnNewButton;
	private JPanel panel_1;
	private JTextField txtUsuario;
	private JTextField txtPassword;
	private JTextField txtNombreCompleto;
	private JTextField textField_3;
	private JLabel lblNewLabel;
	private JButton btnNewButton_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
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
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		panel = new JPanel();
		contentPane.add(panel, 
				BorderLayout.SOUTH);
		
		btnNewButton = new JButton("Registro");
		panel.add(btnNewButton);
		
		panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.CENTER);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[]{15, 105, 138, 20, 155, 15, 15, 0};
		gbl_panel_1.rowHeights = new int[]{15, 0, 0, 0, 0, 0, 15, 0};
		gbl_panel_1.columnWeights = new double[]{1.0, 1.0, 0.0, 0.0, 0.0, 1.0, 1.0, Double.MIN_VALUE};
		gbl_panel_1.rowWeights = new double[]{1.0, 0.0, 1.0, 0.0, 1.0, 0.0, 1.0, Double.MIN_VALUE};
		panel_1.setLayout(gbl_panel_1);
		
		txtUsuario = new JTextField();
		txtUsuario.setText("usuario");
		GridBagConstraints gbc_txtUsuario = new GridBagConstraints();
		gbc_txtUsuario.insets = new Insets(0, 0, 5, 5);
		gbc_txtUsuario.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtUsuario.gridx = 2;
		gbc_txtUsuario.gridy = 1;
		panel_1.add(txtUsuario, gbc_txtUsuario);
		txtUsuario.setColumns(10);
		
		txtPassword = new JTextField();
		txtPassword.setText("password");
		GridBagConstraints gbc_txtPassword = new GridBagConstraints();
		gbc_txtPassword.insets = new Insets(0, 0, 5, 5);
		gbc_txtPassword.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtPassword.gridx = 4;
		gbc_txtPassword.gridy = 1;
		panel_1.add(txtPassword, gbc_txtPassword);
		txtPassword.setColumns(10);
		
		txtNombreCompleto = new JTextField();
		txtNombreCompleto.setText("nombre completo");
		txtNombreCompleto.setHorizontalAlignment(SwingConstants.LEFT);
		txtNombreCompleto.setToolTipText("");
		GridBagConstraints gbc_txtNombreCompleto = new GridBagConstraints();
		gbc_txtNombreCompleto.insets = new Insets(0, 0, 5, 5);
		gbc_txtNombreCompleto.gridwidth = 3;
		gbc_txtNombreCompleto.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtNombreCompleto.gridx = 2;
		gbc_txtNombreCompleto.gridy = 3;
		panel_1.add(txtNombreCompleto, gbc_txtNombreCompleto);
		txtNombreCompleto.setColumns(10);
		
		lblNewLabel = new JLabel("fecha nacimiento");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel.fill = GridBagConstraints.VERTICAL;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 2;
		gbc_lblNewLabel.gridy = 5;
		panel_1.add(lblNewLabel, gbc_lblNewLabel);
		
		textField_3 = new JTextField();
		GridBagConstraints gbc_textField_3 = new GridBagConstraints();
		gbc_textField_3.insets = new Insets(0, 0, 5, 5);
		gbc_textField_3.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_3.gridx = 4;
		gbc_textField_3.gridy = 5;
		panel_1.add(textField_3, gbc_textField_3);
		textField_3.setColumns(10);
		
		btnNewButton_1 = new JButton("Volver");
		btnNewButton_1.setIcon(new ImageIcon(Registro.class.getResource("/recursos/volver (2).png")));
		GridBagConstraints gbc_btnNewButton_1 = new GridBagConstraints();
		gbc_btnNewButton_1.insets = new Insets(0, 0, 0, 5);
		gbc_btnNewButton_1.gridx = 1;
		gbc_btnNewButton_1.gridy = 6;
		panel_1.add(btnNewButton_1, gbc_btnNewButton_1);
		
		btnNewButton_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Crea y muestra la Ventana2 cuando se presiona el botón
                Login ventana2 = new Login();
                ventana2.setVisible();
                setVisible(false);
            }
        });
	}

}
