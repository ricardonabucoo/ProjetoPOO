package UI;

import UI.Buttons.CloseFrameButton;
import UI.Buttons.LoadFileButton;
import essentials.GameManager;

import javax.swing.*;
import java.awt.*;

public class MainMenu extends JPanel{
    private GameManager gm;

    public MainMenu(GameManager gm) {
        this.gm = gm;


        setBackground(Color.decode("#008b8b"));
        setLayout(new FlowLayout(FlowLayout.CENTER, 50, 275));

        Dimension btnDimension = new Dimension(100, 50);



//        JButton playBtn = new JButton("Jogar");
//        panel.add(playBtn);
//        playBtn.setPreferredSize(btnDimension);
//        playBtn.addActionListener((e -> {
//            new Quiz();
//            gm.dispose();
//        }));

        add(new LoadFileButton(gm, "Carregar Partida"));

        add(new CloseFrameButton(gm,"Sair"));


    }

}
