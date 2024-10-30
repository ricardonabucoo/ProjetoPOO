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

	public void playerMove(Cell newcell) {
		try {

			if (movementPoints < newcell.getMPNeeded()) {
				throw new Exception("Movimento insuficiente: o jogador não possui pontos de movimento suficientes.");
			}

			DynamicElem dynamicElem = newcell.getDynamicElem();
			StaticElem staticElem = newcell.getStaticElem();


			if (staticElem instanceof Rock) {
				handleRockObstacle(newcell);
				return;  // Sai após lidar com a pedra
			}

			// Executa movimentação padrão
			handleStandardMove(newcell, dynamicElem);

		} catch (Exception e) {
			System.err.println("Erro ao mover jogador: " + e.getMessage());

		}
	}


	private void handleRockObstacle(Cell newcell) throws Exception {
		movementPoints -= 2;
		Cell[] surroundingCells = {
				newcell.getCellUp(),
				newcell.getCellDown(),
				newcell.getCellLeft(),
				newcell.getCellRight()
		};


		for (Cell cell : surroundingCells) {
			if (cell != null && !(cell.getStaticElem() instanceof Rock)) {
				moveToCell(cell);
				return;
			}
		}


		throw new Exception("Movimento inválido: Nenhuma célula ao redor da pedra está disponível para o jogador.");
	}


	private void handleStandardMove(Cell newcell, DynamicElem dynamicElem) throws Exception {
		if (dynamicElem == null) {
			moveToCell(newcell);
			movementPoints--;
		} else if (dynamicElem instanceof Fruit) {
			collectFruit(newcell, (Fruit) dynamicElem);
			movementPoints--;
		} else if (dynamicElem instanceof Player) {
			Player opponent = (Player) dynamicElem;
			opponent.receivedDamage(this.power);
		} else {
			throw new Exception("Elemento dinâmico inesperado: " + dynamicElem.getClass().getName());
		}
	}

	// Move o jogador para uma nova célula
	private void moveToCell(Cell cell) {
		if (ownPlace != null) {
			ownPlace.removeDynamicElem(this);  // Remove o jogador da célula atual
		}
		cell.setDynamicElem(this);
		this.ownPlace = cell;
	}

	// Método para coletar frutas e adicionar à bolsa
	private void collectFruit(Cell cell, Fruit fruit) {
		ownPlace.removeDynamicElem(this); // Remove o jogador da célula atual
		cell.setDynamicElem(this);
		addFruitBag(fruit);
		this.ownPlace = cell;
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

	public EffectList getEffectList() {
		return this.effectList;
	}

	public void setImage(ImageIcon playerImage) {
		Image scaledImage = playerImage.getImage().getScaledInstance(60, 100, Image.SCALE_SMOOTH);
		setIcon(new ImageIcon(scaledImage));
		setPreferredSize(new Dimension(100, 100));
		revalidate();
		repaint();
	}
}

