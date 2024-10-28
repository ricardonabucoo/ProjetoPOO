package UI.Panels;

import java.awt.*;

import javax.swing.*;

import UI.Buttons.*;
import essentials.*;
import elements.*;

public class TopGameBoard extends JPanel {

	private Match gameMatch;


	public TopGameBoard(Match gameMatch) {

		this.gameMatch = gameMatch;
		setLayout(new GridLayout(0, 3));
		setBackground(Color.decode("#008b8b"));
		this.add(createPanel(gameMatch.getPlayerOne()));
		this.add(createCenterPanel());
		this.add(createPanel(gameMatch.getPlayerTwo()));
	}

	private JPanel createPanel(Player player) {
		JPanel panel = new JPanel();
		setLayout(new FlowLayout());
		panel.add(new JButton(Integer.toString(player.getBag().getPassionFruitAmount())));
		panel.add( new JButton(player.getName()));
		panel.add(new JButton(Integer.toString(player.getBag().getPassionFruitAmount())));
		return panel;
	}

	private JPanel createCenterPanel() {
		JPanel panel = new JPanel();
		setLayout(new FlowLayout());
		panel.add(gameMatch.getRoundCount());
		panel.add(new CloseMainFrameButton());
		return panel;
	}

}
