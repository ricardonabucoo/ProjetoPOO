package essentials;

public final class Rock extends StaticElem {

	public static final int MP_REQUIRED_FOR_ROCK=2;
	
	
	public Rock(Cell ownPlace) {
		this.ownPlace = ownPlace;
	}
	
	@Override
	public int GetMPNeeded() {
		// TODO Auto-generated method stub
		return this.MP_REQUIRED_FOR_ROCK;
	}
	
	@Override
	public void OnEnter(Player player) {
		
		
		
		
	}
	
	
	public Cell GetExitDirection() {
		
		return null;
	}
	
	
	private void JumpTo(Cell exitDirection) {
		
		
		
	}
	
}