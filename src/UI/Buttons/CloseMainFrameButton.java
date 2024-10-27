package UI.Buttons;

import UI.Frames.MainFrame;

import javax.swing.*;
import java.awt.*;

public class CloseMainFrameButton extends JButton {

    public CloseMainFrameButton() {
        super("Sair");
        setPreferredSize(new Dimension(100, 50));
        setAction();
    }

    public CloseMainFrameButton(String title) {
        super(title);
        setPreferredSize(new Dimension(100, 50));
        setAction();
    }

    private void setAction(){
        this.addActionListener((e -> {
            MainFrame.getInstance().dispose();
        }));
    }

}
