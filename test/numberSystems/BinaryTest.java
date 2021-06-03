package numberSystems;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Class used to test Binary.java
 *
 * @author Samuel Adrian Kosasih
 */
class BinaryTest {

    Binary binary;

    /**
     * Instantiates Binary object
     */
    @BeforeEach
    void setUp() {
        binary = new Binary();
    }

    /**
     * Convert positive integers to binary
     */
    @Test
    void convert() {
        //4 bits
        assertEquals(110, binary.convert(6));
        //8 bits
        assertEquals(1100100, binary.convert(100));
    }

    /**
     * Convert 1 to binary
     */
    @Test
    void convertOne() {
        assertEquals(1, binary.convert(1));
    }

    /**
     * Convert 0 to binary
     */
    @Test
    void convertZero() {
        assertEquals(0, binary.convert(0));
    }

    /**
     * Converts a negative number to binary. Should return -1.
     */
    @Test
    void convertNegNumber() {
        assertEquals(-1, binary.convert(-1000));
    }

    /**
     * Reverts binary to positive integers
     */
    @Test
    void revert() {
        //4 bits
        assertEquals(10, binary.revert(1010));
        //8 bits
        assertEquals(20, binary.revert(10100));
    }

    /**
     * Revert 1 (binary) to decimal
     */
    @Test
    void revertOne() {
        assertEquals(1, binary.revert(1));
    }

    /**
     * Revert 0 (binary) to decimal
     */
    @Test
    void revertZero() {
        assertEquals(0, binary.revert(0));
    }

    /**
     * Converts a negative number to binary. Should return -1.
     */
    @Test
    void revertNegNumber() {
        assertEquals(-1, binary.revert(-1000));
    }

    /**
     * Test bitwise AND (&) operation
     */
    @Test
    void bitwiseAnd() {
        //1111 & 1111
        assertEquals(1111, binary.bitwiseAnd(binary.convert(15), binary.convert(15)));
        //0110 & 1001
        assertEquals(0, binary.bitwiseAnd(binary.convert(6), binary.convert(9)));
        //1101 & 0101
        assertEquals(101, binary.bitwiseAnd(binary.convert(13), binary.convert(5)));
        //0110 1010 & 1001 0111
        assertEquals(10, binary.bitwiseAnd(binary.convert(106), binary.convert(151)));
    }

    /**
     * Test bitwise AND (&) operation with a negative number
     */
    @Test
    void bitwiseAndNegNumber() {
        assertEquals(-1, binary.bitwiseAnd(binary.convert(10), binary.convert(-1)));
        assertEquals(-1, binary.bitwiseAnd(binary.convert(-1), binary.convert(10)));
    }

    /**
     * Test bitwise OR (|) operation
     */
    @Test
    void bitwiseOr() {
        //1111 | 1111
        assertEquals(1111, binary.bitwiseOr(binary.convert(15), binary.convert(15)));
        //0110 | 1001
        assertEquals(1111, binary.bitwiseOr(binary.convert(6), binary.convert(9)));
        //1111 | 0000
        assertEquals(1111, binary.bitwiseOr(binary.convert(15), binary.convert(0)));
        //1101 | 0101
        assertEquals(1101, binary.bitwiseOr(binary.convert(13), binary.convert(5)));
        //0011 0101 | 1101 0111
        assertEquals(11110111, binary.bitwiseOr(binary.convert(53), binary.convert(215)));
    }

    /**
     * Test bitwise OR (|) operation with a negative number
     */
    @Test
    void bitwiseOrNegNumber() {
        assertEquals(-1, binary.bitwiseOr(binary.convert(10), binary.convert(-1)));
        assertEquals(-1, binary.bitwiseOr(binary.convert(-1), binary.convert(10)));
    }

    /**
     * Test bitwise XOR (^) operation
     */
    @Test
    void bitwiseXor() {
        //1111 ^ 1111
        assertEquals(0, binary.bitwiseXor(binary.convert(15), binary.convert(15)));
        //0110 ^ 1001
        assertEquals(1111, binary.bitwiseXor(binary.convert(6), binary.convert(9)));
        //1111 ^ 0000
        assertEquals(1111, binary.bitwiseXor(binary.convert(15), binary.convert(0)));
        //1101 ^ 0101
        assertEquals(1000, binary.bitwiseXor(binary.convert(13), binary.convert(5)));
        //0011 0101 ^ 1101 0111
        assertEquals(11100010, binary.bitwiseXor(binary.convert(53), binary.convert(215)));
    }

    /**
     * Test bitwise XOR (^) operation with a negative number
     */
    @Test
    void bitwiseXorNegNumber() {
        assertEquals(-1, binary.bitwiseXor(binary.convert(10), binary.convert(-1)));
        assertEquals(-1, binary.bitwiseXor(binary.convert(-1), binary.convert(10)));
    }

    /**
     * Test Unsigned Right Shift (>>>) operation
     */
    @Test
    void unRightShift() {
        //4 bits (1001 >>> 3)
        assertEquals(1, binary.unRightShift(binary.convert(9), 3));
        //8 bits (0111 1101 >>> 4)
        assertEquals(111, binary.unRightShift(binary.convert(125), 4));
    }

    /**
     * Test Unsigned Right Shift (>>>) operation
     */
    @Test
    void unRightShiftZero() {
        //0 >>> 10
        assertEquals(0, binary.unRightShift(binary.convert(0), 10));
    }

    /**
     * Test Unsigned Right Shift (>>>) operation
     */
    @Test
    void unRightShiftNegNumber() {
        assertEquals(-1, binary.unRightShift(binary.convert(-10), 3));
    }

}