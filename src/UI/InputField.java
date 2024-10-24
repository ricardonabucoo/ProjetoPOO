package UI;

import javax.swing.*;
import java.awt.*;

public class InputField extends JPanel {

    public InputField() {

        this.setLayout(new FlowLayout());
        // Criar o rótulo para "Idade"
        JLabel label = new JLabel("Idade:");

        // Criar a caixa de texto para inserir o número (ex: idade)
        JTextField textField = new JTextField(10); // tamanho 10 para o campo de texto
        Dimension textFieldDimension = new Dimension(0, 10);
        textField.setPreferredSize(textFieldDimension);
        // Adicionar os componentes ao painel
        this.add(label);
        this.add(textField);

    }

}
