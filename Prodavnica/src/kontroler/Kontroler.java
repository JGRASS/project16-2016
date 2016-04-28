package kontroler;

import java.awt.EventQueue;

import javax.swing.JPanel;
import javax.swing.JTable;

import domen.Proizvod;
import domen.SpisakProizvoda;
import forme.DodatProizvod;
import forme.GUIGlavniProgram;
import forme.IzlazPotvrda;
import forme.Model;
import forme.NeispravanUnos;

/**
 * Klasa sadrzi staticke metode kojima manipulise dodavanjem i brisanjem
 * proizvoda iz spiska i fajla.
 * 
 * @author Milos Cvetkovic
 * 
 */
public class Kontroler {

	/**
	 * Predstavlja spisak({@link SpisakProizvoda}) svih proizvoda(
	 * {@link Proizvod}) koji se prodaju u prodavnici.
	 * 
	 * @author Milos Cvetkovic
	 */
	private static SpisakProizvoda spisak = new SpisakProizvoda();

	/**
	 * Vraca spisak({@link SpisakProizvoda}) proizvoda({@link Proizvod}) koji
	 * koristi prodavnica.
	 * 
	 * @return {@link SpisakProizvoda}
	 * @author Milos Cvetkovic
	 */
	public static SpisakProizvoda getSpisak() {
		return spisak;
	}

	/**
	 * Dodaje novi proizvod({@link Proizvod}) u spisak({@link SpisakProizvoda})
	 * i fajl spisak.out.
	 * 
	 * @param sifra
	 *            {@link String}
	 * @param naziv
	 *            {@link String}
	 * @param cena
	 *            double
	 * @return {@link SpisakProizvoda}
	 * @author Milos Cvetkovic
	 */
	public static SpisakProizvoda dodajProizvod(String sifra, String naziv, double cena) {
		spisak.dodajProizvod(sifra, naziv, cena);
		return spisak;
	}

	/**
	 * Brise zadati proizvod({@link Proizvod}) iz spiska({@link SpisakProizvoda}
	 * ) i fajla spisak.out.
	 * 
	 * @param proizvod
	 *            {@link Proizvod}
	 * @return {@link SpisakProizvoda}
	 * @author Milos Cvetkovic
	 */
	public static SpisakProizvoda obrisiIzSpiska(Proizvod proizvod) {
		SpisakProizvoda s = spisak;
		s.obrisiIzSpiska(proizvod);
		return s;
	}

	/**
	 * Kreira i vraca model za tabelu na osnovu spiska({@link SpisakProizvoda})
	 * proizvoda({@link Proizvod}).
	 * 
	 * @return Model {@link Model}
	 * @author Milos Cvetkovic
	 */
	public static Model kreirajModel() {
		String[] columnNames = { "Sifra", "Naziv", "Cena" };
		Model model = new Model(columnNames, spisak.getSpisak().size());
		for (int i = 0; i < spisak.getSpisak().size(); i++) {
			for (int j = 0; j < 3; j++) {
				if (j == 0) {
					model.setValueAt(spisak.getSpisak().get(i).getSifra(), i, j);
				} else if (j == 1) {
					model.setValueAt(spisak.getSpisak().get(i).getNaziv(), i, j);
				} else if (j == 2) {
					model.setValueAt(spisak.getSpisak().get(i).getCena(), i, j);
				}
			}
		}
		return model;
	}

	/**
	 * Prikazuje {@link IzlazPotvrda}
	 * 
	 * @author Milos Cvetkovic
	 */
	public static void potvrdaIzlaza() {
		new IzlazPotvrda().setVisible(true);
	}

	/**
	 * Prikazuje {@link NeispravanUnos}
	 * 
	 * @author Milos Cvetkovic
	 */
	public static void neispravanUnos() {
		new NeispravanUnos().setVisible(true);
	}

	/**
	 * Brise zadati proizvod({@link Proizvod}) iz spiska({@link SpisakProizvoda}
	 * ) i fajla spisak.out.
	 * 
	 * @param table
	 *            {@link JTable}
	 * @param panel
	 *            {@link JPanel}
	 * @param model
	 *            {@link Model}
	 * @param sifra
	 *            {@link String}
	 * @param naziv
	 *            {@link String}
	 * @param cena
	 *            {@link String}
	 * @author Milos Cvetkovic
	 */
	public static void dugmeObrisi(JTable table, JPanel panel, Model model, String sifra, String naziv, String cena) {
		try {
			if (table.getSelectedRow() == -1) {
				int row = -1;
				for (int i = 0; i < model.getRowCount(); i++) {
					if (model.getValueAt(i, 0).toString().equals(sifra)) {
						row = i;
						break;
					}
				}
				model.removeRow(row);
			} else {
				model.removeRow(table.getSelectedRow());
			}
			Proizvod proizvod;
			try {
				proizvod = new Proizvod(sifra, naziv, Double.parseDouble(cena));
			} catch (Exception e1) {
				proizvod = new Proizvod(sifra, "PRAZNO", 0);
			}
			spisak = Kontroler.obrisiIzSpiska(proizvod);
			model.fireTableDataChanged();
			panel.setVisible(false);
			sifra = null;
			naziv = null;
			cena = null;
		} catch (RuntimeException e1) {
			neispravanUnos();
		}
	}

	/**
	 * Dodaje zadati proizvod({@link Proizvod}) u spisak({@link SpisakProizvoda}
	 * ) i fajl spisak.out. Ukoliko proizvod vec postoji onda mu se samo azurira
	 * cena.
	 * 
	 * @param table
	 *            {@link JTable}
	 * @param panel
	 *            {@link JPanel}
	 * @param model
	 *            {@link Model}
	 * @param sifra
	 *            {@link String}
	 * @param naziv
	 *            {@link String}
	 * @param cena
	 *            {@link String}
	 * @author Milos Cvetkovic
	 */
	public static void dugmeOK(JTable table, JPanel panel, Model model, String sifra, String naziv, String cena) {
		try {
			int i = spisak.getSpisak().size();
			spisak = Kontroler.dodajProizvod(sifra, naziv, Double.parseDouble(cena));
			if (i == spisak.getSpisak().size()) {
				if (table.getSelectedRow() == -1) {
					int red = -1;
					for (int j = 0; j < model.getRowCount(); j++) {
						if (model.getValueAt(j, 0).toString().equals(sifra)) {
							red = j;
							break;
						}
					}
					model.setValueAt(cena, red, 2);
				} else {
					model.setValueAt(cena, table.getSelectedRow(), 2);
				}
			} else {
				String[] s = { sifra, naziv, cena };
				model.addRow(s);
			}
			model.fireTableDataChanged();
			new DodatProizvod().setVisible(true);
			panel.setVisible(false);
		} catch (RuntimeException e2) {
			neispravanUnos();
		}
	}

	/**
	 * Pokretanje aplikacije, prikazuje se glavni prozor programa.
	 * 
	 * @param args
	 *            String[]
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUIGlavniProgram frame = new GUIGlavniProgram();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}
