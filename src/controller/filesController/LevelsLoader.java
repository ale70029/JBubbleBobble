package controller.filesController;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.json.JSONArray;
import org.json.JSONObject;

import model.game.Levels.Level;

public class LevelsLoader {

	public static ArrayList<Level> loadFromJson() {
		ArrayList<Level> levelsArray = new ArrayList<>();
		
		//reading file
		String filePath = "src/resources/files/levels.json";
        StringBuilder jsonContent = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                jsonContent.append(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        JSONObject jsonObject = new JSONObject(jsonContent.toString());
        JSONObject levelsObject = jsonObject.getJSONObject("levels");
        Iterator<String> levels = levelsObject.keys();

        //reading all levels
        while (levels.hasNext()) {
            String levelKey = levels.next();
            JSONArray levelArray = levelsObject.getJSONArray(levelKey);
            int[][] levelMatrix = new int[levelArray.length()][];
 
            //reading one level
            for (int i = 0; i < levelArray.length(); i++) {
                JSONArray row = levelArray.getJSONArray(i);
                levelMatrix[i] = new int[row.length()];
                for (int j = 0; j < row.length(); j++) {
                	 levelMatrix[i][j] = row.getInt(j);
                }
            }
            
            Level level = new Level(levelMatrix);
            levelsArray.add(level); 
        }
        
        return levelsArray;
    }	
}
