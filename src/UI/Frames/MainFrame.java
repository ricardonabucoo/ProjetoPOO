package UI.Frames;

import UI.Panels.MainMenuPanel;

import javax.swing.*;

public class MainFrame extends JFrame{

	private static JPanel previousPanel;
	private static JPanel currentPanel;
	private static MainFrame instance;

	private MainFrame() {
			instance = this;
			previousPanel = null;
			currentPanel = null;
			setExtendedState(JFrame.MAXIMIZED_BOTH);
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setVisible(true);
			showMainMenu();
	}

	public static MainFrame getInstance() {
		if (instance == null) {
			instance = new MainFrame();
		}
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
		if (MainFrame.previousPanel != null) {
			remove(MainFrame.previousPanel);
		}
		MainFrame.currentPanel = currentPanel;
		add(MainFrame.currentPanel);
		revalidate();
		repaint();
	}

    public void showMainMenu(){
		setCurrentPanel(new MainMenuPanel());
    }

	public static void main(String[] args) {
		MainFrame mainFrame = new MainFrame();
	}

}
	