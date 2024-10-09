package essentials;

public final class Grass extends StaticElem {
	
	public static final int MP_REQUIRED_FOR_GRASS=1;

	
	public Grass(Cell ownPlace) {
		this.ownPlace = ownPlace;
	}
	
	@Override
	int GetMPNeeded() {
		// TODO Auto-generated method stub
		return this.MP_REQUIRED_FOR_GRASS;
	}
	
	

}
