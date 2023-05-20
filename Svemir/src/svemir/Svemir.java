package svemir;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

public class Svemir extends Canvas implements Runnable {

	ArrayList<NebeskoTelo> nebeskaTela = new ArrayList<>();
	Thread nit = new Thread(this);
	
	public Svemir() { setBackground(Color.BLACK); }
	
	public synchronized void dodajNebeskoTelo(NebeskoTelo nt) { nebeskaTela.add(nt); }
	
	public synchronized void kretanje() {
		
		for (NebeskoTelo nt : nebeskaTela) { nt.promenaKretanja(); }
	}
	
	@Override
	public void paint(Graphics g) {
		
		for (NebeskoTelo nt : nebeskaTela) { nt.paint(g); }
	}
	
	@Override
	public void run() {
		
		try {
			
			while (!nit.isInterrupted()) {
				
				Thread.sleep(100);
				kretanje();
				repaint();
			}
		} catch (InterruptedException e) {}
	}
	
	public synchronized void kreni() { nit.start(); }
}
