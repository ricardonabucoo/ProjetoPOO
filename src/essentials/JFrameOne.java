package essentials;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class JFrameOne extends JFrame {

    private JTextArea textArea;
    private JTextField answerField;
    private JButton submitButton;
    private JButton playButton;
    private String[] otherQuestions = {
        "Qual o nome do primeiro jogador?",
        "Qual o nome do segundo jogador?"
    };

    private String[] questions = {
        "Qual o tamanho da floresta?",
        "Quantas Pedras?",
        "Qual o total de frutas ouro?",
        "Qual será o número de acerolas iniciais?",
        "Qual será o número de goiabas iniciais?",
        "Qual será o número de amoras iniciais?",
        "Qual será o número de laranjas iniciais?",
        "Qual será o número de abacates iniciais?",
        "Qual será o número de cocos iniciais?",
        "Quantas goiabeiras?",
        "Quantos pés de amora?",
        "Quantas laranjeiras?",
        "Quantos pés de abacate?",
        "Quantos coqueiros?",
        "Qual a chance de uma fruta estar bichada em porcentagem?",
        "Qual é a capacidade da mochila?"
    };

    private int[] answers; // Array para armazenar as respostas (apenas inteiros)
    private String[] names; // Array para armazenar o nome dos jogadores (apenas strings)
    private int currentQuestionIndex = 0;

    public int[] getAnswers() {
        return this.answers;
    }

    public String[] getNames() {
        return this.names;
    }

    public JFrameOne() {
        answers = new int[questions.length]; // Inicializa o array de respostas
        names = new String[2]; // Para armazenar os nomes dos jogadores
        initialize();
    }

    public void initialize() {
        JFrame frame = new JFrame();
        frame.setTitle("CataFrutas");

        JPanel panel = new JPanel(new FlowLayout(FlowLayout.CENTER, 15, 20));
        JPanel background = new JPanel(new FlowLayout(FlowLayout.CENTER, 100, 200));

        frame.setLayout(new BorderLayout(10, 5));
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(500, 400);
        frame.setLocationRelativeTo(null);

        background.setBackground(Color.GRAY);
        panel.setBackground(Color.DARK_GRAY);

        // Criação do JTextArea
        textArea = new JTextArea(10, 30);
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        textArea.setEditable(false); // Não editável inicialmente

        JScrollPane scrollPane = new JScrollPane(textArea);

        // Criação do JTextField para resposta
        answerField = new JTextField(20);
        answerField.setEnabled(false); // Desabilita o campo de resposta inicialmente

        // Botão para enviar resposta
        submitButton = new JButton("Enviar");
        submitButton.setEnabled(false); // Desabilita o botão de enviar inicialmente

        // Botão para iniciar o jogo
        playButton = new JButton("Play");
        playButton.setEnabled(false); // Desabilita o botão de Play inicialmente

        // Ação do botão de enviar resposta
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                handleSubmit();
            }
        });

        // Ação do botão Play
        playButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new JFrameTwo(getAnswers()); // Inicia o jogo passando as respostas
                frame.dispose(); // Fecha a janela de perguntas
            }
        });

        // Adicionando KeyListener para pressionar Enter
        answerField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    handleSubmit(); // Chama a função de envio
                }
            }
        });

        // Adiciona componentes ao painel
        panel.add(answerField);
        panel.add(submitButton);
        panel.add(playButton);

        // Adiciona os painéis ao JFrame
        frame.add(panel, BorderLayout.SOUTH);
        frame.add(scrollPane, BorderLayout.CENTER);

        // Exibe a primeira pergunta
        showNextQuestion();

        // Exibe o JFrame
        frame.setVisible(true);
    }

    private void handleSubmit() {
        String answer = answerField.getText();
        if (!answer.trim().isEmpty()) {
            if (currentQuestionIndex < names.length) {
                // Armazena o nome dos jogadores
                names[currentQuestionIndex] = answer;
                textArea.append(" Resposta: " + answer + "\n");
            } else {
                // Armazena as respostas das perguntas do jogo
                try {
                    int answerValue = Integer.parseInt(answer);
                    int questionIndex = currentQuestionIndex - names.length; // Ajusta o índice para o array de respostas
                    answers[questionIndex] = answerValue; // Armazena a resposta
                    textArea.append(" Resposta: " + answerValue + "\n");
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(this, "Por favor, insira um número válido.");
                    return;
                }
            }

            answerField.setText(""); // Limpa o campo de resposta

            // Incrementa o índice da pergunta
            currentQuestionIndex++;

            // Verifica se todas as perguntas foram respondidas
            if (currentQuestionIndex >= (names.length + questions.length)) {
                playButton.setEnabled(true); // Habilita o botão de Play
                answerField.setEnabled(false); // Desabilita o campo de resposta
                submitButton.setEnabled(false); // Desabilita o botão de enviar
                textArea.append("Todas as perguntas respondidas. Clique em 'Play' para iniciar o jogo.\n");
            } else {
                showNextQuestion(); // Mostra a próxima pergunta
            }
        } else {
            JOptionPane.showMessageDialog(this, "Por favor, insira uma resposta.");
        }
    }

    private void showNextQuestion() {
        if (currentQuestionIndex < names.length + questions.length) {
            if (currentQuestionIndex < names.length) {
                textArea.append(otherQuestions[currentQuestionIndex] + "\n"); // Mostra perguntas dos jogadores
            } else {
                int questionIndex = currentQuestionIndex - names.length; // Ajusta o índice para o array de perguntas
                textArea.append(questions[questionIndex] + "\n"); // Mostra perguntas do jogo
            }
            answerField.setEnabled(true); // Habilita o campo de resposta
            submitButton.setEnabled(true); // Habilita o botão de enviar
        }
    }
}