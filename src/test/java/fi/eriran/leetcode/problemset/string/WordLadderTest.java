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

    @Test
    void submissionTest1() {
        assertEquals(
                2,
                new WordLadder()
                        .ladderLength(
                                "a",
                                "c",
                                Arrays.asList("a","b","c")
                        )
        );
    }

    @Test
    void submissionTest2() {
        assertEquals(
                3,
                new WordLadder()
                        .ladderLength(
                                "hot",
                                "dog",
                                Arrays.asList("hot","dog","dot")
                        )
        );
    }

    @Test
    void submissionTest3() {
        assertEquals(
                3,
                new WordLadder()
                        .ladderLength(
                                "hot",
                                "dog",
                                Arrays.asList("hot","cog","dog","tot","hog","hop","pot","dot")
                        )
        );
    }

    @Test
    void submissionTest4() {
        assertEquals(
                3,
                new WordLadder()
                        .ladderLength(
                                "hot",
                                "dog",
                                Arrays.asList("hot","pot","dot","cog", "dog")
                        )
        );
    }

    @Test
    void submissionTest5() {
        assertEquals(
                4,
                new WordLadder()
                        .ladderLength(
                                "lost",
                                "miss",
                                Arrays.asList("most","mist","miss","lost","fist","fish")
                        )
        );
    }

    @Test
    void submissionTest6() {
        assertEquals(
                5,
                new WordLadder()
                        .ladderLength(
                                "hit",
                                "cog",
                                Arrays.asList("hit","dot","hot","dog", "cog")
                        )
        );
    }

    @Test
    void submissionTest7() {
        assertEquals(
                5,
                new WordLadder()
                        .ladderLength(
                                "qa",
                                "sq",
                                Arrays.asList("si","go","se","cm","so","ph","mt","db","mb","sb","kr","ln","tm","le","av","sm","ar","ci","ca","br","ti","ba","to","ra","fa","yo","ow","sn","ya","cr","po","fe","ho","ma","re","or","rn","au","ur","rh","sr","tc","lt","lo","as","fr","nb","yb","if","pb","ge","th","pm","rb","sh","co","ga","li","ha","hz","no","bi","di","hi","qa","pi","os","uh","wm","an","me","mo","na","la","st","er","sc","ne","mn","mi","am","ex","pt","io","be","fm","ta","tb","ni","mr","pa","he","lr","sq","ye")
                        )
        );
    }


}