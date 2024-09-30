package essentials;

public final class Tree extends StaticElem {

	public static final int MP_REQUIRED_FOR_TREE=1;
	public static final int ROUNDS_REQUIRED_FOR_FRUIT= 5;
	private int currentRoundCount;
	private Fruit producedFruit;
	
	
	@Override
	int GetMPNeeded() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	public void Update() {
		
		
		
	}
	
	
	public void OnStay() {
		
		
		
	}
	
	
	public void ProduceFruit () {
		
		
		
		
	}
	
	public void SetCurrentRoundCount(int crc) {
		
		this.currentRoundCount=crc;
		
	}
	
	public int getCurrentRoundCount() {
		
		return this.currentRoundCount;
		
	}
	
	public Fruit getProducedFruit() {
		
		return this.producedFruit;
		
	}
	
	
}
