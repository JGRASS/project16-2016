package domen;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ProizvodTest {

	private Proizvod p;

	@Before
	public void setUp() throws Exception {
		p = new Proizvod("123", "cokolada", 50);
	}

	@After
	public void tearDown() throws Exception {
		p = null;
	}

	@Test
	public void testHashCode() {
		p.hashCode();
	}

	@Test
	public void testProizvod() {
		p = new Proizvod("123", "cokolada", 50);
		assertEquals("123", p.getSifra());
		assertEquals("cokolada", p.getNaziv());
		assertEquals(50, p.getCena(), 0);
	}
	
	@Test(expected = java.lang.RuntimeException.class)
	public void testProizvodNekaVrednostNijeDozvoljenaUSetMetodama() {
		p = new Proizvod(null, null, -1);
	}

	@Test
	public void testGetSifra() {
		assertEquals("123", p.getSifra());
	}

	@Test
	public void testSetSifra() {
		p.setSifra("555");
		assertEquals("555", p.getSifra());
	}

	@Test(expected = java.lang.RuntimeException.class)
	public void testSetSifraNull() {
		p.setSifra(null);
	}

	@Test(expected = java.lang.RuntimeException.class)
	public void testSetSifraIsEmpty() {
		p.setSifra("");
	}

	@Test
	public void testGetNaziv() {
		assertEquals("cokolada", p.getNaziv());
	}

	@Test
	public void testSetNaziv() {
		p.setNaziv("banana");
		assertEquals("banana", p.getNaziv());
	}

	@Test(expected = java.lang.RuntimeException.class)
	public void testSetNazivNull() {
		p.setNaziv(null);
	}

	@Test(expected = java.lang.RuntimeException.class)
	public void testSetNazivIsEmpty() {
		p.setNaziv("");
	}

	@Test
	public void testGetCena() {
		assertEquals(50, p.getCena(), 0);
	}

	@Test
	public void testSetCena() {
		p.setCena(40);
		assertEquals(40, p.getCena(), 0);
	}

	@Test(expected = java.lang.RuntimeException.class)
	public void testSetCenaManjeOdNule() {
		p.setCena(-1);
	}

	@Test
	public void testEqualsObject() {
		Proizvod p2 = new Proizvod("123", "cokolada", 50);
		assertEquals(true, p.equals(p2));
	}

	@Test
	public void testToString() {
		String sifra = "123";
		String naziv = "cokolada";
		double cena = 50;
		String s = "Proizvod [sifra=" + sifra + ", naziv=" + naziv + ", cena=" + cena + "]";
		assertEquals(s, p.toString());
	}

}
