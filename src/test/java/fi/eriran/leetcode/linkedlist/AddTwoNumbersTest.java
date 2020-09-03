package fi.eriran.leetcode.linkedlist;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AddTwoNumbersTest {

    private final ListNodeTestObjectGenerator testObjectGenerator;

    public AddTwoNumbersTest() {
        testObjectGenerator = new ListNodeTestObjectGenerator();
    }

    @Test
    void example1() {
        assertEquals(807,
                ListNodeUtil.getAsOneNumber(
                        new AddTwoNumbers().addTwoNumbers(
                                testObjectGenerator.create(2, 4, 3),
                                testObjectGenerator.create(5, 6, 4)
                        )
                )

        );
    }
}