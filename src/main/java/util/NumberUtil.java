package util;

public class NumberUtil {
    public boolean isPowerOf2(int n) {
        return n > 0 && Integer.bitCount(n) == 1;
    }
}
