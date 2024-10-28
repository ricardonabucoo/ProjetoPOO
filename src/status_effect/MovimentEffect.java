package status_effect;

import elements.Player;

public class MovimentEffect implements StatusEffect {
	 @Override
	 public void applyEffect (Player player) {
		 int currentmovimentsPoints = player.getMovimentPoints();
		player.setMovimentPoints(currentmovimentsPoints * 2);
	}
}
