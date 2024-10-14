package view.window;

import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;


@SuppressWarnings("serial")
public class MainFrame extends JFrame{
	
	public static Image background;
	public static Dimension screenSize;
	private String backgroundPath = "src/resources/images/UI/background.jpg";
	
  //SINGLETON
	private static MainFrame instance;
	
	public static MainFrame getInstance() {
		if(instance == null) 
			instance = new MainFrame();
		return instance;
	}
  //
	
    private MainFrame() {
      //Frame
    	JFrame frame = new JFrame("JBubbleBobble");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setUndecorated(true);
        frame.setResizable(false);

        GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice(); 
        if (gd.isFullScreenSupported()) 
        	gd.setFullScreenWindow(frame);
        else 
        	frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        
      //ScreenSize
        screenSize = Toolkit.getDefaultToolkit().getScreenSize();

      //Background
        background = new ImageIcon(backgroundPath).getImage();
        
      //Font
        loadFonts();
      //Cards Panel
        JPanel cardsPanel =  new JPanel(new CardLayout());
    	frame.add(cardsPanel);
    	
    	
    	cardsPanel.add(MenuPanel.getInstance());

    	frame.setVisible(true);
        
    }
    
    private void loadFonts() {
    	ArrayList<String> fonts= new ArrayList<String>();
    	fonts.add("src/resources/fonts/ARCADE_N.ttf"); // "Arcade Normal"
    	fonts.add("src/resources/fonts/ARCADE_I.ttf"); // "Arcade Interlaced"
    	
    	fonts.forEach(path -> {
            try {
                Font customFont = Font.createFont(Font.TRUETYPE_FONT, new File(path));
                GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
                ge.registerFont(customFont); 
            } catch (FontFormatException | IOException e) {
                e.printStackTrace();
            }
        });
    }
}

