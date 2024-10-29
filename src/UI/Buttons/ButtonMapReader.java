package UI.Buttons;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import essentials.*;
import elements.*;

public class ButtonMapReader extends JButton {
    private JButton loadFileButton;

    public ButtonMapReader() {
        setLayout(new FlowLayout()); // Definindo o layout do painel

        loadFileButton = new JButton("Carregar Configuração");
        loadFileButton.setPreferredSize(new Dimension(200, 50));

        loadFileButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                fileChooser.setDialogTitle("Selecione o arquivo de configuração");

                int userSelection = fileChooser.showOpenDialog(null);
                if (userSelection == JFileChooser.APPROVE_OPTION) {
                    File selectedFile = fileChooser.getSelectedFile();
                    MapReader mapReader = new MapReader(selectedFile);
                    // Aqui você pode usar os métodos get de MapReader para acessar os dados
                    int size = mapReader.getSize();
                    int rocksAmount = mapReader.getRocksAmount();
                    int bagCapacity = mapReader.getBagCapacity();
                    // Exiba os valores ou processe-os conforme necessário
                    JOptionPane.showMessageDialog(null, "Dimensão: " + size +
                            "\nQuantidade de Pedras: " + rocksAmount +
                            "\nCapacidade da Mochila: " + bagCapacity);
                }
            }
        });

        add(loadFileButton); // Adicionando o botão ao painel
    }
}
