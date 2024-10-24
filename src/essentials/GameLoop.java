package essentials;

public class GameLoop {
	
	public GameLoop() {}
	
	public void run() {
		GameManager gm = new GameManager();
		gm.showMainMenu();
		/*
		do {
			gm.Play();
			gm.Update();
		}while(!gm.IsFinished());
		*/
		//gm.EndGame();
	}
}
