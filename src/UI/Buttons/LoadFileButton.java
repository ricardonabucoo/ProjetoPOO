package UI.Buttons;

import UI.Frames.MainFrame;
import essentials.Match;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class LoadFileButton extends JButton {

    /*
    public LoadFileButton(String title) {
        super(title);
        setPreferredSize(new Dimension(100, 50));

        this.addActionListener((e -> {
            JFileChooser fileChooser = new JFileChooser();
            int returnValue = fileChooser.showOpenDialog(null);
            if (returnValue == JFileChooser.APPROVE_OPTION){
                File file = fileChooser.getSelectedFile();
                ObjectInputStream objectIn = new ObjectInputStream(file)) {
                match = (Match) objectIn.readObject();
                MainFrame mainFrame = MainFrame.getInstance();
                mainFrame.setCurrentPanel(match);
            }
        }));
    }
    */

    public LoadFileButton(String title) {
        super(title);
        setPreferredSize(new Dimension(100, 50));

        this.addActionListener((e -> {
            JFileChooser fileChooser = new JFileChooser();
            int returnValue = fileChooser.showOpenDialog(null);
            if (returnValue == JFileChooser.APPROVE_OPTION) {
                File file = fileChooser.getSelectedFile();
                try (ObjectInputStream objectIn = new ObjectInputStream(new FileInputStream(file))) {
                    Match match = null;
                    match = (Match) objectIn.readObject();
                    MainFrame mainFrame = MainFrame.getInstance();
                    mainFrame.setCurrentPanel(match);
                } catch (IOException ex) {
                    ex.printStackTrace(); // Trate a exceção conforme necessário
                } catch (ClassNotFoundException ex) {
                    ex.printStackTrace(); // Trate a exceção conforme necessário
                }
            }
        }));
    }

    private Match loadMatch (String fileName) throws IOException {
        Match match = null;
        try (FileInputStream fileIn = new FileInputStream(fileName);
             ObjectInputStream objectIn = new ObjectInputStream(fileIn)) {
            match = (Match) objectIn.readObject();
            System.out.println("Objeto Match carregado com sucesso!");

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            System.out.println("Erro ao carregar o arquivo.");
        }

        return match;
    }
}
