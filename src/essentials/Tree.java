package essentials;

import java.awt.MediaTracker;

import javax.swing.ImageIcon;

public final class Tree extends StaticElem {

	public static final int MP_REQUIRED_FOR_TREE=1;
	public static final int ROUNDS_REQUIRED_FOR_FRUIT= 5;
	private int currentRoundCount;
	private final Fruit producedFruit;
	
	public Tree(Cell ownPlace, FruitType fruitType) {
		super(ownPlace, null);
		ImageIcon icon = new ImageIcon(getClass().getResource("arvore.png"));
		this.setIcon(icon);
	    if (icon.getImageLoadStatus() == MediaTracker.COMPLETE) {
	        System.out.println("Imagem carregada com sucesso.");
	    } else {
	        System.out.println("Erro ao carregar a imagem.");
	    }
		this.producedFruit = fruitType;
		currentRoundCount = 0;
	}
	
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
