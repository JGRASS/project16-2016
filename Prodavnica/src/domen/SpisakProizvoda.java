package domen;

import java.lang.reflect.Constructor;
import java.util.LinkedList;

import domen.sistemskeoperacije.SOUcitajListuIzFajla;
import domen.sistemskeoperacije.SOUpisiListuUFajl;

/**
 * Predstavlja spisak svih proizvoda({@link Proizvod}) koje prodavnica prodaje.
 * Sadrzi listu({@link LinkedList}) proizvoda, i metode za rad sa tom listom.
 * 
 * @author Milos Cvetkovic
 *
 */
public class SpisakProizvoda {

	/**
	 * Spisak svih proizvoda({@link Proizvod}) predstavljen listom(
	 * {@link LinkedList}).
	 * 
	 * @author Milos Cvetkovic
	 */
	private LinkedList<Proizvod> spisak = new LinkedList<Proizvod>();

	/**
	 * {@link Constructor} koji ucitava listu ({@link LinkedList}) proizvoda(
	 * {@link Proizvod}) iz fajla spisak.out
	 * 
	 * @author Milos Cvetkovic
	 */
	public SpisakProizvoda() {
		ucitajListuIzFajla();
	}

	/**
	 * Vraca spisak proizvoda({@link Proizvod}) u vidu liste({@link LinkedList}
	 * ).
	 * 
	 * @return LinkedList
	 * @author Milos Cvetkovic
	 */
	public LinkedList<Proizvod> getSpisak() {
		return spisak;
	}

	/**
	 * Brise zadati proizvod({@link Proizvod}) iz liste(spiska)(
	 * {@link LinkedList}) i vraca tako izmenjenu listu. Izvrsene izmene u listi
	 * se takodje izvrsavaju u fajlu spisak.out.
	 * 
	 * @param proizvod
	 *            {@link Proizvod}
	 * @return LinkedList
	 * @author Milos Cvetkovic
	 */
	public LinkedList<Proizvod> obrisiIzSpiska(Proizvod proizvod) {
		for (int i = 0; i < spisak.size(); i++) {
			if (spisak.get(i).equals(proizvod)) {
				spisak.remove(i);
				upisiListuUFajl();
				return spisak;
			}
		}
		upisiListuUFajl();
		return spisak;
	}

	/**
	 * Dodaje novi proizvod({@link Proizvod}) u spisak ({@link LinkedList}).
	 * Izvrsene izmene u listi se takodje izvrsavaju u fajlu spisak.out.
	 * 
	 * @param sifra
	 *            {@link String}
	 * @param naziv
	 *            {@link String}
	 * @param cena
	 *            double
	 * @author Milos Cvetkovic
	 */
	public void dodajProizvod(String sifra, String naziv, double cena) {
		Proizvod proizvod = new Proizvod(sifra, naziv, cena);
		if (!spisak.contains(proizvod)) {
			spisak.add(proizvod);
			upisiListuUFajl();
			return;
		} else {
			for (Proizvod p : spisak) {
				if (p.equals(proizvod)) {
					p.setCena(cena);
					upisiListuUFajl();
					return;
				}
			}
		}

	}

	/**
	 * Ucitava listu iz fajla spisak.out.
	 * 
	 * @author Milos Cvetkovic
	 */
	private void ucitajListuIzFajla() {
		SOUcitajListuIzFajla.izvrsi(spisak);
	}

	/**
	 * Upisuje listu u fajl spisak.out.
	 * 
	 * @author Milos Cvetkovic
	 */
	private void upisiListuUFajl() {
		SOUpisiListuUFajl.izvrsi(spisak);
	}

	/**
	 * Vraca spisak svih proizvoda({@link Proizvod}).
	 * 
	 * @return {@link String}
	 * @author Milos Cvetkovic
	 */
	@Override
	public String toString() {
		String s = "";
		for (Proizvod proizvod : spisak) {
			s += proizvod.toString() + '\n';
		}
		return s;
	}

}
