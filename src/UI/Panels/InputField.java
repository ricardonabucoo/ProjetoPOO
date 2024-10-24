package UI.Panels;

import javax.swing.*;
import java.awt.*;

public class InputField extends JPanel {

    public InputField() {
        setLayout(new FlowLayout());
    }

    public InputField(JLabel label, JTextField textField) {

        setLayout(new FlowLayout());
        //Dimension textFieldDimension = new Dimension(100, 30);
        //textField.setPreferredSize(textFieldDimension);
        add(label);
        add(textField);
    }

}
