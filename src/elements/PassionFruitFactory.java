package elements;
import essentials.Cell;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PassionFruitFactory {

	public final int maxPassionFruitsAmount;
	private int passionFruitsCount;
	public final List<Cell> treeList;
	private static PassionFruitFactory instance;
	
	public static PassionFruitFactory getInstance(List<Cell> treeCells, int passionFruitsAmount) {
        if (instance == null) {
            instance = new PassionFruitFactory(treeCells, passionFruitsAmount);
        }
        return instance;
    }
	
	private PassionFruitFactory(List<Cell> treeCells, int PassionFruitsAmount) {
		this.maxPassionFruitsAmount = PassionFruitsAmount;
		this.treeList = treeCells;
	}
///////////////////////////////acho interessante definir um padrão temporal para o aparecimento de maracujás
	public void produce() {
		if (passionFruitsCount >= maxPassionFruitsAmount) {
			return;
		}

		Collections.shuffle(treeList);

			///////////////////////usei a mesma logica do drop de frutas
		for (Cell treeCell : treeList) {
			List<Cell> neighboringCells = new ArrayList<>();
			neighboringCells.add(treeCell.getCellDown());
			neighboringCells.add(treeCell.getCellUp());
			neighboringCells.add(treeCell.getCellLeft());
			neighboringCells.add(treeCell.getCellRight());

			Collections.shuffle(neighboringCells);


			for (Cell cell : neighboringCells) {
				if (cell != null && cell.withoutDynamicElem()) {
					Fruit passionFruit = new Fruit(cell, FruitType.PASSIONFRUIT);
					cell.setDynamicElem(passionFruit);
					passionFruitsCount++;
					return;
				}
			}
		}
	}