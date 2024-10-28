package UI.Buttons;

import UI.Frames.MainFrame;

import javax.swing.*;
import java.awt.*;

public class LoadFileButton extends JButton {

    public LoadFileButton(String title) {
        super(title);
        setPreferredSize(new Dimension(100, 50));
        this.addActionListener((e -> {
            JFileChooser fileChooser = new JFileChooser();
            int returnValue = fileChooser.showOpenDialog(null);
            if (returnValue == JFileChooser.APPROVE_OPTION){
                // construa o mapa com essas caracteristicas
                //gm.buildMapByFile(fileChooser.getSelectedFile());
            }
        }));
    }
}
