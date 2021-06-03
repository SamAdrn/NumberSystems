package numberSystems;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Class used to test Hexadecimal.java
 *
 * @author Samuel Adrian Kosasih
 */
class HexadecimalTest {

    Hexadecimal hex;

    /**
     * Instantiates Binary object
     */
    @BeforeEach
    void setUp() {
        hex = new Hexadecimal();
    }

    /**
     * Convert positive integers to hexadecimal
     */
    @Test
    void convertDecimal() {
        assertEquals("A", hex.convert(10));
        assertEquals("55", hex.convert(85));
        assertEquals("BCD", hex.convert(3021));
    }

    /**
     * Convert negative decimal number
     */
    @Test
    void convertDecimalNegNumber() {
        assertEquals("", hex.convert(-1));
    }

    /**
     * Convert binary to hexadecimal
     */
    @Test
    void convertBinary() {
        assertEquals("F", hex.convert(1111L));
        assertEquals("55", hex.convert(1010101L));
        assertEquals("ADE", hex.convert(101011011110L));
    }

    /**
     * Convert negative binary number
     */
    @Test
    void convertBinaryNegNumber() {
        assertEquals("", hex.convert(-1010L));
    }

    /**
     * Convert binary to hexadecimal
     */
    @Test
    void convertZero() {
        assertEquals("0", hex.convert(0));
        assertEquals("0", hex.convert(0L));
    }

    /**
     * Revert alphabetical hexadecimals to decimal
     */
    @Test
    void revertToDecAlphabets() {
        //Uppercase
        assertEquals(10, hex.revertToDec("A"));
        assertEquals(3021, hex.revertToDec("BCD"));
        //Lowercase
        assertEquals(172, hex.revertToDec("ac"));
    }

    /**
     * Revert numerical hexadecimals to decimal
     */
    @Test
    void revertToDecNumerical() {
        assertEquals(152, hex.revertToDec("98"));
        assertEquals(6, hex.revertToDec("6"));
    }

    /**
     * Revert zero from hexadecimal
     */
    @Test
    void revertToDecZero() {
        assertEquals(0, hex.revertToDec("0"));
    }

    /**
     * Revert alphabetical hexadecimals to binary
     */
    @Test
    void revertToBinaryAlphabets() {
        //Uppercase
        assertEquals(1011L, hex.revertToBinary("B"));
        assertEquals(111011111010L, hex.revertToBinary("EFA"));
        //Lowercase
        assertEquals(10101100L, hex.revertToBinary("ac"));
    }

    /**
     * Revert numerical hexadecimals to decimal
     */
    @Test
    void revertToBinaryNumerical() {
        assertEquals(10011000L, hex.revertToBinary("98"));
        assertEquals(110L, hex.revertToBinary("6"));
    }

}