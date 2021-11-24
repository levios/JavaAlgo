package leetcode.problems.hard;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * 952. Largest Component Size by Common Factor
 * https://leetcode.com/problems/largest-component-size-by-common-factor/
 * Constraints:
 * 1 <= nums.length <= 2 * 10^4
 * 1 <= nums[i] <= 10^5
 * All the values of nums are unique.
 */
public class Largest_Component_by_Common_Factor_952 {

    // TLE
    public int largestComponentSize(int[] nums) {
        if (nums.length == 0 || nums.length == 1) return nums.length;
        long max = 0L;
        // init graph
        boolean[][] g = new boolean[nums.length][nums.length];
        for (int i = 0; i < nums.length; i++)
            for (int j = i+1; j < nums.length; j++)
                if (gcd(nums[i], nums[j]) > 1)
                    g[i][j] = g[j][i] = true;

        boolean[] visited0 = new boolean[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (!visited0[i]) { // it hasn't been visted yet by any previous dfs
                boolean[] visited = new boolean[nums.length];
                dfsUtil(g, i, visited);
                max = Math.max(max, count(visited, true));
                // merge the two arrays
                for (int j = 0; j < nums.length; j++) {
                    if (visited[j]) visited0[j] = true;
                }
                // optimization
                if (max >= count(visited0, false)) {
                    break;
                }
            }
        }
        return (int)max;
    }

    long count(boolean[] array, boolean b) {
        return IntStream.range(0, array.length).filter(idx -> array[idx] == b).count();
    }

    void dfsUtil(boolean[][] graph, int vertex, boolean[] visited) {
        visited[vertex] = true;
        List<Integer> neighbors = IntStream.range(0, graph.length)
                .filter(i -> graph[vertex][i])
                .boxed()
                .collect(Collectors.toList());
        for (int neighbor:  neighbors) {
            if (!visited[neighbor]) {
                dfsUtil(graph, neighbor, visited);
            }
        }
    }

    public int gcd(int a, int b) {
        if (b==0) return a;
        return gcd(b,a%b);
    }

    public static void main(String[] args) {
        Largest_Component_by_Common_Factor_952 app = new Largest_Component_by_Common_Factor_952();
        System.out.println(app.largestComponentSize(new int[]{4,6,15,35}));
        System.out.println(app.largestComponentSize(new int[]{20,50,9,63}));
        System.out.println(app.largestComponentSize(new int[]{2,3,6,7,4,12,21,39}));
        System.out.println(app.largestComponentSize(new int[]{}));
    }
}
