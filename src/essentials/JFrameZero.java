package essentials;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class JFrameZero {
    
    public static void main(String[] args) {
        // Cria o JFrame
        JFrame frame = new JFrame();
        frame.setTitle("CataFrutas");
        frame.setBounds(50, 50, 700, 700);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        // Criação do JPanel para os botões com FlowLayout
        JPanel jpanel = new JPanel();
        jpanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 300));  // Ajuste do espaçamento vertical

        // Definindo a cor de fundo do painel com a cor HEX #4d6f39
        jpanel.setBackground(Color.decode("#4d6f39"));
        
        // Criando um título com JLabel
        JLabel title = new JLabel("Bem-vindo ao CataFrutas", JLabel.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 24));  // Definindo a fonte do título
        title.setForeground(Color.WHITE);  // Cor do texto (branco)
        title.setBackground(Color.decode("#4d6f39"));  // Cor de fundo do título
        title.setOpaque(true);  // Torna o fundo do JLabel visível

        // Criação do BorderLayout no JFrame
        frame.setLayout(new BorderLayout());

        // Adiciona o título no topo do JFrame (NORTE)
        frame.add(title, BorderLayout.NORTH);

        // Adiciona os botões ao JPanel
        JButton j = new JButton("Jogar");
        jpanel.add(j);
        
        // Ação do botão Play
        j.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new JFrameOne(); // Inicia o jogo 
                frame.dispose(); // Fecha a janela de menu
            }
        });

        JButton l = new JButton("Carregar");
        jpanel.add(l);

        JButton s = new JButton("Sair");
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
}