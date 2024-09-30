package essentials;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.*;


public class JFrameOne extends JFrame {
	
	public JFrameOne() {
		Initialize();
	}

	
	public void Initialize () {
		
		JFrame frame= new JFrame();
		frame.setTitle("CataFrutas");
		
		JPanel panel = new JPanel(new FlowLayout(FlowLayout.CENTER, 15,20));
		JPanel background = new JPanel(new FlowLayout(FlowLayout.CENTER,100,200));
		
		frame.setLayout(new BorderLayout(10,5));
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setSize(500, 400);
		frame.setLocationRelativeTo(null);
		
		
		background.setBackground(Color.GRAY);
		panel.setBackground(Color.DARK_GRAY);
		
		Button button = new Button ("Play");
		panel.add(button);
		
		frame.add(panel, BorderLayout.EAST);
		frame.add(background, BorderLayout.CENTER);
		
		
		frame.setVisible(true);
		
	}
	
	
}
