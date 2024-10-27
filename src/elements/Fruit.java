package elements;
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
import essentials.Cell;
import status_effect.*;
import javax.swing.ImageIcon;
import java.util.HashSet;
import java.util.Set;

public class Fruit extends DynamicElem {
	public static  int  WORMY_FRUITS_AMOUNT;
	protected static int wormyChance;
	protected FruitType fruitType;
	protected StatusEffect fruitEffect;

	public Fruit (Cell ownPlace, FruitType fruitType) {
		super(ownPlace);
		this.setIcon(getFruitImage(fruitType));
		this.fruitEffect = getFruitEffect(fruitType);
		this.fruitType = fruitType;
	}

	private StatusEffect getFruitEffect(FruitType fruitType) {

		StatusEffect se;

		StatusEffect fe = switch (fruitType) {
            case ORANGE -> new AntidoteEffect();
            case AVOCADO -> new PowerEffect();
            case COCONUT -> new MovimentEffect();
            default -> new NullEffect();
        };
		se = fe;

        if (isWormy()) {
			EffectList el = new EffectList();
			el.addEffect(new WormyEffect());
			el.addEffect(fe);
			se = el;
		}

		return se;
	}

	private boolean isWormy() {
	 return Math.random() * 100 < wormyChance;
	}

	private ImageIcon getFruitImage(FruitType fruitType) {
		String str = switch (fruitType) {
            case ORANGE -> "images/orange.png";
            case AVOCADO -> "images/avocado.png";
            case COCONUT -> "images/coconut.png";
            case GUAVA -> "images/guava.png";
            case PASSIONFRUIT -> "images/passionfruit.png";
            case BARBADOSCHERRY -> "images/barbadoscherry.png";
            case BLACKBERRY -> "images/blackberry.png";
            default -> "null.png";
        };
        return new ImageIcon(str);
	}

	public void setOwnPlace(Cell newPlace){
		changePosition(newPlace);
	}

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
		addNeighbor(cellSet, ownPlace.getCellDown());
		addNeighbor(cellSet, ownPlace.getCellUp());
		addNeighbor(cellSet, ownPlace.getCellLeft());
		addNeighbor(cellSet, ownPlace.getCellRight());
	}

	// Adiciona as diagonais e bordas
	private void addDiagonalAndBorderNeighbors(Set<Cell> cellSet) {
		Cell down = ownPlace.getCellDown();
		Cell up = ownPlace.getCellUp();
		Cell left = ownPlace.getCellLeft();
		Cell right = ownPlace.getCellRight();

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

	// Método que adiciona ao conjunto se não for nulo
	private void addNeighbor(Set<Cell> cellSet, Cell cell) {
		if (cell != null) {
			cellSet.add(cell);
		}
	}

	// Método  mover para a primeira célula disponível no conjunto
	private boolean moveToAvailableCell(Set<Cell> cells) {
		List<Cell> cellList = new ArrayList<>(cells);
		Collections.shuffle(cellList);
		for (Cell cell : cellList) {
			if (cell.withoutDynamicElem()) {
				ownPlace.removeDynamic(this);
				cell.setDynamicElem(this);
				setOwnPlace(cell);
				return true;
			}
		}
		return false;
	}


	public void giveEffect (Player player) {
		this.fruitEffect.applyEffect(player);
	}

	public FruitType getFruitType() {
	 return fruitType;
	}
}
	
	
	
	
	
	
	
	
	
	    