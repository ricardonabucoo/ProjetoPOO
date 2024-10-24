package UI;

import UI.Buttons.CloseFrameButton;
import UI.Buttons.LoadFileButton;
import UI.Buttons.NewMatchButton;
import essentials.GameManager;

import javax.swing.*;
import java.awt.*;

public class MainMenu extends JPanel{
    private GameManager gm;

    public MainMenu(GameManager gm) {
        this.gm = gm;
        setBackground(Color.decode("#008b8b"));
        setLayout(new FlowLayout(FlowLayout.CENTER, 50, 275));

        add(new NewMatchButton(gm,this));

//        JButton playBtn = new JButton("Jogar");
//        panel.add(playBtn);
//        playBtn.setPreferredSize(btnDimension);
//        playBtn.addActionListener((e -> {
//            new Quiz();
//            gm.dispose();
//        }));

        add(new LoadFileButton(gm, "<html>Carregar<br> Partida</html>"));

        add(new CloseFrameButton(gm,"Sair"));


    }

}
