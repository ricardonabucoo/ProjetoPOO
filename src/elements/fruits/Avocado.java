package elements.fruits;

import cells.Cell;
import status_effect.PowerEffect;

import javax.swing.*;

public class Avocado extends Fruit{

    public Avocado(Cell cell) {
        super(cell);
        fruitType = FruitType.AVOCADO;
        fruitEffect.addEffect(new PowerEffect());
        imageIcon = new ImageIcon("images/Avocado.png");
        setIcon(imageIcon);
    }
    public Avocado() {
        fruitType = FruitType.AVOCADO;
        fruitEffect.addEffect(new PowerEffect());
        imageIcon = new ImageIcon("images/Avocado.png");
        setIcon(imageIcon);
    }

    @Override
    public Fruit clone() {
        return new Avocado(cell);
    }
}
