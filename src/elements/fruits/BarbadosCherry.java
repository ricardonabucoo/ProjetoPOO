package elements.fruits;

import cells.Cell;

import javax.swing.*;

public class BarbadosCherry extends Fruit{

    public BarbadosCherry(Cell cell) {
        super(cell);
        fruitType = FruitType.BARBADOSCHERRY;
        imageIcon = new ImageIcon("images/barbadosCherry.png");
        setIcon(imageIcon);
    }

    @Override
    public Fruit clone() {
        return new BarbadosCherry(cell);
    }
}
