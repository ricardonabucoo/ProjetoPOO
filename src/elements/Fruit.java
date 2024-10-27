package elements;
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
import essentials.Cell;
import status_effect.*;
import javax.swing.ImageIcon;

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
		List <Cell> neighboringCells = new ArrayList<>();
		verify(neighboringCells,ownPlace.getCellDown());
		verify(neighboringCells,ownPlace.getCellUp());
		verify(neighboringCells,ownPlace.getCellLeft());
		verify(neighboringCells,ownPlace.getCellRight());
		/*
		neighboringCells.add(ownPlace.getCellDown());
		neighboringCells.add(ownPlace.getCellUp());
		neighboringCells.add(ownPlace.getCellLeft());
		neighboringCells.add(ownPlace.getCellRight());
		*/
/////////////////A ideia é criar uma lista já com o que sabemos que não será null
		List<Cell> neighboringSquareCells = new ArrayList<>();
		/*
		if (ownPlace.getCellDown() != null) {
			verify(neighboringSquareCells,ownPlace.getCellDown().getCellDown());
			neighboringSquareCells.add(ownPlace.getCellDown().getCellLeft());
			neighboringSquareCells.add(ownPlace.getCellDown().getCellRight());

		}
		if (ownPlace.getCellUp() != null) {
			neighboringSquareCells.add(ownPlace.getCellUp().getCellUp());
			neighboringSquareCells.add(ownPlace.getCellUp().getCellLeft());
			neighboringSquareCells.add(ownPlace.getCellUp().getCellRight());
		}
		if (ownPlace.getCellLeft() != null) {
			neighboringSquareCells.add(ownPlace.getCellLeft().getCellLeft());
		}
		if (ownPlace.getCellRight() != null) {
			neighboringSquareCells.add(ownPlace.getCellRight().getCellRight());
		}
		//////a ideia é só adicionar essas repetições caso não haja o parametro de up ou down (bordas)
		if (ownPlace.getCellDown() == null || ownPlace.getCellUp() == null ) {
			neighboringSquareCells.add(ownPlace.getCellLeft().getCellDown());
			neighboringSquareCells.add(ownPlace.getCellLeft().getCellUp());
			neighboringSquareCells.add(ownPlace.getCellRight().getCellDown());
			neighboringSquareCells.add(ownPlace.getCellRight().getCellUp());
		}
		*/

		if (ownPlace.getCellDown() != null) {
			verify(neighboringSquareCells, ownPlace.getCellDown().getCellDown());
			verify(neighboringSquareCells, ownPlace.getCellDown().getCellLeft());
			verify(neighboringSquareCells, ownPlace.getCellDown().getCellRight());
		}
		if (ownPlace.getCellUp() != null) {
			verify(neighboringSquareCells, ownPlace.getCellUp().getCellUp());
			verify(neighboringSquareCells, ownPlace.getCellUp().getCellLeft());
			verify(neighboringSquareCells, ownPlace.getCellUp().getCellRight());
		}
		if (ownPlace.getCellLeft() != null) {
			verify(neighboringSquareCells, ownPlace.getCellLeft().getCellLeft());
		}
		if (ownPlace.getCellRight() != null) {
			verify(neighboringSquareCells, ownPlace.getCellRight().getCellRight());
		}

		if (ownPlace.getCellDown() == null || ownPlace.getCellUp() == null) {
			verify(neighboringSquareCells, ownPlace.getCellLeft().getCellDown());
			verify(neighboringSquareCells, ownPlace.getCellLeft().getCellUp());
			verify(neighboringSquareCells, ownPlace.getCellRight().getCellDown());
			verify(neighboringSquareCells, ownPlace.getCellRight().getCellUp());
		}

		Collections.shuffle(neighboringCells);
		boolean findPlace = false;

		for (Cell cell : neighboringCells) {
			if (cell != null && cell.withoutDynamicElem()){
				ownPlace.removeDynamic(this);
				cell.setDynamicElem(this);
				setOwnPlace(cell);
				findPlace = true;
				break;

			}

		}
		if (!findPlace) {
			Collections.shuffle(neighboringSquareCells);
			for (Cell cellSquares : neighboringSquareCells) {
				if (cellSquares != null && cellSquares.withoutDynamicElem()){
					setOwnPlace(cellSquares);
					findPlace = true;
					break;
				}
			}
		}
	}

	public void giveEffect (Player player) {
		this.fruitEffect.applyEffect(player);
	}

	public FruitType getFruitType() {
	 return fruitType;
	}
}
	
	
	
	
	
	
	
	
	
	    