package essentials;

import javax.swing.*;
import java.awt.*;

public class Map extends JPanel {
	
	private static Cell[][] grid;
	private int gridSize;
	
	public Map(Cell[][] grid) {
        this.grid = grid;
        this.gridSize = grid.length;
		setLayout(new GridLayout(gridSize, gridSize));
		for(int i = 0; i < gridSize; i++)
			for(int j = 0; j < gridSize; j++)
				add(grid[i][j],i,j);
    }
	
	public void update() {
		for(int i = 0; i < gridSize; i++)
			for(int j = 0; j < gridSize; j++) {
				grid[i][j].update();
			}
	}
}
