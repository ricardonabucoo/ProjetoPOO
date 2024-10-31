package elements;

import cells.Rock;
import elements.fruits.Fruit;
import elements.fruits.FruitType;
import cells.Cell;
import status_effect.EffectList;
import javax.swing.ImageIcon;
import javax.swing.border.LineBorder;
import java.awt.*;

public class Player extends Elem{
	public String name;
	private int power;
	private final Bag bag;
	private final EffectList effectList;
	private int movementPoints;
	private boolean canMoveNextRound;

	public Player(Cell ownPlace) {
		super(ownPlace);
		bag = new Bag();
		effectList = new EffectList();
		movementPoints = 0;
		power = 0;
		name = "";

		canMoveNextRound = true;

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

	public void playerMove(Cell newcell) {
		if (movementPoints < newcell.getMPNeeded()) {
			System.out.println("jogador nao tem pontos de movimentos suficientes para se mover para essa celula");
			return;
		}
		try {

			if (newcell instanceof Rock) {
				handleRockObstacle(newcell);
				return;
			}

			handleStandardMove(newcell, newcell.getElem());

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
			if (cell != null && !(cell instanceof Rock)) {
				moveToCell(cell);
				return;
			}
		}
		throw new Exception("Movimento inválido: Nenhuma célula ao redor da pedra está disponível para o jogador.");
	}


	private void handleStandardMove(Cell newcell, Elem elem) throws Exception {
        switch (elem) {
            case null -> {
                moveToCell(newcell);
            }
            case Fruit fruit -> {
                collectFruit(newcell, fruit);
            }
            case Player otherPlayer -> otherPlayer.receivedDamage(power);
            default -> throw new Exception("Elemento dinâmico inesperado: " + elem.getClass().getName());
        }
	}

	private void moveToCell(Cell cell) {
		this.cell.removeElem();
		movementPoints-=cell.getMPNeeded();
		cell.setElem(this);
		this.cell = cell;
	}

	private void collectFruit(Cell cell, Fruit fruit) {
		this.cell.removeElem();
		cell.setElem(this);
		addFruitBag(fruit);
		this.cell = cell;
	}

	@Override
	public void update(){
		power = bag.getFruitsAmount();
	}

	public void eatFruit(FruitType fruitType) {
		Fruit fruit = bag.take(fruitType);
		if (fruit != null)
			fruit.giveEffect(this);
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

	public boolean isBagFull(){
		return bag.isFull();
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

	public void showCellsToMove() {
		Cell cell_d = cell.getCellDown();
		if(cell_d != null) {
			cell_d.setCellAbleToMove();
		}
		Cell cell_u = cell.getCellUp();
		if(cell_d != null) {
			cell_d.setCellUnableToMove();
		}
		Cell cell_l = cell.getCellLeft();
		if(cell_d != null) {
			cell_d.setCellUnableToMove();
		}
		Cell cell_r = cell.getCellRight();
		if(cell_d != null) {
			cell_d.setCellUnableToMove();
		}

	}
}

