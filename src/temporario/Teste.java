package temporario;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

class Usuario implements java.io.Serializable {
    private String nome;
    private int idade;
    private String sexo;

    public Usuario(String nome, int idade, String sexo) {
        this.nome = nome;
        this.idade = idade;
        this.sexo = sexo;
    }

    @Override
    public String toString() {
        return "Nome: " + nome + ", Idade: " + idade + ", Sexo: " + sexo;
    }
}

public class Teste {
    public static void main(String[] args) {
        JFrame jframe = new JFrame();
        jframe.setTitle("Jogo");
        jframe.setSize(700, 900);
        jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jframe.setLayout(new BorderLayout());
        jframe.setVisible(true);

        JPanel painel = new JPanel();
        painel.setBackground(Color.BLUE);
        jframe.add(painel, BorderLayout.CENTER);

        JPanel painel1 = new JPanel();
        painel1.setBackground(Color.RED);
        painel1.setLayout(null);

        JPanel painel2 = new JPanel();
        painel2.setBackground(Color.GREEN);
        painel2.setLayout(null);

        JPanel painel3 = new JPanel();
        painel3.setBackground(Color.ORANGE);
        painel3.setLayout(null);

        JButton button0 = new JButton("Iniciar jogo");
        painel.add(button0);

        JButton button2 = new JButton("Carregar novo jogo");
        button2.setBounds(350, 100, 200, 30);
        JButton button3 = new JButton("Carregar dados já existentes?");
        button3.setBounds(550, 100, 200, 30); // Ajuste o tamanho do botão para caber o texto

        painel2.add(button2);
        painel2.add(button3);

        button0.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jframe.remove(painel);
                jframe.add(painel2, BorderLayout.CENTER);
                jframe.revalidate(); // Atualiza a janela para mostrar o novo painel
                jframe.repaint();
            }
        });

        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jframe.remove(painel2);
                jframe.add(painel1, BorderLayout.CENTER);
                jframe.revalidate(); // Atualiza a janela para mostrar o novo painel
                jframe.repaint();
            }
        });

        button3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                File file = new File("usuario.bin");
                if (!file.exists() || file.length() == 0) {
                    JOptionPane.showMessageDialog(jframe, "Nenhum dado encontrado. O arquivo está vazio.", "Erro", JOptionPane.WARNING_MESSAGE);
                    jframe.add(painel2);
                    return;
                }
                try (FileInputStream fileIn = new FileInputStream("usuario.bin");
                     ObjectInputStream in = new ObjectInputStream(fileIn)) {
                    Usuario usuario = (Usuario) in.readObject();
                    JLabel infoLabel = new JLabel(usuario.toString());
                    infoLabel.setBounds(500, 300, 400, 50);
                    painel3.add(infoLabel);
                    jframe.remove(painel2);
                    jframe.add(painel3, BorderLayout.CENTER);
                    jframe.revalidate();
                    jframe.repaint();
                } catch (IOException | ClassNotFoundException ex) {
                    JOptionPane.showMessageDialog(jframe, "Erro ao carregar os dados: " + ex.getMessage());
                }
            }
        });

        JLabel pergunta1 = new JLabel("Qual o seu nome?");
        JLabel pergunta2 = new JLabel("Qual a sua idade?");
        JLabel pergunta3 = new JLabel("Qual o seu sexo?");

        pergunta1.setBounds(50, 50, 200, 30);
        pergunta2.setBounds(50, 100, 200, 30);
        pergunta3.setBounds(50, 150, 200, 30);

        painel1.add(pergunta1);
        painel1.add(pergunta2);
        painel1.add(pergunta3);

        JTextField campoNome = new JTextField();
        JTextField campoIdade = new JTextField();
        JTextField campoSexo = new JTextField();

        campoNome.setBounds(250, 50, 200, 30);
        campoIdade.setBounds(250, 100, 200, 30);
        campoSexo.setBounds(250, 150, 200, 30);

        painel1.add(campoNome);
        painel1.add(campoIdade);
        painel1.add(campoSexo);

        JButton button1 = new JButton("Salvar arquivo");
        button1.setBounds(600, 500, 150, 30);
        painel1.add(button1);
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nome = campoNome.getText();
                int idade = Integer.parseInt(campoIdade.getText());
                String sexo = campoSexo.getText();

                Usuario usuario = new Usuario(nome, idade, sexo);
                // Salvar o usuário em um arquivo binário
                try (FileOutputStream fileOut = new FileOutputStream("usuario.bin");
                     ObjectOutputStream out = new ObjectOutputStream(fileOut)) {
                    out.writeObject(usuario);
                    JOptionPane.showMessageDialog(jframe, "Dados salvos com sucesso!");
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(jframe, "Erro ao salvar os dados: " + ex.getMessage());
                }
                jframe.remove(painel1);
                jframe.add(painel, BorderLayout.CENTER);
                jframe.revalidate();
                jframe.repaint();
            }
        });

        painel1.setFocusable(true);
        painel1.requestFocusInWindow();
    }
}
