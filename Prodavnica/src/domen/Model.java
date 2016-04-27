package domen;

import java.lang.reflect.Constructor;
import java.util.Vector;

import javax.swing.table.DefaultTableModel;

/**
 * Predstavlja model namenjen za rad sa tabelom potrebnom za prikaz proizvoda u prodavnici.
 * Nasledjuje klasu {@link DefaultTableModel} i sadrzi izmene njenih metoda za potrebe ovog programa.
 * 
 * @author Milos Cvetkovic
 *
 */
@SuppressWarnings("serial")
public class Model extends DefaultTableModel {
	
	
	/**
	 * {@link Constructor} koji u sustini poziva konstruktor nadklase {@link DefaultTableModel}.
	 * @author Milos Cvetkovic
	 */
	public Model() {
		super();
	}

	/**
	 * Parametrizovan {@link Constructor} koji u sustini poziva konstruktor nadklase {@link DefaultTableModel}.
	 * 
	 * @param rowCount
	 * @param columnCount
	 * @author Milos Cvetkovic
	 */
	public Model(int rowCount, int columnCount) {
		super(rowCount, columnCount);
	}

	/**
	 * Parametrizovan {@link Constructor} koji u sustini poziva konstruktor nadklase {@link DefaultTableModel}.
	 * 
	 * @param columnNames
	 * @param rowCount
	 * @author Milos Cvetkovic
	 */
	public Model(Object[] columnNames, int rowCount) {
		super(columnNames, rowCount);
	}

	/**
	 * Parametrizovan {@link Constructor} koji u sustini poziva konstruktor nadklase {@link DefaultTableModel}.
	 * 
	 * @param data
	 * @param columnNames
	 * @author Milos Cvetkovic
	 */
	public Model(Object[][] data, Object[] columnNames) {
		super(data, columnNames);
	}

	/**
	 * Parametrizovan {@link Constructor} koji u sustini poziva konstruktor nadklase {@link DefaultTableModel}.
	 * 
	 * @param columnNames
	 * @param rowCount
	 * @author Milos Cvetkovic
	 */
	@SuppressWarnings("rawtypes")
	public Model(Vector columnNames, int rowCount) {
		super(columnNames, rowCount);
	}

	/**
	 * Parametrizovan {@link Constructor} koji u sustini poziva konstruktor nadklase {@link DefaultTableModel}.
	 * 
	 * @param data
	 * @param columnNames
	 * @author Milos Cvetkovic
	 */
	@SuppressWarnings("rawtypes")
	public Model(Vector data, Vector columnNames) {
		super(data, columnNames);
	}

	/**
	 * Oznacava da li je moguce vrsiti izmene u celijama tabele. 
	 * Podrazumevana vrednost je <code>false</code>.
	 * 
	 * @author Milos Cvetkovic
	 */
	@Override
	public boolean isCellEditable(int row, int column) {
		return false;
	}

}
