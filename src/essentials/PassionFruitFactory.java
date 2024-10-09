package essentials;

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
	
	public void produce() {
        //
    }
}
