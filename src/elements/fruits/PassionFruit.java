package elements.fruits;

import cells.Cell;

import javax.swing.*;

public class PassionFruit extends Fruit {

    public PassionFruit(Cell cell) {
        super(cell);
        fruitType = FruitType.PASSIONFRUIT;
        imageIcon = new ImageIcon("images/passion.png");
        setIcon(imageIcon);
    }
    public PassionFruit() {
        fruitType = FruitType.PASSIONFRUIT;
        imageIcon = new ImageIcon("images/passion.png");
        setIcon(imageIcon);
    }

    @Override
    public Fruit clone() {
        return new PassionFruit(cell);
    }
}
