package UI.Panels;

import UI.Frames.MainFrame;
import essentials.Map;

import javax.swing.*;
import java.awt.*;
import java.io.Serializable;
import java.util.HashMap;

public class CreateMatchPanel extends JPanel implements Serializable {

    private Match match;
    private HashMap<String,InputField> inputFields;
    private JPanel topPanel;
    private JPanel leftPanel;
    private JPanel rightPanel;
    private JPanel centerPanel;

    private ImageIcon player1Male;
    private ImageIcon player1Female;
    private ImageIcon player2Male;
    private ImageIcon player2Female;



    public CreateMatchPanel(Map map) {
        setLayout(new BorderLayout());
        setBackground(Color.darkGray);

        match = new Match(map);

        inputFields = new HashMap<>();

        player1Female = new ImageIcon("images/Female01.png");
        player1Male = new ImageIcon("images/Male01.png");
        player2Female = new ImageIcon("images/Female02.png");
        player2Male = new ImageIcon("images/Male02.png");

        topPanel = createTopPanel();
        add(topPanel, BorderLayout.NORTH);

        leftPanel = createSidePanel("Player 1","Player1",1);
        add(leftPanel, BorderLayout.WEST);

        rightPanel = createSidePanel("Player 2", "Player2", 2);
        add(rightPanel, BorderLayout.EAST);

        centerPanel = map;
        add(centerPanel, BorderLayout.CENTER);

    }

    private JPanel createSidePanel(String title, String key, int parameter) {
        JPanel panel = createPlayerConfigPanel(title, key, parameter);
        panel.setBackground(Color.lightGray);
        panel.setPreferredSize(new Dimension(300, getHeight()));
        return panel;
    }

    private JPanel createTopPanel(){
        JPanel panel = new JPanel();
        panel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.BLACK)));
        JButton button = new JButton("PLAY");
        Font font = new Font("Arial", Font.BOLD, 20);
        button.setPreferredSize(new Dimension(200,50));
        button.setFont(font);
        button.addActionListener(e -> {
            MainFrame mainFrame = MainFrame.getInstance();

            Map map = match.getMap();
            map.getPlayerOne().setName(inputFields.get("Player1").getInput());
            map.getPlayerTwo().setName(inputFields.get("Player2").getInput());

            mainFrame.setCurrentPanel(new Match(map));
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
            if(parameter == 1){
                setImage(characterPanel, player1Female);
                match.getPlayerOne().setImage(player1Female);
            }
            else{
                setImage(characterPanel, player2Female);
                match.getPlayerTwo().setImage(player2Female);
            }

        });
        buttonPanel.add(button1);

        JButton button2 = new JButton("Male");
        button2.addActionListener(e -> {
            if(parameter == 1){
                setImage(characterPanel, player1Male);
                match.getPlayerOne().setImage(player1Male);
            }
            else{
                setImage(characterPanel, player2Male);
                match.getPlayerTwo().setImage(player2Male);
            }
        });
        buttonPanel.add(button2);

        ImageIcon imageIcon;
        if(parameter == 1){
            imageIcon = new ImageIcon("images/Female01.png");
        }
        else{
            imageIcon = new ImageIcon("images/Female02.png");
        }
        setImage(characterPanel, imageIcon);

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
        //mainFrame.setCurrentPanel(new CreateMatchPanel());

    }

}
