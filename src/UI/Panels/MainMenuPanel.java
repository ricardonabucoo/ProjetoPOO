package UI.Panels;

import UI.Buttons.CloseMainFrameButton;
import UI.Buttons.LoadFileButton;
import UI.Buttons.NewMatchButton;

import javax.swing.*;
import java.awt.*;

public class MainMenuPanel extends JPanel{

    public MainMenuPanel() {

        setBackground(Color.decode("#008b8b"));
        setLayout(new FlowLayout(FlowLayout.CENTER, 50, 275));

        add(new NewMatchButton());

        add(new LoadFileButton( "<html>Carregar<br> Partida</html>"));

        add(new CloseMainFrameButton("Sair"));

    }

}
