	package elements.Fruits;
	
	public enum FruitType {
		
		PASSIONFRUIT(PassionFruit.class),
		BARBADOSCHERRY(BarbadosCherry.class),
		GUAVA(Guava.class),
		BLACKBERRY(BlackBerry.class),
		ORANGE(Orange.class),
		AVOCADO(Avocado.class),
		COCONUT(Coconut.class);
		
		private Class<?> type;

		FruitType(Class<?> fruitType) {
			this.type=fruitType;
		}

		public Class<?> getType() {
			return this.type;
		}

		public boolean isInstance(Object obj) {
			return type.isInstance(obj);
		}


	
	}
