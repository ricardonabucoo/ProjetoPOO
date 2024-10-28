package elements;

import essentials.Cell;

import javax.swing.*;

public abstract class Elem extends JButton
{
	protected Cell ownPlace;
		
	public Elem(Cell ownPlace) {
		this.ownPlace = ownPlace;
	}
	public void update() {}
}
