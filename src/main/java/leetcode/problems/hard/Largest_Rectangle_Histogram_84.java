package leetcode.problems.hard;

import java.util.*;

/**
 * 84. Largest Rectangle in Histogram
 * https://leetcode.com/problems/largest-rectangle-in-histogram/
 */
public class Largest_Rectangle_Histogram_84 {

    public int largestRectangleArea(int[] heights) {

        Stack<Integer> s = new Stack<>();

        int max_area = 0; // Initialize max area

        // Run through all bars of given histogram
        int i = 0;

        while (i < heights.length)
        {
            // If this bar is higher than the bar on top stack, push it to stack
            if (s.empty() || heights[s.peek()] <= heights[i]) {
                s.push(i++);
            } else {
                // If this bar is lower than top of stack,
                // then calculate area of rectangle with stack top as the smallest (or minimum height) bar.
                // 'i' is 'right index' for the top and element before top in stack is 'left index'
                int top = s.pop();

                // Calculate the area with hist[top] stack
                // as smallest bar
                // update max area, if needed
                max_area = Math.max(
                        max_area,
                        heights[top] * (s.empty() ? i : i - s.peek() - 1)
                );
            }
        }

        // Now pop the remaining bars from stack and calculate area with every popped bar as the smallest bar
        while (!s.empty())
        {
            int top = s.pop();
            max_area = Math.max(
                    max_area,
                    heights[top] * (s.empty() ? i : i - s.peek() - 1)
            );
        }

        return max_area;
    }
}
