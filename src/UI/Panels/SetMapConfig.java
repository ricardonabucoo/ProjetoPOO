package UI.Panels;

import javax.swing.*;
import java.awt.*;

public class SetMapConfig extends JPanel {

    public SetMapConfig() {

        setBackground(Color.decode("#008b8b"));
        setLayout(new FlowLayout(FlowLayout.CENTER, 50, 275));

        add(new InputField(new JLabel("Idade:")));
        add(new InputField(new JLabel("Idade:")));
        add(new InputField(new JLabel("Idade:")));
        add(new InputField(new JLabel("Idade:")));

    }
}
