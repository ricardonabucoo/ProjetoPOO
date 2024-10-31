package UI.Panels;

import UI.Frames.MainFrame;
import elements.fruits.FruitType;
import essentials.Map;
import essentials.MapReader;


import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.io.*;
import java.util.HashMap;

public class CreateMapPanel extends JPanel implements Serializable{
    private HashMap<String,InputField> inputFields;
    private Map map;
    private MapReader mapReader;
    private final JPanel leftPanel;
    private final JPanel rightPanel;
    int size;
    int rocksAmount;
    HashMap<FruitType, Integer> treeMap;
    HashMap<FruitType, Integer> fruitMap;
    int passionFruitAmount;
    int bagCapacity;
    int fruitAmount;
    int treesAmount;
    int wormyChance;


    public CreateMapPanel() {
        setLayout(new BorderLayout());
        setBackground(Color.decode("#008b8b"));

        leftPanel = createSetConfigsPanel();
        rightPanel = createMapViewerPanel();

        JSplitPane splitPane = new JSplitPane(
                JSplitPane.HORIZONTAL_SPLIT,
                leftPanel,
                rightPanel
        );
        splitPane.setResizeWeight(0.3);
        splitPane.setDividerLocation(300);
        add(splitPane, BorderLayout.CENTER);
    }

    public CreateMapPanel(MapReader mapReader) {
        this.mapReader = mapReader;
        setLayout(new BorderLayout());
        setBackground(Color.decode("#008b8b"));

        leftPanel = createSetConfigsLoadedPanel();
        rightPanel = createMapViewerPanel();

        JSplitPane splitPane = new JSplitPane(
                JSplitPane.HORIZONTAL_SPLIT,
                leftPanel,
                rightPanel
        );
        splitPane.setResizeWeight(0.3);
        splitPane.setDividerLocation(300);
        add(splitPane, BorderLayout.CENTER);
    }

    private JPanel createMapViewerPanel(Map map){
        JPanel mapViewer = new JPanel(new GridBagLayout());
        mapViewer.setBackground(Color.darkGray);
        this.map = map;
        return getjPanel(map, mapViewer);
    }

    private JPanel createMapViewerPanel(){
        JPanel mapViewer = new JPanel(new GridBagLayout());
        mapViewer.setBackground(Color.darkGray);
        map = createDefaultMap();
        return getjPanel(map, mapViewer);
    }

    private JPanel getjPanel(Map map, JPanel mapViewer) {
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.weightx = 0;
        gbc.weighty = 0;
        mapViewer.add(map, gbc);
        return mapViewer;
    }


    private Map createDefaultMap(){
        HashMap<FruitType,Integer> treeMap = new HashMap<FruitType,Integer>();
        treeMap.put(FruitType.COCONUT,1);
        HashMap<FruitType,Integer> fruitMap = new HashMap<FruitType,Integer>();
        fruitMap.put(FruitType.BLACKBERRY,1);
        return new Map(3,1,treeMap,fruitMap,5,5,0);
    }

    private JPanel createSetConfigsPanel(){
        inputFields = new HashMap<>();

        JPanel configPanel = new JPanel();
        configPanel.setLayout(new BoxLayout(configPanel, BoxLayout.Y_AXIS));
        configPanel.setBackground(Color.decode("#f0f0f0"));
        configPanel.setBorder(
                BorderFactory.createTitledBorder(
                        BorderFactory.createLineBorder(Color.BLACK),
                        "Configurações Avançadas",
                        TitledBorder.CENTER,
                        TitledBorder.TOP
                )
        );

        //dados gerais
        configPanel.add(createGeneralDataPanel());
        //arvores frutiferas
        configPanel.add(createTreesTypePanel());
        //frutas iniciais
        configPanel.add(createInitalFruitsPanel());
        //botoes de submit e suffle
        configPanel.add(createButtonsPanel());

        return configPanel;
    }

    private JPanel createSetConfigsLoadedPanel(){
        inputFields = new HashMap<>();

        JPanel configPanel = new JPanel();
        configPanel.setLayout(new BoxLayout(configPanel, BoxLayout.Y_AXIS));
        configPanel.setBackground(Color.decode("#f0f0f0"));
        configPanel.setBorder(
                BorderFactory.createTitledBorder(
                        BorderFactory.createLineBorder(Color.BLACK),
                        "Configurações Avançadas",
                        TitledBorder.CENTER,
                        TitledBorder.TOP
                )
        );

        //dados gerais
        configPanel.add(createGeneralDataLoadedPanel());
        //arvores frutiferas
        configPanel.add(createTreesTypeLoadedPanel());
        //frutas iniciais
        configPanel.add(createInitalFruitsLoadedPanel());
        //botoes de submit e suffle
        configPanel.add(createButtonsLoadedPanel());

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

    private JPanel createGeneralDataLoadedPanel(){
        JPanel generalDataPanel = new JPanel();
        generalDataPanel.setLayout(new GridLayout(0,1));
        generalDataPanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.BLACK), "Dados Gerais", TitledBorder.CENTER, TitledBorder.TOP));

        addNewInputFieldToHashMap(generalDataPanel,"Size","Tamanho:",mapReader.getSize()+"");
        addNewInputFieldToHashMap(generalDataPanel,"Rocks_amount","Pedras:", mapReader.getRocksAmount()+"");
        addNewInputFieldToHashMap(generalDataPanel,"PassionFruit_amount","Maracujás:", mapReader.getMaxPassionFruitAmount()+"");
        addNewInputFieldToHashMap(generalDataPanel,"BagCapacity","<html>Capacidade <br>da mochila</html>:",mapReader.getBagCapacity()+"");
        addNewInputFieldToHashMap(generalDataPanel,"WormyChance","<html>Chance de <br>fruta bichada:</html>:",mapReader.getWormyFruitChance()+"");

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

    private JPanel createTreesTypeLoadedPanel(){
        JPanel treesTypePanel = new JPanel();
        treesTypePanel.setLayout(new GridLayout(0,1));
        treesTypePanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.BLACK), "Árvore", TitledBorder.CENTER, TitledBorder.TOP));

        addNewInputFieldToHashMap(treesTypePanel,"Guava_tree","Goiaba:",mapReader.getNumberOfTrees().get(FruitType.GUAVA)+"");
        addNewInputFieldToHashMap(treesTypePanel,"BarbadosCherry_tree","Acerola:",mapReader.getNumberOfTrees().get(FruitType.BARBADOSCHERRY)+"");
        addNewInputFieldToHashMap(treesTypePanel,"BlackBerry_tree","Amora:",mapReader.getNumberOfTrees().get(FruitType.BLACKBERRY)+"");
        addNewInputFieldToHashMap(treesTypePanel,"Orange_tree","Laranja:",mapReader.getNumberOfTrees().get(FruitType.ORANGE)+"");
        addNewInputFieldToHashMap(treesTypePanel,"Avocado_tree","Abacate:",mapReader.getNumberOfTrees().get(FruitType.AVOCADO)+"");
        addNewInputFieldToHashMap(treesTypePanel,"Coconut_tree","Côco:",mapReader.getNumberOfTrees().get(FruitType.COCONUT)+"");

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

    private JPanel createInitalFruitsLoadedPanel(){
        JPanel initalFruitsPanel = new JPanel();
        initalFruitsPanel.setLayout(new GridLayout(0,1));
        initalFruitsPanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.BLACK), "Frutas Iniciais", TitledBorder.CENTER, TitledBorder.TOP));

        addNewInputFieldToHashMap(initalFruitsPanel,"Guava_fruit","Goiabas:",mapReader.getInitialFruitsNumber().get(FruitType.GUAVA)+"");
        addNewInputFieldToHashMap(initalFruitsPanel,"BarbadosCherry_fruit","Acerolas:",mapReader.getInitialFruitsNumber().get(FruitType.BARBADOSCHERRY)+"");
        addNewInputFieldToHashMap(initalFruitsPanel,"BlackBerry_fruit","Amoras:",mapReader.getInitialFruitsNumber().get(FruitType.BLACKBERRY)+"");
        addNewInputFieldToHashMap(initalFruitsPanel,"Orange_fruit","Laranjas:",mapReader.getInitialFruitsNumber().get(FruitType.ORANGE)+"");
        addNewInputFieldToHashMap(initalFruitsPanel,"Coconut_fruit","Côcos:",mapReader.getInitialFruitsNumber().get(FruitType.COCONUT)+"");
        addNewInputFieldToHashMap(initalFruitsPanel,"Avocado_fruit","Abacate:",mapReader.getInitialFruitsNumber().get(FruitType.AVOCADO)+"");
        addNewInputFieldToHashMap(initalFruitsPanel,"PassionFruit_fruit","Maracujás:",mapReader.getInitialFruitsNumber().get(FruitType.PASSIONFRUIT)+"");

        return initalFruitsPanel;
    }

    private JPanel createButtonsPanel(){
        JPanel buttonsPanel = new JPanel();
        buttonsPanel.setLayout(new GridLayout(1,3));
        GridBagConstraints gbc = new GridBagConstraints();

        JButton nextButton = new JButton("<html>Criar <br>Partida</html>");
        nextButton.setEnabled(false);
        nextButton.addActionListener(e -> {
            MainFrame mainFrame = MainFrame.getInstance();
            mainFrame.setCurrentPanel(new CreateMatchPanel(map));
        });

        JButton submitButton = new JButton("Gerar");
        submitButton.setEnabled(false);
        submitButton.addActionListener(e -> {

            rightPanel.remove(map);
            map = new Map(size, rocksAmount, treeMap, fruitMap, passionFruitAmount, bagCapacity, wormyChance);
            GridBagConstraints gbcMap = new GridBagConstraints();
            gbcMap.gridx = 0;
            gbcMap.gridy = 1;
            gbcMap.anchor = GridBagConstraints.CENTER;
            gbcMap.weightx = 0;
            gbcMap.weighty = 0;
            rightPanel.add(map, gbc);
            rightPanel.revalidate();
            rightPanel.repaint();
            nextButton.setEnabled(true);
        });

        JButton validateButton = new JButton("Validar");
        validateButton.addActionListener(e -> {
            size = inputFields.get("Size").getInputAsInt();
            rocksAmount = inputFields.get("Rocks_amount").getInputAsInt();
            treeMap = createTreesTypesHashMap();
            fruitMap = createInitialFruitHashMap();
            passionFruitAmount = inputFields.get("PassionFruit_amount").getInputAsInt();
            bagCapacity = inputFields.get("BagCapacity").getInputAsInt();
            treesAmount = treeMap.values().stream().mapToInt(Integer::intValue).sum();
            fruitAmount = fruitMap.values().stream().mapToInt(Integer::intValue).sum();
            wormyChance = inputFields.get("WormyChance").getInputAsInt();
            if(size>=3 && passionFruitAmount > 0 && bagCapacity > 0 && bagCapacity >= (passionFruitAmount/2+1) && treesAmount > 0 && size*size >= fruitAmount+treesAmount+rocksAmount+rocksAmount+2)
            {
                submitButton.setEnabled(true);
            }
            else{
                submitButton.setEnabled(false);
                nextButton.setEnabled(false);
            }

        });


        gbc.gridx=0;
        gbc.gridy = 0;
        gbc.gridwidth = 3;
        gbc.anchor = GridBagConstraints.CENTER;
        buttonsPanel.add(validateButton, gbc);


        gbc.gridy = 1;
        gbc.gridwidth = 1;
        buttonsPanel.add(submitButton, gbc);
        //gbc.gridx = 1;
        //buttonsPanel.add(shuffleButton, gbc);
        gbc.gridx = 2;
        buttonsPanel.add(nextButton, gbc);

        return buttonsPanel;
    }

    private JPanel createButtonsLoadedPanel(){
        JPanel buttonsPanel = createButtonsPanel();

        size = inputFields.get("Size").getInputAsInt();
        rocksAmount = inputFields.get("Rocks_amount").getInputAsInt();
        treeMap = createTreesTypesHashMap();
        fruitMap = createInitialFruitHashMap();
        passionFruitAmount = inputFields.get("PassionFruit_amount").getInputAsInt();
        bagCapacity = inputFields.get("BagCapacity").getInputAsInt();
        treesAmount = treeMap.values().stream().mapToInt(Integer::intValue).sum();
        fruitAmount = fruitMap.values().stream().mapToInt(Integer::intValue).sum();
        wormyChance = inputFields.get("WormyChance").getInputAsInt();
        if(size>=3 && passionFruitAmount > 0 && bagCapacity > 0 && bagCapacity >= (passionFruitAmount/2+1) && treesAmount > 0 && size*size >= fruitAmount+treesAmount+rocksAmount+rocksAmount+2)
        {
            buttonsPanel.getComponent(0).setEnabled(true);
        }
        return buttonsPanel;
    }

    private void addNewInputFieldToHashMap(JPanel panel, String key, String text){
        InputField inputField = new InputField(new JLabel(text));
        panel.add(inputField);
        inputFields.put(key,inputField);
    }

    private void addNewInputFieldToHashMap(JPanel panel, String key, String text, String initialValue){
        InputField inputField = new InputField(new JLabel(text),initialValue);
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
        MainFrame mainFrame = MainFrame.getInstance();
        mainFrame.setCurrentPanel(new CreateMapPanel());
    }

    public void saveMap (String fileName) throws IOException {
        try (FileOutputStream fileOut = new FileOutputStream(fileName);
             ObjectOutputStream objectOut = new ObjectOutputStream(fileOut)) {
            objectOut.writeObject(this);
            System.out.println("Objeto Map salvo com sucesso em " + fileName);
        } catch (IOException e) {
            System.err.println("Erro ao salvar o objeto Map " + e.getMessage());
            e.printStackTrace();
        }
    }

    public static Match loadMap (String fileName) throws IOException {
        Match match = null;
        try (FileInputStream fileIn = new FileInputStream(fileName);
             ObjectInputStream objectIn = new ObjectInputStream(fileIn)) {
            match = (Match) objectIn.readObject();
            System.out.println("Objeto Map carregado com sucesso!");

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            System.out.println("Erro ao carregar o arquivo.");
        }

        return match;
    }

}
