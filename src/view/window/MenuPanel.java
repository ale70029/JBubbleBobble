package view.window;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

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
    	
    	// SPACER FOR TITLE
		JPanel spacer = new JPanel();
	    spacer.setPreferredSize(new Dimension(1, 100)); 
	    spacer.setBackground(new Color(0, 0, 0, 0));
	    gbc.gridx = 0;
	    gbc.gridy = 0;
	    gbc.weighty = 0; 
	    add(spacer, gbc);  

        gbc.gridx = 0;
        gbc.gridy = GridBagConstraints.RELATIVE;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(10, 0, 10, 0);
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
