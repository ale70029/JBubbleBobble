package view.window;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JLabel;
import javax.swing.JPanel;

import view.UI.Button;

@SuppressWarnings("serial")
public class MenuPanel extends JPanel{
	
	private static MenuPanel instance;
	
	public static MenuPanel getInstance() {
		if(instance == null) 
			instance = new MenuPanel();
		return instance;
	}
	
	private MenuPanel() {
		setLayout(new GridBagLayout());
		
    	GridBagConstraints gbc = new GridBagConstraints();
    	
      
    	JLabel title = new JLabel("<html><div align='center'>JBubble<br>Bobble</html>");
    	title.setFont(new Font("Arcade Interlaced", Font.TRUETYPE_FONT, MainFrame.screenSize.width/18));
    	title.setForeground(Color.WHITE);

        gbc.gridx = 0;
        gbc.gridy = GridBagConstraints.RELATIVE;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(10, 0, 10, 0);
        
        add(title,gbc);
        addButtons(gbc);
	}
	
	@Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(MainFrame.background, 0, 0, getWidth(), getHeight(), this);
    }

	
	private void addButtons(GridBagConstraints gbc) {
		Button continueBtn = new Button("continue");
		Button loadBtn = new Button("load");
		Button newGameBtn = new Button("new game");
		Button statsBtn = new Button("stats");
		Button creditsBtn = new Button("credits");
		Button exitBtn = new Button("exit");

		
		add(continueBtn,gbc);
		add(loadBtn,gbc);
		add(newGameBtn,gbc);
		add(statsBtn,gbc);
		add(creditsBtn,gbc);
		add(exitBtn,gbc);
		
		
		
	}
}
