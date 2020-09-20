package fi.eriran.leetcode.challenges.september;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ImageOverlapTest {

    @Test
    @Disabled
    void example1() {
        assertEquals(3, new ImageOverlap()
                .largestOverlap(
                        new int[][] {
                                {1,1,0},
                                {0,1,0},
                                {0,1,0},
                        },
                        new int[][] {
                                {0,0,0},
                                {0,1,1},
                                {0,0,1},
                        }
                ));
    }
}