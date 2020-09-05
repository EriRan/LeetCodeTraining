package fi.eriran.leetcode.problemset.linkedlist;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AddTwoNumbersTest {

    private final ListNodeTestObjectGenerator testObjectGenerator;

    public AddTwoNumbersTest() {
        testObjectGenerator = new ListNodeTestObjectGenerator();
    }

    @Test
    void example1() {
        assertEquals(807,
                reverse(ListNodeUtil.getValuesAsOneString(
                        new AddTwoNumbers().addTwoNumbers(
                                testObjectGenerator.create(2, 4, 3),
                                testObjectGenerator.create(5, 6, 4)
                        )
                ))

        );
    }

    @Test
    void overflowCausesCreationOfNewListNode() {
        assertEquals(1110,
                reverse(ListNodeUtil.getValuesAsOneString(
                        new AddTwoNumbers().addTwoNumbers(
                                testObjectGenerator.create(9, 9, 9),
                                testObjectGenerator.create(1, 1, 1)
                        )
                ))

        );
    }

    private int reverse(String stringToReverse) {
        return Integer.parseInt(
                new StringBuilder(
                        String.valueOf(stringToReverse)
                ).reverse().toString()
        );
    }
}