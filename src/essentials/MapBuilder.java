	package essentials;
	
	import java.util.List;
	
	public class MapBuilder {
	
		private Cell[ ][ ] grid;
		private int gridSize;
		private int rocksAmount;
		private List<Grass> grassList;
		private List<Tree> treeList;
					
		public MapBuilder() {}
		
		public void Reset() {
			this = new MapBuilder();
		}
		
		public MapBuilder BuildCellGrid(int size) {
			grid = new Cell[size][size];	
			return this;
		}
		
		public MapBuilder BuildRockCells(int rocksAmount) {
			return this;	
		}
		
		public MapBuilder BuildTreeCells(HashMap<FruitType, Integer> treeMap) {
			
			return this;
		}
			
		public MapBuilder BuildGrassCells() {
			return this;
		}
		
		public MapBuilder BuildFruitsCells(HashMap<FruitType, Integer> fruitMap) {
			return this;
		}
		
		public List<Tree> GetTreeList() {
			return this.treeList;
		}
			
		public GameMap GetResult() {
			return new GameMap(grid);
		}
		
		
	}
