package essentials;

import javax.swing.*;
import java.awt.*;
import java.io.Serializable;

public class Map extends JPanel{
	
	public static Cell[][] grid;
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
		fillDefaultCells();
	}

	public Map(int size) {
		grid = null;
		gridSize = size;
		setLayout(new GridBagLayout());
		gbc = new GridBagConstraints();
		gbc.weightx = 1;
		gbc.weighty = 1;
		gbc.fill = GridBagConstraints.BOTH;
		fillDefaultCells();
	}

	private void fillDefaultCells() {
		grid = new Cell[gridSize][gridSize];
		for (int i = 0; i < gridSize; i++) {
			for (int j = 0; j < gridSize; j++) {
				Cell cell = new Cell(i, j);
				grid[i][j] = cell;
				addCell(cell, i, j);
			}
		}
	}

	public void addCell(Cell cell, int row,int col){
		gbc.gridx = row;
		gbc.gridy = col;
		add(cell, gbc);
	}

	@Override
	public void revalidate() {
		super.revalidate();
		for (int i = 0; i < gridSize; i++)
			for (int j = 0; j < gridSize; j++)
				grid[i][j].revalidate();
	}

	@Override
	public void repaint() {
		super.repaint();
		for (int i = 0; i < gridSize; i++)
			for (int j = 0; j < gridSize; j++)
				grid[i][j].repaint();
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
