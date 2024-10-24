package UI.Buttons;

import UI.Panels.CreateWorldOptionsPanel;
import UI.Quiz;

import javax.swing.*;
import java.awt.*;

public class NewMatchButton extends JButton {
    private final JFrame frame;

    public NewMatchButton(JFrame frame, JPanel panel) {
        super("Nova Partida");
        this.frame = frame;
        setPreferredSize(new Dimension(100, 50));
        this.addActionListener((e -> {
            frame.remove(panel);
            frame.add(new CreateWorldOptionsPanel());
            frame.revalidate();
            frame.repaint();
        }));
    }
}
