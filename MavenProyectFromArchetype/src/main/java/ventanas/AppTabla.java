package ventanas;

import java.util.ArrayList;

import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;

import dominio.DatosTabla;

public class AppTabla extends JTable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ArrayList<Integer> ids = new ArrayList<Integer>();

	public AppTabla() {
		setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		DefaultTableModel model = new DefaultTableModel(new Object[][] { { null, null, null, null }, },
				new String[] { "Titulo", "Interprete", "Estilo", "Favorita" }) {
			private static final long serialVersionUID = 1L;
			@SuppressWarnings("rawtypes")
			Class[] columnTypes = new Class[] { String.class, String.class, String.class, Boolean.class };

			public Class<?> getColumnClass(int columnIndex) {
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
			private static final long serialVersionUID = 1L;
			@SuppressWarnings("rawtypes")
			Class[] columnTypes = new Class[] { String.class, String.class, String.class, Boolean.class };

			public Class<?> getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}

			boolean[] columnEditables = new boolean[] { false, false, false, true };

			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		};
		model.addTableModelListener(new TableModelListener() {
			
			@Override
			public void tableChanged(TableModelEvent e) {
				// TODO
			}
		});
		model.removeRow(0);
		for (int i = 0; i < datos.getTitulos().size(); i++) {
			model.addRow(new Object[] { datos.getTitulos().get(i), datos.getInterpretes().get(i),
					datos.getEstilos().get(i), datos.getFavoritas().get(i) });
			ids.add(datos.getIds().get(i));
		}
		setModel(model);
	}

	public int nextCancionId() {
		int index = (getSelectedRow() + 1) % getRowCount();
		return ids.get(index);
	}

	public int previousCancionId() {
		int index = (getSelectedRow() - 1) % getRowCount();
		return ids.get(index);
	}
}
