package svemir;

import java.awt.Color;
import java.awt.Graphics;

public class Kometa extends NebeskoTelo {
	
	int nizKoordinata[] = new int[10];
	int nizX[] = new int[5];
	int nizY[] = new int[5];
	float ugao;

	public Kometa(int x, int y, Color boja, int r) {
		
		super(x, y, boja, r);
		if (boja != Color.GRAY) boja = Color.GRAY;
        ugao = (float)(Math.random() * Math.PI * 2);
		
		int i = 0;
		while (i < 10) {
			
			nizKoordinata[i] = (int)(x + r * Math.cos(ugao));
			nizKoordinata[i + 1] = (int)(y + r * Math.sin(ugao)); 
			
			ugao += 2*Math.PI/5;
			
			i += 2;
		}
		
		int j = 0, k = 0;
		i=0;
		
		while (i < 10) {
			
			if (i % 2 == 0) { nizX[j] = nizKoordinata[i]; j++; }
			else { nizY[k] = nizKoordinata[i]; k++; }
			
			i++;
		}
	}

	@Override
	public void paint(Graphics g) {
		
		g.setColor(Color.GRAY);
		g.fillPolygon(nizX, nizY, 5);
	}

	@Override
	public void promenaKretanja() {
		
		int i=0;
		while(i < 5) nizY[i++] += 5; 
	}
}
