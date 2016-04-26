package domen;


public class Kontroler {	
	
	
	public static SpisakProizvoda dodajProizvod(SpisakProizvoda spisak, String sifra, String naziv, double cena){
		spisak.dodajProizvod(sifra, naziv, cena);
		return spisak;
	}
	
	public static SpisakProizvoda obrisiIzSpiska(SpisakProizvoda spisak, Proizvod proizvod){
		SpisakProizvoda s = spisak;
		s.obrisiIzSpiska(proizvod);		
		return s;
	}

}
