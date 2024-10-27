package essentials;

import UI.Frames.MainFrame;

public class GameLoop {
	
	public GameLoop() {}
	
	public void run() {
		MainFrame gm = new MainFrame();
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
