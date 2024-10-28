package essentials;

import elements.Bag;
import elements.PassionFruitFactory;
import elements.Player;

import java.awt.*;

public class Match {

    private Map map;
    private Player player1;
    private Player player2;
    private PassionFruitFactory passionFruitFactory;
    private int roundCount;

    public Match(Map map, Player player1, Player player2, PassionFruitFactory passionFruitFactory) {
        this.map = map;
        this.player1 = player1;
        this.player2 = player2;
        this.passionFruitFactory = passionFruitFactory;
        this.roundCount = 0;

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
