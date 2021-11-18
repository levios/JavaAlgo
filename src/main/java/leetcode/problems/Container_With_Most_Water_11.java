package leetcode.problems;

/**
 * https://leetcode.com/problems/container-with-most-water/
 * each represents a point at coordinate (i, ai)#
 *
 */
public class Container_With_Most_Water_11 {

    // Time: O(n)
    public int maxArea(int[] height) {
        int max = 0;
        int start = 0;
        int end = height.length-1;
        while (start < end) {
            max = Math.max(max, area(height, start, end));
            if (height[start] < height[end]) {
                ++start;
            } else {
                --end;
            }
        }
        return max;
    }

    int area(int[] height, int start, int end) {
        int x = end - start;
        int y = Math.min(height[end], height[start]);
        return x * y;
    }

    public static void main(String[] args) {
        Container_With_Most_Water_11 app = new Container_With_Most_Water_11();
        System.out.println(app.maxArea(new int[]{2,3,4,5,18,17,6})); // 17
        System.out.println(app.maxArea(new int[]{1,8,6,2,5,4,8,25,7})); // 49
        System.out.println(app.maxArea(new int[]{1,1})); // 1
        System.out.println(app.maxArea(new int[]{4,3,2,1,4})); // 16
        System.out.println(app.maxArea(new int[]{1,2,1})); // 2
        System.out.println(app.maxArea(new int[]{0,2})); // 0
    }
}
