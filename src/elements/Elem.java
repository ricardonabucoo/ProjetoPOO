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
		addActionListener(e -> {
			System.out.println(ownPlace.getRow() + " " + ownPlace.getCol());
		});
	}
	public void update() {}
	public ImageIcon getImageIcon () {
		return this.imageIcon;
	}
}
