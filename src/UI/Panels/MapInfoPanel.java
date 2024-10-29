package UI.Panels;

import essentials.Map;

import javax.swing.*;
import java.awt.*;
import java.io.Serializable;

public class MapInfoPanel extends JPanel implements Serializable {

    private Map map;

    public MapInfoPanel(Map map) {

        this.map = map;

        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setBackground(Color.black);

    }

}
