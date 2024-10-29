package elements;

import essentials.Cell;
import status_effect.EffectList;
import javax.swing.ImageIcon;
import java.awt.*;

public class Player extends DynamicElem{
	public String name;
	private int power;
	private final Bag bag;
	private EffectList effectList;
	private int movementPoints;
	private boolean canMoveNextRound;

	public Player(Bag bag, Cell ownPlace) {
		super(ownPlace);
		this.name = "";
		this.bag = bag;
		this.effectList = new EffectList();
		this.movementPoints = 0;
		this.power = 0;
		this.canMoveNextRound = true;

		ImageIcon imageIcon = new ImageIcon("images/Female01.png");

		Image scaledImage = imageIcon.getImage().getScaledInstance(60, 100, Image.SCALE_SMOOTH);
		setIcon(new ImageIcon(scaledImage));
		setPreferredSize(new Dimension(100, 100));
		revalidate();
		repaint();
	}

	public void addFruitBag(Fruit fruit) {
		bag.add(fruit);
	}

	public Cell getOwnPlace() {
		return this.ownPlace;
	}

	public void playerMove (Cell newcell) {
		DynamicElem dynamicElem = newcell.getDynamicElem();
		if (movementPoints >= newcell.getMPNeeded()) {
			if (dynamicElem == null) {
				ownPlace.removeDynamicElem(this);
				newcell.setDynamicElem(this);
				this.ownPlace = newcell;
				movementPoints--;
			} else if (dynamicElem instanceof Fruit fruit) {
                ownPlace.removeDynamicElem(this);
				newcell.setDynamicElem(this);
				addFruitBag(fruit);
				this.ownPlace = newcell;
				movementPoints--;
			} else {
				Player opponent = (Player) dynamicElem;
				opponent.receivedDamage(this.power);
			}
		}
	}

	@Override
	public void update(){

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

	public int getMovementPoints() {
		return movementPoints;
	}

	public void setMovementPoints(int movementPoints) {
		this.movementPoints = movementPoints;
	}

	public void setName(String name){
		this.name = name;
	}

	public Bag getBag() {
		return this.bag;
	}
}
