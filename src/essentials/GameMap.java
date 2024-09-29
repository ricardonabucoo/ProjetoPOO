package essentials;

public class GameMap {
	
	private static Cell[][] grid;
	private int gridSize;
	
	public GameMap(Cell[][] grid) {
        this.grid = grid;
        this.gridSize = grid.length;
    }
	
	public void Update() {
		for(int i = 0; i < gridSize; i++)
			for(int j = 0; j < gridSize; j++) {
				grid[i][j].Update();	
			}
	}
}
