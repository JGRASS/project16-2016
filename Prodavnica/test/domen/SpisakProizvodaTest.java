package domen;

import static org.junit.Assert.*;

import java.util.LinkedList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class SpisakProizvodaTest {
	private SpisakProizvoda s;

	@Before
	public void setUp() throws Exception {
		s = new SpisakProizvoda();
	}

	@After
	public void tearDown() throws Exception {
		s = null;
	}

	@Test
	public void testSpisakProizvoda() {
		s = new SpisakProizvoda();
	}

	@Test
	public void testGetSpisak() {
		SpisakProizvoda pom = new SpisakProizvoda();
		LinkedList<Proizvod> prvi = pom.getSpisak();
		LinkedList<Proizvod> drugi = s.getSpisak();
		assertEquals(prvi, drugi);
	}

	@Test
	public void testObrisiIzSpiska() {
		LinkedList<Proizvod> pom = s.getSpisak();
		pom.remove(new Proizvod("TEST_SIFRA", "TEST_PROIZVOD", 100));
		s.obrisiIzSpiska(new Proizvod("TEST_SIFRA", "TEST_PROIZVOD", 100));
		assertEquals(s.getSpisak(), pom);
	}

	@Test(expected = java.lang.RuntimeException.class)
	public void testObrisiIzSpiskaNijeUnetProizvod() {
		s.obrisiIzSpiska(new Proizvod(null, null, -1));
	}

	@Test
	public void testDodajProizvod() {
		LinkedList<Proizvod> pom = s.getSpisak();
		pom.addLast(new Proizvod("TEST_SIFRA", "TEST_PROIZVOD", 100));
		s.dodajProizvod("TEST_SIFRA", "TEST_PROIZVOD", 100);
		assertEquals(s.getSpisak(), pom);
	}

	@Test(expected = java.lang.RuntimeException.class)
	public void testDodajProizvodNijeUnetProizvod() {
		s.dodajProizvod(null, null, -1);
	}

	@Test
	public void testToString() {
		LinkedList<Proizvod> pom = s.getSpisak();
		String test = "";
		for (int i = 0; i < pom.size(); i++) {
			test += pom.get(i) + "\n";
		}
		assertEquals(test, s.toString());
	}

}
