package leetcode.problems.easy;

/**
 * https://leetcode.com/problems/roman-to-integer/
 * >>> EASY
 */
public class Roman_to_Integer_13 {

    public int romanToInt(String s) {
        int sum = 0;
        for (int i = s.length()-1; i >= 0; i--) {
            switch (s.charAt(i)) {
                case 'M':
                    sum += 1000;
                    break;
                case 'D':
                    sum += 500;
                    break;
                case 'L':
                    sum += 50;
                    break;
                case 'C':
                    sum += (sum >= 500) ? -100 : 100;
                    break;
                case 'X':
                    sum += (sum >= 50) ? -10 : 10;
                    break;
                case 'V':
                    sum += 5;
                    break;
                case 'I':
                    sum += (sum >= 5) ? -1 : 1;
                    break;
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        Roman_to_Integer_13 app = new Roman_to_Integer_13();
        System.out.println(app.romanToInt("III"));
        System.out.println(app.romanToInt("IV"));
        System.out.println(app.romanToInt("IX"));
        System.out.println(app.romanToInt("LVIII"));
        System.out.println(app.romanToInt("MCMXCIV"));
    }
}
