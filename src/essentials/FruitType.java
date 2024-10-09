	package essentials;
	
	public enum FruitType {
		
		PASSIONFRUIT(0),
		BARBADOSCHERRY(1),
		GUAVA(2),
		BLACKBERRY(3),
		ORANGE(4),
		AVOCADO(5),
		COCONUT(6);
		
		private int value;
		
		FruitType(int n){
			
			this.value = n;
		}
		
		public int GetValue() {
			
			return this.value;
			
		}
	
	}
