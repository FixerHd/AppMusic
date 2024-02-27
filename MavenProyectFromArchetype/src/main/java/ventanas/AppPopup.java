package ventanas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import java.awt.Rectangle;

import javax.swing.JLabel;
import javax.swing.JButton;

import javax.swing.SwingConstants;
import java.awt.Toolkit;

public class AppPopup extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel("com.jtattoo.plaf.hifi.HiFiLookAndFeel");
					AppPopup frame = new AppPopup(new String(""), new Rectangle());
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
	public AppPopup(String mensaje, Rectangle rectangulo) {
		setTitle("Singletune");
		setIconImage(Toolkit.getDefaultToolkit().getImage(AppPopup.class.getResource("/recursos/Singletune_16.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(rectangulo);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel = new JLabel(mensaje);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblNewLabel, BorderLayout.NORTH);
		
		JButton btnNewButton = new JButton("Okay");
		btnNewButton.addActionListener(ev ->{
			this.dispose();
		});
		contentPane.add(btnNewButton, BorderLayout.SOUTH);

	}

}
