package revija;

public class Model {
	
	private static int broj = 0;
	private int id;
	private Velicina vel;
	
	public Model(Velicina v) {
		
		vel = v;
		id = broj++;
	}
	
	public int dohvId() { return id; }
	public Velicina dohvVelicinu() { return vel; }
	
	public String toString() {
		
		StringBuilder sb = new StringBuilder();
		sb.append("Model ");
		sb.append(id);
		sb.append(" (");
		sb.append(vel);
		sb.append(")");
		
		return sb.toString();
	}
}
