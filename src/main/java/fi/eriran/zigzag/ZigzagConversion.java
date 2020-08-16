package fi.eriran.zigzag;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this:
 * (you may want to display this pattern in a fixed font for better legibility)
 * <p>
 * P   A   H   N
 * A P L S I I G
 * Y   I   R
 * And then read line by line: "PAHNAPLSIIGYIR"
 * <p>
 * Write the code that will take a string and make this conversion given a number of rows:
 */
public class ZigzagConversion {
    public String convert(String string, int numberOfRows) {
        if (string == null || string.isEmpty()) {
            return "";
        }
        if (numberOfRows == 1) {
            return string;
        }

        return makeZigZag(string, numberOfRows);
    }

    private String makeZigZag(String string, int numberOfRows) {
        //Rows 3 pattern
        //0,4,8,12
        //1,3,5,7,9,11,13
        //2,6,10,

        //Rows 4 pattern
        //0,6,12
        //1,5,7,11,13
        //2,4,8,10
        //3,9
        Map<Integer, List<Character>> characterRows = new HashMap<>();
        int currentRow = 1;
        Direction currentDirection = Direction.DOWN;
        for (char currentCharacter : string.toCharArray()) {
            List<Character> rowCharacters = characterRows.computeIfAbsent(currentRow, ArrayList::new);
            rowCharacters.add(currentCharacter);
            if (currentDirection == Direction.DOWN) {
                if (currentRow == numberOfRows) {
                    currentDirection = Direction.UP;
                    currentRow--;
                } else {
                    currentRow++;
                }
            } else {
                if (currentRow == 1) {
                    currentDirection = Direction.DOWN;
                    currentRow++;
                } else {
                    currentRow--;
                }
            }
        }
        return buildCombinedString(characterRows, numberOfRows);
    }

    private String buildCombinedString(Map<Integer, List<Character>> characterRows, int numberOfRows) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 1; i <= numberOfRows; i++) {
            characterRows.get(i).forEach(stringBuilder::append);
        }
        return stringBuilder.toString();
    }

    enum Direction {
        UP, DOWN
    }
}
