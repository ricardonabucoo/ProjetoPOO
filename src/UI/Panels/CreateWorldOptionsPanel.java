package UI.Panels;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;

public class CreateWorldOptionsPanel extends JPanel {

    public CreateWorldOptionsPanel() {
        setBackground(Color.decode("#008b8b"));
        setLayout(new BorderLayout());

        JPanel leftPanel = new JPanel();
        leftPanel.setLayout(new BoxLayout(leftPanel, BoxLayout.Y_AXIS));
        leftPanel.setBackground(Color.decode("#f0f0f0"));
        leftPanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.BLACK), "Configurações Avançadas", TitledBorder.CENTER, TitledBorder.TOP));

        //dados gerais
        JPanel generalDataPanel = new JPanel();
        generalDataPanel.setLayout(new GridLayout(0,1));
        generalDataPanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.BLACK), "Dados Gerais", TitledBorder.CENTER, TitledBorder.TOP));
        generalDataPanel.add(new InputField(new JLabel("Tamanho:")));
        generalDataPanel.add(new InputField(new JLabel("Pedras:")));
        generalDataPanel.add(new InputField(new JLabel("Maracujás:")));
        generalDataPanel.add(new InputField(new JLabel("<html>Capacidade <br>da mochila</html>:")));
        generalDataPanel.add(new InputField(new JLabel("<html>Chance de <br>fruta bichada:</html>")));


        //arvores frutiferas
        JPanel treesTypePanel = new JPanel();
        treesTypePanel.setLayout(new GridLayout(0,1));
        treesTypePanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.BLACK), "Árvore", TitledBorder.CENTER, TitledBorder.TOP));
        treesTypePanel.add(new InputField(new JLabel("Goiaba:")));
        treesTypePanel.add(new InputField(new JLabel("Acerola:")));
        treesTypePanel.add(new InputField(new JLabel("Amora:")));
        treesTypePanel.add(new InputField(new JLabel("Laranja:")));
        treesTypePanel.add(new InputField(new JLabel("Côco:")));


        //frutas iniciais
        JPanel initalFruitsPanel = new JPanel();
        initalFruitsPanel.setLayout(new GridLayout(0,1));
        initalFruitsPanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.BLACK), "Frutas Iniciais", TitledBorder.CENTER, TitledBorder.TOP));
        initalFruitsPanel.add(new InputField(new JLabel("Goiabas:")));
        initalFruitsPanel.add(new InputField(new JLabel("Acerolas:")));
        initalFruitsPanel.add(new InputField(new JLabel("Amoras:")));
        initalFruitsPanel.add(new InputField(new JLabel("Laranjas:")));
        initalFruitsPanel.add(new InputField(new JLabel("Côcos:")));
        initalFruitsPanel.add(new InputField(new JLabel("Maracujás:")));


        //nomes dos jogadores
        JPanel playerNamesPanel = new JPanel();
        playerNamesPanel.setLayout(new GridLayout(2,1));
        playerNamesPanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.BLACK), "Nomes dos Jogadores", TitledBorder.CENTER, TitledBorder.TOP));
        playerNamesPanel.add(new InputField(new JLabel("<html>Apelido do<br> jogador 1:  </html>"), 20));
        playerNamesPanel.add(new InputField(new JLabel("<html>Apelido do<br> jogador 2:  </html>"), 20));


        leftPanel.add(generalDataPanel);
        //add(Box.createRigidArea(new Dimension(20, 0)));
        leftPanel.add(treesTypePanel);
        //add(Box.createRigidArea(new Dimension(20, 0)));
        leftPanel.add(initalFruitsPanel);
        //add(Box.createRigidArea(new Dimension(20, 0)));
        leftPanel.add(playerNamesPanel);

        add(leftPanel,BorderLayout.WEST);

        JPanel rightPanel = new JPanel();

        add(rightPanel,BorderLayout.EAST);




    }
}
