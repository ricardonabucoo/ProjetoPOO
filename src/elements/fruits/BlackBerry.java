package elements.fruits;

import cells.Cell;

import javax.swing.*;

public class BlackBerry extends Fruit{

    public BlackBerry(Cell cell) {
        super(cell);
        fruitType = FruitType.BLACKBERRY;
        imageIcon = new ImageIcon("images/blackberry.png");
        setIcon(imageIcon);
    }

    @Override
    public Fruit clone() {
        return new BlackBerry(cell);
    }
}
