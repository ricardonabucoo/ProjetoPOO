package essentials;

public class Player extends DynamicElem{
	public final String name;
	private int power;
	private Bag bag;
	private EffectList effectList;
	private int movimentPoints;
	
	public Player(String name, Bag bag, Cell ownPlace) {
		this.ownPlace = ownPlace;
		this.name = name;
		this.bag = bag;
		this.effectList = new EffectList();
		this.movimentPoints = 0;
		this.power = 0;
	}
	
}
