package ventanas;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.LayoutManager;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import Controlador.AppMusic;

public class PanelBuscar extends JPanel{
	
	private static final long serialVersionUID = 1L;
	private JTextField txtInterprete;
	private JTextField txtTitulo;
	private JCheckBox chckbxNewCheckBox;
	private JButton btnNewButton;
	private JComboBox comboBox;

	public PanelBuscar() {
		super();
		
		this.setBorder(new TitledBorder(null, "Buscar", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GridBagLayout gbl_panelBuscar = new GridBagLayout();
		gbl_panelBuscar.columnWidths = new int[]{20, 10, 198, 0, 30, 50, 10, 20, 0};
		gbl_panelBuscar.rowHeights = new int[]{10, 20, 10, 20, 10, 20, 10, 0, 00, 0};
		gbl_panelBuscar.columnWeights = new double[]{0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panelBuscar.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		this.setLayout(gbl_panelBuscar);
		
		JTextField txtInterprete = new HintTextField("Interprete");
		GridBagConstraints gbc_txtInterprete = new GridBagConstraints();
		gbc_txtInterprete.gridwidth = 2;
		gbc_txtInterprete.insets = new Insets(0, 0, 5, 5);
		gbc_txtInterprete.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtInterprete.gridx = 2;
		gbc_txtInterprete.gridy = 1;
		this.add(txtInterprete, gbc_txtInterprete);
		txtInterprete.setColumns(10);
		
		chckbxNewCheckBox = new JCheckBox("Favoritas");
		GridBagConstraints gbc_chckbxNewCheckBox = new GridBagConstraints();
		gbc_chckbxNewCheckBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_chckbxNewCheckBox.insets = new Insets(0, 0, 5, 5);
		gbc_chckbxNewCheckBox.gridx = 5;
		gbc_chckbxNewCheckBox.gridy = 1;
		this.add(chckbxNewCheckBox, gbc_chckbxNewCheckBox);
		
		JTextField txtTitulo = new HintTextField("Titulo");
		GridBagConstraints gbc_txtTitulo = new GridBagConstraints();
		gbc_txtTitulo.gridwidth = 2;
		gbc_txtTitulo.insets = new Insets(0, 0, 5, 5);
		gbc_txtTitulo.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtTitulo.gridx = 2;
		gbc_txtTitulo.gridy = 3;
		this.add(txtTitulo, gbc_txtTitulo);
		txtTitulo.setColumns(10);
		
		
		btnNewButton = new JButton("Buscar");
		PanelResultado panelResultado = new PanelResultado();
		GridBagConstraints gbc_btnNewButton_6 = new GridBagConstraints();
		gbc_btnNewButton_6.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnNewButton_6.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton_6.gridx = 5;
		gbc_btnNewButton_6.gridy = 3;
		btnNewButton.addActionListener(ev-> {
			gbl_panelBuscar.columnWidths = new int[]{20, 10, 198, 0, 30, 50, 10, 20, 0};
			gbl_panelBuscar.rowHeights = new int[]{10, 20, 10, 20, 10, 20, 10, 0, 10, 0};
			gbl_panelBuscar.columnWeights = new double[]{0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
			gbl_panelBuscar.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
			GridBagConstraints gbc_panelResultado = new GridBagConstraints();
			gbc_panelResultado.fill = GridBagConstraints.BOTH;
			gbc_panelResultado.gridx = 1;
			gbc_panelResultado.gridy = 7;
			gbc_panelResultado.gridwidth = 6;
			this.setLayout(gbl_panelBuscar);
			this.add(panelResultado, gbc_panelResultado);
			this.revalidate();
			this.repaint();
		});
		this.add(btnNewButton, gbc_btnNewButton_6);
		
		comboBox = new JComboBox();
		GridBagConstraints gbc_comboBox = new GridBagConstraints();
		gbc_comboBox.gridwidth = 2;
		gbc_comboBox.insets = new Insets(0, 0, 5, 5);
		gbc_comboBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox.gridx = 2;
		gbc_comboBox.gridy = 5;
		comboBox.addItem("Estilo");
		this.add(comboBox, gbc_comboBox);
		
		this.setVisible(true);
	
	}

}
