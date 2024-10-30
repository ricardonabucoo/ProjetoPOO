package cells.trees;

import elements.fruits.Fruit;
import elements.fruits.FruitType;
import elements.Player;
import cells.Cell;

import javax.swing.ImageIcon;

public abstract class Tree extends Cell {

	public static final int MP_REQUIRED_FOR_TREE=1;
	public static final int ROUNDS_REQUIRED_FOR_FRUIT= 5;
	private int currentRoundCount;
	private final ImageIcon stage0;
	protected Fruit producedFruit;
	protected ImageIcon stage1;
	protected ImageIcon stage2;
	protected ImageIcon stage3;

	public Tree(int row, int col)
	{
		super(row, col);
		imageIcon = new ImageIcon("images/tree.png");
		stage0 = imageIcon;
		setIcon(imageIcon);
		currentRoundCount = 0;
	}

	private void updateImageTree(){
		switch (currentRoundCount){
			case 0: imageIcon = stage0;
			break;
			case 1, 2: imageIcon = stage1;
			break;
            case 3, 4: imageIcon = stage2;
			break;
            default: imageIcon = stage3;
		}
		revalidate();
		repaint();
	}

	@Override
	public int getMPNeeded() {
		return 0;
	}
	
	@Override
	public void updateCell() {
		currentRoundCount++;
		updateImageTree();
	}
	
	@Override
	public void onStay(Player player) {
		if (currentRoundCount >= ROUNDS_REQUIRED_FOR_FRUIT && !player.isBagFull()) {
			currentRoundCount = 0;
			Fruit fruit = producedFruit.clone();
			player.addFruitBag(fruit);
		}
	}

	public FruitType getProducedFruitType() { return producedFruit.getType(); }



}
