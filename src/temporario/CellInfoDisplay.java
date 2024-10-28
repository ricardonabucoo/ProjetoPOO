package temporario;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

public class CellInfoDisplay extends JFrame {
    private final JLabel infoLabel;
    private final Cell[][] cells;
    private final int gridSize = 5;

    public CellInfoDisplay() {
        setTitle("Informações da Célula");
        setLayout(new BorderLayout());

        JPanel gridPanel = new JPanel(new GridLayout(gridSize, gridSize));
        cells = new Cell[gridSize][gridSize];

        // Inicializar a matriz de células
        for (int i = 0; i < gridSize; i++) {
            for (int j = 0; j < gridSize; j++) {
                cells[i][j] = new Cell(i, j, "Grama", 10); // Exemplo de inicialização
                JPanel cellPanel = new JPanel();
                cellPanel.setBackground(Color.GREEN);
                cellPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
                gridPanel.add(cellPanel);

                // Adiciona um DynamicElem aleatório para demonstrar
                if ((i + j) % 2 == 0) { // Condição para adicionar elemento dinâmico
                    cells[i][j].setDynamicElem(new Fruit("Maçã", 5));
                } else {
                    cells[i][j].setDynamicElem(new Player("Jogador1"));
                }

                // Adiciona o MouseMotionListener a cada célula
                int finalI = i;
                int finalJ = j;
                cellPanel.addMouseMotionListener(new MouseMotionAdapter() {
                    @Override
                    public void mouseMoved(MouseEvent e) {
                        showCellInfo(finalI, finalJ);
                    }
                });
            }
        }

        // Label para exibir as informações da célula
        infoLabel = new JLabel("Passe o mouse sobre uma célula para ver as informações.");
        add(infoLabel, BorderLayout.SOUTH);
        add(gridPanel, BorderLayout.CENTER);

        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    // Método para exibir as informações da célula no label
    private void showCellInfo(int i, int j) {
        Cell cell = cells[i][j];
        StringBuilder info = new StringBuilder(String.format("Posição: (%d, %d), Elemento: %s, Pontos: %d",
                cell.getI(), cell.getJ(), cell.getStaticElement(), cell.getPoints()));

        // Verifica e exibe o elemento dinâmico, se houver
        DynamicElem dynamicElem = cell.getDynamicElem();
        if (dynamicElem != null) {
            info.append(", Dinâmico: ").append(dynamicElem.getInfo());
        }

        infoLabel.setText(info.toString());
    }

    // Classe Cell para armazenar as informações de cada célula
    private static class Cell {
        private final int i, j;
        private final String staticElement;
        private final int points;
        private DynamicElem dynamicElem;

        public Cell(int i, int j, String staticElement, int points) {
            this.i = i;
            this.j = j;
            this.staticElement = staticElement;
            this.points = points;
        }

        public int getI() { return i; }
        public int getJ() { return j; }
        public String getStaticElement() { return staticElement; }
        public int getPoints() { return points; }
        public DynamicElem getDynamicElem() { return dynamicElem; }
        public void setDynamicElem(DynamicElem dynamicElem) { this.dynamicElem = dynamicElem; }
    }

    // Classe mãe para elementos dinâmicos
    private static abstract class DynamicElem {
        public abstract String getInfo();
    }

    // Classe Fruit que herda de DynamicElem
    private static class Fruit extends DynamicElem {
        private final String type;
        private final int value;

        public Fruit(String type, int value) {
            this.type = type;
            this.value = value;
        }

        @Override
        public String getInfo() {
            return "Fruta: " + type + ", Valor: " + value;
        }
    }

    // Classe Player que herda de DynamicElem
    private static class Player extends DynamicElem {
        private final String name;

        public Player(String name) {
            this.name = name;
        }

        @Override
        public String getInfo() {
            return "Jogador: " + name;
        }
    }

    public static void main(String[] args) {
        new CellInfoDisplay();
    }
}

