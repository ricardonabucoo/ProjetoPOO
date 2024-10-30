package UI.Panels;

import UI.Frames.MainFrame;
import essentials.Map;
import essentials.MapReader;

import javax.swing.*;
import java.awt.*;
import java.io.Serializable;

public class ChooseBuildMapMethodPanel extends JPanel implements Serializable {

    public ChooseBuildMapMethodPanel() {
        setLayout(new FlowLayout(FlowLayout.CENTER, 50, 275));
        setBackground(Color.darkGray);

        JButton createButton = new JButton("<html>Criar novo <br> mapa</html>");
        createButton.setPreferredSize(new Dimension(100, 50));
        createButton.addActionListener(e -> {
            MainFrame mainFrame = MainFrame.getInstance();
            mainFrame.setCurrentPanel(new CreateMapPanel());
        });

        add(createButton);

        JButton loadButton = new JButton("<html>Carregar <br> configurações <br> do mapa </html>");
        loadButton.setPreferredSize(new Dimension(100, 50));
        loadButton.addActionListener((e -> {
            JFileChooser fileChooser = new JFileChooser();
            int returnValue = fileChooser.showOpenDialog(null);

        }));

        add(loadButton);

        revalidate();
        repaint();
    }
}
