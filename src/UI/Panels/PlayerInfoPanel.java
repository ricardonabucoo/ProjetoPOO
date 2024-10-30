package UI.Panels;

import elements.Fruits.FruitType;
import elements.Player;
import essentials.Match;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.io.Serializable;
import status_effect.*;

public class PlayerInfoPanel extends JPanel implements Serializable {

    private final Match match;
    private final Player player;

    public PlayerInfoPanel(Match match, Player player) {
        this.match = match;
        this.player = player;

        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setBorder(
                BorderFactory.createTitledBorder(
                        BorderFactory.createLineBorder(Color.BLACK),
                        "Informações do Jogador",
                        TitledBorder.CENTER,
                        TitledBorder.TOP
                )
        );
        setBackground(Color.lightGray);
        setPreferredSize(new Dimension(300, 500));

        // Adiciona os painéis diretamente ao PlayerInfoPanel
        add(createGeneralDataPanel());
        add(createFruitPanel());
        add(createEffectPanel());
        add(createEndTurnButton());
    }

    private JPanel createGeneralDataPanel() {
        JPanel generalData = new JPanel();
        generalData.setLayout(new BoxLayout(generalData, BoxLayout.Y_AXIS));
        generalData.setBackground(Color.lightGray);
        generalData.setBorder(
                BorderFactory.createTitledBorder(
                        BorderFactory.createLineBorder(Color.BLACK),
                        "Configurações Avançadas",
                        TitledBorder.CENTER,
                        TitledBorder.TOP
                )
        );

        generalData.add(new JButton("Poder: " + player.getPower()));
        generalData.add(new JButton("Pontos de Movimento: " + player.getMovementPoints()));
        return generalData;
    }

    private JPanel createEffectPanel() {
        JPanel effectPanel = new JPanel();
        effectPanel.setLayout(new BoxLayout(effectPanel, BoxLayout.Y_AXIS));
        effectPanel.setBackground(Color.lightGray);
        effectPanel.setBorder(
                BorderFactory.createTitledBorder(
                        BorderFactory.createLineBorder(Color.BLACK),
                        "Efeitos ativos:",
                        TitledBorder.CENTER,
                        TitledBorder.TOP
                )
        );

        effectPanel.add(new JButton("Effect: " +
                (player.getEffectList().containsEffect(EffectType.MOVIMENTEFFECT) ? "Speed x2" : "")));
        effectPanel.add(new JButton("Effect: " +
                (player.getEffectList().containsEffect(EffectType.POWEREFFECT) ? "Power x2" : "")));
        effectPanel.add(new JButton("Effect: " +
                (player.getEffectList().containsEffect(EffectType.WHORMYEFFECT) ? "Enjoado" : "")));
        return effectPanel;
    }

    private JPanel createFruitPanel() {
        JPanel fruitPanel = new JPanel();
        fruitPanel.setLayout(new BoxLayout(fruitPanel, BoxLayout.Y_AXIS));
        fruitPanel.setBackground(Color.lightGray);
        fruitPanel.setBorder(
                BorderFactory.createTitledBorder(
                        BorderFactory.createLineBorder(Color.BLACK),
                        "Frutas na mochila:",
                        TitledBorder.CENTER,
                        TitledBorder.TOP
                )
        );

        // Botão para consumir maracujá
        JButton passionfruitButton = new JButton(player.getBag().contains(FruitType.PASSIONFRUIT) ? new ImageIcon("images/passionfruit.png") : null);
        passionfruitButton.addActionListener(e -> {
            player.eatFruit(FruitType.PASSIONFRUIT);
            updateFruitPanel(fruitPanel); // Atualiza o painel de frutas
        });
        fruitPanel.add(passionfruitButton);

        // Botão para consumir abacate
        JButton avocadoButton = new JButton(player.getBag().contains(FruitType.AVOCADO) ? new ImageIcon("images/avocado.png") : null);
        avocadoButton.addActionListener(e -> {
            player.eatFruit(FruitType.AVOCADO);
            updateFruitPanel(fruitPanel);
        });
        fruitPanel.add(avocadoButton);

        // Continue para as demais frutas...
        // Para acerola
        JButton barbadosCherryButton = new JButton(player.getBag().contains(FruitType.BARBADOSCHERRY) ? new ImageIcon("images/barbadoscherry.png") : null);
        barbadosCherryButton.addActionListener(e -> {
            player.eatFruit(FruitType.BARBADOSCHERRY);
            updateFruitPanel(fruitPanel);
        });
        fruitPanel.add(barbadosCherryButton);

        // Para amora
        JButton blackberryButton = new JButton(player.getBag().contains(FruitType.BLACKBERRY) ? new ImageIcon("images/blackberry.png") : null);
        blackberryButton.addActionListener(e -> {
            player.eatFruit(FruitType.BLACKBERRY);
            updateFruitPanel(fruitPanel);
        });
        fruitPanel.add(blackberryButton);

        // Para coco
        JButton coconutButton = new JButton(player.getBag().contains(FruitType.COCONUT) ? new ImageIcon("images/coconut.png") : null);
        coconutButton.addActionListener(e -> {
            player.eatFruit(FruitType.COCONUT);
            updateFruitPanel(fruitPanel);
        });
        fruitPanel.add(coconutButton);

        // Para goiaba
        JButton guavaButton = new JButton(player.getBag().contains(FruitType.GUAVA) ? new ImageIcon("images/guava.png") : null);
        guavaButton.addActionListener(e -> {
            player.eatFruit(FruitType.GUAVA);
            updateFruitPanel(fruitPanel);
        });
        fruitPanel.add(guavaButton);

        // Para laranja
        JButton orangeButton = new JButton(player.getBag().contains(FruitType.ORANGE) ? new ImageIcon("images/orange.png") : null);
        orangeButton.addActionListener(e -> {
            player.eatFruit(FruitType.ORANGE);
            updateFruitPanel(fruitPanel);
        });
        fruitPanel.add(orangeButton);

        return fruitPanel;
    }

    private void updateFruitPanel(JPanel fruitPanel) {
        fruitPanel.removeAll();                    // Remove todos os componentes do painel
        JPanel newFruitPanel = createFruitPanel();  // Recria o painel de frutas
        for (Component comp : newFruitPanel.getComponents()) {
            fruitPanel.add(comp);                   // Adiciona os componentes recriados
        }
        fruitPanel.revalidate();                    // Revalida para atualizar a interface
        fruitPanel.repaint();
    }


    private JButton createEndTurnButton() {
        JButton button = new JButton("End Turn");
        button.addActionListener(e -> match.endTurn(player));
        return button;
    }
}
