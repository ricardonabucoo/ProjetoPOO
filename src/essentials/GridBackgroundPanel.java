package essentials;

import java.awt.*;

import javax.swing.*;

class GridBackgroundPanel extends JPanel {
    private int rows, cols;

    public GridBackgroundPanel(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        int width = getWidth();
        int height = getHeight();
        int cellWidth = height / rows;
        int cellHeight = height / rows;

        g.setColor(Color.LIGHT_GRAY);
        for (int i = 0; i < cols; i++) {
            for (int j = 0; j < rows; j++) {
                g.drawRect(i * cellWidth, j * cellHeight, cellWidth, cellHeight);
            }
        }
    }
}
