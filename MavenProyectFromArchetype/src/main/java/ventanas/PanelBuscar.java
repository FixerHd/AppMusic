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
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import Controlador.AppMusic;
import Utilidades.Constantes;
import dominio.DatosTabla;

public class PanelBuscar extends JPanel{
	
	private static final long serialVersionUID = 1L;
	private JCheckBox Botón_Favoritas;
	private JButton Botón_Buscar;
	private HintTextField Texto_Titulo;
	private HintTextField Texto_Interprete;
	private JComboBox Estilo;

	public PanelBuscar() {
		super();
		
		this.setBorder(new TitledBorder(null, "Buscar", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GridBagLayout gbl_panelBuscar = new GridBagLayout();
		gbl_panelBuscar.columnWidths = new int[]{20, 10, 198, 0, 30, 50, 10, 20, 0};
		gbl_panelBuscar.rowHeights = new int[]{10, 20, 10, 20, 10, 20, 10, 0, 00, 0};
		gbl_panelBuscar.columnWeights = new double[]{0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panelBuscar.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		this.setLayout(gbl_panelBuscar);
		
		Texto_Interprete = new HintTextField("Interprete");
		GridBagConstraints gbc_Texto_Interprete = new GridBagConstraints();
		gbc_Texto_Interprete.gridwidth = 2;
		gbc_Texto_Interprete.insets = new Insets(0, 0, 5, 5);
		gbc_Texto_Interprete.fill = GridBagConstraints.HORIZONTAL;
		gbc_Texto_Interprete.gridx = 2;
		gbc_Texto_Interprete.gridy = 1;
		this.add(Texto_Interprete, gbc_Texto_Interprete);
		Texto_Interprete.setColumns(10);
		
		Botón_Favoritas = new JCheckBox("Favoritas");
		GridBagConstraints gbc_Botón_Favoritas = new GridBagConstraints();
		gbc_Botón_Favoritas.fill = GridBagConstraints.HORIZONTAL;
		gbc_Botón_Favoritas.insets = new Insets(0, 0, 5, 5);
		gbc_Botón_Favoritas.gridx = 5;
		gbc_Botón_Favoritas.gridy = 1;
		this.add(Botón_Favoritas, gbc_Botón_Favoritas);
		
		Texto_Titulo = new HintTextField("Titulo");
		GridBagConstraints gbc_Texto_Titulo = new GridBagConstraints();
		gbc_Texto_Titulo.gridwidth = 2;
		gbc_Texto_Titulo.insets = new Insets(0, 0, 5, 5);
		gbc_Texto_Titulo.fill = GridBagConstraints.HORIZONTAL;
		gbc_Texto_Titulo.gridx = 2;
		gbc_Texto_Titulo.gridy = 3;
		this.add(Texto_Titulo, gbc_Texto_Titulo);
		Texto_Titulo.setColumns(10);
		
		Estilo = new JComboBox();
		GridBagConstraints gbc_Estilo = new GridBagConstraints();
		gbc_Estilo.gridwidth = 2;
		gbc_Estilo.insets = new Insets(0, 0, 5, 5);
		gbc_Estilo.fill = GridBagConstraints.HORIZONTAL;
		gbc_Estilo.gridx = 2;
		gbc_Estilo.gridy = 5;
		Estilo.addItem("Estilo");
		this.add(Estilo, gbc_Estilo);
		
		Botón_Buscar = new JButton("Buscar");
		PanelResultado panelResultado = new PanelResultado();
		GridBagConstraints gbc_Botón_Buscar = new GridBagConstraints();
		gbc_Botón_Buscar.fill = GridBagConstraints.HORIZONTAL;
		gbc_Botón_Buscar.insets = new Insets(0, 0, 5, 5);
		gbc_Botón_Buscar.gridx = 5;
		gbc_Botón_Buscar.gridy = 3;
		Botón_Buscar.addActionListener(ev-> {
			DatosTabla datos = AppMusic.getUnicaInstancia().buscarCanciones(Texto_Titulo.getText(), Texto_Interprete.getText(), Estilo.getSelectedItem(), Botón_Favoritas.isSelected());
			if (datos != null) {
				gbl_panelBuscar.columnWidths = new int[]{20, 10, 198, 0, 30, 50, 10, 20, 0};
				gbl_panelBuscar.rowHeights = new int[]{10, 20, 10, 20, 10, 20, 10, 0, 10, 0};
				gbl_panelBuscar.columnWeights = new double[]{0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
				gbl_panelBuscar.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
				GridBagConstraints gbc_panelResultado = new GridBagConstraints();
				gbc_panelResultado.fill = GridBagConstraints.BOTH;
				gbc_panelResultado.gridx = 1;
				gbc_panelResultado.gridy = 7;
				gbc_panelResultado.gridwidth = 6;
				panelResultado.setTable(datos);
				this.setLayout(gbl_panelBuscar);
				this.add(panelResultado, gbc_panelResultado);
				this.revalidate();
				this.repaint();
			} else {
				AppMusic.getUnicaInstancia().showPopup(Principal.getInstancia(), Constantes.ERROR_TABLA_VACIA_MENSAJE);
			}
		});
		this.add(Botón_Buscar, gbc_Botón_Buscar);
		
		this.setVisible(true);
	
	}

}
