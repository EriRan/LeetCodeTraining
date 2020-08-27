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

    //My output was: "jjievdteb"
    @Test
    void submissionTest1() {
        assertEquals(
                "jjievdtjfb",
                new FindAndReplaceString()
                        .findReplaceString(
                                "jjievdtjfb",
                                new int[]{4,6,1},
                                new String[]{"md","tjgb","jf"},
                                new String[]{"foe","oov","e"}
                        )
        );
    }
}