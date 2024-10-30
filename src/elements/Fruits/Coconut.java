package elements.Fruits;

import essentials.Cell;
import status_effect.MovimentEffect;

import javax.swing.*;

public class Coconut extends Fruit{

    public Coconut (Cell cell) {
        super(cell);
        fruitType = FruitType.COCONUT;
        fruitEffect.addEffect(new MovimentEffect());
        imageIcon = new ImageIcon("images/coconut.png");
        setIcon(imageIcon);
    }

    @Override
    public Fruit clone() {
        return new Coconut(cell);
    }
}
