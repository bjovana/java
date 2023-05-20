package banditi;

import java.util.*;

public class Vagon {
	
	private LinkedList<Bandit> banditi = new LinkedList<Bandit>();
	
	public Vagon() {}
	
	public void dodajBandita(Bandit b) { banditi.add(b); }
	
	public boolean sadrziBandita(Bandit b) {
		
		for (Bandit e : banditi) {
			
			if (e == b) return true;
		}
		
		return false;
	}
	
	public void ukloniBandita(Bandit b) {
		
		if (!this.sadrziBandita(b)) return;
		banditi.remove(b);
	}
	
	public int dohvatiBrojBandita() { return banditi.size(); } 
	
	public Bandit dohvatiBandita(int i) {
		
		if (i > banditi.size() || i < 0) return null;
		return banditi.get(i);
	}
	
	public String tekstualniOpisVagona() {
		
		String ret = "[";
		
		for (Bandit b : banditi) {
			
			ret += b.toString();
			if (b != banditi.getLast()) ret += ",";
		}
		
		ret += "]";
		
		return ret;
	}
	
	@Override
	public String toString() {
		
		StringBuilder sb = new StringBuilder();
		sb.append(this.tekstualniOpisVagona());
		return sb.toString();
	}
}
