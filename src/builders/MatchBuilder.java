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
    public void build() {

        match = new Match(map, player1, player2, passionFruitFactory);
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

    private MatchBuilder buildPassionFruitFactory(int PassionFruitsAmount){
        passionFruitFactory = PassionFruitFactory.getInstance(mapBuilder.getTreeCellList(), PassionFruitsAmount);
        return this;
    }

}
