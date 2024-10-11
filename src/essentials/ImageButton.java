package essentials;

import javax.swing.*;
import java.awt.*;

public class ImageButton {
	//cria uma nova janela
		JFrame jframe = new JFrame();
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    frame.setSize(300, 200);
	    
	    ImageIcon image = new ImageIcon("caminhoparaimagem/imagem.png");
	    
	    //Botão criado com imagem
	    JButton button = new Button(image);
	    button.setText("Mensagem do botão");
	    
	    frame.getContentPane().setLayout(new FlowLayout());
        frame.getContentPane().add(button);

        frame.setVisible(true);	     
}
