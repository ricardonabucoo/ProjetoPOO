package UI.Panels;

import javax.swing.*;

import java.awt.*;

public class GamePanel extends JPanel {
	

	    private JPanel leftPanel;
	    private JPanel rightPanel;
	    private JPanel centerPanel;
	    private JPanel topPanel;

	    public GamePanel() {
	        setLayout(new BorderLayout());
	        setBackground(Color.decode("#008b8b"));
	        leftPanel = createLeftPanel();
	        rightPanel = createRightPanel();
	        centerPanel = new MainMenuPanel();
	        topPanel = createTopPanel();
	        add(leftPanel, BorderLayout.WEST);
	        add(rightPanel, BorderLayout.EAST);
	        add(centerPanel, BorderLayout.CENTER);
	        add(topPanel, BorderLayout.NORTH);

	    }

	    private JPanel createLeftPanel() {
	        JPanel panel = new JPanel();
	        panel.setBackground(Color.MAGENTA);
	        return panel;
	    }
	    private JPanel createRightPanel() {
	        JPanel panel = new JPanel();
	        panel.setBackground(Color.CYAN);
	        return panel;
	    }
	    private JPanel createCenterPanel() {
	        JPanel panel = new JPanel();
	        panel.setBackground(Color.GREEN);
	        return panel;
	    }
	    private JPanel createTopPanel() {
	        JPanel panel = new JPanel();
	        panel.setBackground(Color.orange);
	        return panel;
	    }

	    public static void main(String[] args) {
	        JFrame frame = new JFrame();
	        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        frame.setSize(800, 600);
	        frame.setLocationRelativeTo(null);
	        frame.setVisible(true);

	        GamePanel panel = new GamePanel();
	        frame.add(panel);

	    }
}
