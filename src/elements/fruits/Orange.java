package elements.fruits;

import cells.Cell;
import status_effect.AntidoteEffect;

import javax.swing.*;

public class Orange extends Fruit {

    public Orange(Cell cell){
        super(cell);
        fruitType = FruitType.ORANGE;
        fruitEffect.addEffect(new AntidoteEffect());
        imageIcon = new ImageIcon("images/orange.png");
        setIcon(imageIcon);
    }

    @Override
    public Fruit clone() {
        return new Orange(cell);
    }
}
