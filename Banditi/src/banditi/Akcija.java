package banditi;

public abstract class Akcija {
	
	protected Kompozicija k;
	
	public Akcija(Kompozicija kom) { k = kom; }
	public abstract void izvrsi(Bandit b);
	
}
