package essentials;

public class GameLoop {

	public void Run() {
		// ler arquivos , bla ,bla ,bla
		MapBuilder builder = new MapBuilder();
		GameMap map = builder.BuildCellGrid(1).BuildRockCells(1).BuildTreeCells(null).BuildGrassCells().BuildFruitsCells(null).GetResult();
		PassionFruitFactory pfFactory = new PassionFruitFactory(builder.GetTreeCellList(),maxPassionFruitsAmount);
		while(true){			
			map.Update();
		}
	}
}
	