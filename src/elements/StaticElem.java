package elements;

import cells.Cell;

public abstract class StaticElem extends Elem
{
	public StaticElem(Cell ownPlace)
	{
		super(ownPlace);
	}
	
	public void onEnter(Player player) {}
	public void onStay(Player player) {}
	public void onExit(Player player) {}

	public abstract int getMPNeeded();

}
