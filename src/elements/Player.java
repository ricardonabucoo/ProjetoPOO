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
	private boolean canMoveNextRound;
	
	public Player(String name, Bag bag, Cell ownPlace) {
		super(ownPlace);
		this.name = name;
		this.bag = bag;
		this.effectList = new EffectList();
		this.movimentPoints = 0;
		this.power = 0;
		this.canMoveNextRound = true;
	}

	public void addFruitBag(Fruit fruit) {
		bag.add(fruit);
	}

	public Cell getOwnPlace() {
		return this.ownPlace;
	}

	public void playerMove (Cell newcell) {
		DynamicElem dynamicElem = newcell.getDynamicElem();
		if (movimentPoints >= newcell.getMPNeeded()) {
			if (dynamicElem == null) {
				ownPlace.removeDynamicElem(this);
				newcell.setDynamicElem(this);
				this.ownPlace = newcell;
				movimentPoints--;
			} else if (dynamicElem instanceof Fruit) {
				Fruit fruit = (Fruit) dynamicElem;
				ownPlace.removeDynamicElem(this);
				newcell.setDynamicElem(this);
				addFruitBag(fruit);
				this.ownPlace = newcell;
				movimentPoints--;
			} else {
				Player opponent = (Player) dynamicElem;
				opponent.receivedDamage(this.power);
			}
		}
	}

	public void eatFruit(FruitType fruitType) {
		Fruit fruitToConsume = bag.take(fruitType);

		if (fruitToConsume != null) {
			fruitToConsume.giveEffect(this);
		}
	}

	public void receivedDamage (int power) {
		double logFa = Math.log(power + 1) / Math.log(2);
		double logFd = Math.log(this.power + 1) / Math.log(2);
		int difference = (int) Math.floor(logFa - logFd);

		if (difference > 0) {
			bag.dropFruit(difference);
		}
	}

	public boolean getCanMoveNextRound () {
		return canMoveNextRound;
	}
	public void setCanMoveNextRound (boolean canMoveNextRound) {
		this.canMoveNextRound = canMoveNextRound;
	}

	public int getPower () {
		return power;
	}

	public void setPower (int power) {
		this.power = power;
	}

	public int getMovimentPoints () {
		return movimentPoints;
	}

	public void setMovimentPoints (int movimentPoints) {
		this.movimentPoints = movimentPoints;
	}
}
