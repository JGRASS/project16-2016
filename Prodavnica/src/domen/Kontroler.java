package domen;

/**
 * Klasa sadrzi staticke metode kojima manipulise dodavanjem i brisanjem proizvoda iz spiska i fajla.
 * 
 * @author Milos Cvetkovic
 * 
 */
public class Kontroler {	
	
	/**
	 * Dodaje novi proizvod u spisak i fajl spisak.out.
	 * 
	 * @param spisak
	 * @param sifra
	 * @param naziv
	 * @param cena
	 * @return {@link SpisakProizvoda}
	 * @author Milos Cvetkovic
	 */
	public static SpisakProizvoda dodajProizvod(SpisakProizvoda spisak, String sifra, String naziv, double cena){
		spisak.dodajProizvod(sifra, naziv, cena);
		return spisak;
	}
	
	/**
	 * Brise zadati proizvod iz spiska i fajla spisak.out.
	 * 
	 * @param spisak
	 * @param proizvod
	 * @return {@link SpisakProizvoda}
	 * @author Milos Cvetkovic
	 */
	public static SpisakProizvoda obrisiIzSpiska(SpisakProizvoda spisak, Proizvod proizvod){
		SpisakProizvoda s = spisak;
		s.obrisiIzSpiska(proizvod);		
		return s;
	}

}
