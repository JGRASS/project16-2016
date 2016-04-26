package domen;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.LinkedList;

public class SpisakProizvoda {

	private LinkedList<Proizvod> spisak = new LinkedList<Proizvod>();
	
	public SpisakProizvoda() {
		ucitajListuIzFajla();
	}

	public LinkedList<Proizvod> getSpisak() {
		return spisak;
	}	
	
	public void setSpisak(LinkedList<Proizvod> spisak) {
		this.spisak = spisak;
	}

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

	@Override
	public String toString() {
		String s = "";
		for (Proizvod proizvod : spisak) {
			s += proizvod.toString() + '\n';
		}
		return s;
	}	
	

}
