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
		
		
		setLayout(new BorderLayout(10,5));
		setTitle("CataFrutas");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setSize(500, 400);
		setLocationRelativeTo(null);
		
		JPanel panel = new JPanel();
		JPanel background = new JPanel();
		panel.setLayout(new FlowLayout(FlowLayout.CENTER,15,20));
		background.setLayout(new FlowLayout(FlowLayout.CENTER,100,200));
		
		background.setBackground(Color.GRAY);
		panel.setBackground(Color.DARK_GRAY);
		
		Button button = new Button ("Play");
		panel.add(button);
		
		this.add(panel, BorderLayout.EAST);
		this.add(background, BorderLayout.CENTER);
		
		
		setVisible(true);
		
	}
	
	
}
