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
		MapBuilder builder = new MapBuilder();
		
		HashMap<FruitType, Integer> treeMap = new HashMap<>();
		treeMap.put(FruitType.ORANGE, 2);
		treeMap.put(FruitType.COCONUT, 1);
		
		GameMap map = builder.BuildCellGrid(25).BuildRockCells(4).BuildTreeCells(treeMap).BuildGrassCells().BuildFruitsCells(treeMap).GetResult();
		//PassionFruitFactory pfFactory = new PassionFruitFactory(builder.GetTreeCellList(),maxPassionFruitsAmount);
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
	