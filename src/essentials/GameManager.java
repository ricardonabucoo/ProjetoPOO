package essentials;

import java.util.HashMap;
import java.util.Scanner;

public class GameManager {
	private GameMap map;
	private Player player1;
	private Player player2;
	private Boolean isFinished;
	
	
	
	public GameManager() {
		this.isFinished = false;
	}
	
	public void Initialization() {
				BuildMapByQuiz();
		
	}
	
	private void BuildMapByFile() {			
		MapReader reader = new MapReader();
		reader.readFile("nomedoarquivo.txt");
		
		MapBuilder builder = new MapBuilder();	
		
		builder.BuildCellGrid(reader.getSize());
		builder.BuildRockCells(reader.getRocksAmount());
		builder.BuildTreeCells(reader.getNumberOfTrees());
		builder.BuildGrassCells();
		builder.BuildFruitsCells(reader.getInitialFruitsNumber());
		
		this.map = 
	}
	
	private void BuildMapByQuiz() {
		
		JFrameOne quiz = new JFrameOne();
		
		MapBuilder builder = new MapBuilder();	
		
		builder.BuildCellGrid(quiz.GetSize());
		builder.BuildRockCells(quiz.GetRocksAmount());
		builder.BuildTreeCells(quiz.GetNumberOfTrees());
		builder.BuildGrassCells();
		builder.BuildFruitsCells(quiz.GetFruitsAmount());
		
		this.map = builder.GetResult();
	}
	
	public void Play() {
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
	public void Update() {
		map.Update();
	}
	public void EndGame() {
		System.out.println("Fim de jogo!");
	}
	public int PlayDices() {return 0;}
	public boolean IsFinished() {
		return this.isFinished;
	}
	
	
}
	