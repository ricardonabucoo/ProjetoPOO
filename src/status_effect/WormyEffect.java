package status_effect;

import elements.Player;

import java.io.Serializable;

public class WormyEffect implements StatusEffect, Serializable {
	 @Override
	 public void applyEffect(Player player) {
		player.setCanMoveNextRound(false); //dar o efeito de não poder se mover na próxima rodada
	}
}
