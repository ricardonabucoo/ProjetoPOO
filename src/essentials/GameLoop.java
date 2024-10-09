package essentials;

public class GameLoop {
	
	public GameLoop() {}
	
	public void Run() {
		GameManager gm = new GameManager();
		gm.Initialization();
		
		do {
			gm.Play();
			gm.Update();
		}while(!gm.IsFinished());
		
		gm.EndGame();
	}
}
