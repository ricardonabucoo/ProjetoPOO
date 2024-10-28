package elements;

import essentials.Cell;
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

public class Bag {
    private static int capacity;
    private ArrayList<Fruit> fruitList;
    private int fruitsAmount;

    public Bag(int capacity) {
        this.capacity = capacity;
        this.fruitList = new ArrayList<Fruit>();
        this.fruitsAmount = 0;
    }

    public void add(Fruit fruit) {
        if(fruitsAmount >= capacity)
            System.out.println("mochila atingiu a capacidade maxima");
        else {
            fruitList.add(fruit);
            fruitsAmount++;
        }
    }

    public Fruit take(FruitType fruitType) {
        for(Fruit fruit : fruitList) {
            if(fruit.getFruitType() == fruitType) {
                fruitList.remove(fruit);
                return fruit;
            }
        }
        return null;
    }

    public int getFruitsAmount() {
        return this.fruitsAmount;
    }

    public void changeBagPosition(Cell newPosition) {
        for(Fruit fruit : fruitList) {
            fruit.setOwnPlace(newPosition);
        }
    }

    public void dropFruit(int dropFruitAmount) {

        int value = 0;
        if(dropFruitAmount <= fruitsAmount)
            value = dropFruitAmount;
        else
            value = fruitsAmount;

        for(int i = 0; i < value; i++) {
            Collections.shuffle(fruitList);
            Fruit fruit = fruitList.getFirst();
            fruit.drop();
            fruitsAmount--;
        }
    }

}

