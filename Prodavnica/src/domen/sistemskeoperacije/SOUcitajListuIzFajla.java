package domen.sistemskeoperacije;

import java.io.BufferedInputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.LinkedList;

import domen.Proizvod;

/**
 * Ucitava proizvode({@link Proizvod}) iz fajla spisak.out u listu(
 * {@link LinkedList}).
 * 
 * @author Milos Cvetkovic
 */
public class SOUcitajListuIzFajla {

	/**
	 * Metoda koja ucitava proizvode({@link Proizvod}) iz fajla spisak.out u
	 * listu({@link LinkedList}).
	 * 
	 * @param spisak
	 *            {@link LinkedList}
	 * @author Milos Cvetkovic
	 */
	public static void izvrsi(LinkedList<Proizvod> spisak) {
		try {
			ObjectInputStream in = new ObjectInputStream(new BufferedInputStream(new FileInputStream("spisak.out")));
			spisak.clear();
			try {
				while (true) {
					Proizvod proizvod = (Proizvod) in.readObject();
					spisak.add(proizvod);
				}
			} catch (EOFException e) {
			}
			in.close();
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage());
		}
	}

}
