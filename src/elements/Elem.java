package elements;

import essentials.Cell;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public abstract class Elem extends JButton{
	protected Cell ownPlace;
		
	public Elem(Cell ownPlace, ImageIcon icon){
		this.ownPlace = ownPlace;
		this.setIcon(icon);
	}
	
	public void Update() {}
}
