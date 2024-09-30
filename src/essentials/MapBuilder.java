package essentials;

import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.Random;
	
public class MapBuilder {

	private Cell[][] grid;
	private int gridSize;
	private int rocksAmount;
	private int treesAmount;
	private List<Cell> grassCellsList;
	private List<Tree> treeList;
					
	public MapBuilder() {}
	
	public void Reset() {
		this.grid = null;
	    this.gridSize = 0;					
	    this.rocksAmount = 0;
	    this.treesAmount = 0;
	    this.grassCellsList = null;
	    this.treeList = null;
	}
	
	public MapBuilder BuildCellGrid(int size) {
		this.gridSize = size;
		grid = new Cell[size][size];	
		return this;
	}
	
	public MapBuilder BuildRockCells(int rocksAmount) {
		for(int i = 0; i < rocksAmount; i++) {
				int r1 = RandomNum();
				int r2 = RandomNum();
				grid[r1][r2].SetStaticElem(new Rock(grid[r1][r2])); 
		}
		return this;	
	}
	
	public MapBuilder BuildTreeCells(HashMap<FruitType, Integer> treeMap) {
		for(Map.Entry<FruitType, Integer> entry : treeMap.entrySet()) {
			int value = entry.getValue();
			this.treesAmount += value;
;			for(int i = 0; i < value; i++){
					int r1 = RandomNum();
					int r2 = RandomNum();
					grid[r1][r2].SetStaticElem(new Tree(grid[r1][r2],entry.getKey())); 
			}
		}	
			
		return this;
	}
		
	public MapBuilder BuildGrassCells() {
		int value = gridSize*gridSize - rocksAmount - treesAmount;
			for(int j = 0; j < value; j++) {
				int r1 = RandomNum();
				int r2 = RandomNum();
				grid[r1][r2].SetStaticElem(new Grass(grid[r1][r2]));
				grassCellsList.add(grid[r1][r2]);
			}
	return this;
	}
	
	public MapBuilder BuildFruitsCells(HashMap<FruitType, Integer> fruitMap) {
		for(Map.Entry<FruitType, Integer> entry : fruitMap.entrySet()) {
			int value = entry.getValue();
			for(int i = 0; i < value; i++){
				int r1 = RandomNum();
				grassCellsList.get(r1).SetDynamicElem(new Fruit(grassCellsList.get(r1),entry.getKey(), false));
			}
		}			
		return this;
	}
	
	public List<Tree> GetTreeList() {
		return this.treeList;
	}
		
	public GameMap GetResult() {
		GameMap gm = new GameMap(grid);
		Reset();	
		return gm;
	}
	
	private int RandomNum() {
        Random random = new Random();
        return random.nextInt(gridSize);
    }
		
		
}
