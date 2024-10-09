	package essentials;
	
	public class Fruit extends DynamicElem{
		
		public static  int  WORMY_FRUITS_AMOUNT;
		protected static int currentWormyFruitsAmount;
		protected boolean isWormy;
		protected FruitType fruitType;
		protected StatusEffect fruitEffect;
		
		public Fruit (Cell ownPlace, FruitType fruitType, boolean isWormy) {
			
			this.ownPlace = ownPlace;
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
	
	
	
	
	
	
	
	
	
	    