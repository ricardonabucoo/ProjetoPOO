package essentials;

import elements.*;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MapBuilder {

	private Map map;
	private int gridSize;
	private int rocksAmount;
	private int treesAmount;
	private List<Cell> grassCellList;
	private List<Cell> treeCellList;
	private List<Cell> availableCells;
	private Player player1;
	private Player player2;

	public MapBuilder() {
		reset();
	}
	public MapBuilder(Map map){
		reset();
		this.map = map;
	}

	public void reset() {
		gridSize = 0;
		rocksAmount = 0;
		treesAmount = 0;
		grassCellList = new ArrayList<>();
		treeCellList = new ArrayList<>();
		availableCells = new ArrayList<>();
		player1 = null;
		player2 = null;
	}

	public MapBuilder buildCellGrid(int size) {
		this.gridSize = size;
		map = new Map(size);
		for (int i = 0; i < size; i++)
			for (int j = 0; j < size; j++) {
				Cell cell = new Cell(i, j);
				map.addCell(cell,i,j);
				availableCells.add(cell);
			}
		map.revalidate();
		map.repaint();
		return this;
	}

	public MapBuilder buildRockCells(int rocksAmount) {
		this.rocksAmount = rocksAmount;
		for(int i = 0; i < rocksAmount; i++) {
			Cell cell = getRandomEmptyCell();
			cell.setStaticElem(new Rock(cell));
		}
		return this;
	}

	public MapBuilder buildTreeCells(HashMap<FruitType, Integer> treeMap) {
		for(java.util.Map.Entry<FruitType, Integer> entry : treeMap.entrySet()) {
			int value = entry.getValue();
			this.treesAmount += value;
			for(int i = 0; i < value; i++){
				Cell cell = getRandomEmptyCell();
				cell.setStaticElem(new Tree(cell,entry.getKey()));
				treeCellList.add(cell);
			}
		}

		return this;
	}

	public MapBuilder buildGrassCells() {
		int value = gridSize*gridSize - rocksAmount - treesAmount;
			for(int i = 0; i < value; i++) {
				Cell cell = getRandomEmptyCell();
				cell.setStaticElem(new Grass(cell));
				grassCellList.add(cell);
			}
		return this;
	}

	public MapBuilder buildFruitsCells(HashMap<FruitType, Integer> fruitMap) {
		int totalFruits = fruitMap.values().stream().mapToInt(Integer::intValue).sum();
		if (totalFruits > grassCellList.size()) {
			throw new IllegalArgumentException("numero de frutas maior que o numero de celular disponiveis");
		}
		else
		{
			for(java.util.Map.Entry<FruitType, Integer> entry : fruitMap.entrySet()) {
				int value = entry.getValue();
				for(int i = 0; i < value; i++){
					Cell cell = getRandomWithoutFruitCell();
					cell.setDynamicElem(new Fruit(cell,entry.getKey()));
				}
			}
		}
		return this;
	}

	public MapBuilder buildPlayerOne(String name, int bagCapacity){
		Cell cell = getRandomEmptyCell();
		this.player1 = new Player(name,new Bag(bagCapacity),cell);
		cell.setDynamicElem(player1);
		return this;
	}

	public MapBuilder buildPlayerTwo(String name, int bagCapacity){
		Cell cell = getRandomEmptyCell();
		this.player2 = new Player(name,new Bag(bagCapacity),cell);
		cell.setDynamicElem(player1);
		return this;
	}

	public List<Cell> getTreeCellList() {
		return this.treeCellList;
	}

	public Player getPlayerOne() {
		return player1;
	}

	public Player getPlayerTwo() {
		return player2;
	}

	public Map getResult() {
		Map mapAux = map;
		reset();
		return mapAux;
	}

	private Cell getRandomWithoutFruitCell() {
		if (grassCellList.isEmpty()) {
			throw new IllegalStateException("sem celulas vazias");
		}
		Random random = new Random();
		return grassCellList.remove(random.nextInt(grassCellList.size()));
	}

	private Cell getRandomEmptyCell() {
		if (availableCells.isEmpty()) {
			throw new IllegalStateException("sem celulas vazias");
		}
		Random random = new Random();
		return availableCells.remove(random.nextInt(availableCells.size()));
	}



}
