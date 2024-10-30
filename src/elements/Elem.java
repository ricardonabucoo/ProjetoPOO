package elements;

import essentials.Cell;

import javax.swing.*;
import java.io.Serializable;

public abstract class Elem extends JButton implements Serializable
{
	protected Cell ownPlace;
	protected ImageIcon imageIcon;
		
	public Elem(Cell ownPlace) {
		this.ownPlace = ownPlace;
		setContentAreaFilled(false);
		setBorderPainted(false);
		setFocusPainted(false);
		setOpaque(false);
		setEnabled(false);
		addActionListener(e -> {
			System.out.println(getClass());
		});
	}
	public void update() {}
	public ImageIcon getImageIcon () {
		return this.imageIcon;
	}
}
