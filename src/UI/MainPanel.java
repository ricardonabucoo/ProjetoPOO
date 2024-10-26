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

        JFrame frame = new JFrame();
        frame.setBounds(50, 50, 1000, 1000);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setVisible(true);

        JPanel panel1 = new JPanel();
        panel1.setBackground(Color.CYAN);
        frame.add(panel1);

        JPanel panel2 = new JPanel();
        panel2.setBackground(Color.ORANGE);

        // Painel no lado oeste (WEST)
        JPanel westPanel = new JPanel();
        westPanel.setBackground(Color.CYAN);
        westPanel.add(new JLabel("WEST"));

        // Painel no lado leste (EAST)
        JPanel eastPanel = new JPanel();
        eastPanel.setBackground(Color.MAGENTA);
        eastPanel.add(new JLabel("EAST"));

        panel2.setLayout(new BorderLayout());
        panel2.add(westPanel, BorderLayout.WEST);
        panel2.add(eastPanel, BorderLayout.EAST);

        JButton button = new JButton("Click Me");
        panel1.add(button);
        button.addActionListener(e -> {
            frame.remove(panel1);
            frame.add(panel2);
            frame.revalidate();
            frame.repaint();
        });

    }
}

