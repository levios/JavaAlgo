package leetcode.problems.easy;

import java.util.*;

public class Pascals_triangle_ {
    static List<List<Integer>> triangle = new LinkedList<>();
    static {
        triangle.add(Collections.singletonList(1));
        triangle.add(Arrays.asList(1,1));
    }
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> triangle = new LinkedList<>();
        triangle.add(Collections.singletonList(1));
        triangle.add(Arrays.asList(1,1));
        while (triangle.size() < numRows) {
            List<Integer> last = triangle.get(triangle.size()-1);
            List<Integer> newList = new ArrayList<>(last.size()+1);
            for (int i = 0; i <= last.size(); i++) {
                int prev = i == 0 ? 0 : last.get(i-1);
                int next = i == last.size() ? 0 : last.get(i);
                newList.add(prev + next);
            }
            triangle.add(newList);
        }
        return triangle.subList(0,numRows);
    }

    public static void main(String[] args) {
        System.out.println(new Pascals_triangle_().generate(5));
    }
}
