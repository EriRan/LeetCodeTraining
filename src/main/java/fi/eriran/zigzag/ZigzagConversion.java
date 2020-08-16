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
        if (numberOfRows == 1 || string.length() <= numberOfRows) {
            return string;
        }
        return makeZigZag(string, numberOfRows);
    }

    private String makeZigZag(String string, int numberOfRows) {
        Map<Integer, List<Character>> characterRows = createInitializedMap(numberOfRows);
        createRows(string, numberOfRows, characterRows);
        return buildCombinedString(characterRows, numberOfRows);
    }

    private void createRows(String string, int numberOfRows, Map<Integer, List<Character>> characterRows) {
        int currentRow = 1;
        int incrementValue = 1;
        for (char currentCharacter : string.toCharArray()) {
            characterRows
                    .get(currentRow)
                    .add(currentCharacter);
            incrementValue = deduceIncrementDirection(numberOfRows, currentRow, incrementValue);
            currentRow += incrementValue;
        }
    }

    private Map<Integer, List<Character>> createInitializedMap(int numberOfRows) {
        Map<Integer, List<Character>> characterRowMap = new HashMap<>();
        for (int i = 1; i <= numberOfRows; i++) {
            characterRowMap.put(i, new ArrayList<>());
        }
        return characterRowMap;
    }

    private int deduceIncrementDirection(int numberOfRows, int currentRow, int incrementValue) {
        if (currentRow == numberOfRows) {
            incrementValue = -1;
        } else if (currentRow == 1) {
            incrementValue = 1;
        }
        return incrementValue;
    }

    private String buildCombinedString(Map<Integer, List<Character>> characterRows, int numberOfRows) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 1; i <= numberOfRows; i++) {
            characterRows.get(i).forEach(stringBuilder::append);
        }
        return stringBuilder.toString();
    }
}
