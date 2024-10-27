package UI.Buttons;

import UI.Frames.MainFrame;
import UI.Panels.ChooseBuildMapMethodPanel;
import UI.Panels.CreateMapPanel;

import javax.swing.*;
import java.awt.*;

public class NewMatchButton extends JButton {

    public NewMatchButton() {
        super("<html> Nova <br>Partida</html>");
        setPreferredSize(new Dimension(100, 50));

        this.addActionListener((e -> {
            MainFrame mainFrame = MainFrame.getInstance();
            mainFrame.setCurrentPanel(new ChooseBuildMapMethodPanel());
        }));
    }
}
