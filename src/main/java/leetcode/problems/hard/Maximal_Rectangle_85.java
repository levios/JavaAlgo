package leetcode.problems.hard;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/maximal-rectangle/discuss/29054/Share-my-DP-solution
 * Tags: DP ; dynamic programmic
 */
class Maximal_Rectangle_85 {
    public int maximalRectangle(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) return 0;
        int m = matrix.length;
        int n = matrix[0].length;
        int maxArea = 0;
        // left[i] record the left most index j which satisfies that for any index k from j to  i, height[k] >= height[i]
        int[] left = new int[n];
        // right[i] record the right most index j which satisfies that for any index k from i to  j, height[k] >= height[i]
        int[] right = new int[n];
        int[] height = new int[n];
        Arrays.fill(right, n - 1);
        for (int i = 0; i < m; i++) {
            // the idea for updating the right boundary is similar, we just need to iterate from right to left
            int rB = n - 1;
            for (int j = n - 1; j >= 0; j--) {
                if (matrix[i][j] == '1') {
                    right[j] = Math.min(right[j], rB);
                } else {
                    right[j] = n - 1;
                    rB = j - 1;
                }
            }
            //lB is indicating the left boundary for the current row of the matrix (for cells with char "1"), not the height array...
            int lB = 0;
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == '1') {
                    // this means the current boundary should satisfy two conditions:
                    //  within the boundary of the previous height array,
                    //  and within the boundary of the current row
                    left[j] = Math.max(left[j], lB);
                    height[j]++;
                    maxArea = Math.max(maxArea, height[j] * (right[j] - left[j] + 1));
                } else {
                    height[j] = 0;
                    // when matrix[i][j] = 0, height[j] will get update to 0, so left[j] becomes 0,
                    // since all heights in between 0 - j satisfies the condition of height[k] >= height[j]
                    left[j] = 0;
                    // and since current position is '0', so the left most boundary for next "1" cell is at least j + 1
                    lB = j + 1;
                }
            }
        }
        return maxArea;
    }

}