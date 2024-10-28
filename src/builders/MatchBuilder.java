package builders;

import elements.PassionFruitFactory;
import elements.Player;
import essentials.Map;
import essentials.Match;

public class MatchBuilder implements Builder {
    private MapBuilder mapBuilder;
    private Map map;
    private Player player1;
    private Player player2;
    private PassionFruitFactory passionFruitFactory;
    private Match match;

    public MatchBuilder(MapBuilder mapBuilder, Map map) {
        reset();
        this.mapBuilder = mapBuilder;
        this.map = map;
    }

    @Override
    public MatchBuilder build() {
        match = new Match(map, player1, player2, passionFruitFactory);
        return this;
    }

    public MatchBuilder setPlayersName(String player1Name, String player2Name) {
        map.setPlayerOneName(player1Name);
        map.setPlayerTwoName(player2Name);
        return this;
    }

    @Override
    public void reset() {
        mapBuilder = null;
        map = null;
        player1 = null;
        player2 = null;
        passionFruitFactory = null;
        match = null;
    }

    public Match getResult() {
        Match aux = match;
        reset();
        return aux;
    }

}
