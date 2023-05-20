package revija;

public class Odeca implements Nosivo {

	private String naziv;
	private Velicina vel;
	
	public Odeca(String n, Velicina v) {
		
		naziv = n; vel = v;
	}
	
	public String dohvNaziv() { return naziv; }
	public Velicina dohvVelicinu() { return vel; }
	
	@Override
	public boolean odgovara(Model m) {
		
		if (!vel.manja(m.dohvVelicinu())) return true;
		return false;
	}
	
	@Override
	public String toString() {
		
		StringBuilder sb = new StringBuilder();
		
		sb.append("odeća");
		sb.append(naziv);
		sb.append(vel);
		
		return sb.toString();
	}
}
