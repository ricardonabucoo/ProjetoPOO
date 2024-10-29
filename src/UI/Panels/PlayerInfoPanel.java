package UI.Panels;

import elements.Player;
import essentials.Match;

import javax.swing.*;
import java.awt.*;

public class PlayerInfoPanel extends JPanel {

    private final Match match;
    private final Player player;
    //private final

    public PlayerInfoPanel(Match match,Player player) {
        this.match = match;
        this.player = player;
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setBackground(Color.lightGray);
        setPreferredSize(new Dimension(300,500));

    }

    private JButton createEndTurnButton() {
        JButton button = new JButton("End Turn");
        button.addActionListener(e -> {
           match.endTurn(player);
        });
        return button;
    }




}
