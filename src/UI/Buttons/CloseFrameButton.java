package UI.Buttons;

import javax.swing.*;
import java.awt.*;

public class CloseFrameButton extends JButton {
    private final JFrame frame;

    public CloseFrameButton(JFrame frame) {
        super("Sair");
        this.frame = frame;
        setPreferredSize(new Dimension(100, 50));
        setCloseFrameAction();
    }

    public CloseFrameButton(JFrame frame, String title) {
        super(title);
        this.frame = frame;
        setPreferredSize(new Dimension(100, 50));
        setCloseFrameAction();
    }

    private void setCloseFrameAction(){
        this.addActionListener((e -> {
            this.frame.dispose();
        }));
    }

}
