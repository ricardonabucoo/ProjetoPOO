package elements;

import essentials.Cell;
import java.util.ArrayList;
import java.util.List;

public class Bag {
    private static int capacity;
    private List<Fruit> fruitList;
    private int fruitsAmount;

    public Bag(int capacity){
        this.capacity = capacity;
        this.fruitList = new ArrayList<Fruit>();
        this.fruitsAmount = 0;
    }
    public void Add(Fruit fruit) {
        if(fruitsAmount >= capacity)
            System.out.println("mochila atingiu a capacidade maxima");
        else{
            fruitList.add(fruit);
            fruitsAmount++;
        }
    }

    public Fruit Take(FruitType fruitType) {
        for(Fruit fruit : fruitList) {
            if(fruit.GetFruitType() == fruitType) {
                fruitList.remove(fruit);
                return fruit;
            }
        }
        return null;
    }

    public int GetFruitsAmount() {
        return this.fruitsAmount;
    }

    public void ChangeBagPosition(Cell newPosition) {
        for(Fruit fruit : fruitList){
            fruit.SetOwnPlace(newPosition);
        }
    }
}

