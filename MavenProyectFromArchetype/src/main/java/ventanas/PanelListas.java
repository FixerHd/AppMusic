package ventanas;

import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;

import java.awt.BorderLayout;
import javax.swing.JList;
import javax.swing.AbstractListModel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

public class PanelListas extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTable table;

	/**
	 * Create the panel.
	 */
	public PanelListas() {
		setBorder(new TitledBorder(null, "Listas", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		setLayout(new BorderLayout(0, 0));
		
		JSplitPane splitPane = new JSplitPane();
		splitPane.setOneTouchExpandable(true);
		add(splitPane);
		
		JList list = new JList();
		list.setValueIsAdjusting(true);
		list.setVisibleRowCount(4);
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		list.setModel(new AbstractListModel() {
			String[] values = new String[] {"Lista_1", "Lista_2", "Lista_3", "Lista_4", "Lista_5", "Lista_6", "Lista_7", "Lista_8", "Lista_9", "Lista_10"};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		
		JScrollPane leftScrollPane = new JScrollPane(list);
		splitPane.setLeftComponent(leftScrollPane);
		
		table = new JTable();
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setModel(new DefaultTableModel(new Object[][] { { null, null, null, null }, },
				new String[] { "Titulo", "Interprete", "Estilo", "" }) {
			Class[] columnTypes = new Class[] { Object.class, Object.class, Object.class, Boolean.class };

			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}

			boolean[] columnEditables = new boolean[] { false, false, false, true };

			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		JScrollPane rightScrollPane = new JScrollPane(table);
		splitPane.setRightComponent(rightScrollPane);

	}

}
