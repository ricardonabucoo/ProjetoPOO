package UI.Panels;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;

public class CreateWorldOptionsPanel extends JPanel {

    public CreateWorldOptionsPanel() {
        setBackground(Color.decode("#008b8b"));
        setLayout(new BoxLayout(this, BoxLayout.X_AXIS));


        //dados gerais
        JPanel generalDataPanel = new JPanel();
        generalDataPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        generalDataPanel.add(new InputField(new JLabel("Tamanho:")));
        generalDataPanel.add(new InputField(new JLabel("Pedras:")));
        generalDataPanel.add(new InputField(new JLabel("Maracujás:")));
        generalDataPanel.add(new InputField(new JLabel("<html>Capacidade <br>da mochila</html>:")));
        generalDataPanel.add(new InputField(new JLabel("<html>Chance de <br>fruta bichada:</html>")));
        generalDataPanel.setLayout(new GridBagLayout());
        //generalDataPanel.setLayout(new BoxLayout(generalDataPanel, BoxLayout.Y_AXIS));

        //arvores frutiferas
        JPanel treesTypePanel = new JPanel();
        treesTypePanel.add(new InputField(new JLabel("Goiaba:")));
        treesTypePanel.add(new InputField(new JLabel("Acerola:")));
        treesTypePanel.add(new InputField(new JLabel("Amora:")));
        treesTypePanel.add(new InputField(new JLabel("Laranja:")));
        treesTypePanel.add(new InputField(new JLabel("Côco:")));
        treesTypePanel.setLayout(new BoxLayout(treesTypePanel, BoxLayout.Y_AXIS));

        //frutas iniciais
        JPanel initalFruitsPanel = new JPanel();
        initalFruitsPanel.add(new InputField(new JLabel("Goiabas:")));
        initalFruitsPanel.add(new InputField(new JLabel("Acerolas:")));
        initalFruitsPanel.add(new InputField(new JLabel("Amoras:")));
        initalFruitsPanel.add(new InputField(new JLabel("Laranjas:")));
        initalFruitsPanel.add(new InputField(new JLabel("Côcos:")));
        initalFruitsPanel.add(new InputField(new JLabel("Maracujás:")));
        initalFruitsPanel.setLayout(new BoxLayout(initalFruitsPanel, BoxLayout.Y_AXIS));

        //nomes dos jogadores
        JPanel playerNamesPanel = new JPanel();
        playerNamesPanel.add(new InputField(new JLabel("<html>Apelido do<br> jogador 1:</html>")));
        playerNamesPanel.add(new InputField(new JLabel("<html>Apelido do<br> jogador 2:</html>")));
        playerNamesPanel.setLayout(new BoxLayout(playerNamesPanel, BoxLayout.Y_AXIS));

        add(generalDataPanel);
        add(Box.createRigidArea(new Dimension(20, 0)));
        add(treesTypePanel);
        add(Box.createRigidArea(new Dimension(20, 0)));
        add(initalFruitsPanel);
        add(Box.createRigidArea(new Dimension(20, 0)));
        add(playerNamesPanel);
        generalDataPanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.BLACK), "Dados Gerais", TitledBorder.LEFT, TitledBorder.TOP));
    }
}
