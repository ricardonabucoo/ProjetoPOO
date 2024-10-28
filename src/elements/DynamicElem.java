package elements;

import essentials.Cell;

public class DynamicElem extends Elem
{
	public DynamicElem(Cell ownPlace)
	{
		super(ownPlace);
	}
	protected void changePosition(Cell newPosition)
	{
		this.ownPlace = newPosition;
	}



}
