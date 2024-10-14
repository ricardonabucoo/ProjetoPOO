	package essentials;
	
	import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
		
	public class MapBuilder {
	
		private Cell[][] grid;
		private int gridSize;
		private int rocksAmount;
		private int treesAmount;
		private List<Cell> grassCellList;
		private List<Cell> treeCellList;
		private List<Cell> availableCells;
		private Player player1;				
		private Player player2;	
		
		
		public MapBuilder() {
			Reset();							
		}
		
		public void Reset() {
			this.grid = null;
		    this.gridSize = 0;					
		    this.rocksAmount = 0;
		    this.treesAmount = 0;
		    this.grassCellList = new ArrayList<>();
		    this.treeCellList = new ArrayList<>();
		    this.availableCells = new ArrayList<>();
		    this.player1 = null;
		    this.player2 = null;
		}
		
		public MapBuilder BuildCellGrid(int size) {
			JFrame frame = new JFrame();
	        frame.setTitle("CataFrutas");
        	
	        JPanel centerPanel = new JPanel(new GridBagLayout());
	        GridBagConstraints gbc = new GridBagConstraints();
	        
	        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	        frame.setSize(700, 700); 
	        frame.setLocationRelativeTo(null);
	        frame.add(centerPanel, BorderLayout.CENTER);
	        
	        gbc.weightx = 1;
	        gbc.weighty = 1;
	        gbc.fill = GridBagConstraints.BOTH; 
	        
	        
			this.gridSize = size;
			grid = new Cell[size][size];
			for (int i = 0; i < size; i++) {
			    for (int j = 0; j < size; j++) {
			    	Cell cell = new Cell(i, j);
			    	cell.setPreferredSize(new Dimension(100, 100));
			    	gbc.gridx = i;  
	                gbc.gridy = j;
	                centerPanel.add(cell, gbc);
			        grid[i][j] = cell;
			        availableCells.add(cell);
			    }
			}	
			
			frame.addComponentListener(new java.awt.event.ComponentAdapter() {
	            public void componentResized(java.awt.event.ComponentEvent evt) {
	                adjustButtonSize(centerPanel, size);
	            }
	        });
			frame.setVisible(true);												
			return this;
		}
		
		public MapBuilder BuildRockCells(int rocksAmount) {
			this.rocksAmount = rocksAmount;
			for(int i = 0; i < rocksAmount; i++) {
				Cell cell = GetRandomEmptyCell();
				cell.SetStaticElem(new Rock(cell)); 
			}
			return this;	
		}
		
		public MapBuilder BuildTreeCells(HashMap<FruitType, Integer> treeMap) {
			for(Map.Entry<FruitType, Integer> entry : treeMap.entrySet()) {
				int value = entry.getValue();
				this.treesAmount += value;
				for(int i = 0; i < value; i++){
					Cell cell = GetRandomEmptyCell();
					cell.SetStaticElem(new Tree(cell,entry.getKey()));
					treeCellList.add(cell);
				}
			}	
				
			return this;
		}
		
			
		public MapBuilder BuildGrassCells() {
			int value = gridSize*gridSize - rocksAmount - treesAmount;
				for(int i = 0; i < value; i++) {	
					Cell cell = GetRandomEmptyCell();
					cell.SetStaticElem(new Grass(cell));
					grassCellList.add(cell);
				}	
			return this;		
		}
		
		// pressupoe que o numero de frutas é menor ou igual ao numero de frutas
		public MapBuilder BuildFruitsCells(HashMap<FruitType, Integer> fruitMap) {
			int totalFruits = fruitMap.values().stream().mapToInt(Integer::intValue).sum();
			if (totalFruits > grassCellList.size()) {
			    throw new IllegalArgumentException("numero de frutas maior que o numero de celular disponiveis");
			}
			else
			{
				for(Map.Entry<FruitType, Integer> entry : fruitMap.entrySet()) {
					int value = entry.getValue();
					for(int i = 0; i < value; i++){	
						Cell cell = GetRandomWithoutFruitCell();
						cell.SetDynamicElem(new Fruit(cell,entry.getKey(), false));
					}
				}			
			}
			return this;
		}
		public MapBuilder BuildPlayerOne(String name, int bagCapacity){
			Cell cell = GetRandomEmptyCell();
			this.player1 = new Player(name,new Bag(bagCapacity),cell);
			cell.SetDynamicElem(player1);
			return this;
		}
		public MapBuilder BuildPlayerTwo(String name, int bagCapacity){
			Cell cell = GetRandomEmptyCell();
			this.player2 = new Player(name,new Bag(bagCapacity),cell);
			cell.SetDynamicElem(player1);
			return this;
		}
		
		public List<Cell> GetTreeCellList() {				
			return this.treeCellList;
		}
		
		public Player GetPlayerOne() {
			return player1;
		}
		
		public Player GetPlayerTwo() {
			return player2;
		}
			
		public GameMap GetResult() {
			GameMap gm = new GameMap(grid);
			Reset();	
			return gm;
		}
		
		private Cell GetRandomWithoutFruitCell() {
			if (grassCellList.isEmpty()) {
		        throw new IllegalStateException("sem celular vazias");
		    }
		    Random random = new Random();
		    return grassCellList.remove(random.nextInt(grassCellList.size()));
		}
		
		private Cell GetRandomEmptyCell() {
		    if (availableCells.isEmpty()) {
		        throw new IllegalStateException("sem celular vazias");
		    }
		    Random random = new Random();
		    return availableCells.remove(random.nextInt(availableCells.size()));
		}
		// Método para ajustar o tamanho dos botões para que sejam quadrados
	    private void adjustButtonSize(JPanel panel, int gridSize) {
	        int width = panel.getWidth() / gridSize; // Largura de cada botão
	        int height = panel.getHeight() / gridSize; // Altura de cada botão
	        int buttonSize = Math.min(width, height); // Tamanho mínimo para manter os botões quadrados

	        for (Component comp : panel.getComponents()) {
	            if (comp instanceof JButton) {
	                comp.setPreferredSize(new Dimension(buttonSize, buttonSize));
	            }
	        }
	        panel.revalidate(); // Revalida o painel para aplicar as alterações
	        panel.repaint();    // Repaint para garantir que as mudanças sejam visíveis
	    }
			
		
	}
