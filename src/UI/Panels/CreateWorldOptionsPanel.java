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
    private HashMap<InputField,String> inputFields;
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


        generalDataPanel.add(new InputField(new JLabel("Tamanho:")));
        generalDataPanel.add(new InputField(new JLabel("Pedras:")));
        generalDataPanel.add(new InputField(new JLabel("Maracujás:")));
        generalDataPanel.add(new InputField(new JLabel("<html>Capacidade <br>da mochila</html>:")));
        generalDataPanel.add(new InputField(new JLabel("<html>Chance de <br>fruta bichada:</html>")));

        return generalDataPanel;
    }

    private JPanel createTreesTypePanel(){
        JPanel treesTypePanel = new JPanel();
        treesTypePanel.setLayout(new GridLayout(0,1));
        treesTypePanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.BLACK), "Árvore", TitledBorder.CENTER, TitledBorder.TOP));

        treesTypePanel.add(new InputField(new JLabel("Goiaba:")));
        treesTypePanel.add(new InputField(new JLabel("Acerola:")));
        treesTypePanel.add(new InputField(new JLabel("Amora:")));
        treesTypePanel.add(new InputField(new JLabel("Laranja:")));
        treesTypePanel.add(new InputField(new JLabel("Côco:")));

        return treesTypePanel;
    }

    private JPanel createInitalFruitsPanel(){
        JPanel initalFruitsPanel = new JPanel();
        initalFruitsPanel.setLayout(new GridLayout(0,1));
        initalFruitsPanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.BLACK), "Frutas Iniciais", TitledBorder.CENTER, TitledBorder.TOP));

        initalFruitsPanel.add(new InputField(new JLabel("Goiabas:")));
        initalFruitsPanel.add(new InputField(new JLabel("Acerolas:")));
        initalFruitsPanel.add(new InputField(new JLabel("Amoras:")));
        initalFruitsPanel.add(new InputField(new JLabel("Laranjas:")));
        initalFruitsPanel.add(new InputField(new JLabel("Côcos:")));
        initalFruitsPanel.add(new InputField(new JLabel("Maracujás:")));

        return initalFruitsPanel;
    }

    private JPanel createPlayerNamesPanel(){
        JPanel playerNamesPanel = new JPanel();
        playerNamesPanel.setLayout(new GridLayout(2,1));
        playerNamesPanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.BLACK), "Nomes dos Jogadores", TitledBorder.CENTER, TitledBorder.TOP));

        playerNamesPanel.add(new InputField(new JLabel("<html>Apelido do<br> jogador 1:  </html>"), 20));
        playerNamesPanel.add(new InputField(new JLabel("<html>Apelido do<br> jogador 2:  </html>"), 20));

        return playerNamesPanel;
    }

    private JPanel createButtonsPanel(){
        JPanel buttonsPanel = new JPanel();
        buttonsPanel.setLayout(new GridLayout(0,2));

        JButton submitButton = new JButton("Submit");
        submitButton.addActionListener(e -> {

        });

        JButton shuffleButton = new JButton("Shuffle");
        shuffleButton.addActionListener(e -> {
            map.grid[1][1].setStaticElem(new Grass(grid[1][1]));
            map.grid[1][1].setDynamicElem(new Fruit(grid[1][1], FruitType.AVOCADO));
            //map.revalidate();
            //map.repaint();
        });
        buttonsPanel.add(submitButton);
        buttonsPanel.add(shuffleButton);

        return buttonsPanel;
    }

    private void addNewInputFieldToHashMap(JPanel panel, String key){
        InputField inputField = new InputField(new JLabel(key));
        panel.add(inputField);
        inputFields.put(inputField, key);
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
