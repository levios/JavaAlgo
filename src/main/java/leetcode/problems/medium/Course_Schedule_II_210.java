package leetcode.problems.medium;

import java.util.*;

/**
 * https://leetcode.com/problems/course-schedule-ii/
 * 210. Course Schedule II
 * There are a total of numCourses courses you have to take, labeled from 0 to numCourses - 1.
 * You are given an array prerequisites where prerequisites[i] = [ai, bi] indicates that
 * you must take course bi first if you want to take course ai.
 *
 * Return the ordering of courses you should take to finish all courses.
 * If there are many valid answers, return any of them.
 * If it is impossible to finish all courses, return an empty array.
 * Constraints:
 * 1 <= numCourses <= 2000
 * 0 <= prerequisites.length <= numCourses * (numCourses - 1)
 * prerequisites[i].length == 2
 * 0 <= ai, bi < numCourses
 * ai != bi
 * All the pairs [ai, bi] are distinct.
 */
public class Course_Schedule_II_210 {

    /**
     * Runtime: 69 ms, faster than 5.02%
     * Memory Usage: 40.8 MB, less than 27.64%
     */
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] not_found = new int[0];
        Map<Integer, Set<Integer>> inGoing = new HashMap<>();
        Map<Integer, Set<Integer>> outGoing = new HashMap<>();
        for (int[] dep : prerequisites) {
            // edge: from --> to
            int to = dep[0];
            int from = dep[1];
            Set<Integer> nodes = inGoing.getOrDefault(to, new HashSet<>());
            nodes.add(from);
            inGoing.put(to, nodes);
            nodes = outGoing.getOrDefault(from, new HashSet<>());
            nodes.add(to);
            outGoing.put(from, nodes);
        }
        // if there's an edge to all the nodes --> DAG
        if (inGoing.size() == numCourses) {
            return not_found;
        }
        List<Integer> visited = new LinkedList<>();
        Set<Integer> next = new HashSet<>();
        for (int i = 0; i < numCourses; i++) {
            if (inGoing.get(i) == null) {
                visited.add(i);
                next.addAll(outGoing.getOrDefault(i, new HashSet<>()));
            }
        }

        while (visited.size() < numCourses) {
            int current = 0;
            Set<Integer> temp = new HashSet<>();
            next.removeAll(visited);
            for (int r : next) {
                Set<Integer> in = inGoing.get(r);
                if (visited.containsAll(in)) {
                    current++;
                    temp.addAll(outGoing.getOrDefault(r, new HashSet<>()));
                    visited.add(r);
                }
            }
            if (current == 0) {
                return not_found;
            }
            next = temp;
        }
        return visited.stream().mapToInt(Integer::intValue).toArray();
    }

    public static void main(String[] args) {
        Course_Schedule_II_210 app = new Course_Schedule_II_210();
        System.out.println(Arrays.toString(app.findOrder(1,
                new int[][]{}))); // [0]
        System.out.println(Arrays.toString(app.findOrder(2,
                new int[][]{{1,0}}))); // [0,1]
        System.out.println(Arrays.toString(app.findOrder(4,
                new int[][]{{1,0},{2,0},{3,1},{3,2}}))); // [0,1,2,3]
        System.out.println(Arrays.toString(app.findOrder(2,
                new int[][]{{0,1}}))); // [1,0]
    }
}
