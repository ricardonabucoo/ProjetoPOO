package UI.Panels;

import elements.Fruit;
import elements.FruitType;
import elements.Grass;
import elements.Rock;
import essentials.Map;
import essentials.MapBuilder;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.util.HashMap;

import static essentials.Map.grid;

public class CreateWorldOptionsPanel extends JPanel {
    private MapBuilder mapBuilder;
    private HashMap<String,InputField> inputFields;
    private Map map;
    private JPanel leftPanel;
    private JPanel rightPanel;

    public CreateWorldOptionsPanel() {
        setLayout(new BorderLayout());
        setBackground(Color.decode("#008b8b"));


        leftPanel = createSetConfigsPanel();
        rightPanel = new JPanel(new GridBagLayout());
        rightPanel.setBackground(Color.darkGray);
        map = new Map();
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.weightx = 0;
        gbc.weighty = 0;
        rightPanel.add(map, gbc);

        JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, leftPanel, rightPanel);
        splitPane.setResizeWeight(0.3);
        splitPane.setOneTouchExpandable(true); // Adiciona setinhas para o usuário ajustar o tamanho manualmente
        splitPane.setDividerLocation(300); // Posição inicial do divisor (pode ajustar conforme necessário)

        // Adiciona o JSplitPane ao layout do painel
        add(splitPane, BorderLayout.CENTER);
    }

    private JPanel createSetConfigsPanel(){
        inputFields = new HashMap<>();

        JPanel configPanel = new JPanel();
        configPanel.setLayout(new BoxLayout(configPanel, BoxLayout.Y_AXIS));
        configPanel.setBackground(Color.decode("#f0f0f0"));
        configPanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.BLACK), "Configurações Avançadas", TitledBorder.CENTER, TitledBorder.TOP));

        //dados gerais
        configPanel.add(createGeneralDataPanel());
        //arvores frutiferas
        configPanel.add(createTreesTypePanel());
        //frutas iniciais
        configPanel.add(createInitalFruitsPanel());
        //nomes dos jogadores
        configPanel.add(createPlayerNamesPanel());
        //botoes de submit e suffle
        configPanel.add(createButtonsPanel());

        return configPanel;
    }

    private JPanel createGeneralDataPanel(){
        JPanel generalDataPanel = new JPanel();
        generalDataPanel.setLayout(new GridLayout(0,1));
        generalDataPanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.BLACK), "Dados Gerais", TitledBorder.CENTER, TitledBorder.TOP));

        addNewInputFieldToHashMap(generalDataPanel,"Size","Tamanho:");
        addNewInputFieldToHashMap(generalDataPanel,"Rocks_amount","Pedras:");
        addNewInputFieldToHashMap(generalDataPanel,"PassionFruit_amount","Maracujás:");
        addNewInputFieldToHashMap(generalDataPanel,"BagCapacity","<html>Capacidade <br>da mochila</html>:");
        addNewInputFieldToHashMap(generalDataPanel,"WormyChance","<html>Chance de <br>fruta bichada:</html>:");

        return generalDataPanel;
    }

    private JPanel createTreesTypePanel(){
        JPanel treesTypePanel = new JPanel();
        treesTypePanel.setLayout(new GridLayout(0,1));
        treesTypePanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.BLACK), "Árvore", TitledBorder.CENTER, TitledBorder.TOP));


        addNewInputFieldToHashMap(treesTypePanel,"Guava_tree","Goiaba:");
        addNewInputFieldToHashMap(treesTypePanel,"BarbadosCherry_tree","Acerola:");
        addNewInputFieldToHashMap(treesTypePanel,"BlackBerry_tree","Amora:");
        addNewInputFieldToHashMap(treesTypePanel,"Orange_tree","Laranja:");
        addNewInputFieldToHashMap(treesTypePanel,"Avocado_tree","Abacate:");
        addNewInputFieldToHashMap(treesTypePanel,"Coconut_tree","Côco:");

        return treesTypePanel;
    }

    private JPanel createInitalFruitsPanel(){
        JPanel initalFruitsPanel = new JPanel();
        initalFruitsPanel.setLayout(new GridLayout(0,1));
        initalFruitsPanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.BLACK), "Frutas Iniciais", TitledBorder.CENTER, TitledBorder.TOP));

        addNewInputFieldToHashMap(initalFruitsPanel,"Guava_fruit","Goiabas:");
        addNewInputFieldToHashMap(initalFruitsPanel,"BarbadosCherry_fruit","Acerolas:");
        addNewInputFieldToHashMap(initalFruitsPanel,"BlackBerry_fruit","Amoras:");
        addNewInputFieldToHashMap(initalFruitsPanel,"Orange_fruit","Laranjas:");
        addNewInputFieldToHashMap(initalFruitsPanel,"Coconut_fruit","Côcos:");
        addNewInputFieldToHashMap(initalFruitsPanel,"Avocado_fruit","Abacate:");
        addNewInputFieldToHashMap(initalFruitsPanel,"PassionFruit_fruit","Maracujás:");

        return initalFruitsPanel;
    }

    private JPanel createPlayerNamesPanel(){
        JPanel playerNamesPanel = new JPanel();
        playerNamesPanel.setLayout(new GridLayout(2,1));
        playerNamesPanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.BLACK), "Nomes dos Jogadores", TitledBorder.CENTER, TitledBorder.TOP));

        addNewInputFieldToHashMap(playerNamesPanel,"Player1","<html>Apelido do<br> jogador 1:  </html>",20);
        addNewInputFieldToHashMap(playerNamesPanel,"Player2","<html>Apelido do<br> jogador 2:  </html>",20);

        return playerNamesPanel;
    }

    private JPanel createButtonsPanel(){
        JPanel buttonsPanel = new JPanel();
        buttonsPanel.setLayout(new GridLayout(0,2));

        JButton submitButton = new JButton("Submit");
        submitButton.addActionListener(e -> {
            mapBuilder = new MapBuilder(map);

            mapBuilder.buildCellGrid(inputFields.get("Size").getInputAsInt());
            mapBuilder.buildRockCells(inputFields.get("Rocks_amount").getInputAsInt());
            mapBuilder.buildTreeCells(createTreesTypesHashMap());
            mapBuilder.buildGrassCells();
            mapBuilder.buildFruitsCells(createInitialFruitHashMap());

            rightPanel.remove(map);
            map = mapBuilder.getResult();
            GridBagConstraints gbc = new GridBagConstraints();
            gbc.gridx = 0;
            gbc.gridy = 0;
            gbc.anchor = GridBagConstraints.CENTER;
            gbc.weightx = 0;
            gbc.weighty = 0;
            rightPanel.add(map, gbc);
            rightPanel.revalidate();
            rightPanel.repaint();
        });

        JButton shuffleButton = new JButton("Shuffle");
        shuffleButton.addActionListener(e -> {
            mapBuilder.reset();
            mapBuilder.buildCellGrid(inputFields.get("Size").getInputAsInt());
            mapBuilder.buildRockCells(inputFields.get("Rocks_amount").getInputAsInt());
            mapBuilder.buildTreeCells(createTreesTypesHashMap());
            mapBuilder.buildGrassCells();
            mapBuilder.buildFruitsCells(createInitialFruitHashMap());
        });
        buttonsPanel.add(submitButton);
        buttonsPanel.add(shuffleButton);

        return buttonsPanel;
    }

    private void addNewInputFieldToHashMap(JPanel panel, String key, String text){
        InputField inputField = new InputField(new JLabel(text));
        panel.add(inputField);
        inputFields.put(key,inputField);
    }

    private void addNewInputFieldToHashMap(JPanel panel, String key, String text, int size){
        InputField inputField = new InputField(new JLabel(text),size);
        panel.add(inputField);
        inputFields.put(key,inputField);
    }

    private HashMap<FruitType,Integer> createTreesTypesHashMap(){
        HashMap<FruitType,Integer> trees = new HashMap<>();
        trees.put(FruitType.GUAVA, inputFields.get("Guava_tree").getInputAsInt());
        trees.put(FruitType.BARBADOSCHERRY, inputFields.get("BarbadosCherry_tree").getInputAsInt());
        trees.put(FruitType.BLACKBERRY, inputFields.get("BlackBerry_tree").getInputAsInt());
        trees.put(FruitType.ORANGE, inputFields.get("Orange_tree").getInputAsInt());
        trees.put(FruitType.AVOCADO, inputFields.get("Avocado_tree").getInputAsInt());
        trees.put(FruitType.COCONUT, inputFields.get("Coconut_tree").getInputAsInt());

        return trees;
    }

    private HashMap<FruitType,Integer> createInitialFruitHashMap(){
        HashMap<FruitType,Integer> fruits = new HashMap<>();
        fruits.put(FruitType.PASSIONFRUIT, inputFields.get("PassionFruit_fruit").getInputAsInt());
        fruits.put(FruitType.GUAVA, inputFields.get("Guava_fruit").getInputAsInt());
        fruits.put(FruitType.BARBADOSCHERRY, inputFields.get("BarbadosCherry_fruit").getInputAsInt());
        fruits.put(FruitType.BLACKBERRY, inputFields.get("BlackBerry_fruit").getInputAsInt());
        fruits.put(FruitType.ORANGE, inputFields.get("Orange_fruit").getInputAsInt());
        fruits.put(FruitType.AVOCADO, inputFields.get("Avocado_fruit").getInputAsInt());
        fruits.put(FruitType.COCONUT, inputFields.get("Coconut_fruit").getInputAsInt());

        return fruits;
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setBounds(50, 50, 1000, 1000);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        CreateWorldOptionsPanel panel = new CreateWorldOptionsPanel();
        frame.add(panel);
        frame.setVisible(true);
    }


}
