package elements;

import essentials.Cell;

import java.awt.MediaTracker;

import javax.swing.ImageIcon;

public final class Tree extends StaticElem {

	public static final int MP_REQUIRED_FOR_TREE=1;
	public static final int ROUNDS_REQUIRED_FOR_FRUIT= 5;
	private int currentRoundCount;
	private FruitType producedFruit;
	
	public Tree(Cell ownPlace, FruitType fruitType) {
		super(ownPlace, null);
		ImageIcon icon = new ImageIcon("images/arvore.png");
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
	public int GetMPNeeded() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	@Override
	public void Update() {
		
		
		
	}
	
	@Override
	public void OnStay(Player player) {
		
		
		
	}
	
	public void ProduceFruit() {
		
		
	
	}
	
	public void SetCurrentRoundCount(int crc) {
		
		this.currentRoundCount = 	crc;
		
	}
	
	public int getCurrentRoundCount() {
		
		return this.currentRoundCount;
		
	}
	
	public FruitType getProducedFruit() {
		
		return this.producedFruit;
		
	}
	
	
}
