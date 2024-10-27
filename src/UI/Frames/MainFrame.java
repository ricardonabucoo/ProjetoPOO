package UI.Frames;

import Builders.MapBuilder;
import UI.MainMenu;
import elements.Player;
import essentials.Cell;
import essentials.Map;
import essentials.MapReader;
import essentials.PassionFruitFactory;

import java.awt.*;
import java.io.File;
import java.util.List;

import javax.swing.*;

public class MainFrame extends JFrame{

	private static JPanel previousPanel;
	private static JPanel currentPanel;
	private static MainFrame instance;

	public MainFrame() {
		previousPanel = null;
		currentPanel = null;
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		showMainMenu();
	}

	public static MainFrame getInstance() {
		return instance;
	}

	public static JPanel getPreviousPanel() {
		return previousPanel;
	}

	public static JPanel getCurrentPanel() {
		return currentPanel;
	}

	public void setCurrentPanel(JPanel currentPanel) {
		MainFrame.previousPanel = MainFrame.currentPanel;
		remove(MainFrame.previousPanel);
		MainFrame.currentPanel = currentPanel;
		add(MainFrame.currentPanel);
		revalidate();
		repaint();
	}

    public void showMainMenu(){
		setCurrentPanel(new MainMenu());
    }

	public static void main(String[] args) {
		MainFrame mainFrame = new MainFrame();
	}

}
	