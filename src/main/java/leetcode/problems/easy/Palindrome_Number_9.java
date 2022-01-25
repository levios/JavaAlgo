package leetcode.problems.easy;

/**
 * https://leetcode.com/problems/palindrome-number/
 *
 * Given an integer x, return true if x is palindrome integer.
 * An integer is a palindrome when it reads the same backward as forward.
 * For example, 121 is palindrome while 123 is not.
 */
public class Palindrome_Number_9 {

    // -2,147,483,648 (-2^31) to 2,147,483,647 (2^31-1)
    public boolean isPalindrome(int x) {
        // When x < 0, x is not a palindrome.
        // Also if the last digit of the number is 0, in order to be a palindrome,
        // the first digit of the number also needs to be 0.
        // Only 0 satisfy this property.
        if (x < 0 || (x % 10 == 0 && x != 0)) return false;
        if (x == 0) return true;
        int[] a = new int[10];
        int idx = 0;
        while (x > 0) {
            int d = x % 10;
            a[idx++] = d;
            x /= 10;
        }
        idx--;
        for (int i = 0; i <= idx/2; i++) {
            if (a[i] != a[idx-i]) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Palindrome_Number_9 app = new Palindrome_Number_9();
        System.out.println(app.isPalindrome(121)); // true
        System.out.println(app.isPalindrome(-121)); // false
        System.out.println(app.isPalindrome(4224)); // true
        System.out.println(app.isPalindrome(4220)); // false
        System.out.println(app.isPalindrome(0)); // true
    }

}
