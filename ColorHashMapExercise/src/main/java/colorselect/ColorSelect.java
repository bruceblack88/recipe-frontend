/*
Color Change Exercise 1
Bruce Black
Liberty University
CSIS 505: Software Development
Dr. James Dollens
June 06, 2021
 */
package colorselect;

import java.awt.*;
import java.util.HashMap;

//create color class and hashmap
public class ColorSelect {

    private static HashMap<String, Color> colorHashMap = new HashMap<>();

    //13 color selection
    public ColorSelect() {

        colorHashMap.put("RED", Color.RED);
        colorHashMap.put("GREEN", Color.GREEN);
        colorHashMap.put("BLUE", Color.BLUE);
        colorHashMap.put("YELLOW", Color.YELLOW);
        colorHashMap.put("MAGENTA", Color.MAGENTA);
        colorHashMap.put("CYAN", Color.CYAN);
        colorHashMap.put("WHITE", Color.WHITE);
        colorHashMap.put("BLACK", Color.BLACK);
        colorHashMap.put("GRAY", Color.GRAY);
        colorHashMap.put("LIGHT_GRAY", Color.LIGHT_GRAY);
        colorHashMap.put("DARK_GRAY", Color.DARK_GRAY);
        colorHashMap.put("PINK", Color.PINK);
        colorHashMap.put("ORANGE", Color.ORANGE);

    }
    //get color 
    private String getName(Color color) {
        return color.getClass().getName();
    }
    //get full list of 13 colors
    public HashMap<String, Color> getAllColors() {
        return colorHashMap;
    }
}
