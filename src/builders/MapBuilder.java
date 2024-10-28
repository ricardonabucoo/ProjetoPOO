package builders;

import elements.*;
import essentials.Cell;
import essentials.Map;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

public class MapBuilder implements Builder {

	private Map map;
	private int gridSize;
	private List<Cell> rocksCellList;
	private List<Cell> grassCellList;
	private List<Cell> treeCellList;
	private List<Cell> fruitCellList;
	private List<Cell> availableCells;
	private Player player1;
	private Player player2;
	private PassionFruitFactory passionFruitFactory;

	public MapBuilder(){
		reset();
	}

	@Override
	public void build() {}

	public MapBuilder buildMap(int size, int rocksAmount, HashMap<FruitType, Integer> treeMap, HashMap<FruitType, Integer> fruitMap, int passionFruitsAmount, String name_p1, String name_p2, int bagCapacity) {
		buildCellGrid(size)
				.buildRockCells(rocksAmount)
				.buildTreeCells(treeMap)
				.buildGrassCells()
				.buildFruitsCells(fruitMap)
				.buildPassionFruitFactory(passionFruitsAmount)
				.buildPlayerOne(name_p1,bagCapacity)
				.buildPlayerTwo(name_p2,bagCapacity);
		return this;
	}

	@Override
	public void reset() {
		map = null;
		gridSize = 0;
		rocksCellList = new ArrayList<>();
		grassCellList = new ArrayList<>();
		treeCellList = new ArrayList<>();
		fruitCellList = new ArrayList<>();
		availableCells = new ArrayList<>();
		player1 = null;
		player2 = null;
	}
	public Map getResult() {
		Map mapAux = map;
		reset();
		return mapAux;
	}

	public List<Cell> getFruitCellList() {
		return this.fruitCellList;
	}

	private MapBuilder buildPassionFruitFactory(int PassionFruitsAmount){
		passionFruitFactory = PassionFruitFactory.getInstance(treeCellList, PassionFruitsAmount);
		return this;
	}

	private MapBuilder buildCellGrid(int size) {
		gridSize = size;
		map = new Map(size);
		for (int i = 0; i < size; i++)
			for (int j = 0; j < size; j++) {
				Cell cell = new Cell(i, j);
				map.addCell(cell,i,j);
				availableCells.add(cell);
			}
		Cell.setGridMap(map.getGrid());
		map.revalidate();
		map.repaint();
		return this;
	}

	private Player buildPlayer(String playerName, int bagCapacity) {
		Cell cell = getRandomEmptyCell();
		Player player = new Player(playerName,new Bag(bagCapacity),cell);
		cell.setDynamicElem(player);
		return player;
	}

	private MapBuilder buildPlayerOne(String name, int bagCapacity){
		player1 = buildPlayer(name,bagCapacity);
		return this;
	}

	private MapBuilder buildPlayerTwo(String name, int bagCapacity){
		player2 = buildPlayer(name,bagCapacity);
		return this;
	}

	private MapBuilder buildRockCells(int rocksAmount) {
		for(int i = 0; i < rocksAmount; i++) {
			Cell cell = getRandomEmptyCell();
			cell.setStaticElem(new Rock(cell));
			rocksCellList.add(cell);
		}
		return this;
	}

	private MapBuilder buildTreeCells(HashMap<FruitType, Integer> treeMap) {
		treeMap.forEach((type, amount) -> {
			for (int i = 0; i < amount; i++) {
				Cell cell = getRandomEmptyCell();
				cell.setStaticElem(new Tree(cell, type));
				treeCellList.add(cell);
			}
		});
		/*
		int treesAmount = 0;
		for(java.util.Map.Entry<FruitType, Integer> entry : treeMap.entrySet()) {
			int value = entry.getValue();
			treesAmount += value;
			for(int i = 0; i < value; i++){
				Cell cell = getRandomEmptyCell();
				cell.setStaticElem(new Tree(cell,entry.getKey()));
				treeCellList.add(cell);
			}
		}
		*/
		return this;
	}

	private MapBuilder buildGrassCells() {
		int grassCount = gridSize * gridSize - treeCellList.size() - rocksCellList.size();
			for(int i = 0; i < grassCount; i++) {
				Cell cell = getRandomEmptyCell();
				cell.setStaticElem(new Grass(cell));
				grassCellList.add(cell);
			}
		return this;
	}

	private MapBuilder buildFruitsCells(HashMap<FruitType, Integer> fruitMap) {

		fruitMap.forEach((type, amount) -> {
			for (int i = 0; i < amount; i++) {
				Cell cell = getRandomWithoutFruitCell();
				cell.setDynamicElem(new Fruit(cell, type));
				fruitCellList.add(cell);
			}
		});
		/*
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
		*/
		return this;
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
