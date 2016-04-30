package domen.sistemskeoperacije;

import java.util.LinkedList;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import domen.Proizvod;

public class SOUcitajListuIzFajlaTest {

	private LinkedList<Proizvod> spisak;

	@Before
	public void setUp() throws Exception {
		spisak = new LinkedList<Proizvod>();
	}

	@After
	public void tearDown() throws Exception {
		spisak = null;
	}

	@Test
	public void testIzvrsi() {
		SOUcitajListuIzFajla.izvrsi(spisak);
	}
	
	@Test(expected = java.lang.RuntimeException.class)
	public void testIzvrsiNullParametar() {
		SOUcitajListuIzFajla.izvrsi(null);
	}

}
