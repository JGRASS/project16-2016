package domen;

import java.io.Serializable;
import java.lang.reflect.Constructor;

/**
 * Predstavlja proizvod koji se prodaje u prodavnici. Objekte je moguce cuvati u fajlovima. {@link Serializable}
 * 
 * @author Milos Cvetkovic
 *
 */
@SuppressWarnings("serial")
public class Proizvod implements Serializable{

	/**
	 * Jedinstvena sifra proizvoda.
	 * 
	 * @author Milos Cvetkovic
	 */
	private String sifra;
	/**
	 * Naziv proizvoda.
	 * 
	 * @author Milos Cvetkovic
	 */
	private String naziv;
	/**
	 * Cena proizvoda.
	 * 
	 * @author Milos Cvetkovic
	 */
	private double cena;

	/**
	 * {@link Constructor} koji kreira novi proizvod.
	 * 
	 * @param sifra String
	 * @param naziv String
	 * @param cena double
	 * @author Milos Cvetkovic
	 */
	public Proizvod(String sifra, String naziv, double cena) {
		this.sifra = sifra;
		this.naziv = naziv;
		this.cena = cena;
	}

	/**
	 * Vraca sifru proizvoda.
	 * 
	 * @return {@link String}
	 * @author Milos Cvetkovic
	 */
	public String getSifra() {
		return sifra;
	}

	/**
	 * Postavlja sifru proizvoda.
	 * 
	 * @param sifra String
	 * @author Milos Cvetkovic
	 */
	public void setSifra(String sifra) {
		if(sifra == null || sifra.isEmpty()){
			throw new RuntimeException("");
		}else{
			this.sifra = sifra;
		}
	}

	/**
	 * Vraca naziv proizvoda.
	 * 
	 * @return {@link String}
	 * @author Milos Cvetkovic
	 */
	public String getNaziv() {
		return naziv;
	}

	/**
	 * Postavlja naziv proizvoda.
	 * 
	 * @param naziv String
	 * @author Milos Cvetkovic
	 */
	public void setNaziv(String naziv) {
		if(naziv == null || naziv.isEmpty()){
			throw new RuntimeException("");
		}else{
			this.naziv = naziv;
		}
	}

	/**
	 * Vraca cenu proizvoda.
	 * 
	 * @return double
	 * @author Milos Cvetkovic
	 */
	public double getCena() {
		return cena;
	}

	/**
	 * Postavlja cenu proizvoda.
	 * 
	 * @param cena double
	 * @author Milos Cvetkovic
	 */
	public void setCena(double cena) {
		if(cena < 0){
			throw new RuntimeException("");
		}else{
			this.cena = cena;
		}
	}

	/**
	 * Redefinisana hashCode() metoda klase {@link Object} prema parametru sifra.
	 * @return int
	 * @author Milos Cvetkovic
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((sifra == null) ? 0 : sifra.hashCode());
		return result;
	}

	/**
	 * Redefinisana equals() metoda klase {@link Object} prema parametru sifra.
	 * Vraca true ako je parametar sifra isti kao kod zadatog proizvoda.
	 * @return boolean
	 * @author Milos Cvetkovic
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Proizvod other = (Proizvod) obj;
		if (sifra == null) {
			if (other.sifra != null)
				return false;
		} else if (!sifra.equals(other.sifra))
			return false;
		return true;
	}

	/**
	 * Vraca sve podatke o proizvodu.
	 * @return {@link String}
	 * @author Milos Cvetkovic
	 */
	@Override
	public String toString() {
		return "Proizvod [sifra=" + sifra + ", naziv=" + naziv + ", cena=" + cena + "]";
	}

}
