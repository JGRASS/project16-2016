package domen.sistemskeoperacije;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.LinkedList;

import domen.Proizvod;

/**
 * Upisuje proizvode({@link Proizvod}) iz liste({@link LinkedList}) u fajl spisak.out.
 * @author Milos Cvetkovic
 */
public class SOUpisiListuUFajl {
	
	/**
	 * Metoda koja izvrsava upisivanje proizvoda({@link Proizvod}) iz liste({@link LinkedList}) u fajl spisak.out.
	 * @param spisak {@link LinkedList}
	 * @author Milos Cvetkovic
	 */
	public static void izvrsi(LinkedList<Proizvod> spisak){
		try {
			ObjectOutputStream out = new ObjectOutputStream(
					new BufferedOutputStream(new FileOutputStream("spisak.out")));
			for (Proizvod proizvod : spisak) {
				out.writeObject(proizvod);
			}
			out.close();
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage());
		}
	}

}
