package model.game;

import java.util.ArrayList;

public class Levels {
	public ArrayList<Level> levels;
	
	//Level
	public static class Level{
		public int[][] level;
		
		public Level(int[][] array) {
			this.level=array;
		}
	}
	//
	
	//Singleton
	private static Levels instance;
	public static Levels getInstance() {
		if(instance==null)
			instance = new Levels();
		return instance;
	}
	private Levels() {}
	//
	
	
	
	//DEBUG
	public void printTest() {
		levels.forEach(level ->{
			int[][] levelMatrix = level.level;
			for (int i = 0; i < levelMatrix.length; i++) {
                for (int j = 0; j < levelMatrix[i].length; j++) {
                    System.out.print(levelMatrix[i][j] + " ");
                }
                System.out.println();
            }
            System.out.println();
		});
	}

	
	

}


