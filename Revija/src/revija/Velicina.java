package revija;

public class Velicina {
	
	public enum Oznaka {S, M, L};
	private Oznaka oznaka;
	
	public Velicina(Oznaka o) {
		
		oznaka = o;
	}
	
	public Oznaka dohvOznaku() { return oznaka; }
	
	public boolean manja(Velicina v) {
		
		if (oznaka.compareTo(v.oznaka) > 0) return false;
		else if (oznaka.compareTo(v.oznaka) == 0) return false;
		return true;
	}
	
	@Override
	public String toString() {
		
		StringBuilder sb = new StringBuilder();
		sb.append(String.valueOf(oznaka));
		return sb.toString();
	}
}
