package UI.Panels;

import javax.swing.*;
import java.awt.*;
import java.io.Serializable;

public class InputField extends JPanel implements Serializable {
    private JTextField field;

    public InputField() {
        setLayout(new FlowLayout());
    }

    public InputField(JLabel label) {
        field = new JTextField("0",4);
        setLayout(new FlowLayout());
        //Dimension textFieldDimension = new Dimension(100, 30);
        //textField.setPreferredSize(textFieldDimension);
        add(label);
        add(field);
    }

    public InputField(JLabel label, int size) {
        field = new JTextField("nome",size);
        setLayout(new FlowLayout());
        add(label);
        add(field);
    }

    public String getInput() {
        return field.getText();
    }

    public int getInputAsInt() {
        try {
            return Integer.parseInt(field.getText());
        }
        catch (NumberFormatException e) {
            System.err.println("Valor inválido, não é um número inteiro");
            return 0; // valor padrao
        }
    }
}
