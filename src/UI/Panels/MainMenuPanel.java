package UI.Panels;

import UI.Buttons.CloseMainFrameButton;
import UI.Buttons.LoadFileButton;
import UI.Buttons.NewMatchButton;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.Serializable;

public class MainMenuPanel extends JPanel implements Serializable {
    private BufferedImage backgroundImage;

    public MainMenuPanel() {


        setBackground(new Color(0, 139, 139,0));
        setLayout(new FlowLayout(FlowLayout.CENTER, 100, 275));


        JLabel titleLabel = new JLabel("JOGO CATA-FRUTAS");
        Font font = new Font("Arial", Font.BOLD, 100);
        titleLabel.setFont(font);
        add(titleLabel);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 100, 20)); // Espaçamento para os botões

        Font fontButton = new Font("Arial", Font.BOLD, 20);

        NewMatchButton newMatchButton = new NewMatchButton();
        newMatchButton.setFont(fontButton);
        newMatchButton.setPreferredSize(new Dimension(200, 100));
        buttonPanel.add(newMatchButton);

        LoadFileButton loadFileButton = new LoadFileButton("<html>Carregar<br> Partida</html>");
        loadFileButton.setFont(fontButton);
        loadFileButton.setPreferredSize(new Dimension(200, 100));
        buttonPanel.add(loadFileButton);

        CloseMainFrameButton closeMainFrameButton = new CloseMainFrameButton("Sair");
        closeMainFrameButton.setFont(fontButton);
        closeMainFrameButton.setPreferredSize(new Dimension(200, 100));
        buttonPanel.add(closeMainFrameButton);

        add(buttonPanel);

    }

}
