package elements.fruits;

import cells.Cell;

import javax.swing.*;

public class Guava extends Fruit {

    public Guava(Cell cell) {
        super(cell);
        fruitType = FruitType.GUAVA;
        imageIcon = new ImageIcon("images/guava.png");
        setIcon(imageIcon);
    }

    @Override
    public Fruit clone() {
        return new Guava(cell);
    }

}
