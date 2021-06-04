package numberSystems;

import java.util.HashMap;

/**
 * This class performs operations related to the Binary Number System (Base 16).
 *
 * @author Samuel Adrian Kosasih
 */
public class Hexadecimal {

    /**
     * Used to store every possible type of binary to hex conversion
     */
    HashMap<Character, String> binaryMap = new HashMap<>();

    /**
     * Default Constructor. Fills binaryMap.
     */
    public Hexadecimal() {
        createBinaryMap();
    }

    /**
     * Converts the decimal number to Hexadecimal form
     *
     * @param num the decimal to be converted
     * @return the conversion result in hexadecimal
     */
    public String convert(int num) {
        if (num < 0) {
            return "";
        }
        if (num == 0) {
            return "0";
        }
        StringBuilder result = new StringBuilder();
        while (num != 0) {
            result.insert(0, findBase15(num % 16));
            num /= 16;
        }
        return result.toString();
    }

    /**
     * Converts the binary number to Hexadecimal form
     *
     * @param binary the binary to be converted
     * @return the conversion result in hexadecimal
     */
    public String convert(long binary) {
        if (binary < 0) {
            return "";
        }
        if (binary == 0) {
            return "0";
        }
        String bin = Long.toString(binary);
        StringBuilder result = new StringBuilder();
        while (!bin.equals("")) {
            int start = bin.length() < 4 ? 0 : bin.length() - 4;
            String temp = bin.substring(start);
            int total = 0;
            for (int i = 0; i < temp.length(); i++) {
                if (temp.charAt(i) == '1') {
                    total += Math.pow(2, (temp.length() - 1) - i);
                }
            }
            result.insert(0, findBase15(total));
            bin = bin.substring(0, start);
        }
        return result.toString();
    }

    /**
     * Reverts the hexadecimal to decimal
     *
     * @param hex the hexadecimal to be reverted
     * @return the reverted decimal number
     */
    public int revertToDec(String hex) {
        try {
            if (hex.equals("0")) {
                return 0;
            }
            hex = hex.toUpperCase();
            int result = 0;
            for (int i = 0; i < hex.length(); i++) {
                result += findDec(hex.charAt(i)) * Math.pow(16, (hex.length() - 1) - i);
            }
            return result;
        } catch (NumberFormatException nfe) {
            return -1;
        }
    }

    /**
     * Reverts the hexadecimal to binary
     *
     * @param hex the hexadecimal to be reverted
     * @return the reverted binary number
     */
    public long revertToBinary(String hex) {
        try {
            if (hex.equals("0")) {
                return 0;
            }
            hex = hex.toUpperCase();
            StringBuilder result = new StringBuilder();
            for (int i = 0; i < hex.length(); i++) {
                result.append(binaryMap.get(hex.charAt(i)));
            }
            return Long.parseLong(result.toString());
        } catch (NumberFormatException nfe) {
            return -1;
        }
    }

    /**
     * Finds the hex of a digit.
     *
     * @param num the single digit value to be converted
     * @return a hex value
     */
    private String findBase15(int num) {
        switch (num) {
            case 10:
                return "A";
            case 11:
                return "B";
            case 12:
                return "C";
            case 13:
                return "D";
            case 14:
                return "E";
            case 15:
                return "F";
            default:
                return Integer.toString(num);
        }
    }

    /**
     * Finds the positive integer of a hex.
     *
     * @param hex the hex value to be converted
     * @return a positive integer
     */
    private int findDec(char hex) {
        switch (hex) {
            case 'A':
                return 10;
            case 'B':
                return 11;
            case 'C':
                return 12;
            case 'D':
                return 13;
            case 'E':
                return 14;
            case 'F':
                return 15;
            default:
                return Integer.parseInt(Character.toString(hex));
        }
    }

    /**
     * Fills binary map with every possible hex to binary conversion
     */
    private void createBinaryMap() {
        binaryMap.put('0', "0000");
        binaryMap.put('1', "0001");
        binaryMap.put('2', "0010");
        binaryMap.put('3', "0011");
        binaryMap.put('4', "0100");
        binaryMap.put('5', "0101");
        binaryMap.put('6', "0110");
        binaryMap.put('7', "0111");
        binaryMap.put('8', "1000");
        binaryMap.put('9', "1001");
        binaryMap.put('A', "1010");
        binaryMap.put('B', "1011");
        binaryMap.put('C', "1100");
        binaryMap.put('D', "1101");
        binaryMap.put('E', "1110");
        binaryMap.put('F', "1111");
    }

}
