package essentials;

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
	private GridBagConstraints gbc;
	private JPanel cellInfoPanel; // Painel de informações da célula
	private JPanel gridPanel; // Painel que contém a grade

	public Map() {
		cellInfoPanel = new JPanel();
		player1 = null;
		player2 = null;
		grid = null;
		gridSize = 3;
		setLayout(new BorderLayout()); // Define o layout como BorderLayout
		gbc = new GridBagConstraints();
		gbc.weightx = 1;
		gbc.weighty = 1;
		gbc.fill = GridBagConstraints.BOTH;

		gridPanel = new JPanel(new GridBagLayout()); // Painel para a grade
		fillDefaultCells();

		add(cellInfoPanel, BorderLayout.EAST); // Coloca o painel de informações no lado direito
		add(gridPanel, BorderLayout.CENTER); // Coloca a grade no centro
	}

	public Map(int size) {
		cellInfoPanel = new JPanel();
		player1 = null;
		player2 = null;
		grid = null;
		gridSize = size;
		setLayout(new BorderLayout()); // Define o layout como BorderLayout
		gbc = new GridBagConstraints();
		gbc.weightx = 1;
		gbc.weighty = 1;
		gbc.fill = GridBagConstraints.BOTH;

		gridPanel = new JPanel(new GridBagLayout()); // Painel para a grade
		fillDefaultCells();

		add(cellInfoPanel, BorderLayout.EAST); // Coloca o painel de informações no lado direito
		add(gridPanel, BorderLayout.CENTER); // Coloca a grade no centro
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
		cellInfoPanel.removeAll();

		cellInfoPanel.setLayout(new BoxLayout(cellInfoPanel, BoxLayout.Y_AXIS));

		Cell cell = grid[i][j];

		Dimension buttonSize = new Dimension(200, 40); // Largura 200px, altura 40px

		// Cria e adiciona os botões de informações
		cellInfoPanel.add(createButtonPanel("Célula", buttonSize));
		cellInfoPanel.add(createButtonPanel("Linha: " + cell.getRow(), buttonSize));
		cellInfoPanel.add(createButtonPanel("Coluna: " + cell.getCol(), buttonSize));

		// Exibe o elemento estático como um painel de imagem
		JPanel staticElemPanel = new JPanel();
		staticElemPanel.setPreferredSize(new Dimension(200, 200));

		// Obtém o caminho da imagem com base no elemento estático
		String imagePath = getStaticElementImagePath(cell.getStaticElem());
		ImageIcon staticElemIcon = new ImageIcon(imagePath);

		JButton button = new JButton();
		button.setIcon(staticElemIcon);

		staticElemPanel.add(button);
		cellInfoPanel.add(staticElemPanel);


		// Verifica se há um elemento dinâmico e cria um botão para ele
		DynamicElem dynamicElem = cell.getDynamicElem();
		if (dynamicElem != null) {
			cellInfoPanel.add(createButtonPanel("Elemento Dinâmico: " + dynamicElem, buttonSize));
		}

		// Atualiza o painel para exibir os novos componentes
		cellInfoPanel.revalidate();
		cellInfoPanel.repaint();
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

	public void addCell(Cell cell, int row, int col) {
		gbc.gridx = row;
		gbc.gridy = col;
		grid[row][col] = cell;
		gridPanel.add(cell, gbc);
		cell.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent e) {
				cellInfoPanel(row, col);
			}
		});
	}

	public void update() {
		for (int i = 0; i < gridSize; i++) {
			for (int j = 0; j < gridSize; j++) {
				grid[i][j].update();
			}
		}
	}

	public JPanel getCellInfoPanel() {
		return cellInfoPanel;
	}
}
