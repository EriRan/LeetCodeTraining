package fi.eriran.leetcode.challenges.september;

/**
 * Two images A and B are given, represented as binary, square matrices of the same size.
 * (A binary matrix has only 0s and 1s as values.)
 * <p>
 * We translate one image however we choose (sliding it left, right, up, or down any number of units), and place it on
 * top of the other image.  After, the overlap of this translation is the number of positions that have a 1 in both
 * images.
 * <p>
 * (Note also that a translation does not include any kind of rotation.)
 * <p>
 * What is the largest possible overlap?
 *
 * UNFINISHED
 */
public class ImageOverlap {

    public int largestOverlap(int[][] array1, int[][] array2) {
        //Normal overlap
        //Move left 1,2
        //Move right 1,2
        //Move down 1,2
        //Also all combinations of left,right,down

        //Location starts at array1's lower right corner being over array2's upper left corner
        //array1 is moved to all possible overlap positions
        //array1[2][2], array2[0][0]
        //next when moved down: array1[2][1], [2][2]. array2[0][0], [0][1]
        int length = (array1.length * 2) - 1;
        for (int movesRight = 0; movesRight < length; movesRight++) {
            for (int movesDown = 0; movesDown < length; movesDown++) {

            }
        }
        return checkForFullOverlap(array1, array2);
    }

    private int checkForFullOverlap(int[][] array1, int[][] array2) {
        int overlaps = 0;
        for (int i = 0; i < array1.length; i++) {
            for (int j = 0; j < array1.length; j++) {
                if (array1[i][j] == 1 && array2[i][j] == 1) {
                    overlaps++;
                }
            }
        }
        return overlaps;
    }

}
