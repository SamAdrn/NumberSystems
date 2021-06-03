package numberSystems;

/**
 * This class performs operations related to the Binary Number System (Base 2).
 *
 * @author Samuel Adrian Kosasih
 */
public class Binary {

    /**
     * Default Constructor
     */
    public Binary() {
    }

    /**
     * Converts the decimal number to Binary
     *
     * @param num the decimal to be converted
     * @return the conversion result in binary
     */
    public long convert(int num) {
        int power = 0;
        long result = 0;
        while (Math.pow(2, power) < num) {
            power++;
        }
        while (power >= 0) {
            while (Math.pow(2, power) <= num) {
                num -= Math.pow(2, power);
                result += Math.pow(10, power);
            }
            power--;
        }
        return result;
    }

    /**
     * Performs an AND bitwise operator action on two binary numbers (&)
     *
     * @param bin1 the first binary number
     * @param bin2 the second binary number
     * @return the result of the AND bitwise operator (bin1 & bin2)
     */
    public long bitwiseAnd(long bin1, long bin2) {
        long result = 0;
        int power = 0;
        while (bin1 > 0 && bin2 > 0) {
            if ((bin1 % 10) == 1 && (bin2 % 10) == 1) {
                result += Math.pow(10, power);
            }
            power++;
            bin1 /= 10;
            bin2 /= 10;
        }
        return result;
    }

    /**
     * Performs an OR bitwise operator action on two binary numbers (|)
     *
     * @param bin1 the first binary number
     * @param bin2 the second binary number
     * @return the result of the OR bitwise operator (bin1 | bin2)
     */
    public long bitwiseOr(long bin1, long bin2) {
        long result = 0;
        int power = 0;
        while (bin1 > 0 && bin2 > 0) {
            if ((bin1 % 10) == 1 || (bin2 % 10) == 1) {
                result += Math.pow(10, power);
            }
            power++;
            bin1 /= 10;
            bin2 /= 10;
        }
        if (bin1 != 0) {
            while (bin1 != 0) {
                if (bin1 % 10 == 1) {
                    result += Math.pow(10, power);
                }
                power++;
                bin1 /= 10;
            }
        } else {
            while (bin2 != 0) {
                if (bin2 % 10 == 1) {
                    result += Math.pow(10, power);
                }
                power++;
                bin2 /= 10;
            }
        }
        return result;
    }

    /**
     * Performs an XOR bitwise operator action on two binary numbers (^)
     *
     * @param bin1 the first binary number
     * @param bin2 the second binary number
     * @return the result of the XOR bitwise operator (bin1 ^ bin2)
     */
    public long bitwiseXor(long bin1, long bin2) {
        long result = 0;
        int power = 0;
        while (bin1 > 0 && bin2 > 0) {
            if (((bin1 % 10) == 1 && (bin2 % 10) == 0) || ((bin1 % 10) == 0 && (bin2 % 10) == 1)) {
                result += Math.pow(10, power);
            }
            power++;
            bin1 /= 10;
            bin2 /= 10;
        }
        if (bin1 != 0) {
            while (bin1 != 0) {
                if (bin1 % 10 == 1) {
                    result += Math.pow(10, power);
                }
                power++;
                bin1 /= 10;
            }
        } else {
            while (bin2 != 0) {
                if (bin2 % 10 == 1) {
                    result += Math.pow(10, power);
                }
                power++;
                bin2 /= 10;
            }
        }
        return result;
    }

    /**
     * Performs an Unsigned Right Shift operator action on a binary number (>>>).
     *
     * @param binary the binary number to be processed
     * @param places the number of places to be shifted
     * @return the result of the unsigned right shift operator
     */
    public long unRightShift(long binary, int places) {
        while (places != 0) {
            binary /= 10;
            places--;
        }
        return binary;
    }

}
