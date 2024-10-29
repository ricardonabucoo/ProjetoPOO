package essentials;

import UI.Panels.MapInfoPanel;
import elements.*;
import temporario.CellInfoDisplay;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.io.Serializable;

public class Map extends JPanel implements Serializable {

	public static Cell[][] grid;
	private Player player1;
	private Player player2;
	private int gridSize;
	private PassionFruitFactory passionFruitFactory;
	private GridBagConstraints gbc;
	private MapInfoPanel mapInfoPanel;


	public Map(int size) {
		passionFruitFactory = null;
		mapInfoPanel = new MapInfoPanel(this);
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

		mapInfoPanel.removeAll();

		Cell cell = grid[i][j];

		Dimension buttonSize = new Dimension(200, 40); // Largura 200px, altura 40px

		// Cria e adiciona os botões de informações
		mapInfoPanel.add(createButtonPanel("Célula", buttonSize));
		mapInfoPanel.add(createButtonPanel("Linha: " + cell.getRow(), buttonSize));
		mapInfoPanel.add(createButtonPanel("Coluna: " + cell.getCol(), buttonSize));

		// Exibe o elemento estático como um painel de imagem
		JPanel staticElemPanel = new JPanel();
		staticElemPanel.setPreferredSize(new Dimension(200, 200));

		// Obtém o caminho da imagem com base no elemento estático
		String imagePath = getStaticElementImagePath(cell.getStaticElem());
		ImageIcon staticElemIcon = new ImageIcon(imagePath);

		JButton button = new JButton();
		button.setIcon(staticElemIcon);

		staticElemPanel.add(button);
		mapInfoPanel.add(staticElemPanel);


		// Verifica se há um elemento dinâmico e cria um botão para ele
		DynamicElem dynamicElem = cell.getDynamicElem();
		if (dynamicElem != null) {
			mapInfoPanel.add(createButtonPanel("Elemento Dinâmico: " + dynamicElem, buttonSize));
		}

		// Atualiza o painel para exibir os novos componentes
		mapInfoPanel.revalidate();
		mapInfoPanel.repaint();
	}

	private JPanel createButtonPanel(String text, Dimension buttonSize) {
		JButton button = new JButton(text);
		button.setPreferredSize(buttonSize);

		JPanel panel = new JPanel();
		panel.setLayout(new FlowLayout(FlowLayout.CENTER));
		panel.add(button);
		panel.setPreferredSize(buttonSize); // Define o tamanho do painel também

		return panel;
	}

	private String getStaticElementImagePath (Object staticElem) {
		if (staticElem instanceof Tree) {
			return ((Tree) staticElem).getCurrentImagePath();
		} else if (staticElem instanceof Grass) {
			return ((Grass) staticElem).getCurrentImagePath();
		} else {
			return ((Rock) staticElem).getCurrentImagePath();
		}
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

	public MapInfoPanel getMapInfoPanel() {
		return mapInfoPanel;
	}
}
