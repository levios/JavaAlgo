package leetcode.problems.medium;

import scala.Int;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * https://leetcode.com/problems/all-paths-from-source-to-target/
 * 797. All Paths From Source to Target
 *
 * Given a directed acyclic graph (DAG) of n nodes labeled from 0 to n - 1, find all possible
 * paths from node 0 to node n - 1 and return them in any order.
 *
 * The graph is given as follows: graph[i] is a list of all nodes you can visit
 * from node i (i.e., there is a directed edge from node i to node graph[i][j]).
 */
public class Paths_From_Source_To_Target_797 {
    /**
     * @param graph n x n 2D array
     *
     * Runtime: 3 ms, faster than 62.13%
     * Memory Usage: 43 MB, less than 34.39%
     */
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        int n = graph.length;
        List<List<Integer>> res = new LinkedList<>();
        boolean[] visited = new boolean[n];
        visited[0] = true;
        LinkedList<Integer> current = new LinkedList<>();
        current.add(0);
        dfs(0, graph, visited, current, res);
        return res;
    }

    private void dfs(int i, int[][] graph, boolean[] visited, List<Integer> current, List<List<Integer>> res) {
        for (int v : graph[i]) {
            if (!visited[v]) {
                current.add(v);
                if (v == graph.length-1) {
                    res.add(new LinkedList<>(current));
                } else {
                    visited[v] = true;
                    dfs(v, graph, visited, current, res);
                }

                // backtrack
                current.remove(current.size()-1);
                visited[v] = false;
            }
        }
    }

    public static void main(String[] args) {
        Paths_From_Source_To_Target_797 app = new Paths_From_Source_To_Target_797();
        System.out.println(app.allPathsSourceTarget(new int[][]{{1,2},{3},{3},{}}));
        System.out.println(app.allPathsSourceTarget(new int[][]{{4,3,1},{3,2,4},{3},{4},{}}));
        System.out.println(app.allPathsSourceTarget(new int[][]{{1},{}}));
        System.out.println(app.allPathsSourceTarget(new int[][]{{1,2,3},{2},{3},{}}));
        System.out.println(app.allPathsSourceTarget(new int[][]{{1,3},{2},{3},{}}));
    }
}
