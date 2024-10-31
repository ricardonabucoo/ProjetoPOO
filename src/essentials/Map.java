package essentials;

import cells.Cell;
import cells.Grass;
import cells.Rock;
import elements.*;
import elements.fruits.*;
import cells.trees.*;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.Point;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class Map extends JPanel implements Serializable {

	public Cell[][] grid;
	private Player player1;
	private Player player2;
	private final int gridSize;
	private PassionFruitFactory passionFruitFactory;
	private GridBagConstraints gbc;
	private JPanel mapInfoPanel;

	private ArrayList<Point> avaliablePoints = new ArrayList<>();
	private ArrayList<Cell> emptyCells = new ArrayList<>();
	private ArrayList<Tree> treeCellList = new ArrayList<>();
	private ArrayList<Grass> grassCellList = new ArrayList<>();
	private ArrayList<Cell> avaliableCellsForPlayer = new ArrayList<>();


	public JPanel createMapInfoPanel(){
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(3, 1));
		panel.setBorder(
				BorderFactory.createTitledBorder(
						BorderFactory.createLineBorder(Color.BLACK),
						"Informações da célula",
						TitledBorder.CENTER,
						TitledBorder.TOP
				)
		);
		panel.setBackground(Color.lightGray);
		panel.setPreferredSize(new Dimension(300,500));
		return panel;
	}

	private void cellInfoPanel(int i, int j) {

		mapInfoPanel.removeAll();
		Cell cell = grid[i][j];
		Dimension buttonSize = new Dimension(200, 40);
		// Cria e adiciona os botões de informações

		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout( 1, 3));
		panel.add( new JButton("Célula[" + cell.getRow() + "][" + cell.getCol() + "]"));
		mapInfoPanel.add(panel);
		mapInfoPanel.add(new JButton(cell.getImageIcon()));



		Elem elem = cell.getElem();
		if (elem != null) {
			JButton elemButton = new JButton(elem.getImageIcon());
			mapInfoPanel.add(elemButton);
		}

		mapInfoPanel.revalidate();
		mapInfoPanel.repaint();
	}



	private JPanel createButtonPanel(Cell cell) {
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(2, 1));

		JLabel label = new JLabel();
		return panel;
	}

	public void setPlayer1(Player player1) {
		this.player1 = player1;
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

	public JPanel getMapInfoPanel() {
		return mapInfoPanel;
	}

	public Player getPlayerOne() {
		return player1;
	}

	public Player getPlayerTwo() {
		return player2;
	}

	public void setPlayer1Image(ImageIcon playerImage) {
		player1.setImage(playerImage);
	}
	public void setPlayer2Image(ImageIcon playerImage) {
		player2.setImage(playerImage);
	}

	public void setPlayerOneName(String name){
		player1.setName(name);
	}

	public void setPlayer2(Player player2) {
		this.player2 = player2;
	}

	public Map(
			int size,
			int rocksAmount,
			HashMap<FruitType, Integer> treeMap,
			HashMap<FruitType, Integer> fruitMap,
			int passionFruitsAmount,
			int bagCapacity,
			int wormyChance)
	{
		setLayout(new GridBagLayout());
		grid = new Cell[size][size];
		gridSize = size;
		avaliablePoints = cartesianProduct(size);

		///// rochas

		for(int i = 0; i < rocksAmount; i++) {
			Point freePoint = getUnoccupedRandomPoint();
			grid[freePoint.x][freePoint.y] = new Rock(freePoint.x,freePoint.y);
		}

		////// arvores

		treeCellList = new ArrayList<>();
		int treeAmount = treeMap.getOrDefault(FruitType.AVOCADO, 0);
		for (int i = 0; i < treeAmount; i++) {
			Point freePoint = getUnoccupedRandomPoint();
			AvocadoTree tree = new AvocadoTree(freePoint.x, freePoint.y);
			grid[freePoint.x][freePoint.y] = tree;
			treeCellList.add(tree);
		}
		 treeAmount = treeMap.getOrDefault(FruitType.GUAVA, 0);
		for(int i = 0; i < treeAmount; i++){
			Point freePoint = getUnoccupedRandomPoint();
			GuavaTree tree = new GuavaTree(freePoint.x,freePoint.y);
			grid[freePoint.x][freePoint.y] = tree;
			treeCellList.add(tree);
		}

		treeAmount = treeMap.getOrDefault(FruitType.ORANGE, 0);
		for(int i = 0; i < treeAmount; i++){
			Point freePoint = getUnoccupedRandomPoint();
			OrangeTree tree = new OrangeTree(freePoint.x,freePoint.y);
			grid[freePoint.x][freePoint.y] = tree;
			treeCellList.add(tree);
		}

		treeAmount = treeMap.getOrDefault(FruitType.BARBADOSCHERRY, 0);
		for(int i = 0; i < treeAmount; i++){
			Point freePoint = getUnoccupedRandomPoint();
			BarbadosCherryTree tree = new BarbadosCherryTree(freePoint.x,freePoint.y);
			grid[freePoint.x][freePoint.y] = tree;
			treeCellList.add(tree);
		}

		treeAmount = treeMap.getOrDefault(FruitType.COCONUT, 0);
		for(int i = 0; i < treeAmount; i++){
			Point freePoint = getUnoccupedRandomPoint();
			CoconutTree tree = new CoconutTree(freePoint.x,freePoint.y);
			grid[freePoint.x][freePoint.y] = tree;
			treeCellList.add(tree);
		}

		treeAmount = treeMap.getOrDefault(FruitType.BLACKBERRY, 0);
		for(int i = 0; i < treeAmount; i++){
			Point freePoint = getUnoccupedRandomPoint();
			BlackBerryTree tree = new BlackBerryTree(freePoint.x,freePoint.y);
			grid[freePoint.x][freePoint.y] = tree;
			treeCellList.add(tree);
		}

		///// gramas

		int grassCount = avaliablePoints.size();
		for(int i = 0; i < grassCount; i++) {
			Point freePoint = getUnoccupedRandomPoint();
			Grass grass = new Grass(freePoint.x,freePoint.y);
			grid[freePoint.x][freePoint.y] = grass;
			grassCellList.add(grass);
		}

		////// frutas

		Fruit.setWormyChance(wormyChance);
		int fruitAmount = fruitMap.getOrDefault(FruitType.AVOCADO, 0);
		for(int i = 0; i < fruitAmount; i++){
			Grass grass = getRandomEmptyCell();
			Avocado fruit = new Avocado(grass);
			//grass.setElem(fruit);
		}

		fruitAmount = fruitMap.getOrDefault(FruitType.GUAVA, 0);
		for(int i = 0; i < fruitAmount; i++){
			Grass grass = getRandomEmptyCell();
			Guava fruit = new Guava(grass);
			//grass.setElem(fruit);
		}

		fruitAmount = fruitMap.getOrDefault(FruitType.ORANGE, 0);
		for(int i = 0; i < fruitAmount; i++){
			Grass grass = getRandomEmptyCell();
			Orange fruit = new Orange(grass);
			//grass.setElem(fruit);
		}


		fruitAmount = fruitMap.getOrDefault(FruitType.AVOCADO, 0);
		for(int i = 0; i < fruitAmount; i++){
			Grass grass = getRandomEmptyCell();
			BarbadosCherry fruit = new BarbadosCherry(grass);
			//grass.setElem(fruit);
		}

		fruitAmount = fruitMap.getOrDefault(FruitType.COCONUT, 0);
		for(int i = 0; i < fruitAmount; i++){
			Grass grass = getRandomEmptyCell();
			Coconut fruit = new Coconut(grass);
			//grass.setElem(fruit);
		}

		fruitAmount = fruitMap.getOrDefault(FruitType.BLACKBERRY, 0);
		for(int i = 0; i < fruitAmount; i++){
			Grass grass = getRandomEmptyCell();
			BlackBerry fruit = new BlackBerry(grass);
			//grass.setElem(fruit);
		}

		fruitAmount = fruitMap.getOrDefault(FruitType.PASSIONFRUIT, 0);
		for(int i = 0; i < fruitAmount; i++){
			Grass grass = getRandomEmptyCell();
			PassionFruit fruit = new PassionFruit(grass);
			//grass.setElem(fruit);
		}


		passionFruitFactory = PassionFruitFactory.getInstance(treeCellList, passionFruitsAmount, fruitAmount);

		Bag.setCapacity(bagCapacity);

		avaliableCellsForPlayer.addAll(grassCellList);
		avaliableCellsForPlayer.addAll(treeCellList);

		Random random = new Random();
		Cell cell;
		cell = avaliableCellsForPlayer.remove(random.nextInt(avaliableCellsForPlayer.size()));
		player1 = new Player(cell);
		cell.setElem(player1);
		cell = avaliableCellsForPlayer.remove(random.nextInt(avaliableCellsForPlayer.size()));
		player2 = new Player(cell);
		cell.setElem(player2);


		gbc = new GridBagConstraints();
		gbc.weightx = 1;
		gbc.weighty = 1;
		gbc.fill = GridBagConstraints.BOTH;
		for(int i = 0; i < size; i++)
			for(int j = 0; j < size; j++)
				addCell(grid[i][j],i,j);

		mapInfoPanel = createMapInfoPanel();
	}

	private void addCell(Cell cell, int row,int col){
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

	private ArrayList<Point> cartesianProduct(int size){
		ArrayList<Point> list = new ArrayList<Point>();

		for(int i = 0; i < size; i++) {
			for(int j = 0; j < size; j++){
				list.add(new Point(i,j));
			}
		}

		return list;
	}

	private Grass getRandomEmptyCell() {
		if (grassCellList.isEmpty()) {
			throw new IllegalStateException("sem celulas vazias");
		}
		Random random = new Random();
		return grassCellList.remove(random.nextInt(grassCellList.size()));
	}

	private Point getUnoccupedRandomPoint(){
		if (avaliablePoints.isEmpty()) {
			throw new IllegalStateException("sem celulas vazias");
		}
		Random random = new Random();
		return avaliablePoints.remove(random.nextInt(avaliablePoints.size()));
	}
}
