package UI;

import essentials.GameManager;

import javax.swing.*;
import java.awt.*;

public class MainMenu {
    private GameManager gm;

    public MainMenu(GameManager gm) {
        this.gm = gm;

        JFrame frame = new JFrame();
        frame.setBounds(50, 50, 700, 700);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setVisible(true);

        JPanel panel = new JPanel();
        frame.add(panel, BorderLayout.CENTER);
        panel.setBackground(Color.decode("#008b8b"));
        panel.setLayout(new FlowLayout(FlowLayout.CENTER, 50, 275));  // Ajuste do espaçamento vertical

        Dimension btnDimension = new Dimension(100, 50);

        JButton playBtn = new JButton("Jogar");
        panel.add(playBtn);
        playBtn.setPreferredSize(btnDimension);
        playBtn.addActionListener((e -> {
            new Quiz();
            frame.dispose();
        }));

        JButton loadBtn = new JButton("Carregar Mapa");
        panel.add(loadBtn);
        loadBtn.setPreferredSize(btnDimension);
        loadBtn.addActionListener((e -> {

            JFileChooser fileChooser = new JFileChooser();
            int returnValue = fileChooser.showOpenDialog(null);
            if (returnValue == JFileChooser.APPROVE_OPTION){
                gm.buildMapByFile(fileChooser.getSelectedFile());
                frame.dispose();
            }

        }));

        JButton exitBtn = new JButton("Sair");
        panel.add(exitBtn);
        exitBtn.setPreferredSize(btnDimension);
        exitBtn.addActionListener((e -> {
            frame.dispose();
        }));

    }

}
