package domen;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Constructor;
import java.util.LinkedList;


/**
 * Predstavlja spisak svih proizvoda({@link Proizvod}) koje prodavnica prodaje.
 * Sadrzi listu({@link LinkedList}) proizvoda, i metode za rad sa tom listom.
 * 
 * @author Milos Cvetkovic
 *
 */
public class SpisakProizvoda {

	/**
	 * Spisak svih proizvoda({@link Proizvod}) predstavljen listom({@link LinkedList}).
	 * 
	 * @author Milos Cvetkovic
	 */
	private LinkedList<Proizvod> spisak = new LinkedList<Proizvod>();
	
	/**
	 * {@link Constructor} koji ucitava listu ({@link LinkedList}) proizvoda({@link Proizvod}) iz fajla spisak.out
	 * 
	 * @author Milos Cvetkovic
	 */
	public SpisakProizvoda() {
		ucitajListuIzFajla();
	}

	/**
	 * Vraca spisak proizvoda({@link Proizvod}) u vidu liste({@link LinkedList}).
	 * 
	 * @return LinkedList
	 * @author Milos Cvetkovic
	 */
	public LinkedList<Proizvod> getSpisak() {
		return spisak;
	}		

	/**
	 * Brise zadati proizvod({@link Proizvod}) iz liste(spiska)({@link LinkedList}) i vraca tako izmenjenu listu.
	 * Izvrsene izmene u listi se takodje izvrsavaju u fajlu spisak.out.
	 * 
	 * @param proizvod {@link Proizvod}
	 * @return LinkedList
	 * @author Milos Cvetkovic
	 */
	public LinkedList<Proizvod> obrisiIzSpiska(Proizvod proizvod){		
		for (int i = 0; i < spisak.size(); i++) {
			if(spisak.get(i).equals(proizvod)){
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
	 * @param sifra {@link String}
	 * @param naziv {@link String}
	 * @param cena double
	 * @author Milos Cvetkovic
	 */
	public void dodajProizvod(String sifra, String naziv, double cena){		
		Proizvod proizvod = new Proizvod(sifra, naziv, cena);
		if(!spisak.contains(proizvod)){
			spisak.add(proizvod);
			upisiListuUFajl();
			return;
		}else{
			for (Proizvod p : spisak) {
				if(p.equals(proizvod)){
					p.setCena(cena);
					upisiListuUFajl();
					return;
				}
			}
		}
		
	}

	/**
	 * Ucitava proizvode({@link Proizvod}) iz fajla spisak.out u listu({@link LinkedList}).
	 * @author Milos Cvetkovic
	 */
	private void ucitajListuIzFajla() {
		try {
			ObjectInputStream in = new ObjectInputStream(
					new BufferedInputStream(new FileInputStream("spisak.out")));
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
			System.out.println("Greska, ne moze se ucitati fajl.");
		}
	}
	
	/**
	 * Upisuje proizvode({@link Proizvod}) iz liste({@link LinkedList}) u fajl spisak.out.
	 * @author Milos Cvetkovic
	 */
	private void upisiListuUFajl(){
		try {
			ObjectOutputStream out = new ObjectOutputStream(
					new BufferedOutputStream(new FileOutputStream("spisak.out")));
			for (Proizvod proizvod : spisak) {
				out.writeObject(proizvod);
			}
			out.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
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
