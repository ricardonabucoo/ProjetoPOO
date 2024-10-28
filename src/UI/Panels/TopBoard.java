package UI.Panels;

import java.awt.*;

import javax.swing.*;

import UI.Buttons.*;
import essentials.*;

public class TopBoard extends JPanel {
	
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
	
	

	public TopBoard() {
		
		setLayout(new GridLayout(0,3));
		setBackground(Color.decode("#008b8b"));
		PassionPlayerOne = getPassionPlayerOne();
		PassionPlayerTwo = getPassionPlayerTwo();
		NamePlayerOne = getNamePlayerOne();
		NamePlayerTwo = getNamePlayerTwo();
		PowerPlayerOne = getPowerPlayerOne();
		PowerPlayerTwo = getPowerPlayerTwo();
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
		int player2P = match.GetPlayerTwo().getPlayerPower();
		return null;
	}

	private JPanel createRightPanel() {
    	 JPanel panel = new JPanel();
    	 setLayout(new FlowLayout());
         panel.setBackground(Color.orange);
         return panel;
	}

	private JPanel createCenterPanel() {
		 JPanel panel = new JPanel();
		 setLayout(new FlowLayout());
	        panel.setBackground(Color.yellow);
	        return panel;
	}

	private JPanel createLeftPanel() {
		 JPanel panel = new JPanel();
		 setLayout(new FlowLayout());
	        panel.setBackground(Color.green);
	        return panel;
	}

	private JButton getPowerPlayerOne(Match match) {
		int player1P = match.GetPlayerOne().getPlayerPower();
		return null;
	}

	private JButton getNamePlayerTwo(Match match) {
		String player2N = match.GetPlayerTwo().getPlayerName();
		return null;
	}

	private JButton getNamePlayerOne(Match match) {
		String player1N = match.GetPlayerOne().getPlayerName();
		return null;
	}

	private JButton getPassionPlayerTwo(Match match) {
		int player2PF = match.GetPlayerTwo().getBag().getFruitsAmount();
		return null;
	}

	private JButton getPassionPlayerOne(Match match) {
		int player1PF = match.GetPlayerOne().getBag().getFruitsAmount();
		return null;
	}


    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        TopBoard panel = new TopBoard();
        frame.add(panel);

    }

}
