package ventanas;

import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import Controlador.AppMusic;
import dominio.DatosTabla;

import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.util.List;

import javax.swing.JList;
import javax.swing.AbstractListModel;
import javax.swing.DefaultListModel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

public class PanelListas extends JPanel {

	private static final long serialVersionUID = 1L;
	private AppTabla table;
	private JList<String> lista;
	private JScrollPane leftScrollPane;
	private JScrollPane rightScrollPane;

	/**
	 * Create the panel.
	 */
	public PanelListas() {
		setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		setLayout(new BorderLayout(0, 0));

		JSplitPane splitPane = new JSplitPane();
		splitPane.setOneTouchExpandable(true);
		add(splitPane);

		lista = new JList<String>();
		lista.setValueIsAdjusting(true);
		lista.setVisibleRowCount(4);
		lista.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		lista.setModel(new AbstractListModel() {
			String[] values = new String[] {};

			public int getSize() {
				return values.length;
			}

			public Object getElementAt(int index) {
				return values[index];
			}
		});

		leftScrollPane = new JScrollPane(lista);
		splitPane.setLeftComponent(leftScrollPane);

		table = new AppTabla();
		rightScrollPane = new JScrollPane(table);
		splitPane.setRightComponent(rightScrollPane);

		setVisible(true);
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

	public AppTabla getTable() {
		return table;
	}

	public void setTable(DatosTabla datos) {
		table = new AppTabla(datos);
		remove(rightScrollPane);
		rightScrollPane = new JScrollPane(table);
		add(rightScrollPane);
	}

}
