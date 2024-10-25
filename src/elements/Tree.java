package elements;

import essentials.Cell;

import java.awt.MediaTracker;

import javax.swing.ImageIcon;

public final class Tree extends StaticElem {

	public static final int MP_REQUIRED_FOR_TREE=1;
	public static final int ROUNDS_REQUIRED_FOR_FRUIT= 5;
	private int currentRoundCount;
	private FruitType producedFruit;
	
	public Tree(Cell ownPlace, FruitType fruitType)
	{
		super(ownPlace);
		ImageIcon icon = new ImageIcon("images/tree.png");
		this.setIcon(icon);
		this.producedFruit = fruitType;
		currentRoundCount = 0;

	    if (icon.getImageLoadStatus() == MediaTracker.COMPLETE)
	        System.out.println("Imagem carregada com sucesso (Arvore).");
	    else
	        System.out.println("Erro ao carregar a imagem.");
	}
	
	@Override
	public int getMPNeeded() {
		return 0;
	}
	
	@Override
	public void update() {

	}
	
	@Override
	public void onStay(Player player) {

	}
	
	public void produceFruit() {

	}

	public FruitType getProducedFruit() { return this.producedFruit; }

}
