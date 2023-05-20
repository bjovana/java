package svemir;

import java.awt.Color;
import java.util.Random;

public class Generator extends Thread {

	Svemir svemir;
		
	@Override
	public void run() {
		
		try {
			
			while (!isInterrupted()) {
				
				Thread.sleep(900);
				Random r = new Random();
				int donjaGranica = 0;
				int gornjaGranica = 200;
				int x = r.nextInt(gornjaGranica - donjaGranica) + donjaGranica;
				int y = 0;
				
				Random r1 = new Random();
				donjaGranica = 10; gornjaGranica = 30;
				int poluprecnik = r1.nextInt(gornjaGranica - donjaGranica) + donjaGranica;
				
				Kometa kometa = new Kometa(x, y, Color.GRAY, poluprecnik);
				svemir.dodajNebeskoTelo(kometa);
				
			}
			
		} catch (InterruptedException e) {}
	}
	
	public synchronized void kreni() {
		this.start();
	}
	
	public Generator(Svemir svemir) { this.svemir = svemir; }
	
}

