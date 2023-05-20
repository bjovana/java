package revija;

import java.util.LinkedList;

public class Kombinacija {
	
	private int brStvari;
	private LinkedList<Nosivo> stvari = new LinkedList<>();
	
	public Kombinacija(int d) {
		
		brStvari = d;
	}
	
	public void dodaj(Nosivo n) throws GDodavanje {
		
		if (stvari.size() == brStvari) throw new GDodavanje();
		stvari.add(n);
	}
	
	public int dohvBrStvari() { return stvari.size(); }
	public int dohvMaxBrStvari() { return brStvari; }
	
	public Nosivo dohvStvar(int i) throws GIndeks {
		
		if (i < 0 || i >= stvari.size()) throw new GIndeks();
		
		return stvari.get(i);
	}
	
	@Override
	public String toString() {
		
		StringBuilder sb = new StringBuilder();
		
		int i = 0;
		
		sb.append("[");
		
		for (Nosivo n : stvari) {
			
			sb.append(n);
			if (i != stvari.size() - 1) sb.append(",");
			i++;
		}
		
		sb.append("]");
		
		return sb.toString();
	}
}
