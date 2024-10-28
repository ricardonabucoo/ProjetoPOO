package UI.Panels;

import java.awt.*;

import javax.swing.*;

import UI.Buttons.*;
import essentials.*;

public class TopBoard extends JPanel  {
	
	private JButton PassionPlayerOne;
	private JButton PassionPlayerTwo;
	private JButton NamePlayerOne;
	private JButton NamePlayerTwo;
	private JButton PowerPlayerOne;
	private JButton PowerPlayerTwo;
	private JButton RoundCounter;
	private JButton ExitButton;
	private JPanel Left;
	private JPanel Center;
	private JPanel Right;
	
	

	public TopBoard(Match gameMatch) {
		
		setLayout(new GridLayout(0,3));
		setBackground(Color.decode("#008b8b"));
		PassionPlayerOne = getPassionPlayerOne(gameMatch);
		PassionPlayerTwo = getPassionPlayerTwo(gameMatch);
		NamePlayerOne = getNamePlayerOne(gameMatch);
		NamePlayerTwo = getNamePlayerTwo(gameMatch);
		PowerPlayerOne = getPowerPlayerOne(gameMatch);
		PowerPlayerTwo = getPowerPlayerTwo(gameMatch);
		RoundCounter = getRoundCounter();
		ExitButton = new CloseMainFrameButton();
		Left= createLeftPanel();
		Center= createCenterPanel();
		Right= createRightPanel();
		this.add(Left);
		this.add(Center);
		this.add(Right);
		}
	
    private JButton getRoundCounter() {
		
		return null;
	}

	private JButton getPowerPlayerTwo(Match match) {
		int player2Power = match.getPlayerTwo().getPower();
		JButton powerButton = new JButton(Integer.toString(player2Power));
		return powerButton;
	}

	private JPanel createRightPanel() {
    	 JPanel panel = new JPanel();
    	 setLayout(new FlowLayout());
    	 panel.add(PassionPlayerTwo);
    	 panel.add(NamePlayerTwo);
    	 panel.add(PowerPlayerTwo);
         return panel;
	}

	private JPanel createCenterPanel() {
		 JPanel panel = new JPanel();
		 setLayout(new FlowLayout());
    	 panel.add(RoundCounter);
    	 panel.add(ExitButton);
	        return panel;
	}

	private JPanel createLeftPanel() {
		 JPanel panel = new JPanel();
		 setLayout(new FlowLayout());
    	 panel.add(PassionPlayerOne);
    	 panel.add(NamePlayerOne);
    	 panel.add(PowerPlayerOne);
	        return panel;
	}

	private JButton getPowerPlayerOne(Match match) {
		int player1Power = match.getPlayerOne().getPower();
		JButton powerButton = new JButton(Integer.toString(player1Power));
		return powerButton;
	}

	private JButton getNamePlayerTwo(Match match) {
		String player2Name = match.getPlayerTwo().getName();
		JButton nameButton = new JButton(player2Name);
		return nameButton;
	}

	private JButton getNamePlayerOne(Match match) {
		String player1Name = match.getPlayerOne().getName();
		JButton nameButton = new JButton(player1Name);
		return nameButton;
	}

	private JButton getPassionPlayerTwo(Match match) {
		int player2PassionFruit = match.getPlayerTwo().getBag().getPassionFruitAmount();
		JButton goldenFruitButton = new JButton(Integer.toString(player2PassionFruit));
		return goldenFruitButton;
	}

	private JButton getPassionPlayerOne(Match match) {
		int player1PassionFruit = match.getPlayerOne().getBag().getPassionFruitAmount();
		JButton goldenFruitButton = new JButton(Integer.toString(player1PassionFruit));
		return goldenFruitButton;
	}


    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        
        CreateMatchPanel create = new CreateMatchPanel(null, null);
        TopBoard panel = new TopBoard(create.getMatch());
        frame.add(panel);

    }

}
