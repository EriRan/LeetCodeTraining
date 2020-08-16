package fi.eriran.zigzag;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ZigzagConversionTest {

    /**
     * P   A   H   N
     * A P L S I I G
     * Y   I   R
     */
    @Test
    void example1() {
        assertEquals("PAHNAPLSIIGYIR", new ZigzagConversion().convert("PAYPALISHIRING", 3));
    }

    /**
     * Explanation:
     *
     * P     I    N
     * A   L S  I G
     * Y A   H R
     * P     I
     */
    @Test
    void example2() {
        assertEquals("PINALSIGYAHRPI", new ZigzagConversion().convert("PAYPALISHIRING", 4));
    }
}