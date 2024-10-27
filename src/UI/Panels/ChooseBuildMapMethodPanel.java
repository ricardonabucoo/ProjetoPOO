package UI.Panels;

import UI.Buttons.CloseMainFrameButton;
import UI.Buttons.LoadFileButton;
import UI.Buttons.NewMatchButton;
import UI.Frames.MainFrame;

import javax.swing.*;
import java.awt.*;

public class ChooseBuildMapMethodPanel extends JPanel {

    public ChooseBuildMapMethodPanel() {
        setLayout(new FlowLayout(FlowLayout.CENTER, 50, 275));
        setBackground(Color.darkGray);

        JButton button = new JButton("Create map");
        button.setPreferredSize(new Dimension(100, 50));
        button.addActionListener(e -> {
            MainFrame mainFrame = MainFrame.getInstance();
            mainFrame.setCurrentPanel(new CreateMapPanel());
        });

        add(button);

        revalidate();
        repaint();
    }
}
