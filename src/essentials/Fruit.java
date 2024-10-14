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
	
	
	public Fruit (boolean isWormy, FruitType fruitType ) 
	  {
	    this.fruitType = fruitType;
	    this.isWormy = isWormy;
	    
	    StatusEffect se;
	    
	    switch (fruitType)
	   { 
	    case ORANGE:

	        se = new AntidoteEffect();
	        break;

	    case BARBADOSCHERRY:
	        se = new NullEffect();
	        break;

	    case AVOCADO:
	        se = new PowerEffect();
	        break;

	    case BLACKBERRY:
	        se = new NullEffect();
	        break;

	    case GUAVA:
	        se = new NullEffect();
	        break;

	    case COCONUT:
	        se = new MovimentEffect();
	        break;

	    case PASSIONFRUIT:
	        se = new NullEffect();
	        break;
	    }
	    
	    if (isWormy)
	    {
	        fruitsEffect = new EffectList();
	        fruitsEffect.AddEffect(new WormyEffect);
	        fruitEffect.AddEffect(se);
	    }
	         else
	           fruitEffect = se;
<<<<<<< HEAD
		    
		}
		    
		
		public ImageIcon FruitImage(FruitType fruitType) {
			
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
			return new ImageIcon(getClass().getResource(str));
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
		 
			 
		 
=======
	    
	    }
	    
	    
	public void Drop() {
		
	} 
   
	
	public void GiveEffect (Player player) {
		this.fruitEffect.ApplyEffect(player);
>>>>>>> main
	}


     public boolean isWormy() {
    	 return isWormy;
     }
     
     
     public void setWormy (boolean isWormy) {
    	 this.isWormy = isWormy;
     }
     
     public FruitType getFruitType() {
    	 return fruitType;
     }
     
    