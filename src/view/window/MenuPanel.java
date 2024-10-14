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
        gbc.gridx = 0;
        gbc.gridy = GridBagConstraints.RELATIVE;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(10, 0, 10, 0);
        
        addTitle(gbc);
        addButtons(gbc);
	}
	
	private void addTitle(GridBagConstraints gbc) {
		JLabel title = new JLabel("<html><div align='center'>JBubble<br>Bobble</html>");
    	title.setFont(new Font("Arcade Interlaced", Font.TRUETYPE_FONT, MainFrame.screenSize.width/15));
    	title.setForeground(Color.WHITE);
    	add(title,gbc);
	}

	
	private void addButtons(GridBagConstraints gbc) {
		Button continueBtn = new Button("continue");
		add(continueBtn,gbc);
		
		Button loadBtn = new Button("load");
		add(loadBtn,gbc);
		
		Button newGameBtn = new Button("new game");
		add(newGameBtn,gbc);
		
		Button statsBtn = new Button("stats");
		add(statsBtn,gbc);
		
		Button creditsBtn = new Button("credits");
		add(creditsBtn,gbc);
		
		Button exitBtn = new Button("exit");
		add(exitBtn,gbc);
		
		newGameBtn.requestFocusInWindow();
	}
	
	@Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(MainFrame.background, 0, 0, getWidth(), getHeight(), this);
    }

}
