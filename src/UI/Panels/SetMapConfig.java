package UI.Panels;

import javax.swing.*;
import java.awt.*;
import java.io.Serializable;

public class SetMapConfig extends JPanel implements Serializable {

    public SetMapConfig() {

        setBackground(Color.decode("#008b8b"));
        setLayout(new FlowLayout(FlowLayout.CENTER, 50, 275));

        add(new InputField(new JLabel("Idade:")));
        add(new InputField(new JLabel("Idade:")));
        add(new InputField(new JLabel("Idade:")));
        add(new InputField(new JLabel("Idade:")));

    }
}
