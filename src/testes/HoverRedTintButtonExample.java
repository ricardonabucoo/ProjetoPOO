package testes;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Objects;
import javax.imageio.ImageIO;

public class HoverRedTintButtonExample {

    public static void main(String[] args) {
        JFrame frame = new JFrame("Botão com Imagem e Tonalidade Vermelha ao Passar o Mouse");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 200);

        JButton button = new JButton();

        try {
            // Carrega a imagem original
            BufferedImage originalImage = ImageIO.read(Objects.requireNonNull(HoverRedTintButtonExample.class.getResource("arvore.png")));

            // Cria a imagem com o filtro vermelho
            BufferedImage redTintImage = applyRedTint(originalImage);

            // Define a imagem padrão (sem o filtro) no botão
            button.setIcon(new ImageIcon(originalImage));

            // Adiciona o MouseListener para alterar a imagem ao passar o mouse
            button.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseEntered(MouseEvent e) {
                    button.setIcon(new ImageIcon(redTintImage)); // Imagem com tonalidade vermelha
                }

                @Override
                public void mouseExited(MouseEvent e) {
                    button.setIcon(new ImageIcon(originalImage)); // Imagem original
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Adiciona o botão ao frame
        frame.add(button);
        frame.setVisible(true);
    }

    // Método para aplicar o filtro de tonalidade vermelha na imagem
    public static BufferedImage applyRedTint(BufferedImage image) {
        BufferedImage tintedImage = new BufferedImage(image.getWidth(), image.getHeight(), BufferedImage.TYPE_INT_ARGB);

        for (int x = 0; x < image.getWidth(); x++) {
            for (int y = 0; y < image.getHeight(); y++) {
                Color originalColor = new Color(image.getRGB(x, y), true);
                int red = Math.min(255, (int) (originalColor.getRed() * 1.5));  // Aumenta a tonalidade vermelha
                int green = (int) (originalColor.getGreen() * 0.5);  // Reduz o verde
                int blue = (int) (originalColor.getBlue() * 0.5);    // Reduz o azul
                int alpha = originalColor.getAlpha();
                Color tintedColor = new Color(red, green, blue, alpha);
                tintedImage.setRGB(x, y, tintedColor.getRGB());
            }
        }
        return tintedImage;
    }
}

