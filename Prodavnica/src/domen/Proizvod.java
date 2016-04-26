package domen;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Proizvod implements Serializable{

	private String sifra;
	private String naziv;
	private double cena;

	public Proizvod(String sifra, String naziv, double cena) {
		this.sifra = sifra;
		this.naziv = naziv;
		this.cena = cena;
	}

	public String getSifra() {
		return sifra;
	}

	public void setSifra(String sifra) {
		if(sifra == null || sifra.isEmpty()){
			throw new RuntimeException("");
		}else{
			this.sifra = sifra;
		}
	}

	public String getNaziv() {
		return naziv;
	}

	public void setNaziv(String naziv) {
		if(naziv == null || naziv.isEmpty()){
			throw new RuntimeException("");
		}else{
			this.naziv = naziv;
		}
	}

	public double getCena() {
		return cena;
	}

	public void setCena(double cena) {
		if(cena < 0){
			throw new RuntimeException("");
		}else{
			this.cena = cena;
		}
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((sifra == null) ? 0 : sifra.hashCode());
		return result;
	}

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

	@Override
	public String toString() {
		return "Proizvod [sifra=" + sifra + ", naziv=" + naziv + ", cena=" + cena + "]";
	}

}
