package essentials;

import elements.DynamicElem;
import elements.Player;
import temporario.CellInfoDisplay;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.io.Serializable;

public class Map extends JPanel implements Serializable{

	public static Cell[][] grid;
	private Player player1;
	private Player player2;
	private int gridSize;
	private GridBagConstraints gbc;
	private  JLabel infoLabel;

	public Map() {
		infoLabel = new JLabel();
		player1 = null;
		player2 = null;
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
		infoLabel = new JLabel();
		player1 = null;
		player2 = null;
		grid = null;
		gridSize = size;
		setLayout(new GridBagLayout());
		gbc = new GridBagConstraints();
		gbc.weightx = 1;
		gbc.weighty = 1;
		gbc.fill = GridBagConstraints.BOTH;
		fillDefaultCells();

	}


	public Cell[][] getGrid() {
		return grid;
	}

	private void fillDefaultCells() {
		grid = new Cell[gridSize][gridSize];
		for (int i = 0; i < gridSize; i++) {
			for (int j = 0; j < gridSize; j++) {
				addCell(new Cell(i, j), i, j);
			}
		}
	}
	private void showCellInfo(int i, int j) {
		Cell cell = grid[i][j];
		StringBuilder info = new StringBuilder(String.format("Posição: (%d, %d), Elemento: %s,",
				cell.getRow(), cell.getCol(), cell.getStaticElem() ));

		// Verifica e exibe o elemento dinâmico, se houver
		DynamicElem dynamicElem = cell.getDynamicElem();
		if (dynamicElem != null) {
			info.append(", Dinâmico: ").append(cell.getDynamicElem());
		}

		infoLabel.setText(info.toString());
	}
	public void addCell(Cell cell, int row,int col){
		gbc.gridx = row;
		gbc.gridy = col;
		grid[row][col] = cell;
		add(cell, gbc);
		cell.addMouseMotionListener(new MouseMotionAdapter() {
										@Override
										public void mouseMoved(MouseEvent e) {
											showCellInfo(row, col);
										}
									} );
	}

	public void update() {
		for(int i = 0; i < gridSize; i++)
			for(int j = 0; j < gridSize; j++) {
				grid[i][j].update();
			}
	}

	public JLabel getInfoLabel() {
		return infoLabel;
	}
}
