package essentials;
import elements.fruits.Fruit;
import elements.fruits.PassionFruit;
import cells.trees.Tree;
import cells.Cell;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PassionFruitFactory implements Serializable {

	public final int maxPassionFruitsAmount;
	private int passionFruitsCount;
	public final ArrayList<Tree> treeList;
	private static PassionFruitFactory instance;
	
	public static PassionFruitFactory getInstance(ArrayList<Tree> treeCells, int passionFruitsAmount, int initialPassionFruitsCount) {
        if (instance == null) {
            instance = new PassionFruitFactory(treeCells, passionFruitsAmount, initialPassionFruitsCount);
        }
        return instance;
    }
	
	private PassionFruitFactory(ArrayList<Tree> treeCells, int PassionFruitsAmount, int initialPassionFruitsCount) {
		this.maxPassionFruitsAmount = PassionFruitsAmount;
		this.passionFruitsCount = initialPassionFruitsCount;
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
				if (cell != null && cell.isUnoccupied()) {
					Fruit passionFruit = new PassionFruit(cell);
					cell.setElem(passionFruit);
					passionFruitsCount++;
					return;
				}
			}

			System.out.println("nao tem espaço pra por a fruta de maracujá");
		}
	}
}