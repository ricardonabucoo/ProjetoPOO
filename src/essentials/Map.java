package essentials;

import elements.DynamicElem;
import elements.PassionFruitFactory;
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
	private PassionFruitFactory passionFruitFactory;
	private GridBagConstraints gbc;
	private JPanel cellInfoPanel;

	public Map() {
		passionFruitFactory = null;
		cellInfoPanel = new JPanel();
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
		passionFruitFactory = null;
		cellInfoPanel = new JPanel();
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

	private void cellInfoPanel(int i, int j) {
		JPanel panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

		Cell cell = grid[i][j];

		StringBuilder info = new StringBuilder(String.format("Posição: (%d, %d), Elemento: %s,",
				cell.getRow(), cell.getCol(), cell.getStaticElem() ));

		JButton button = new JButton(Integer.toString(cell.getRow()));
		button.setBounds(350, 100, 200, 30);
		JButton button1 = new JButton(Integer.toString(cell.getCol()));
		button1.setBounds(350, 100, 200, 30);
		JButton button2 = new JButton(String.valueOf(cell.getStaticElem()));
		button2.setBounds(350, 100, 200, 30);
		panel.add(button);
		panel.add(button1);
		panel.add(button2);

		DynamicElem dynamicElem = cell.getDynamicElem();
		if (dynamicElem != null) {
			JButton button3 = new JButton(String.valueOf(cell.getDynamicElem()));
			panel.add(button3);
			button3.setBounds(350, 100, 200, 30);
		}

		this.cellInfoPanel = panel;
	}
	public void addCell(Cell cell, int row,int col){
		gbc.gridx = row;
		gbc.gridy = col;
		grid[row][col] = cell;
		add(cell, gbc);
		cell.addMouseMotionListener(new MouseMotionAdapter() {
										@Override
										public void mouseMoved(MouseEvent e) {
											cellInfoPanel(row, col);
										}
									} );
	}

	public void setPassionFruitFactory(PassionFruitFactory passionFruitFactory) {
		this.passionFruitFactory = passionFruitFactory;
	}

	public void setPlayer1(Player player1) {
		this.player1 = player1;
	}

	public void setPlayerOneName(String name){
		player1.setName(name);
	}


	public void setPlayer2(Player player2) {
		this.player2 = player2;
	}

	public void setPlayerTwoName(String name){
		player2.setName(name);
	}

	public void update() {
		for(int i = 0; i < gridSize; i++)
			for(int j = 0; j < gridSize; j++) {
				grid[i][j].update();
			}
	}

	public JPanel getCellInfoPanel() {
		return cellInfoPanel;
	}
}
