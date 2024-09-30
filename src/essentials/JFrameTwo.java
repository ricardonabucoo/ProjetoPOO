package essentials;

import java.awt.*;
import javax.swing.*;

public class JFrameTwo {
    
    public JFrameTwo() {
        initialize();
    }

    public void initialize() {
        JFrame frame = new JFrame();
        frame.setTitle("CataFrutas");

        JPanel panel = new JPanel(new GridLayout(4, 1, 1, 1));
        GridBackgroundPanel background = new GridBackgroundPanel(10, 10);

        frame.setLayout(new BorderLayout(10, 5));
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(554, 500);
        frame.setLocationRelativeTo(null);
        
        panel.setBackground(Color.DARK_GRAY);

        frame.add(panel, BorderLayout.EAST);
        frame.add(background, BorderLayout.CENTER);
        
        for (int i = 1; i <= 4; i++) {
            JButton button;
            if (i == 1)
                button = new JButton("North");
            else if (i == 2)
                button = new JButton("South");
            else if (i == 3)
                button = new JButton("West");
            else
                button = new JButton("East");
            panel.add(button);
        }
        
        frame.setVisible(true);
    }
    
    

}