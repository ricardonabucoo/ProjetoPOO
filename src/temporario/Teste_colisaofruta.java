package temporario;

import builders.MapBuilder;
import elements.Fruit;
import elements.FruitType;
import essentials.Map;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;

public class Teste_colisaofruta {

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setBounds(50, 50, 1000, 1000);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setVisible(true);

        JPanel mapViewer = new JPanel(new GridBagLayout());
        mapViewer.setBackground(Color.darkGray);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.weightx = 0;
        gbc.weighty = 0;

        MapBuilder builder = new MapBuilder();

        HashMap<FruitType, Integer> treeMap = new HashMap<FruitType, Integer>();
        treeMap.put(FruitType.AVOCADO,1);
        treeMap.put(FruitType.COCONUT,2);
        treeMap.put(FruitType.ORANGE,3);

        HashMap<FruitType, Integer> fruitMap = new HashMap<FruitType, Integer>();
        fruitMap.put(FruitType.AVOCADO,1);
        //fruitMap.put(FruitType.COCONUT,1);
        //fruitMap.put(FruitType.ORANGE,2);

        builder.buildMap(5,5,treeMap,fruitMap);
        Fruit fruita = (Fruit) builder.getFruitCellList().get(0).getDynamicElem();
        Map map = builder.getResult();

        mapViewer.add(map, gbc);
        mapViewer.revalidate();;
        mapViewer.repaint();


        JButton button = new JButton("simular colisao");
        button.addActionListener(e -> {
           fruita.drop();
        });
        mapViewer.add(button);

        frame.add(mapViewer);

        mapViewer.revalidate();;
        mapViewer.repaint();
    }
}
