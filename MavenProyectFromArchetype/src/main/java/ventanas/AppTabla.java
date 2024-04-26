package ventanas;

import java.util.ArrayList;

import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

import Controlador.AppMusic;
import dominio.DatosTabla;

public class AppTabla extends JTable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ArrayList<String> ids = new ArrayList<String>();

	public AppTabla() {
		setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		DefaultTableModel model = new DefaultTableModel(new Object[][] { { null, null, null, null }, },
				new String[] { "Titulo", "Interprete", "Estilo", "Favorita" }) {
			Class[] columnTypes = new Class[] { Object.class, Object.class, Object.class, Boolean.class };

			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}

			boolean[] columnEditables = new boolean[] { false, false, false, true };

			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		};
		model.removeRow(0);
		setModel(model);
	}

	public AppTabla(DatosTabla datos) {
		setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		DefaultTableModel model = new DefaultTableModel(new Object[][] { { null, null, null, null }, },
				new String[] { "Titulo", "Interprete", "Estilo", "Favorita" }) {
			Class[] columnTypes = new Class[] { Object.class, Object.class, Object.class, Boolean.class };

			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}

			boolean[] columnEditables = new boolean[] { false, false, false, true };

			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		};
		model.removeRow(0);
		for (int i = 0; i < datos.getTitulos().size(); i++) {
			model.addRow(new Object[] { datos.getTitulos().get(i), datos.getInterpretes().get(i),
					datos.getEstilos().get(i), datos.getFavoritas().get(i) });
			ids.add(datos.getIds().get(i));
		}
		setModel(model);
	}
	
	public String nextCancionId() {
		int index = (getSelectedRow() + 1) % getRowCount();
		return ids.get(index);
	}
	
	public String previousCancionId() {
		int index = (getSelectedRow() - 1) % getRowCount();
		return ids.get(index);
	}
}
