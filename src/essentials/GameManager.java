	package essentials;

import java.util.HashMap;
import java.util.Scanner;

public class GameManager {
	private GameMap map;
	private Player player1;
	private Player player2;
	private Boolean isFinished;
	
	
	
	public GameManager() {
		this.isFinished = false;
	}
	
	public void Initialization() {
		// ler arquivos , bla ,bla ,bla		
						
		MapBuilder builder = new MapBuilder();
		
		Scanner read = new Scanner(System.in);
		
		System.out.print("Digite o tamanho do mapa.");
		int mapsize = read.nextInt();
		
		System.out.print("Digite a quantidade de rochas.");
		int rocksAmount = read.nextInt();
		
		System.out.print("Digite a quantidade de arvores.");
		int treeAmounts = read.nextInt(); 
		
		HashMap <TypeFruit, Integer> treemap = new HashMap<>();
		System.out.ptint("Digite a quantidade de frutas que deseja adicionar.");
		int fruitAmounts = read.nextInt();
		
		for (int i = 0; i < fruitAmounts; i ++) {
			System.out.print("Digite o tipo da fruta.");
			String fruitTypeString = read.next();
			FruitType fruitType = FruitType.valueOf(fruitTypeString.toUpperCase());
			
			System.out.print("Quantas frutas do tipo escolhido deseja adicionar?");
			int quantityFruit = read.nextInt();
			
			treemap.put(fruitType, quantityFruit);
		}
		
		System.out.print("Digite o nome Player 1");
		String nameOne = read.next();
		
		System.out.print("Digite o nome Player 2");
		String nameTwo = read.next();
		
		System.out.print("Digite o tamanho da mochila dos Players.");
		int bagSizePlayers = read.nextInt();
		
		builder.BuildCellGrid(mapsize)
		       .BuildRockCells(rocksAmount)
		       .BuildTreeCells(treemap)
			   .BuildGrassCells()
			   .BuildFruitsCells(treemap)
			   .BuildPlayerOne(nameOne, bagSizePlayers)
			   .BuildPlayerTwo(nameTwo, bagSizePlayers);
		
		this.map = builder.GetResult();
		System.out.print("Mapa construido com sucesso!");
		
		//PassionFruitFactory pfFactory = new PassionFruitFactory(builder.GetTreeCellList(),maxPassionFruitsAmount);
	}
	
	private void BuildMapByFile() {
		MapReader reader = new MapReader();
		reader.readFile("nomedoarquivo.txt");
		
		MapBuilder builder = new MapBuilder();	
		
		builder.BuildCellGrid(reader.getSize());
		builder.BuildRockCells(reader.getRocksAmount());
		builder.BuildTreeCells(reader.getNumberOfTrees());
		builder.BuildGrassCells();
		builder.BuildFruitsCells(reader.getInitialFruitsNumber());
		
		GameMap map = builder.GetResult();			
	}
	
	private void BuildMapByQuiz() {
		
	}
	
	public void Play() {
		//so um esboço
		while (!isFinished) {
			 
			//System.out.println(map); //exibe o estado atual do mapa
			//System.out.print("Turno de " + player1.name);
			TurnPlayerOne(player1);
			
			if (checkGameOver(isFinished)) {
				break;
			}
			//System.out.print(map); //exibe o estado atual do mapa após o player jogar
			//System.out.print("Turno de " + player2.name);
			TurnPlayerTwo(player2);
			
			if (checkGameOver(isFinished)) {
				break;
			}
		}
		EndGame();
		
	}
	
	private void TurnPlayer1(Player player) {}
	private void TurnPlayer2(Player player) {}	
	private boolean checkGameOver(boolean isfinished) {
		if () {
			isfinished = true;
		}
	}
	public void Update() {
		map.Update();
	}
	public void EndGame() {
		System.out.println("Fim de jogo!");
	}
	public int PlayDices() {return 0;}
	public boolean IsFinished() {
		return this.isFinished;
	}
	
	
}
	