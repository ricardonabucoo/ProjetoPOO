	package essentials;

import javax.swing.ImageIcon;

public class Fruit extends DynamicElem{
		
		public static  int  WORMY_FRUITS_AMOUNT;
		protected static int currentWormyFruitsAmount;
		protected boolean isWormy;
		protected FruitType fruitType;
		protected StatusEffect fruitEffect;
		
		public Fruit (Cell ownPlace, FruitType fruitType, boolean isWormy) {
			super(ownPlace,null);
			this.setIcon(FruitImage(fruitType));
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
		    
		
		public ImageIcon FruitImage(FruitType fruitType) {
			
			String str;
			switch (fruitType) {
		    
		    case ORANGE:
		        str = "images/laranja.png";
		        break;
	
		    case AVOCADO:
		        str = "images/abacate.png";
		        break;
	
		    case COCONUT:
		    	str = "images/coco.png";
		        break;
		    case GUAVA:
		    	str = "images/goiaba.png";
		    	break;
		    case PASSIONFRUIT:
		    	str = "images/maracuja.png";
		    	break;
		    case BARBADOSCHERRY:
		    	str = "images/acerola.png";
		    	break;
		    case BLACKBERRY:
		    	str = "images/amora.png";
		    	break;
		    default:
		    	str = "images/pedro.png";
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
	
	
	
	
	
	
	
	
	
	    