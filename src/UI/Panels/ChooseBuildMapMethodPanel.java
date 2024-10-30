package UI.Panels;

import UI.Frames.MainFrame;
import essentials.Map;
import essentials.MapReader;

import javax.swing.*;
import java.awt.*;
import java.io.Serializable;

public class ChooseBuildMapMethodPanel extends JPanel implements Serializable {

    public ChooseBuildMapMethodPanel() {
        setLayout(new FlowLayout(FlowLayout.CENTER, 200, 275));
        setBackground(Color.darkGray);
        Font fontButton = new Font("Arial", Font.BOLD, 20);

        JButton createButton = new JButton("Criar novo mapa");
        createButton.setPreferredSize(new Dimension(400, 100));
        createButton.setFont(fontButton);
        createButton.addActionListener(e -> {
            MainFrame mainFrame = MainFrame.getInstance();
            mainFrame.setCurrentPanel(new CreateMapPanel());
        });

        add(createButton);

        JButton loadButton = new JButton("Carregar  configurações do mapa");
        loadButton.setPreferredSize(new Dimension(400, 100));
        loadButton.setFont(fontButton);
        loadButton.addActionListener((e -> {
            JFileChooser fileChooser = new JFileChooser();
            int returnValue = fileChooser.showOpenDialog(null);

        }));

        add(loadButton);

        revalidate();
        repaint();
    }
}
