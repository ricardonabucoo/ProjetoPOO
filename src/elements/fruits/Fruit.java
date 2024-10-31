package elements.fruits;
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

import elements.Elem;
import elements.Player;
import cells.Cell;
import status_effect.*;

import java.util.HashSet;
import java.util.Set;

public abstract class Fruit extends Elem {
	protected static int wormyChance;
	protected FruitType fruitType;
	protected EffectList fruitEffect;

	public Fruit (Cell cell) {
		super(cell);
		fruitEffect = new EffectList();
		if(isWormy())
			fruitEffect.addEffect(new WormyEffect());
	}
	public Fruit () {
		fruitEffect = new EffectList();
		if(isWormy())
			fruitEffect.addEffect(new WormyEffect());
	}

	public static void setWormyChance(int wormyChance) { Fruit.wormyChance = wormyChance; }

	private boolean isWormy() { return Math.random() * 100 < wormyChance; }

	public void giveEffect (Player player) { this.fruitEffect.applyEffect(player); }

	public FruitType getType(){ return fruitType; }

	public abstract Fruit clone();

	public void verify(List<Cell> cellList, Cell cell){
		if(cell != null){
			cellList.add(cell);
			return;
		}
		return;
	}

	public void drop() {
		Set<Cell> neighboringCells = new HashSet<>();
		Set<Cell> neighboringSquareCells = new HashSet<>();

		addDirectNeighbors(neighboringCells);
		addDiagonalAndBorderNeighbors(neighboringSquareCells);

		// Tenta mover para uma célula direta, se não conseguir, tenta uma célula diagonal ou de borda
		if (!moveToAvailableCell(neighboringCells)) {
			moveToAvailableCell(neighboringSquareCells);
		}
	}

	// vizinhos diretos
	private void addDirectNeighbors(Set<Cell> cellSet) {
		addNeighbor(cellSet, cell.getCellDown());
		addNeighbor(cellSet, cell.getCellUp());
		addNeighbor(cellSet, cell.getCellLeft());
		addNeighbor(cellSet, cell.getCellRight());
	}

	// Adiciona as diagonais e bordas
	private void addDiagonalAndBorderNeighbors(Set<Cell> cellSet) {
		Cell down = cell.getCellDown();
		Cell up = cell.getCellUp();
		Cell left = cell.getCellLeft();
		Cell right = cell.getCellRight();

		if (down != null) {
			addNeighbor(cellSet, down.getCellDown());
			addNeighbor(cellSet, down.getCellLeft());
			addNeighbor(cellSet, down.getCellRight());
		}
		if (up != null) {
			addNeighbor(cellSet, up.getCellUp());
			addNeighbor(cellSet, up.getCellLeft());
			addNeighbor(cellSet, up.getCellRight());
		}
		if (left != null) {
			addNeighbor(cellSet, left.getCellLeft());
			addNeighbor(cellSet, left.getCellUp());
			addNeighbor(cellSet, left.getCellDown());
		}
		if (right != null) {
			addNeighbor(cellSet, right.getCellRight());
			addNeighbor(cellSet, right.getCellUp());
			addNeighbor(cellSet, right.getCellDown());
		}


	}

	private void addNeighbor(Set<Cell> cellSet, Cell cell) {
		if (cell != null) {
			cellSet.add(cell);
		}
	}

	private boolean moveToAvailableCell(Set<Cell> cells) {
		List<Cell> cellList = new ArrayList<>(cells);
		Collections.shuffle(cellList);
		for (Cell cell : cellList) {
			if (cell.isUnoccupied()) {
				this.cell.removeElem();
				cell.setElem(this);
				setCell(cell);
				return true;
			}
		}
		return false;
	}


}
	
	
	
	
	
	
	
	
	
	    