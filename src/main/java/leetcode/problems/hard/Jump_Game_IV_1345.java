package leetcode.problems.hard;

import java.util.*;

/**
 * Given an array of integers arr, you are initially positioned at the first index of the array.
 * In one step you can jump from index i to index:
 * i + 1 where: i + 1 < arr.length.
 * i - 1 where: i - 1 >= 0.
 * j where: arr[i] == arr[j] and i != j.
 * Return the MINIMUM number of steps to reach the last index of the array.
 * Notice that you can not jump outside of the array at any time.
 */
public class Jump_Game_IV_1345 {
    // BFS
    public int minJumps(int[] arr) {
        if (arr.length <= 1) {
            return 0;
        }
        Map<Integer, Set<Integer>> m = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            m.computeIfAbsent(arr[i], v -> new HashSet<>()).add(i);
        }
        List<Integer> curs = new LinkedList<>(); // store current layer
        curs.add(0);
        Set<Integer> visited = new HashSet<>();
        int step = 0;

        // when current layer exists
        while (!curs.isEmpty()) {
            List<Integer> next = new LinkedList<>();

            // iterate the layer
            for (int node : curs) {
                // check if reached end
                if (node == arr.length - 1) {
                    return step;
                }

                // check same value
                for (int child : m.get(arr[node])) {
                    if (!visited.contains(child)) {
                        visited.add(child);
                        next.add(child);
                    }
                }

                // clear the list to prevent redundant search
                m.get(arr[node]).clear();

                // check neighbors
                if (node + 1 < arr.length && !visited.contains(node + 1)) {
                    visited.add(node + 1);
                    next.add(node + 1);
                }
                if (node - 1 >= 0 && !visited.contains(node - 1)) {
                    visited.add(node - 1);
                    next.add(node - 1);
                }
            }
            curs = next;
            step++;
        }
        return -1;
    }

    public static void main(String[] args) {
        Jump_Game_IV_1345 x = new Jump_Game_IV_1345();
        System.out.println(x.minJumps(new int[]{100,-23,-23,404,100,23,23,23,3,404}));
        System.out.println(x.minJumps(new int[]{7}));
        System.out.println(x.minJumps(new int[]{7,6,9,6,9,6,9,7}));
        System.out.println(x.minJumps(new int[]{-76,3,66,-32,64,2,-19,-8,-5,-93,80,-5,-76,-78,64,2,16}));
        System.out.println(x.minJumps(new int[]{68,-94,-44,-18,-1,18,-87,29,-6,-87,-27,37,-57,7,18,68,-59,29,7,53,-27,-59,18,-1,18,-18,-59,-1,-18,-84,-20,7,7,-87,-18,-84,-20,-27}));
    }
}
