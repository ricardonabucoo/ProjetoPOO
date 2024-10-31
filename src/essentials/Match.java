package essentials;


import UI.Frames.MainFrame;
import UI.Panels.PlayerInfoPanel;
import elements.Player;

import java.io.*;
import java.io.IOException;
import javax.swing.*;
import java.awt.*;

public class Match extends JPanel implements Serializable {

    private MainFrame mainFrame;

    private JPanel gameBoard;
    private final Map map;
    private JPanel mapInfo;

    private final PlayerInfoPanel player1Info;
    private final PlayerInfoPanel player2Info;
    private PlayerInfoPanel currentPlayerInfo;

    private final Player player1;
    private final Player player2;
    private Player currentPlayer;
    private PassionFruitFactory passionFruitFactory;
    private int roundCount;

    public Match(Map map) {
        mainFrame = MainFrame.getInstance();
        this.map = map;
        player1 = map.getPlayerOne();
        player2 = map.getPlayerTwo();
        roundCount = 0;

        setLayout(new BorderLayout());
        setBackground(Color.decode("#008b8b"));
        mapInfo = map.getMapInfoPanel();
        player1Info = new PlayerInfoPanel(this,player1);
        add(player1Info, BorderLayout.EAST);
        player2Info = new PlayerInfoPanel(this,player2);
        add(mapInfo, BorderLayout.WEST);
        add(map, BorderLayout.CENTER);
        gameBoard = createGameBoard();
        add(gameBoard, BorderLayout.NORTH);

    }

    public void endTurn(Player player) {
        roundCount++;
        map.update();
        beginTurn(player);
    }

    public void beginTurn(Player player) {
        if(player == player1){
            currentPlayer = player2;
            currentPlayerInfo = player2Info;
        }
        else{
            currentPlayer = player1;
            currentPlayerInfo = player1Info;
        }
    }

    public Player getPlayerOne() {
    	return this.player1;
    }
    
    public Player getPlayerTwo() {
    	return this.player2;
    }

    public Map getMap() {
        return this.map;
    }

    public int getRoundCount() {
        return this.roundCount;
    }

    private JPanel createGameBoard() {
        JPanel gameBoard = new JPanel();
        gameBoard.setLayout(new GridLayout(0, 3));
        gameBoard.setBackground(Color.decode("#008b8b"));
        gameBoard.add(createPanel(player1));
        gameBoard.add(createCenterPanel());
        gameBoard.add(createPanel(player2));
        return gameBoard;
    }

    private JPanel createPanel(Player player) {
        JPanel panel = new JPanel(new FlowLayout(FlowLayout.CENTER,25,5));
        panel.setBackground(Color.lightGray);
        panel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.BLACK)));
        Font font = new Font("Arial", Font.BOLD, 18);
        JButton nameButton = new JButton("PLAYER: "+ player.getName());
        nameButton.setPreferredSize(new Dimension(250,100));
        nameButton.setFont(font);
        nameButton.setContentAreaFilled(false);
        nameButton.setOpaque(false);
        nameButton.setBorderPainted(false);
        panel.add(nameButton);
        JButton powerButton = new JButton("PODER: "+ player.getPower());
        powerButton.setPreferredSize(new Dimension(150,100));
        powerButton.setFont(font);
        powerButton.setContentAreaFilled(false);
        powerButton.setOpaque(false);
        powerButton.setBorderPainted(false);
        panel.add(powerButton);
        ImageIcon icon = new ImageIcon("images/passionfruit.png");
        JButton passionFruitButton = new JButton(Integer.toString(player.getBag().getPassionFruitAmount()), icon) ;
        passionFruitButton.setFont(font);
        passionFruitButton.setContentAreaFilled(false);
        passionFruitButton.setOpaque(false);
        passionFruitButton.setBorderPainted(false);
        panel.add(passionFruitButton);
        return panel;
    }

    private JPanel createCenterPanel() {
        JPanel panel = new JPanel(new FlowLayout(FlowLayout.CENTER,25,5));
        panel.setBackground(Color.lightGray);
        panel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.BLACK)));
        Font font = new Font("Arial", Font.BOLD, 20);
        JButton saveButton = new JButton("Salvar");
        saveButton.setPreferredSize(new Dimension(150,100));
        saveButton.setFont(font);
        saveButton.addActionListener(e -> {
            try {
                saveMatch("saved_match/match_data.ser");
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });
        panel.add(saveButton);
        JButton roundButton = new JButton("ROUND: "+ roundCount);
        roundButton.setPreferredSize(new Dimension(200,100));
        roundButton.setFont(font);
        roundButton.setContentAreaFilled(false);
        roundButton.setOpaque(false);
        roundButton.setBorderPainted(false);
        panel.add(roundButton);
        JButton closeButton = new JButton("Sair");
        closeButton.setPreferredSize(new Dimension(150,100));
        closeButton.setFont(font);
        closeButton.addActionListener(e -> {
           mainFrame.dispose();
        });
        panel.add(closeButton);
        return panel;
    }

    private void saveMatch (String fileName) throws IOException {
        try (FileOutputStream fileOut = new FileOutputStream(fileName);
             ObjectOutputStream objectOut = new ObjectOutputStream(fileOut)) {
            objectOut.writeObject(this);
            System.out.println("Objeto Match salvo com sucesso em " + fileName);
        } catch (IOException e) {
            System.err.println("Erro ao salvar o objeto Match: " + e.getMessage());
            e.printStackTrace();}
    }

    public void setMainFrame(MainFrame mainFrame) {
        this.mainFrame = mainFrame;
    }
}
