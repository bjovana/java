package svemir;

import java.awt.Color;

public abstract class NebeskoTelo extends Objekat {

	int r;
	
	public NebeskoTelo(int x, int y, Color boja, int r) {
		
		super(x, y, boja);
		this.r = r;
	}
	
	public abstract void promenaKretanja();
}
