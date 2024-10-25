package essentials;

import javax.swing.*;
import java.awt.*;

public class Map extends JPanel {
	
	private static Cell[][] grid;
	private int gridSize;
	private GridBagConstraints gbc;

	public Map() {
		grid = null;
		gridSize = 3;
		setLayout(new GridBagLayout());
		gbc = new GridBagConstraints();
		gbc.weightx = 1;
		gbc.weighty = 1;
		gbc.fill = GridBagConstraints.BOTH;
	}

	public void addCell(Cell cell, int row,int col){
		gbc.gridx = row;
		gbc.gridy = col;
		add(cell, gbc);
	}

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
