package essentials;

import UI.Buttons.CloseMainFrameButton;
import UI.Panels.MapInfoPanel;
import UI.Panels.PlayerInfoPanel;
import elements.PassionFruitFactory;
import elements.Player;

import javax.swing.*;
import java.awt.*;

public class Match extends JPanel {

    private JPanel gameBoard;
    private final Map map;
    private MapInfoPanel mapInfo;

    private final PlayerInfoPanel player1Info;
    private final PlayerInfoPanel player2Info;
    private PlayerInfoPanel currentPlayerInfo;

    private final Player player1;
    private final Player player2;
    private Player currentPlayer;
    private PassionFruitFactory passionFruitFactory;
    private int roundCount;

    public Match(Map map, Player player1, Player player2, PassionFruitFactory passionFruitFactory) {
        this.map = map;
        this.player1 = player1;
        this.player2 = player2;
        this.passionFruitFactory = passionFruitFactory;
        this.roundCount = 0;

        setLayout(new BorderLayout());
        setBackground(Color.decode("#008b8b"));
        mapInfo = map.getMapInfoPanel();
        player1Info = new PlayerInfoPanel(this,player1);
        add(player1Info, BorderLayout.EAST);
        player2Info = new PlayerInfoPanel(this,player2);
        add(mapInfo, BorderLayout.WEST);
        add(map, BorderLayout.CENTER);
        gameBoard = createGameBoard();
        add(gameBoard, BorderLayout.NORTH);

    }

    public void endTurn(Player player) {
        roundCount++;
        map.update();
        beginTurn(player);
    }

    public void beginTurn(Player player) {
        if(player == player1){
            currentPlayer = player2;
            currentPlayerInfo = player2Info;
        }
        else{
            currentPlayer = player1;
            currentPlayerInfo = player1Info;
        }
    }

    public Player getPlayerOne() {
    	return this.player1;
    }
    
    public Player getPlayerTwo() {
    	return this.player2;
    }

    public Map getMap() {
        return this.map;
    }

    public int getRoundCount() {
        return this.roundCount;
    }


    private JPanel createGameBoard() {
        JPanel gameBoard = new JPanel();
        gameBoard.setLayout(new GridLayout(0, 3));
        gameBoard.setBackground(Color.decode("#008b8b"));
        gameBoard.add(createPanel(player1));
        gameBoard.add(createCenterPanel());
        gameBoard.add(createPanel(player2));
        return gameBoard;
    }

    private JPanel createPanel(Player player) {
        JPanel panel = new JPanel();
        panel.add(new JButton(Integer.toString(player.getBag().getPassionFruitAmount())));
        panel.add( new JButton(player.getName()));
        panel.add(new JButton(Integer.toString(player.getBag().getPassionFruitAmount())));
        return panel;
    }

    private JPanel createCenterPanel() {
        JPanel panel = new JPanel();
        panel.add(new JButton(Integer.toString(roundCount)));
        panel.add(new CloseMainFrameButton());
        return panel;
    }
}
