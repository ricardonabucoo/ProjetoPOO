package essentials;

public  class Fruit {
	public static  int  WORMY_FRUITS_AMOUNT;
	protected static int currentWormyFruitsAmount;
	protected boolean isWormy;
	protected FruitType fruitType;
	protected StatusEffect fruitsEffect;
	
	
	
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
	    
	    }
	    
	    
	public void Drop() {
		
	} 
   
	
	public void GiveEffect (Player player) {
		this.fruitEffect.ApplyEffect(player);
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
     
    