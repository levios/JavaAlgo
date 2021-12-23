package leetcode.problems.medium;

import java.util.*;
import java.util.stream.Collectors;

/**
 * https://leetcode.com/problems/minimum-height-trees/
 * 310. Minimum Height Trees
 *
 * A tree is an undirected graph in which any two vertices are connected by exactly one path.
 * In other words, any connected graph without simple cycles is a tree.
 * Given a tree of n nodes labelled from 0 to n - 1, and an array of n - 1 edges
 * where edges[i] = [ai, bi] indicates that there is an undirected edge between the two nodes ai and bi in the tree,
 * you can choose any node of the tree as the root.
 * When you select a node x as the root, the result tree has height h.
 * Among all possible rooted trees, those with minimum height (i.e. min(h))  are called minimum height trees (MHTs).
 * Return a list of all MHTs' root labels. You can return the answer in any order.
 * The height of a rooted tree is the number of edges on the longest downward path between the root and a leaf.
 */
public class Minimum_Height_Trees_310 {
    /**
     * Runtime: 666 ms, faster than 5.04
     * Memory Usage: 69.3 MB, less than 5.04%
     */
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if (edges.length == 0) return Collections.singletonList(0);
        Map<Integer, Set<Integer>> edgeMap = new HashMap<>();
        for (int[] edge: edges) {
            Set<Integer> e0 = edgeMap.getOrDefault(edge[0], new HashSet<>());
            e0.add(edge[1]);
            Set<Integer> e1 = edgeMap.getOrDefault(edge[1], new HashSet<>());
            e1.add(edge[0]);
            edgeMap.put(edge[0], e0);
            edgeMap.put(edge[1], e1);
        }

        List<Integer> leaves = edgeMap.entrySet().stream().filter(entry -> entry.getValue().size() == 1).map(Map.Entry::getKey).collect(Collectors.toList());
        // peel off (filter out) leaf nodes
        int nonLeafCount = n;
        while (nonLeafCount > 2) {
            Set<Integer> removeFrom = new HashSet<>();
            for (int l: leaves) {
                Set<Integer> neigh = edgeMap.remove(l);
                removeFrom.addAll(neigh);
            }
            List<Integer> tempLeaves = new LinkedList<>();
            for (int i : removeFrom) {
                if (edgeMap.get(i) != null) {
                    edgeMap.get(i).removeAll(leaves);
                    if (edgeMap.get(i).size() == 1) {
                        tempLeaves.add(i);
                    }
                }
            }
            nonLeafCount -= leaves.size();
            leaves = tempLeaves;
        }

        // height by nodes
        HashMap<Integer, List<Integer>> heights = new HashMap<>();
        int min = Integer.MAX_VALUE;
        for (int i : edgeMap.keySet()) {
            int height = dfs(i, edgeMap, new boolean[n]);
            if (height <= min) {
                min = height;
                List<Integer> list = heights.getOrDefault(height, new LinkedList<>());
                list.add(i);
                heights.put(height, list);
            }

        }
        return heights.get(min);
    }

    int dfs(int i, Map<Integer, Set<Integer>> edgeMap, boolean[] visited) {
        visited[i] = true;
        int h = -1;
        for (int neighbor: edgeMap.get(i)) {
            if (!visited[neighbor]) {
                h = Math.max(dfs(neighbor, edgeMap, visited), h);
            }
        }
        return h+1;
    }

    public static void main(String[] args) {
        Minimum_Height_Trees_310 m = new Minimum_Height_Trees_310();
        System.out.println(m.findMinHeightTrees(6, new int[][]{{3,0},{1,3},{2,3},{3,4},{5,4}}));    // [3,4]
        System.out.println(m.findMinHeightTrees(4, new int[][]{{1,0}, {1,2}, {1,3}}));              // [1]
        System.out.println(m.findMinHeightTrees(1, new int[][]{}));                                 // [0]
        System.out.println(m.findMinHeightTrees(2, new int[][]{{1,0}}));                            // [0, 1]
    }

}
