	package essentials;
	
	import java.util.ArrayList;
	import java.util.HashMap;
	import java.util.Map;
	import java.util.List;
	import java.util.Random;
		
	public class MapBuilder {
	
		private Cell[][] grid;
		private int gridSize;
		private int rocksAmount;
		private int treesAmount;
		private List<Cell> grassCellList;
		private List<Cell> treeCellList;
		private List<Cell> availableCells;
						
		public MapBuilder() {
			Reset();							
		}
		
		public void Reset() {
			this.grid = null;
		    this.gridSize = 0;					
		    this.rocksAmount = 0;
		    this.treesAmount = 0;
		    this.grassCellList = new ArrayList<>();
		    this.treeCellList = new ArrayList<>();
		    this.availableCells = new ArrayList<>();
		}
		
		public MapBuilder BuildCellGrid(int size) {
			this.gridSize = size;
			grid = new Cell[size][size];
			for (int i = 0; i < size; i++) {
			    for (int j = 0; j < size; j++) {
			    	Cell cell = new Cell(i, j);
			        grid[i][j] = cell;
			        availableCells.add(cell);
			    }
			}	
			return this;
		}
		
		public MapBuilder BuildRockCells(int rocksAmount) {
			this.rocksAmount = rocksAmount;
			for(int i = 0; i < rocksAmount; i++) {
				Cell cell = GetRandomEmptyCell();
				cell.SetStaticElem(new Rock(cell)); 
			}
			return this;	
		}
		
		public MapBuilder BuildTreeCells(HashMap<FruitType, Integer> treeMap) {
			for(Map.Entry<FruitType, Integer> entry : treeMap.entrySet()) {
				int value = entry.getValue();
				this.treesAmount += value;
				for(int i = 0; i < value; i++){
					Cell cell = GetRandomEmptyCell();
					cell.SetStaticElem(new Tree(cell,entry.getKey()));
					treeCellList.add(cell);
				}
			}	
				
			return this;
		}
			
		public MapBuilder BuildGrassCells() {
			int value = gridSize*gridSize - rocksAmount - treesAmount;
				for(int i = 0; i < value; i++) {	
					Cell cell = GetRandomEmptyCell();
					cell.SetStaticElem(new Grass(cell));
					grassCellList.add(cell);
				}	
			return this;		
		}
		
		// pressupoe que o numero de frutas é menor ou igual ao numero de frutas
		public MapBuilder BuildFruitsCells(HashMap<FruitType, Integer> fruitMap) {
			int totalFruits = fruitMap.values().stream().mapToInt(Integer::intValue).sum();
			if (totalFruits > grassCellList.size()) {
			    throw new IllegalArgumentException("numero de frutas maior que o numero de celular disponiveis");
			}
			else
			{
				for(Map.Entry<FruitType, Integer> entry : fruitMap.entrySet()) {
					int value = entry.getValue();
					for(int i = 0; i < value; i++){	
						Cell cell = GetRandomWithoutFruitCell();
						cell.SetDynamicElem(new Fruit(cell,entry.getKey(), false));
					}
				}			
			}
			return this;
		}
		
		public List<Cell> GetTreeCellList() {				
			return this.treeCellList;
		}
			
		public GameMap GetResult() {
			GameMap gm = new GameMap(grid);
			Reset();	
			return gm;
		}
		
		private Cell GetRandomWithoutFruitCell() {
			if (grassCellList.isEmpty()) {
		        throw new IllegalStateException("sem celular vazias");
		    }
		    Random random = new Random();
		    return grassCellList.remove(random.nextInt(grassCellList.size()));
		}
		
		private Cell GetRandomEmptyCell() {
		    if (availableCells.isEmpty()) {
		        throw new IllegalStateException("sem celular vazias");
		    }
		    Random random = new Random();
		    return availableCells.remove(random.nextInt(availableCells.size()));
		}
			
			
	}
