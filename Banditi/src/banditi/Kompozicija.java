package banditi;


import java.util.LinkedList;

public class Kompozicija {
	
	private LinkedList<Vagon> vagoni = new LinkedList<Vagon>();
	
	public Kompozicija() {}
	
	public void dodajVagon(Vagon v) { vagoni.add(v); }
	
	public Vagon dohvatiVagon(Bandit b) throws GNepostojeciVagon {
		
		for (Vagon v : vagoni) {
			
			if (v.sadrziBandita(b)) return v;
		}
		throw new GNepostojeciVagon();
	}
	
	public Vagon dohvatiSusedniVagon(Vagon v, Smer s) throws GNepostojeciVagon {
		
		Vagon pom = null;
		int a = 0;
		
		for (Vagon e : vagoni) {
			
			if (a == 1) return e;
			
			if (e == v) {
				
				if (s == Smer.ISPRED) {
					
					if (pom != null) return pom;
					break;
				}
				else if (s == Smer.IZA) a = 1;
			}
			
			pom = e;
		}
		
		throw new GNepostojeciVagon();
	}
	
	public String tekstualniOpisKompozicije() {
		
		String ret = "";
		
		for (Vagon v : vagoni) {
			
			ret += v.tekstualniOpisVagona();
			if (v != vagoni.getLast()) ret += "_";
		}
		
		return ret;
	}
	
	@Override
	public String toString() {
		
		StringBuilder sb = new StringBuilder();
		sb.append(this.tekstualniOpisKompozicije());
		return sb.toString();
	}
}
