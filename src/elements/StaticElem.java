package elements;

import essentials.Cell;

import javax.swing.ImageIcon;

public abstract class StaticElem extends Elem {

	public StaticElem(Cell ownPlace, ImageIcon icon){
		super(ownPlace, icon);
	}
	
	public void OnEnter(Player player) {}
	public void OnStay(Player player) {}
	public void OnExit(Player player) {}

	public abstract int GetMPNeeded();

}
