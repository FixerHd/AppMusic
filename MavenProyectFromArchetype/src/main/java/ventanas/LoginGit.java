package ventanas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.border.EtchedBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.AbstractAction;
import java.awt.event.ActionEvent;
import javax.swing.Action;

public class LoginGit extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private final Action action = new SwingAction();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel("com.jtattoo.plaf.hifi.HiFiLookAndFeel");
					LoginGit frame = new LoginGit();
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
	public LoginGit() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		JPanel Bottons_panel = new JPanel();
		contentPane.add(Bottons_panel, BorderLayout.SOUTH);

		JButton btnNewButton = new JButton("Login");
		btnNewButton.setIcon(new ImageIcon(LoginGit.class.getResource("/recursos/usuario.png")));
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		Bottons_panel.add(btnNewButton);

		JButton btnNewButton_1 = new JButton("Login con GitHub");
		btnNewButton_1.setIcon(new ImageIcon(LoginGit.class.getResource("/recursos/github.png")));
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		Bottons_panel.add(btnNewButton_1);

		JButton btnNewButton_2 = new JButton("Registro");
		btnNewButton_2.setIcon(new ImageIcon(LoginGit.class.getResource("/recursos/editar.png")));
		btnNewButton_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton_2.addActionListener(ev -> {
			// Crea y muestra la VentanaRegistro cuando se presiona el botón
			Registro VentanaRegistro = new Registro();
			VentanaRegistro.setVisible(true);
			setVisible(false);
		});
		Bottons_panel.add(btnNewButton_2);

		JPanel Text_panel = new JPanel();
		Text_panel.setBorder(null);
		contentPane.add(Text_panel, BorderLayout.WEST);
		GridBagLayout gbl_Text_panel = new GridBagLayout();
		gbl_Text_panel.columnWidths = new int[] { 50, 80, 15, 200, 50, 0 };
		gbl_Text_panel.rowHeights = new int[] { 15, 35, 15, 35, 15, 0 };
		gbl_Text_panel.columnWeights = new double[] { 1.0, 0.0, 0.0, 1.0, 1.0, Double.MIN_VALUE };
		gbl_Text_panel.rowWeights = new double[] { 1.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE };
		Text_panel.setLayout(gbl_Text_panel);

		JLabel lblNewLabel_1 = new JLabel("Usuario:");
		lblNewLabel_1.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 16));
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 1;
		gbc_lblNewLabel_1.gridy = 1;
		Text_panel.add(lblNewLabel_1, gbc_lblNewLabel_1);

		textField = new JTextField();
		textField.setText("Usuario");
		textField.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField.setColumns(4);
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.fill = GridBagConstraints.BOTH;
		gbc_textField.insets = new Insets(0, 0, 5, 5);
		gbc_textField.gridx = 3;
		gbc_textField.gridy = 1;
		Text_panel.add(textField, gbc_textField);

		JLabel lblNewLabel_2 = new JLabel("Contraseña:");
		lblNewLabel_2.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 16));
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2.gridx = 1;
		gbc_lblNewLabel_2.gridy = 3;
		Text_panel.add(lblNewLabel_2, gbc_lblNewLabel_2);

		textField_1 = new JTextField();
		textField_1.setText("Contraseña");
		textField_1.setSelectedTextColor(Color.WHITE);
		textField_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField_1.setColumns(10);
		GridBagConstraints gbc_textField_1 = new GridBagConstraints();
		gbc_textField_1.fill = GridBagConstraints.BOTH;
		gbc_textField_1.insets = new Insets(0, 0, 5, 5);
		gbc_textField_1.gridx = 3;
		gbc_textField_1.gridy = 3;
		Text_panel.add(textField_1, gbc_textField_1);

		JPanel Title_panel = new JPanel();
		Title_panel.setBorder(null);
		contentPane.add(Title_panel, BorderLayout.NORTH);
		GridBagLayout gbl_Title_panel = new GridBagLayout();
		gbl_Title_panel.columnWidths = new int[] { 0, 175, 0, 0 };
		gbl_Title_panel.rowHeights = new int[] { 51, 0, 0 };
		gbl_Title_panel.columnWeights = new double[] { 1.0, 0.0, 1.0, Double.MIN_VALUE };
		gbl_Title_panel.rowWeights = new double[] { 0.0, 1.0, Double.MIN_VALUE };
		Title_panel.setLayout(gbl_Title_panel);

		JPanel Space_panel_1 = new JPanel();
		GridBagConstraints gbc_Space_panel_1 = new GridBagConstraints();
		gbc_Space_panel_1.fill = GridBagConstraints.BOTH;
		gbc_Space_panel_1.insets = new Insets(0, 0, 5, 5);
		gbc_Space_panel_1.gridx = 0;
		gbc_Space_panel_1.gridy = 0;
		Title_panel.add(Space_panel_1, gbc_Space_panel_1);

		JPanel Name_panel = new JPanel();
		Name_panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		GridBagConstraints gbc_Name_panel = new GridBagConstraints();
		gbc_Name_panel.fill = GridBagConstraints.BOTH;
		gbc_Name_panel.insets = new Insets(0, 0, 5, 5);
		gbc_Name_panel.gridx = 1;
		gbc_Name_panel.gridy = 0;
		Title_panel.add(Name_panel, gbc_Name_panel);

		JLabel lblNewLabel = new JLabel("AppMusic");
		lblNewLabel.setFont(new Font("Source Sans Pro Black", Font.PLAIN, 40));
		Name_panel.add(lblNewLabel);

		JPanel Space_panel_2 = new JPanel();
		GridBagConstraints gbc_Space_panel_2 = new GridBagConstraints();
		gbc_Space_panel_2.fill = GridBagConstraints.BOTH;
		gbc_Space_panel_2.insets = new Insets(0, 0, 5, 0);
		gbc_Space_panel_2.gridx = 2;
		gbc_Space_panel_2.gridy = 0;
		Title_panel.add(Space_panel_2, gbc_Space_panel_2);
	}

	private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "SwingAction");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}

		public void actionPerformed(ActionEvent e) {
		}
	}
}
