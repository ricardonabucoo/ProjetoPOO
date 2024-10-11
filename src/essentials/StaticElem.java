package essentials;

import javax.swing.ImageIcon;

public abstract class StaticElem extends Elem {

	public StaticElem(Cell ownPlace, ImageIcon icon){
		super(ownPlace, icon);
	}
	
	public void OnEnter(Player player) {}
	public void OnStay(Player player) {}
	public void OnExit(Player player) {}

	abstract int GetMPNeeded();

}
