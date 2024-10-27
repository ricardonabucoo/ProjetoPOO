package UI.Panels;

import UI.Frames.MainFrame;
import builders.MapBuilder;
import builders.MatchBuilder;
import essentials.Map;
import essentials.Match;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.util.HashMap;

public class CreateMatchPanel extends JPanel {

    private MatchBuilder matchBuilder;
    private Match match;
    private HashMap<String,InputField> inputFields;
    private JPanel topPanel;
    private JPanel leftPanel;
    private JPanel rightPanel;
    private JPanel centerPanel;

    public CreateMatchPanel(MapBuilder mapBuilder, Map map) {
        setLayout(new BorderLayout());
        setBackground(Color.darkGray);

        matchBuilder = new MatchBuilder(mapBuilder, map);

        topPanel = new JPanel();
        topPanel.setBackground(Color.WHITE);

        JButton button = new JButton("Play");
        button.addActionListener(e -> {
           MainFrame mainFrame = MainFrame.getInstance();
           mainFrame.setCurrentPanel(new MainMenuPanel()); // new GamePanel()
        });

        topPanel.add(button);
        add(topPanel, BorderLayout.NORTH);

        centerPanel = map;
        add(centerPanel, BorderLayout.CENTER);

        inputFields = new HashMap<>();


        leftPanel = createPlayerConfigPanel("Player 1", "Player1");
        leftPanel.setBackground(Color.lightGray);
        leftPanel.setPreferredSize(new Dimension(300, getHeight()));
        add(leftPanel, BorderLayout.WEST);

        rightPanel = createPlayerConfigPanel("Player 2", "Player2");
        rightPanel.setBackground(Color.lightGray);
        rightPanel.setPreferredSize(new Dimension(300, getHeight()));
        add(rightPanel, BorderLayout.EAST);

    }

    private JPanel createPlayerConfigPanel(String title, String key) {
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3,1));
        panel.setBorder(
                BorderFactory.createTitledBorder(
                        BorderFactory.createLineBorder(Color.BLACK),
                        title,
                        TitledBorder.CENTER, TitledBorder.TOP
                ));
        addNewInputFieldToHashMap(panel,key);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(0,2));
        JButton button1 = new JButton("Female");
        button1.addActionListener(e -> {

        });
        buttonPanel.add(button1);
        JButton button2 = new JButton("Male");
        button2.addActionListener(e -> {

        });
        buttonPanel.add(button2);
        panel.add(buttonPanel);

        JPanel characterPanel = new JPanel();
        characterPanel.setBackground(Color.PINK);
        characterPanel.setPreferredSize(new Dimension(getWidth(),500));
        panel.add(characterPanel);

        return panel;
    }

    private void addNewInputFieldToHashMap(JPanel panel, String key){
        InputField inputField = new InputField(new JLabel(), 20);
        panel.add(inputField);
        inputFields.put(key,inputField);
    }

    public static void main(String[] args) {
        MainFrame mainFrame = MainFrame.getInstance();
        //mainFrame.setCurrentPanel(new CreateMatchPanel(new Map()));

    }

}
