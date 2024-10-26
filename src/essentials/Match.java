package essentials;

import elements.Player;

public class Match {

    private Map map;
    private Player player1;
    private Player player2;
    private PassionFruitFactory passionFruitFactory;

    public Match(Map map, Player player1, Player player2, PassionFruitFactory passionFruitFactory) {
        this.map = map;
        this.player1 = player1;
        this.player2 = player2;
        this.passionFruitFactory = passionFruitFactory;
    }




}
