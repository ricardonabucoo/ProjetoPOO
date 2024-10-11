package essentials;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class GameManager {
	private GameMap map;
	private Player player1;
	private Player player2;
	private Boolean isFinished;
	
	
	
	public GameManager() {
		this.isFinished = false;
	}
	
	public void Initialization() {

		// Cria o JFrame
        JFrame frame = new JFrame();
        frame.setTitle("CataFrutas");
        frame.setBounds(50, 50, 700, 700);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        // Criação do JPanel para os botões com FlowLayout
        JPanel jpanel = new JPanel();
        jpanel.setLayout(new FlowLayout(FlowLayout.CENTER, 50, 275));  // Ajuste do espaçamento vertical

        // Definindo a cor de fundo do painel com a cor HEX #4d6f39
        jpanel.setBackground(Color.decode("#4d6f39"));
        
        // Criando um título com JLabel
        JLabel title = new JLabel("Bem-vindo ao Cata Frutas", JLabel.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 50));  // Definindo a fonte do título
        title.setForeground(Color.WHITE);  // Cor do texto (branco)
        title.setBackground(Color.decode("#4d6f39"));  // Cor de fundo do título
        title.setOpaque(true);  // Torna o fundo do JLabel visível

        // Criação do BorderLayout no JFrame
        frame.setLayout(new BorderLayout());

        // Adiciona o título no topo do JFrame (NORTE)
        frame.add(title, BorderLayout.NORTH);

        // Adiciona os botões ao JPanel
        JButton j = new JButton("Jogar");
        j.setPreferredSize(new Dimension(100, 50));
        jpanel.add(j);
        
        // Ação do botão Play
        j.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	new Quiz();
                frame.dispose(); 
            }
        });

        JButton l = new JButton("Carregar");
        l.setPreferredSize(new Dimension(100, 50));
        jpanel.add(l);

        JButton s = new JButton("Sair");
        s.setPreferredSize(new Dimension(100, 50));
        jpanel.add(s);
        
        s.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose(); // Fecha a janela de menu
            }
        });

        // Adiciona o JPanel com os botões no centro do JFrame (CENTRO)
        frame.add(jpanel, BorderLayout.CENTER);

        // Torna o JFrame visível
        frame.setVisible(true);
		
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
		
		this.map = builder.GetResult();
	}
	
	private void BuildMapByQuiz() {
		
		
		/*
		MapBuilder builder = new MapBuilder();	
		
		builder.BuildCellGrid(quiz.GetSize());
		builder.BuildRockCells(quiz.GetRocksAmount());
		builder.BuildTreeCells(quiz.GetNumberOfTrees());
		builder.BuildGrassCells();
		builder.BuildFruitsCells(quiz.GetFruitsAmount());
		
		this.map = builder.GetResult();
		*/
	}
	/*
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
	*/
	
}
	