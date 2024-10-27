package UI.Frames;

import Builders.MapBuilder;
import UI.MainMenu;
import elements.Player;
import essentials.Map;
import essentials.MapReader;

import java.awt.*;
import java.io.File;

import javax.swing.*;

public class MainFrame extends JFrame{
	private JPanel currentPanel;

	public MainFrame() {
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}

    public void showMainMenu(){
        currentPanel = new MainMenu();
		this.add(new MainMenu(this),BorderLayout.CENTER);
    }

	public static void main(String[] args) {
		MainFrame mainFrame = new MainFrame();
		MainMenu mainMenu = new MainMenu(mainFrame);
		mainFrame.add(mainMenu);
	}

}
	