package main;

import revija.*;

public class Main {

	public static void main(String[] args) {
		Velicina malaVelicina = new Velicina(Velicina.Oznaka.S);
		Velicina srednjaVelicina = new Velicina(Velicina.Oznaka.M);
		Velicina velikaVelicina = new Velicina(Velicina.Oznaka.L);

		System.out.println("Srednja veli�ina je: " + srednjaVelicina.dohvOznaku());
		if (malaVelicina.manja(srednjaVelicina)) {
			System.out.println("Veli�ina " + malaVelicina + " je manja od veli�ine " + srednjaVelicina);
		}

		Model model = new Model(srednjaVelicina);
		Odeca majica = new Odeca("Majica", malaVelicina);
		Nosivo pantalone = new Odeca("Pantalone", srednjaVelicina);

		System.out.println(model);
		String majicaOdgovara = (majica.odgovara(model)) ? "mo�e" : "ne mo�e";
		System.out.println("Model " + model.dohvId() + " veli�ine " + model.dohvVelicinu()
				+ " " + majicaOdgovara + " da obu�e majicu "
				+ majica.dohvNaziv() + " veli�ine " + majica.dohvVelicinu());
		System.out.println(pantalone);
		
		Kombinacija kombinacija = new Kombinacija(3);
		try {
			kombinacija.dodaj(majica);
			kombinacija.dodaj(pantalone);
			System.out.println(kombinacija);
			System.out.println("br stvari: " + kombinacija.dohvBrStvari() 
					+ "/" + kombinacija.dohvMaxBrStvari());
			kombinacija.dohvStvar(2);
		} catch (GDodavanje e) {
			System.out.println("Gre�ka dodavanje!");
		} catch (GIndeks e) {
			System.out.println("Gre�ka indeks!");
		}
	}

}

