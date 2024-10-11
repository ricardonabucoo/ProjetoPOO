	package essentials;

import java.util.HashMap;

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
		// perguntar se a pessoa quer ler entradas ou importar arquivo
		
		
		
		
		
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
		
		this.map = builder.GetResult();
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
	
	public void Play() {}
	public void Update() {
		map.Update();
	}
	public void EndGame() {}
	public int PlayDices() {return 0;}
	public boolean IsFinished() {
		return this.isFinished;
	}
	
	
}
	