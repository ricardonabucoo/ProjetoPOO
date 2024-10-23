package elements;

import essentials.Cell;
import status_effect.*;
import javax.swing.ImageIcon;

public class Fruit extends DynamicElem {
	public static  int  WORMY_FRUITS_AMOUNT;
	protected static int wormyChance;
	protected FruitType fruitType;
	protected StatusEffect fruitEffect;

	public Fruit (Cell ownPlace, FruitType fruitType) {
		super(ownPlace);
		this.setIcon(getFruitImage(fruitType));
		this.fruitEffect = getFruitEffect(fruitType);
		this.fruitType = fruitType;
	}

	private StatusEffect getFruitEffect(FruitType fruitType) {

		StatusEffect se;

		StatusEffect fe = switch (fruitType) {
            case ORANGE -> new AntidoteEffect();
            case AVOCADO -> new PowerEffect();
            case COCONUT -> new MovimentEffect();
            default -> new NullEffect();
        };
		se = fe;

        if (isWormy()) {
			EffectList el = new EffectList();
			el.addEffect(new WormyEffect());
			el.addEffect(fe);
			se = el;
		}

		return se;
	}

	private boolean isWormy() {
	 return Math.random() * 100 < wormyChance;
	}

	private ImageIcon getFruitImage(FruitType fruitType) {
		String str = switch (fruitType) {
            case ORANGE -> "images/orange.png";
            case AVOCADO -> "images/avocado.png";
            case COCONUT -> "images/coconut.png";
            case GUAVA -> "images/guava.png";
            case PASSIONFRUIT -> "images/passionfruit.png";
            case BARBADOSCHERRY -> "images/barbadoscherry.png";
            case BLACKBERRY -> "images/blackberry.png";
            default -> "null.png";
        };
        return new ImageIcon(str);
	}

	public void setOwnPlace(Cell newPlace){
		changePosition(newPlace);
	}

	public void drop() {

	}

	public void giveEffect (Player player) {
		this.fruitEffect.applyEffect(player);
	}

	public FruitType getFruitType() {
	 return fruitType;
	}
}
	
	
	
	
	
	
	
	
	
	    