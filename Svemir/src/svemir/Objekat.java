package svemir;

import java.awt.Color;
import java.awt.Graphics;

public abstract class Objekat {
	
	int x, y;
	Color boja;
	
	public Objekat(int x, int y, Color boja) {
		
		this.x = x; this.y = y; this.boja = boja;
	}
	
	public int dohvX() { return x; }
	public int dohvY() { return y; }
	
	public void promenaX(int pomeraj) { x += pomeraj; }
	public void promenaY(int pomeraj) { y += pomeraj; }
	
	public abstract void paint(Graphics g);
}
