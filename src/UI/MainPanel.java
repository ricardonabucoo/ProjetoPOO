package UI;

import javax.swing.*;
import java.awt.*;

public class MainPanel extends JFrame {

    public MainPanel() {
        setTitle("JSplitPane Example");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 400);

        // Painel no lado oeste (WEST)
        JPanel westPanel = new JPanel();
        westPanel.setBackground(Color.CYAN);
        westPanel.add(new JLabel("WEST"));

        // Painel no lado leste (EAST)
        JPanel eastPanel = new JPanel();
        eastPanel.setBackground(Color.MAGENTA);
        eastPanel.add(new JLabel("EAST"));

        // Usando JSplitPane para dividir o espaço
        JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, westPanel, eastPanel);
        splitPane.setResizeWeight(0.3); // Define que o WEST ocupa 30% da largura, o EAST 70%

        add(splitPane);

        setVisible(true);
    }

    public static void main(String[] args) {
        new MainPanel();
    }
}

