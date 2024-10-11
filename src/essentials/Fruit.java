	package essentials;

import javax.swing.ImageIcon;

public class Fruit extends DynamicElem{
		
		public static  int  WORMY_FRUITS_AMOUNT;
		protected static int currentWormyFruitsAmount;
		protected boolean isWormy;
		protected FruitType fruitType;
		protected StatusEffect fruitEffect;
		
		public Fruit (Cell ownPlace, FruitType fruitType, boolean isWormy) {
			super(ownPlace,FruitImage(fruitType) );
		    this.fruitType = fruitType;	
		    this.isWormy = isWormy;
		    
		    StatusEffect se;
		    
		    switch (fruitType) {
		    
		    case ORANGE:
		        se = new AntidoteEffect();
		        break;
	
		    case AVOCADO:
		        se = new PowerEffect();
		        break;
	
		    case COCONUT:
		        se = new MovimentEffect();
		        break;
	
		    default:
		        se = new NullEffect();
		        break;
		    }
		    
		    if (isWormy){
		        EffectList el = new EffectList();
		        el.AddEffect(new WormyEffect());
		        el.AddEffect(se);
		        fruitEffect = el;
		    }
		    else
	           fruitEffect = se;
		    
		}
		    
		
		public static ImageIcon FruitImage(FruitType fruitType) {
			
			String str;
			switch (fruitType) {
		    
		    case ORANGE:
		        str = "laranja.png";
		        break;
	
		    case AVOCADO:
		        str = "abacate.png";
		        break;
	
		    case COCONUT:
		    	str = "coco.png";
		        break;
		    case GUAVA:
		    	str = "goiaba.png";
		    	break;
		    case PASSIONFRUIT:
		    	str = "maracuja.png";
		    	break;
		    case BARBADOSCHERRY:
		    	str = "acerola.png";
		    	break;
		    case BLACKBERRY:
		    	str = "amora.png";
		    	break;
		    default:
		    	str = "pedro.png";
			}
			return new ImageIcon(str);
		}
		
		public void SetOwnPlace(Cell newPlace){
			this.ownPlace = newPlace;
		}
		
		public void Drop() {
			
		} 
	   
		
		public void GiveEffect (Player player) {
			this.fruitEffect.ApplyEffect(player);
		}
		
		
		 public boolean IsWormy() {
			 return isWormy;
		 }
		 
		 
		 public void SetWormy (boolean isWormy) {
			 this.isWormy = isWormy;
		 }
		 
		 public FruitType GetFruitType() {
			 return fruitType;
		 }
		 
			 
		 
	}
	
	
	
	
	
	
	
	
	
	    