package banditi;

public class Bandit {
	
	public enum Tim{A, B};
	
	private Tim tim;
	private int brZlatnika;
	
	public Bandit(Tim t) { tim = t; brZlatnika = 50; }
	
	public Tim dohvatiTim() { return tim; }
	public int dohvatiBrojZlatnika() { return brZlatnika; }
	
	public void promeniBrojZlatnika(int noviBrZlatnika) { brZlatnika += noviBrZlatnika; }
		
	@Override
	public String toString() {
		
		String ret = "";
		if (tim == Tim.A) ret += "A";
		else ret += "B";
		ret += String.valueOf(brZlatnika);
		StringBuilder sb = new StringBuilder();
		sb.append(ret);
		return sb.toString();
	}
	
	public static void main(String args[]) {
		
		Bandit b = new Bandit(Tim.B);
		b.promeniBrojZlatnika(1000);
		System.out.println(b);
	}
}
