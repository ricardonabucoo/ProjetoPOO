package essentials;

import UI.MainMenu;
import UI.Quiz;
import elements.Player;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.io.File;

import javax.swing.*;

public class GameManager {
	private GameMap map;
	private Player player1;
	private Player player2;
	private Boolean isFinished;

	public GameManager() {
		this.isFinished = false;
	}

    public void showMainMenu(){
        MainMenu mainMenu = new MainMenu(this);
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
	