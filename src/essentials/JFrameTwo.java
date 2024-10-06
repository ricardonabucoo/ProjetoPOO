package essentials;

import java.awt.*;
import javax.swing.*;

public class JFrameTwo {

    private int valX;
    private int[] answerVector;

    public JFrameTwo(int[] answ) {
        answerVector = answ;
        valX = answ[0];
        initialize(valX);
    }

    public void initialize(int x) {
        // Criando o JFrame
        JFrame frame = new JFrame();
        frame.setTitle("CataFrutas");

        // Criando o painel central com GridBagLayout
        JPanel centerPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        // Definindo o comportamento do frame
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(800, 800); // Tamanho inicial da janela
        frame.setLocationRelativeTo(null); // Centraliza a janela

        // Adicionando o painel central ao centro (CENTER) do frame
        frame.add(centerPanel, BorderLayout.CENTER);

        // Configura o peso para garantir que o GridBagLayout distribua o espaço igualmente
        gbc.weightx = 1;
        gbc.weighty = 1;
        gbc.fill = GridBagConstraints.BOTH; // O botão vai ocupar toda a célula

        // Criando os botões no painel central
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < x; j++) {
                // Criando um botão para cada posição
                JButton buttonCenter = new JButton("Button " + i + " " + j);
                
                // Definindo o tamanho do botão para ser quadrado
                buttonCenter.setPreferredSize(new Dimension(100, 100)); // Tamanho preferido

                // Definindo a posição no GridBagLayout
                gbc.gridx = i;  // Posição na coluna
                gbc.gridy = j;  // Posição na linha

                // Adicionando o botão ao painel central
                centerPanel.add(buttonCenter, gbc);
            }
        }

        // Adicionando um ComponentListener para ajustar os botões ao redimensionar a janela
        frame.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentResized(java.awt.event.ComponentEvent evt) {
                adjustButtonSize(centerPanel, x);
            }
        });

        // Exibindo a janela
        frame.setVisible(true);
    }

    // Método para ajustar o tamanho dos botões para que sejam quadrados
    private void adjustButtonSize(JPanel panel, int gridSize) {
        int width = panel.getWidth() / gridSize; // Largura de cada botão
        int height = panel.getHeight() / gridSize; // Altura de cada botão
        int buttonSize = Math.min(width, height); // Tamanho mínimo para manter os botões quadrados

        for (Component comp : panel.getComponents()) {
            if (comp instanceof JButton) {
                comp.setPreferredSize(new Dimension(buttonSize, buttonSize));
            }
        }
        panel.revalidate(); // Revalida o painel para aplicar as alterações
        panel.repaint();    // Repaint para garantir que as mudanças sejam visíveis
    }

    public static void main(String[] args) {
        // Passando um exemplo de vetor como argumento
        int[] answer = {5, 5};  // O valor de "x" será o primeiro valor do vetor
        new JFrameTwo(answer);
    }
}