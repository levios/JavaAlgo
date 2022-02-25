package leetcode.problems.medium;

/**
 * 1 <= k <= num.length <= 105
 */
public class Remove_K_Digits_402 {
    public String removeKdigits(String num, int k) {
        return removeKdigits(num, k, true);
    }
    public String removeKdigits(String num, int k, boolean first) {
        if (k <= 0) return num;
        if (num.length() == k) {
            if (first) {
                return "0";
            } else {
                return "";
            }
        }
        char[] head = num.substring(0, k+1).toCharArray();
        int minIdx = 0;
        for (int i = 1; i <= k; i++) {
            if (head[i] < head[minIdx]) {
                minIdx = i;
            }
        }
        if (first) {
            // remove leading zeros
            while (minIdx < num.length()-1 && num.charAt(minIdx) == '0') {
                minIdx++;
            }
        }
        return num.charAt(minIdx) + removeKdigits(num.substring(minIdx+1), k-minIdx, false);
    }

    public static void main(String[] args) {
        Remove_K_Digits_402 x = new Remove_K_Digits_402();
//        System.out.println(x.removeKdigits("10200", 1));
//        System.out.println(x.removeKdigits("112", 1));
        System.out.println(x.removeKdigits("10001", 4));

    }
}
