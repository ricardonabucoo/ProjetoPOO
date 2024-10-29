package essentials;

import UI.Panels.MapInfoPanel;
import UI.Panels.PlayerInfoPanel;
import UI.Panels.TopGameBoard;
import elements.Bag;
import elements.PassionFruitFactory;
import elements.Player;

import javax.swing.*;
import java.awt.*;

public class Match extends JPanel {

    private TopGameBoard topBoard;
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
        //add(new TopGameBoard(this), BorderLayout.NORTH);

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

}
