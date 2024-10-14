package view.UI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


import javax.swing.ImageIcon;
import javax.swing.JButton;

import view.window.MainFrame;

@SuppressWarnings("serial")
public class Button extends JButton{
	
	 private ImageIcon normalBg,hoverBg,pressedBg;
	 private String normalBgPath = "src/resources/images/UI/buttons/btnNormal.png";
	 private String hoverlBgPath = "src/resources/images/UI/buttons/btnHover.png";
	 private String pressedBgPath = "src/resources/images/UI/buttons/btnPressed.png";
	 
	 private int btnWidth, btnHeight;
	 
	 public Button(String text) {
		 this.btnWidth = MainFrame.screenSize.width/7;
		 this.btnHeight = MainFrame.screenSize.height/11;
		 setPreferredSize(new Dimension(btnWidth, btnHeight));
		 
		 this.normalBg = resizeImage(normalBgPath);
		 this.hoverBg = resizeImage(hoverlBgPath);
		 this.pressedBg = resizeImage(pressedBgPath);
		 
		 setIcon(normalBg);
	     setRolloverIcon(hoverBg);
	     setPressedIcon(pressedBg); 
	     
	    
	     setBorderPainted(false);
	     setFocusPainted(false);
	     setContentAreaFilled(false);
	     
	     setText(text);
	     setHorizontalTextPosition(CENTER);  
	     setVerticalTextPosition(CENTER);    
	     setForeground(Color.WHITE);
	     setFont(new Font("Arcade Normal", Font.TRUETYPE_FONT, 20));
	     
	     addMouseListener(new MouseAdapter() {
	            @Override
	            public void mouseEntered(MouseEvent e) {
	                setIcon(hoverBg);
	            }

	            @Override
	            public void mouseExited(MouseEvent e) {
	                setIcon(normalBg);
	            }

	            @Override
	            public void mousePressed(MouseEvent e) {
	                setIcon(pressedBg);
	                switch(text) {
	                case "exit":
	                	System.exit(0);
	                default:
	                	break;
	                }
	            }

	            @Override
	            public void mouseReleased(MouseEvent e) {
	                setIcon(hoverBg);
	            }
	        }); 
	 }
	 
	 private ImageIcon resizeImage(String imagePath) {
        ImageIcon icon = new ImageIcon(imagePath);
        Image image = icon.getImage(); 
        Image scaledImage = image.getScaledInstance(btnWidth, btnHeight, Image.SCALE_SMOOTH);
        return new ImageIcon(scaledImage);
	 }
	 

}
