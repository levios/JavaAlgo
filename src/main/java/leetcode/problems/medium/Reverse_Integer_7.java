package leetcode.problems.medium;

/**
 * Given a signed 32-bit integer x, return x with its digits reversed.
 * If reversing x causes the value to go outside the signed 32-bit integer range [-231, 231 - 1], then return 0.
 * -2^31 <= x <= 2^31 - 1
 */
public class Reverse_Integer_7 {

    public int reverse(int x) {
        String s = String.valueOf(x);
        StringBuffer sbr;
        // To reverse the string
        if (s.startsWith("-")) {
            sbr = new StringBuffer(s.substring(1) + "-").reverse();
        } else {
            sbr = new StringBuffer(s).reverse();
        }

        try{
            return Integer.parseInt(sbr.toString());
        } catch (NumberFormatException ex) {
            return 0;
        }
    }

    public static void main(String[] args) {
        Reverse_Integer_7 app = new Reverse_Integer_7();
        System.out.println(app.reverse(123));
        System.out.println(app.reverse(-123));
        System.out.println(app.reverse(120));
        System.out.println(app.reverse(0));
        System.out.println(app.reverse(Integer.MAX_VALUE));
    }
}
