package builders;

import elements.PassionFruitFactory;
import elements.Player;
import essentials.Map;
import essentials.Match;

public class MatchBuilder implements Builder {
    private MapBuilder mapBuilder;
    private Map map;
    private PassionFruitFactory passionFruitFactory;
    private Match match;

    public MatchBuilder(MapBuilder mapBuilder, Map map) {
        reset();
        this.mapBuilder = mapBuilder;
        this.map = map;
    }

    @Override
    public MatchBuilder build() {
        match = new Match(map, map.getPlayerOne(), map.getPlayerTwo(), passionFruitFactory);
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
        passionFruitFactory = null;
        match = null;
    }

    public Match getResult() {
        Match aux = match;
        reset();
        return aux;
    }

}
