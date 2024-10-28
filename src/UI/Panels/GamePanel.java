package UI.Panels;

import essentials.Match;

import javax.swing.*;

import java.awt.*;

public class GamePanel extends JPanel {

	    public GamePanel(Match match) {
	        setLayout(new BorderLayout());
	        setBackground(Color.decode("#008b8b"));
	        add(createPanel(), BorderLayout.WEST);
	        add(createPanel(), BorderLayout.EAST);
	        add(match.getMap(), BorderLayout.CENTER);
	        add(new TopGameBoard(match), BorderLayout.NORTH);

	    }

	    private JPanel createPanel() {
	        JPanel panel = new JPanel();
	        panel.setBackground(Color.lightGray);
	        return panel;
	    }

	    private JPanel createCenterPanel() {
	        JPanel panel = new JPanel();
	        panel.setBackground(Color.GREEN);
	        return panel;
	    }

}
