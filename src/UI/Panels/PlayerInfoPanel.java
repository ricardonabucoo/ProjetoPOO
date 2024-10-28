package UI.Panels;

import elements.FruitType;
import elements.Player;
import status_effect.*;

import javax.swing.*;
import java.awt.*;

public class PlayerInfoPanel extends JPanel {


    public PlayerInfoPanel(Player player) {

        setLayout(new GridBagLayout());

        GridBagConstraints playerInfo = new GridBagConstraints();
        playerInfo.gridx = 0;
        playerInfo.gridy = 0;
        playerInfo.gridwidth = 6;
        playerInfo.gridheight = 6;
        add(new JButton("Informações do Jogador"), playerInfo);

        GridBagConstraints playerPower = new GridBagConstraints();
        playerPower.gridx = 0;
        playerPower.gridy = 7;
        playerPower.gridwidth = 1;
        playerPower.gridheight = 2;
        add(new JButton("Poder:" + player.getPower()), playerPower);

        GridBagConstraints playerMovementPoints = new GridBagConstraints();
        playerMovementPoints.gridx = 0;
        playerMovementPoints.gridy = 9;
        playerMovementPoints.gridwidth = 1;
        playerMovementPoints.gridheight = 2;
        add(new JButton("Pontos de Movimento:" + player.getMovimentPoints()), playerMovementPoints);

        GridBagConstraints playerEffects = new GridBagConstraints();
        playerEffects.gridx = 0;
        playerEffects.gridy = 11;
        playerEffects.gridwidth = 8;
        playerEffects.gridheight = 2;
        playerEffects.ipady = 1;

        add(new JButton("==Effect List=="), playerEffects);
        if (player.getEffectList().containsEffect(EffectType.MOVIMENTEFFECT)) {
            add(new JButton("Effect: Speed x2"));
        } else {
            add(new JButton("Effect: "));
        }
        if (player.getEffectList().containsEffect(EffectType.POWEREFFECT)) {
            add(new JButton("Effect: Power x2"));
        } else {
            add(new JButton("Effect: "));
        }
        if (player.getEffectList().containsEffect(EffectType.WHORMYEFFECT)) {
            add(new JButton("Effect: Enjoado"));
        } else {
            add(new JButton("Effect: "));
        }

        GridBagConstraints playerFruits = new GridBagConstraints();
        playerEffects.gridx = 2;
        playerEffects.gridy = 7;
        playerEffects.gridwidth = 14;
        playerEffects.gridheight = 2;
        playerEffects.ipady = 1;

        if (player.getBag().getFruitList().contains(FruitType.PASSIONFRUIT))
            add(new JButton(new ImageIcon("images/passionfruit.png")), playerFruits);
        else add(new JButton(), playerFruits);

        if (player.getBag().getFruitList().contains(FruitType.AVOCADO))
            add(new JButton(new ImageIcon("images/avocado.png")), playerFruits);
        else add(new JButton(), playerFruits);

        if (player.getBag().getFruitList().contains(FruitType.BARBADOSCHERRY))
            add(new JButton(new ImageIcon("images/barbadoscherry.png")), playerFruits);
        else add(new JButton(), playerFruits);

        if (player.getBag().getFruitList().contains(FruitType.BLACKBERRY))
            add(new JButton(new ImageIcon("images/blackberry.png")), playerFruits);
        else add(new JButton(), playerFruits);

        if (player.getBag().getFruitList().contains(FruitType.COCONUT))
            add(new JButton(new ImageIcon("images/coconut.png")), playerFruits);
        else add(new JButton(), playerFruits);

        if (player.getBag().getFruitList().contains(FruitType.GUAVA))
            add(new JButton(new ImageIcon("images/guava.png")), playerFruits);
        else add(new JButton(), playerFruits);

        if (player.getBag().getFruitList().contains(FruitType.ORANGE))
            add(new JButton(new ImageIcon("images/orange.png")), playerFruits);
        else add(new JButton(), playerFruits);


    }
}
