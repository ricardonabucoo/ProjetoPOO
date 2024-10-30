package elements;

import elements.Fruits.Fruit;
import elements.Fruits.FruitType;
import essentials.Cell;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;

public class Bag implements Serializable {
    private static int capacity;
    private final ArrayList<Fruit> fruitList;
    private int passionFruitAmount;

    public Bag() {
        this.fruitList = new ArrayList<Fruit>();
        this.passionFruitAmount = 0;
    }

    public static void setCapacity(int capacity) {
        Bag.capacity = capacity;
    }

    public void add(Fruit fruit) {
        if(fruitList.size() == capacity)
            System.out.println("mochila atingiu a capacidade maxima");
        else {
            fruitList.add(fruit);
            if(FruitType.PASSIONFRUIT.isInstance(fruit))
            	passionFruitAmount++;
        }
    }

    public Fruit take(FruitType type) {
        for(Fruit fruit : fruitList) {
            if(type.isInstance(fruit)) {
                fruitList.remove(fruit);
                return fruit;
            }
        }
        return null;
    }

    public int getFruitsAmount() {
        return fruitList.size();
    }
    
    public int getPassionFruitAmount() {
    	return passionFruitAmount;
    }

    public void changeBagPosition(Cell newPosition) {
        for(Fruit fruit : fruitList) {
            fruit.setCell(newPosition);
        }
    }

    public void dropFruit(int dropFruitAmount) {

        int value = Math.min(dropFruitAmount, fruitList.size());

        for(int i = 0; i < value; i++) {
            Collections.shuffle(fruitList);
            Fruit fruit = fruitList.getFirst();
            fruit.drop();
        }
    }

    public boolean contains(FruitType fruitType) {
        for (Fruit fruit : fruitList) {
            if (fruitType.isInstance(fruit)) {
                return true;
            }
        }
        return false;
    }

    public boolean isFull() { return fruitList.size() == capacity; }
}

