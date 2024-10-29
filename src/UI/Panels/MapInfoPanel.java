package UI.Panels;

import essentials.Map;

import javax.swing.*;
import java.awt.*;

public class MapInfoPanel extends JPanel {

    private Map map;

    public MapInfoPanel(Map map) {

        this.map = map;

        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setBackground(Color.black);

    }

}
