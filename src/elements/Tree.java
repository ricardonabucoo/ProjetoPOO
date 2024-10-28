package elements;

import essentials.Cell;

import java.awt.MediaTracker;

import javax.swing.ImageIcon;

public final class Tree extends StaticElem {

	public static final int MP_REQUIRED_FOR_TREE=1;
	public static final int ROUNDS_REQUIRED_FOR_FRUIT= 5;
	private int currentRoundCount;
	private FruitType producedFruit;
	private boolean hasfruit = false;
	public String currentImagePath;
	
	public Tree(Cell ownPlace, FruitType fruitType)
	{
		super(ownPlace);
		currentImagePath = "images/tree.png";
		ImageIcon icon = new ImageIcon(currentImagePath);
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
		currentRoundCount++;
	}
	
	@Override
	public void onStay(Player player) {
			if (player.getOwnPlace() == this.ownPlace) {
				if (currentRoundCount >= ROUNDS_REQUIRED_FOR_FRUIT) {
					produceFruit(player);
				}
			}
	}
	
	public void produceFruit(Player player) {
		if (!hasfruit) {
			currentRoundCount = 0;
			hasfruit = true;
			Fruit fruit = new Fruit(ownPlace, producedFruit);
			player.addFruitBag(fruit);
			collectFruit();
		}
	}


	public void collectFruit() {
		if (hasfruit) {
			hasfruit = false;
		}
	}


	public boolean hasfruit() {
		return hasfruit;
	}

	public FruitType getProducedFruit() { return this.producedFruit; }

	public String getCurrentImagePath () {
		return this.currentImagePath;
	}

}
