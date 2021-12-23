package leetcode.problems.easy;

/**
 * https://leetcode.com/problems/add-binary/
 * 67. Add Binary
 *
 * Given two binary strings a and b, return their sum as a binary string.
 * Constraints:
 *
 * 1 <= a.length, b.length <= 104
 * a and b consist only of '0' or '1' characters.
 * Each string does not contain leading zeros except for the zero itself.
 */
public class Add_Binary_67 {

    public String addBinary0(String a, String b) {
        int aa = Integer.parseInt(a,2);
        int bb = Integer.parseInt(b,2);
        return Integer.toString(aa+bb, 2);
    }

    public String addBinary(String a, String b) {
        StringBuilder bBuilder = new StringBuilder(b);
        while (a.length() > bBuilder.length()) {
            bBuilder.insert(0, "0");
        }
        b = bBuilder.toString();
        StringBuilder aBuilder = new StringBuilder(a);
        while (b.length() > aBuilder.length()) {
            aBuilder.insert(0, "0");
        }
        a = aBuilder.toString();

        StringBuilder ret = new StringBuilder();

        int rem = 0;
        for (int i = a.length()-1; i >= 0 ; i--) {
          int d = a.charAt(i)-48 + b.charAt(i)-48 + rem;
          if (d > 1) {
              d-=2;
              rem = 1;
          } else {
              rem = 0;
          }
          ret.insert(0, d);
        }
        if (rem > 0)
            ret.insert(0, 1);
        return ret.toString();
    }

    public static void main(String[] args) {
        Add_Binary_67 a = new Add_Binary_67();
        System.out.println(a.addBinary("11", "1"));
        System.out.println(a.addBinary0("11", "1"));
    }
}
