package controller.main;


import controller.filesController.LevelsLoader;
import model.game.Levels;
import view.window.MainFrame;


public class JBubbleBobble {
	
	public static void main(String[] args) {
		@SuppressWarnings("unused")
		
		//View Loading
		MainFrame mainFrame = MainFrame.getInstance();
		
		//Model Loading
		Levels levels = Levels.getInstance();
		levels.levels=LevelsLoader.loadFromJson();
		
		
		
		//DEBUG 
			//levels.printTest();
    }
}
