package UI.Panels;

import UI.Buttons.CloseMainFrameButton;
import UI.Buttons.LoadFileButton;
import UI.Buttons.NewMatchButton;
import UI.Frames.MainFrame;
import builders.MapBuilder;
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
            if (returnValue == JFileChooser.APPROVE_OPTION){
                MapReader mapReader = new MapReader(fileChooser.getSelectedFile());
                MapBuilder mapBuilder = new MapBuilder();
                mapBuilder.buildMap(
                        mapReader.getSize(),
                        mapReader.getRocksAmount(),
                        mapReader.getNumberOfTrees(),
                        mapReader.getInitialFruitsNumber(),
                        mapReader.getMaxPassionFruitAmount(),
                        mapReader.getBagCapacity()
                                );
                Map map = mapBuilder.getResult();
                MainFrame mainFrame = MainFrame.getInstance();
                mainFrame.setCurrentPanel(new CreateMatchPanel(mapBuilder,map));
            }
        }));

        add(loadButton);

        revalidate();
        repaint();
    }
}
