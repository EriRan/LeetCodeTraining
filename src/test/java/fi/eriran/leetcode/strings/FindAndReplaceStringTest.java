package fi.eriran.leetcode.strings;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FindAndReplaceStringTest {

    @Test
    void example1() {
        assertEquals(
                "eeebffff",
                new FindAndReplaceString()
                        .findReplaceString(
                                "abcd",
                                new int[]{0, 2},
                                new String[]{"a", "cd"},
                                new String[]{"eee", "ffff"}
                        )
        );
    }

    @Test
    void example2() {
        assertEquals(
                "eeecd",
                new FindAndReplaceString()
                        .findReplaceString(
                                "abcd",
                                new int[]{0, 2},
                                new String[]{"ab", "ec"},
                                new String[]{"eee", "ffff"}
                        )
        );
    }

    @Test
    void twoReplacesOneCommand() {
        assertEquals(
                "xxcoolxx",
                new FindAndReplaceString()
                        .findReplaceString(
                                "acoola",
                                new int[]{0},
                                new String[]{"a"},
                                new String[]{"xx"}
                        )
        );
    }
}