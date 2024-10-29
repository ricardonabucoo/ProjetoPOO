package UI.Panels;

import essentials.Map;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.io.Serializable;

public class MapInfoPanel extends JPanel implements Serializable {

    private Map map;

    public MapInfoPanel(Map map) {

        this.map = map;

        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setBorder(
                BorderFactory.createTitledBorder(
                        BorderFactory.createLineBorder(Color.BLACK),
                        "Informações da célula",
                        TitledBorder.CENTER,
                        TitledBorder.TOP
                )
        );
        setBackground(Color.lightGray);
        setPreferredSize(new Dimension(300,500));


    }

}
