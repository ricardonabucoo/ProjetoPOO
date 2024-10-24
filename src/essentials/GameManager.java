package essentials;

import UI.MainMenu;
import elements.Player;

import java.awt.BorderLayout;
import java.io.File;

import javax.swing.*;

public class GameManager extends JFrame{
	private Map map;
	private Player player1;
	private Player player2;
	private Boolean isFinished;

	public GameManager() {
		this.isFinished = false;
		setBounds(50, 50, 1000, 1000);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setVisible(true);
	}

    public void showMainMenu(){
        this.add(new MainMenu(this),BorderLayout.CENTER);
    }

    public void buildMapByFile(File file) {
		
		MapReader reader = new MapReader(file);
		MapBuilder builder = new MapBuilder();
		builder.buildCellGrid(reader.getSize());
		builder.buildRockCells(reader.getRocksAmount());
		builder.buildTreeCells(reader.getNumberOfTrees());
		builder.buildGrassCells();
		builder.buildFruitsCells(reader.getInitialFruitsNumber());
		this.map = builder.getResult();
	}
	
	private void buildMapByQuiz() {
		/*
		MapBuilder builder = new MapBuilder();	
		
		builder.BuildCellGrid(quiz.GetSize());
		builder.BuildRockCells(quiz.GetRocksAmount());
		builder.BuildTreeCells(quiz.GetNumberOfTrees());
		builder.BuildGrassCells();
		builder.BuildFruitsCells(quiz.GetFruitsAmount());
		
		this.map = builder.GetResult();
		*/
	}
	/*
	public void play() {
		//so um esboço
		while (!isFinished) {
			 
			//System.out.println(map); //exibe o estado atual do mapa
			//System.out.print("Turno de " + player1.name);
			TurnPlayerOne(player1);
			
			if (checkGameOver(isFinished)) {
				break;
			}
			//System.out.print(map); //exibe o estado atual do mapa após o player jogar
			//System.out.print("Turno de " + player2.name);
			TurnPlayerTwo(player2);
			
			if (checkGameOver(isFinished)) {
				break;
			}
		}		
	}

	private void TurnPlayer1(Player player) {}
	private void TurnPlayer2(Player player) {}	
	private boolean checkGameOver(boolean isfinished) {
		if () {
			isfinished = true;
		}
	}
	public void update() {
		map.Update();
	}
	public void endGame() {
		System.out.println("Fim de jogo!");
	}
	public int playDices() {return 0;}
	public boolean isFinished() {
		return this.isFinished;
	}
	*/
	
}
	