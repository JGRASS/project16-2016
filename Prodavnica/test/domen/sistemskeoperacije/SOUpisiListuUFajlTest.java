package domen.sistemskeoperacije;

import java.util.LinkedList;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import domen.Proizvod;

public class SOUpisiListuUFajlTest {

	private LinkedList<Proizvod> spisak;

	@Before
	public void setUp() throws Exception {
		spisak = new LinkedList<Proizvod>();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testIzvrsi() {
		spisak.add(new Proizvod("111", "test1", 50));
		spisak.add(new Proizvod("222", "test2", 60));
		spisak.add(new Proizvod("333", "test3", 50));
		SOUpisiListuUFajl.izvrsi(spisak);
	}
	
	@Test (expected = java.lang.RuntimeException.class)
	public void testIzvrsiNull() {
		SOUpisiListuUFajl.izvrsi(null);
	}

}
