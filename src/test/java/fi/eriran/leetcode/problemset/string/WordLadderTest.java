package fi.eriran.leetcode.problemset.string;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class WordLadderTest {

    @Test
    void example1() {
        assertEquals(
                5,
                new WordLadder()
                        .ladderLength(
                                "hit",
                                "cog",
                                Arrays.asList("hot","dot","dog","lot","log","cog")
                        )
                );
    }

    @Test
    void example2() {
        assertEquals(
                0,
                new WordLadder()
                        .ladderLength(
                                "hit",
                                "cog",
                                Arrays.asList("hot","dot","dog","lot","log")
                        )
        );
    }
}