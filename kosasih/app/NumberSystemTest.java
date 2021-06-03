package app;

import numberSystems.Binary;
import numberSystems.Hexadecimal;

public class NumberSystemTest {

    private static final Binary binary = new Binary();
    private static final Hexadecimal hex = new Hexadecimal();

    public static void main(String[] args) {
        System.out.println("Binary:");
        System.out.println("100 in Binary = " + binary.convert(100));
        System.out.println("0 in Binary = " + binary.convert(0));
        System.out.println("AND: (0110 0100 & 0101 1010) = " + binary.bitwiseAnd(binary.convert(100), binary.convert(90)));
        System.out.println("OR: (0111 1101 0000 | 0101 1010) = " + binary.bitwiseOr(binary.convert(2000), binary.convert(90)));
        System.out.println("XOR: (1001 ^ 0110) = " + binary.bitwiseXor(binary.convert(9), binary.convert(6)));
        System.out.println("Unsigned Right Shift 4 (0111 1101 >>> 4) = " + binary.unRightShift(binary.convert(2000), 4));

        System.out.println();

        System.out.println("Hexadecimal:");
        System.out.println("9 in Hexadecimal = " + hex.convert(9));
        System.out.println("985 in Hexadecimal = " + hex.convert(985));
        System.out.println("0110 0100 in Hexadecimal = " + hex.convert(binary.convert(100)));
    }

}
