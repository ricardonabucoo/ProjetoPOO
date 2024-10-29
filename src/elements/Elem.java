package elements;

import essentials.Cell;

import javax.swing.*;
import java.io.Serializable;

public abstract class Elem extends JButton implements Serializable
{
	protected Cell ownPlace;
		
	public Elem(Cell ownPlace) {
		this.ownPlace = ownPlace;
	}
	public void update() {}
}
