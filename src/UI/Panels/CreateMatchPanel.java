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

        inputFields = new HashMap<>();
        matchBuilder = new MatchBuilder(mapBuilder, map);

        topPanel = createTopPanel();
        add(topPanel, BorderLayout.NORTH);

        leftPanel = createSidePanel("Player 1","Player1",1);
        add(leftPanel, BorderLayout.WEST);

        rightPanel = createSidePanel("Player 2", "Player2", 2);
        add(rightPanel, BorderLayout.EAST);


        centerPanel = map;
        add(centerPanel, BorderLayout.CENTER);

    }

    private JPanel createSidePanel(String title, String key, int paramter) {
        JPanel panel = createPlayerConfigPanel(title, key, paramter);
        panel.setBackground(Color.lightGray);
        panel.setPreferredSize(new Dimension(300, getHeight()));
        return panel;
    }

    private JPanel createTopPanel(){
        JPanel panel = new JPanel();
        panel.setBackground(Color.WHITE);

        JButton button = new JButton("Play");
        button.addActionListener(e -> {
            MainFrame mainFrame = MainFrame.getInstance();




            //mainFrame.setCurrentPanel(new GamePanel(new Match(map,player1,player2,passionFruitFactory)));
        });

        panel.add(button);
        return panel;
    }

    private JPanel createPlayerConfigPanel(String title, String key, int parameter) {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        addNewInputFieldToHashMap(panel,key);

        JPanel characterPanel = new JPanel();
        characterPanel.setBackground(Color.PINK);
        characterPanel.setPreferredSize(new Dimension(getWidth(),500));
        panel.add(characterPanel);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(0,2));
        JButton button1 = new JButton("Female");
        button1.addActionListener(e -> {
            ImageIcon imageIcon;
            if(parameter == 1){
                imageIcon = new ImageIcon("images/Female01.png");
            }
            else{
                imageIcon = new ImageIcon("images/Female02.png");
            }
            setImage(characterPanel, imageIcon);
        });
        buttonPanel.add(button1);
        JButton button2 = new JButton("Male");
        button2.addActionListener(e -> {
            ImageIcon imageIcon;
            if(parameter == 1){
                imageIcon = new ImageIcon("images/Male01.png");
            }
            else{
                imageIcon = new ImageIcon("images/Male02.png");
            }

            setImage(characterPanel, imageIcon);
        });
        buttonPanel.add(button2);
        panel.add(buttonPanel);
        
        return panel;
    }

    private void setImage(JPanel characterPanel, ImageIcon imageIcon) {
        if (imageIcon.getImageLoadStatus() == MediaTracker.COMPLETE)
            System.out.println("Imagem carregada com sucesso. (personagem)");
        else
            System.out.println("Erro ao carregar a imagem.");

        JLabel imageLabel = new JLabel(imageIcon);
        characterPanel.removeAll();
        characterPanel.add(imageLabel);
        characterPanel.revalidate();
        characterPanel.repaint();
    }

    private void addNewInputFieldToHashMap(JPanel panel, String key){
        InputField inputField = new InputField(new JLabel(), 20);
        panel.add(inputField);
        inputFields.put(key,inputField);
    }
    
    public Match getMatch() {
    	
    	return this.match;
    }

    public static void main(String[] args) {
        MainFrame mainFrame = MainFrame.getInstance();
        //mainFrame.setCurrentPanel(new CreateMatchPanel(new Map()));

    }

}
