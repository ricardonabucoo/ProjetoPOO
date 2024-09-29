package essentials;

import javax.swing.*;

public class Launcher {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SwingUtilities.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				
				JFrameOne frame1 = new JFrameOne();
				
			}
		});
	}

}
