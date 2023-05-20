package banditi;

import banditi.Bandit.Tim;

public class Pomeranje extends Akcija {
	
	Smer smer;
	
	public Pomeranje(Kompozicija k, Smer s) {
		
		super(k);
		smer = s;
	}

	@Override
	public void izvrsi(Bandit b) {
		
		try {
			
			Vagon v = k.dohvatiVagon(b);
			v.ukloniBandita(b);
			try {
				
				Vagon susedni = k.dohvatiSusedniVagon(v, smer);
				susedni.dodajBandita(b);
			} 
			catch (GNepostojeciVagon e) {
				
				v.dodajBandita(b);
			}
		} catch (GNepostojeciVagon e) { return; }
		
		
	}
	
	public String tekstualniOpisPomeranja() {
		
		String ret = "Pomeranje: ";
		
		ret += (smer == Smer.ISPRED ? "ispred" : "iza" );
		
		return ret;
	}
	
	@Override
	public String toString() {
		
		StringBuilder sb = new StringBuilder();
		sb.append(this.tekstualniOpisPomeranja());
		return sb.toString();
	}
	
}
