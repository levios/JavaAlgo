package leetcode.problems.medium;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/maximal-square/
 * 221. Maximal Square
 * very similar to {@link leetcode.problems.hard.Maximal_Rectangle_85}
 * Constraints:
 * m == matrix.length
 * n == matrix[i].length
 * 1 <= m, n <= 300
 * matrix[i][j] is '0' or '1'.
 */
public class Maximal_Square_221 {

    public int maximalSquare(char[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[] height = new int[n];
        int[] left = new int[n];
        int[] right = new int[n];
        Arrays.fill(right, n - 1);
        int area = 0;
        for (char[] chars : matrix) {

            // calculate left, right and height

            int rightMost = n-1;
            for (int j = n-1; j >= 0; j--) {
                if (chars[j] == '0') {
                    rightMost = j-1;
                    right[j] = n-1;
                } else {
                    right[j] = Math.min(rightMost, right[j]);
                }
            }

            int leftMost = 0;
            for (int j = 0; j < n; j++) {
                if (chars[j] == '0') {
                    height[j] = 0;
                    left[j] = 0;
                    leftMost = j + 1;
                } else {
                    height[j] += 1;
                    left[j] = Math.max(leftMost, left[j]);

                    // calculate area
                    int side = Math.min(right[j] - left[j] + 1, height[j]);
                    area = Math.max(area, side * side);
                }
            }
        }
        return area;
    }

    public static void main(String[] args) {
        Maximal_Square_221 m = new Maximal_Square_221();
        System.out.println(m.maximalSquare(new char[][]
                {{'0','1'}}
                ));
        System.out.println(m.maximalSquare(new char[][]{
                {'1','0','1','0','0'},
                {'1','0','1','1','1'},
                {'1','1','1','1','1'},
                {'1','0','0','1','0'}}));

        /*
            0   1   2   3   4
         H  1   0   1   0   0
         L  0   4   2   4   4
         R  0   0   2   0   0
         S  1   0   1   0   0

         H  2   0   2   1   1
         L  0   4   2   2   2
         R  0   0   4   4   4
         S  1   0

         H  3   1   3   2   2
         L
         R

         H  4   0   0   3   0
         L
         R
         */
    }

}
