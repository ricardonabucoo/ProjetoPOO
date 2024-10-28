package temporario;

import UI.Frames.MainFrame;
import builders.MapBuilder;
import elements.Fruit;
import elements.FruitType;
import essentials.Map;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;

public class Teste_colisaofruta {

    public static void main(String[] args) {
        MainFrame mainFrame = MainFrame.getInstance();

        JPanel mapViewer = new JPanel(new BorderLayout());
        mapViewer.setBackground(Color.darkGray);

        MapBuilder builder = new MapBuilder();

        HashMap<FruitType, Integer> treeMap = new HashMap<FruitType, Integer>();
        treeMap.put(FruitType.AVOCADO,1);
        treeMap.put(FruitType.COCONUT,2);
        treeMap.put(FruitType.ORANGE,3);

        HashMap<FruitType, Integer> fruitMap = new HashMap<FruitType, Integer>();
        fruitMap.put(FruitType.AVOCADO,1);
        //fruitMap.put(FruitType.COCONUT,1);
        //fruitMap.put(FruitType.ORANGE,2);

        builder.buildMap(5,5,treeMap,fruitMap,5,"sla","sla",5);
        Fruit fruita = (Fruit) builder.getFruitCellList().get(0).getDynamicElem();
        Map map = builder.getResult();
        mapViewer.add(map, BorderLayout.CENTER);

        JPanel panel = new JPanel();
        panel.setBackground(Color.lightGray);
        panel.setPreferredSize(new Dimension(300,500));
        mapViewer.add(panel, BorderLayout.EAST);
        JPanel panel2 = map.getCellInfoPanel();
        panel2.setBackground(Color.lightGray);
        panel2.setPreferredSize(new Dimension(300,500));
        mapViewer.add(panel2, BorderLayout.WEST);

        mapViewer.revalidate();;
        mapViewer.repaint();

        mainFrame.setCurrentPanel(mapViewer);


        JButton button = new JButton("simular colisao");
        button.addActionListener(e -> {
           fruita.drop();
        });
       // mapViewer.add(button);


        mapViewer.revalidate();;
        mapViewer.repaint();
    }
}
