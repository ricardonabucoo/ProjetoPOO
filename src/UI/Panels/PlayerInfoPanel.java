package UI.Panels;

import UI.Frames.MainFrame;
import elements.FruitType;
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

    public PlayerInfoPanel(Match match,Player player) {
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
        setPreferredSize(new Dimension(300,500));

        JPanel generalData = new JPanel();
        generalData.setLayout(new BoxLayout(generalData, BoxLayout.Y_AXIS));
        generalData.setBackground(Color.decode("#f0f0f0"));
        generalData.setBorder(
                BorderFactory.createTitledBorder(
                        BorderFactory.createLineBorder(Color.BLACK),
                        "Configurações Avançadas",
                        TitledBorder.CENTER,
                        TitledBorder.TOP
                )
        );
        generalData.setBackground(Color.lightGray);



        generalData.add(new JButton("Poder:" + player.getPower()));
        generalData.add(new JButton("Pontos de Movimento:" + player.getMovementPoints()));

        JPanel effectPanel = new JPanel();
        effectPanel.setLayout(new BoxLayout(effectPanel, BoxLayout.Y_AXIS));
        effectPanel.setBackground(Color.decode("#f0f0f0"));
        effectPanel.setBorder(
                BorderFactory.createTitledBorder(
                        BorderFactory.createLineBorder(Color.BLACK),
                        "Efeitos ativos:",
                        TitledBorder.CENTER,
                        TitledBorder.TOP
                )
        );
        effectPanel.setBackground(Color.lightGray);

        if (player.getEffectList().containsEffect(EffectType.MOVIMENTEFFECT)) {
            effectPanel.add(new JButton("Effect: Speed x2"));
        } else {
            effectPanel.add(new JButton("Effect: "));
        }
        if (player.getEffectList().containsEffect(EffectType.POWEREFFECT)) {
            effectPanel.add(new JButton("Effect: Power x2"));
        } else {
            effectPanel.add(new JButton("Effect: "));
        }
        if (player.getEffectList().containsEffect(EffectType.WHORMYEFFECT)) {
            effectPanel.add(new JButton("Effect: Enjoado"));
        } else {
            effectPanel.add(new JButton("Effect: "));
        }

        JPanel fruitPanel = new JPanel();
        fruitPanel.setLayout(new BoxLayout(fruitPanel, BoxLayout.Y_AXIS));
        fruitPanel.setBackground(Color.decode("#f0f0f0"));
        fruitPanel.setBorder(
                BorderFactory.createTitledBorder(
                        BorderFactory.createLineBorder(Color.BLACK),
                        "Frutas na mochila:",
                        TitledBorder.CENTER,
                        TitledBorder.TOP
                )
        );
        fruitPanel.setBackground(Color.lightGray);

        if (player.getBag().contains(FruitType.PASSIONFRUIT))
            fruitPanel.add(new JButton(new ImageIcon("images/passionfruit.png")));
        else fruitPanel.add(new JButton());
        if (player.getBag().contains(FruitType.AVOCADO))
            fruitPanel.add(new JButton(new ImageIcon("images/avocado.png")));
        else fruitPanel.add(new JButton());
        if (player.getBag().contains(FruitType.BARBADOSCHERRY))
            fruitPanel.add(new JButton(new ImageIcon("images/barbadoscherry.png")));
        else fruitPanel.add(new JButton());
        if (player.getBag().contains(FruitType.BLACKBERRY))
            fruitPanel.add(new JButton(new ImageIcon("images/blackberry.png")));
        else fruitPanel.add(new JButton());

        if (player.getBag().contains(FruitType.COCONUT))
            fruitPanel.add(new JButton(new ImageIcon("images/coconut.png")));
        else fruitPanel.add(new JButton());

        if (player.getBag().contains(FruitType.GUAVA))
            fruitPanel.add(new JButton(new ImageIcon("images/guava.png")));
        else fruitPanel.add(new JButton());

        if (player.getBag().contains(FruitType.ORANGE))
            fruitPanel.add(new JButton(new ImageIcon("images/orange.png")));
        else fruitPanel.add(new JButton());

        add(generalData);
        add(fruitPanel);
        add(effectPanel);

    }

    private JButton createEndTurnButton() {
        JButton button = new JButton("End Turn");
        button.addActionListener(e -> {
           match.endTurn(player);
        });
        return button;
    }


}
