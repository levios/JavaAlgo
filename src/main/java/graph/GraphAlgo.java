package graph;

import java.util.*;

/**
 * For a given source node in the graph, the algo finds the shortest path between that node and every other.
 */
public class GraphAlgo {
    // https://www.geeksforgeeks.org/dijkstras-shortest-path-algorithm-greedy-algo-7/
    public static int[] dijkstra(int[][] weights, int start) {
        int[] distances = new int[weights.length];
        distances[start] = 0;

        // shortest-path tree
        // sptSet[i] == true if vertex i is included in shortest path tree or shortest distance from src to i is finalized
        boolean[] spTree = new boolean[weights.length];

        for (int i = 1; i < weights.length; i++) {
            distances[i] = Integer.MAX_VALUE;
        }

        // Find shortest path for all vertices
        for (int i = 0; i < weights.length - 1; i++) {
            // Pick the minimum distance vertex from the set of vertices not yet processed.
            // u is always 'start' in the first iteration.
            int u = minDistance(distances, spTree);

            // Mark the picked vertex as processed
            spTree[u] = true;

            for (int j = 0; j < weights[u].length; j++) {
                if (distances[u] != Integer.MAX_VALUE && weights[u][j] != 0) {
                   int fullDistance = distances[u] + weights[u][j];
                   if (fullDistance < distances[j]) {
                       distances[j] = fullDistance;
                   }
                }
            }
        }
        return distances;
    }

    /**
     * A DFS based recursive function that returns "true" if a matching for vertex "u" is possible
     * @param bpGraph our graph (job-to-applicant)
     * @param u  row in the matrix
     * @param seen
     * @param matchR
     * @param N number of vertices
     * @return
     */
    boolean bipartiteMatching(boolean[][] bpGraph, int u, boolean[] seen, int[] matchR, int N) {
        // Try every job one by one
        for (int v = 0; v < N; v++) {
            // If applicant 'u' is interested in job 'v' and 'v' is not visited
            if (bpGraph[u][v] && !seen[v]) {
                // Mark v as visited
                seen[v] = true;

                // If job 'v' is not assigned to an applicant OR previously
                // assigned applicant for job v (which is matchR[v]) has an alternate job available.
                // Since v is marked as visited in the above line, matchR[v] in the following
                // recursive call will not get job 'v' again
                if (matchR[v] < 0 || bipartiteMatching(bpGraph, matchR[v], seen, matchR, N)) {
                    matchR[v] = u;
                    return true;
                }
            }
        }
        return false;
    }

    // Returns maximum number of matching from M to N
    int maxBipartiteMatching(boolean[][] bpGraph, int M, int N)
    {
        // An array to keep track of the applicants assigned to jobs.
        // The value of matchR[i] is the applicant number assigned to job i,
        // the value -1 indicates nobody is assigned.
        int[] matchR = new int[N];

        // Initially all jobs are available
        for (int i = 0; i < N; ++i)
            matchR[i] = -1;

        // Count of jobs assigned to applicants
        int result = 0;
        for (int u = 0; u < M; u++)
        {
            // Mark all jobs as not seen
            // for next applicant.
            boolean[] seen =new boolean[N] ;
            for(int i = 0; i < N; ++i)
                seen[i] = false;

            // Find if the applicant 'u' can get a job
            if (bipartiteMatching(bpGraph, u, seen, matchR, N))
                result++;
        }
        return result;
    }

    /**
     * Works ONLY on UNDIRECTED graphs.
     * Uses DFS to traverse the graph. Time complexity is O(V+E)
     * Let's assume the graph is connected. (Otherwise let's do this for all nodes in the Graph)
     */
    public static boolean isCyclicGraph(int N, boolean[][] graph) {
        boolean[] visited = new boolean[N];
        int start = 0;
        return isCyclicUtil(start, N, visited, graph);
    }

    /**
     * Works on DIRECTED graphs as well.
     * Uses DFS to traverse the graph. Time complexity is O(V+E)
     * Let's assume the graph is connected. (Otherwise let's do this for all nodes in the Graph)
     */
    public static boolean isCyclicDirectedGraph(int N, boolean[][] graph) {
        boolean[] stack = new boolean[N];
        boolean[] visited = new boolean[N];
        for (int i = 0; i < N; i++) {
            if (isCyclicUtilDirected(i, N, stack, visited, graph))
                return true;
        }
        return false;
    }

    private static boolean isCyclicUtil(int current, int N, boolean[] visited, boolean[][] graph) {
        if (visited[current])
            return true;
        visited[current] = true;

        for (int i = 0; i < N; i++)
            if (graph[current][i])
                if(isCyclicUtil(i, N, visited, graph))
                    return true;

        return false;
    }

    private static boolean isCyclicUtilDirected(int curr, int N, boolean[] stack, boolean[] visited, boolean[][] graph) {
        if (stack[curr]) // already on the stack
            return true;
        if (visited[curr]) // NOT on the stack, already visited -> shortcut
            return false;
        stack[curr] = true;
        visited[curr] = true;

        for (int i = 0; i < N; i++)
            if (graph[curr][i]) // neighbor
                if (isCyclicUtilDirected(i, N, stack, visited, graph))
                    return true;

        stack[curr] = false;
        return false;
    }

    public static boolean[][] buildGraph(int N, List<int[]> edges) {
        boolean[][] matrix = new boolean[N][N];
        for (int[] e: edges) {
            int from = e[0];
            int to = e[1];
            matrix[from][to] = true;
            matrix[to][from] = true;
        }
        return matrix;
    }

    private static int minDistance(int[] distances, boolean[] spTree) {
        // Initialize min value
        int min = Integer.MAX_VALUE;
        int min_index = 0;
        for (int i = 0; i < spTree.length; i++) {
            if (spTree[i] == false && distances[i] < min) {
                min = distances[i];
                min_index = i;
            }
        }
        return min_index;
    }
}
