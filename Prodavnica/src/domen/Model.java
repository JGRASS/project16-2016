package domen;

import java.util.Vector;

import javax.swing.table.DefaultTableModel;

@SuppressWarnings("serial")
public class Model extends DefaultTableModel {
	
	
	
	public Model() {
		super();
	}

	public Model(int rowCount, int columnCount) {
		super(rowCount, columnCount);
	}

	public Model(Object[] columnNames, int rowCount) {
		super(columnNames, rowCount);
	}

	public Model(Object[][] data, Object[] columnNames) {
		super(data, columnNames);
	}

	@SuppressWarnings("rawtypes")
	public Model(Vector columnNames, int rowCount) {
		super(columnNames, rowCount);
	}

	@SuppressWarnings("rawtypes")
	public Model(Vector data, Vector columnNames) {
		super(data, columnNames);
	}

	@Override
	public boolean isCellEditable(int row, int column) {
		return false;
	}

}
