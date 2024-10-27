package elements;

import essentials.Cell;
import status_effect.EffectList;
import javax.swing.ImageIcon;

public class Player extends DynamicElem{
	public final String name;
	private int power;
	private Bag bag;
	private EffectList effectList;
	private int movimentPoints;
	
	public Player(String name, Bag bag, Cell ownPlace) {
		super(ownPlace);
		this.name = name;
		this.bag = bag;
		this.effectList = new EffectList();
		this.movimentPoints = 0;
		this.power = 0;
	}

	public void addFruitBag(Fruit fruit) {
		bag.add(fruit);
	}

	public Cell getOwnPlace() {
		return this.ownPlace;
	}
	
}
