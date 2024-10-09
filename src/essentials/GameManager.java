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
		// ler arquivos , bla ,bla ,bla		
		
		
		
		
		
		//PassionFruitFactory pfFactory = new PassionFruitFactory(builder.GetTreeCellList(),maxPassionFruitsAmount);
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
		
		GameMap map = builder.GetResult();
		
			
	}
	
	private void BuildMapByQuiz() {
		
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
	