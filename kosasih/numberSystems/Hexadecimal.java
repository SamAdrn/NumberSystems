package numberSystems;

/**
 * This class performs operations related to the Binary Number System (Base 16).
 *
 * @author Samuel Adrian Kosasih
 */
public class Hexadecimal {

    /**
     * Used for binary conversions
     */
    Binary binary = new Binary();

    /**
     * Default Constructor.
     */
    public Hexadecimal() {
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
        return convert(binary.convert(num));
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

}
