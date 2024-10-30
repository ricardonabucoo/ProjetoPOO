package testes;

import UI.Frames.MainFrame;
import elements.Fruits.Fruit;
import elements.Fruits.FruitType;
import elements.Grass;
import essentials.Cell;

import javax.swing.*;

public class CellClick {



    public static void main(String[] args) {
        MainFrame mainFrame = MainFrame.getInstance();

        JPanel panel = new JPanel();
        Cell cell = new Cell(0,0);
        panel.add(cell);
        Grass grass = new Grass(cell);
        cell.setStaticElem(grass);

        Fruit fruit = new Fruit(cell, FruitType.AVOCADO);
        //cell.setDynamicElem(fruit);

        mainFrame.setCurrentPanel(panel);
    }
}
