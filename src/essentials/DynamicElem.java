package essentials;

import javax.swing.ImageIcon;

public class DynamicElem extends Elem {
	
	public DynamicElem(Cell ownPlace, ImageIcon icon){
		
		super(ownPlace,icon);
	}
	protected void ChangePosition(Cell newPosition) {
		this.ownPlace = newPosition;
	}
}
