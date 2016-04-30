package kontroler;

import static org.junit.Assert.*;

import javax.swing.JPanel;
import javax.swing.JTable;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import domen.Proizvod;
import domen.SpisakProizvoda;
import forme.Model;

public class KontrolerTest {

	@Before
	public void setUp() throws Exception {

	}

	@After
	public void tearDown() throws Exception {

	}

	@Test
	public void testGetSpisak() {
		SpisakProizvoda pom = new SpisakProizvoda();
		Kontroler.getSpisak();
		assertEquals(pom.toString(), Kontroler.getSpisak().toString());
	}

	@Test
	public void testDodajProizvod() {
		SpisakProizvoda pom = new SpisakProizvoda();
		Kontroler.dodajProizvod("789", "PROVERA", 1000);
		pom.dodajProizvod("789", "PROVERA", 1000);
		assertEquals(pom.toString(), Kontroler.getSpisak().toString());
	}

	@Test(expected = java.lang.RuntimeException.class)
	public void testDodajProizvodNull() {
		Kontroler.dodajProizvod(null, null, -1);
	}

	@Test
	public void testObrisiIzSpiska() {
		SpisakProizvoda pom = new SpisakProizvoda();
		Kontroler.dodajProizvod("789", "PROVERA", 1000);
		pom.dodajProizvod("789", "PROVERA", 1000);
		Kontroler.obrisiIzSpiska(new Proizvod("789", "PROVERA", 1000));
		pom.obrisiIzSpiska(new Proizvod("789", "PROVERA", 1000));
		assertEquals(pom.toString(), Kontroler.getSpisak().toString());
	}

	@Test(expected = java.lang.RuntimeException.class)
	public void testObrisiIzSpiskaNull() {
		Kontroler.obrisiIzSpiska(new Proizvod(null, null, -1));
	}

	@Test
	public void testKreirajModel() {
		String[] columnNames = { "Sifra", "Naziv", "Cena" };
		Model model = new Model(columnNames, Kontroler.getSpisak().getSpisak().size());
		for (int i = 0; i < Kontroler.getSpisak().getSpisak().size(); i++) {
			for (int j = 0; j < 3; j++) {
				if (j == 0) {
					model.setValueAt(Kontroler.getSpisak().getSpisak().get(i).getSifra(), i, j);
				} else if (j == 1) {
					model.setValueAt(Kontroler.getSpisak().getSpisak().get(i).getNaziv(), i, j);
				} else if (j == 2) {
					model.setValueAt(Kontroler.getSpisak().getSpisak().get(i).getCena(), i, j);
				}
			}
		}
		Model model2 = Kontroler.kreirajModel();
		for (int i = 0; i < model.getRowCount(); i++) {
			for (int j = 0; j < model.getColumnCount(); j++) {
				assertEquals(model.getValueAt(i, j), model2.getValueAt(i, j));
			}
		}
	}

	@Test
	public void testPotvrdaIzlaza() {
		Kontroler.potvrdaIzlaza();
	}

	@Test
	public void testNeispravanUnos() {
		Kontroler.neispravanUnos();
	}

	@Test
	public void testDugmeObrisi() {
		Kontroler.dugmeObrisi(new JTable(), new JPanel(), Kontroler.kreirajModel(), "123", "bla", "15");
	}

	@Test
	public void testDugmeObrisiNeispravanUnos() {
		Kontroler.dugmeObrisi(null, null, null, null, null, null);
	}

	@Test
	public void testDugmeOK() {
		Kontroler.dugmeOK(new JTable(), new JPanel(), Kontroler.kreirajModel(), "123", "bla", "15");
	}

	@Test
	public void testDugmeOKNull() {
		Kontroler.dugmeOK(null, null, null, null, null, null);
	}

}
