package essentials;

import javax.swing.JFrame;

public class JFrameOne extends JFrame {
	
	public JFrameOne() {
		Initialize();
	}

	
	public void Initialize () {
		
		setTitle("CataFrutas");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setSize(500, 400);
		setLocationRelativeTo(null);
		setVisible(true);
		
		
	}
	
	
}
