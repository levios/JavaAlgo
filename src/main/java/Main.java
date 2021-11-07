import graph.*;

import java.util.*;

public class Main {

    public static void mainx(String[] args) {

        //var res = num_ways(50, new int[] {1,2});



//        int[] arr = {12, 11, 13, 5, 6, 7};
//        MergeSort.sort(arr, 0, arr.length - 1);

//        System.out.println("Result: " +  );
    }

    boolean findSumSorted(int sum, int[] numbers) {
        int head = 0;
        int tail = numbers.length - 1;
        while (head < tail) {
            if (numbers[head] + numbers[tail] < sum)
                head++;
            else if (numbers[head] + numbers[tail] > sum)
                tail--;
            else
                return true;
        }
        return false;
    }

    static Map<Integer, Long> hmap = new HashMap<>();
    static long num_ways(int N, int[] x) {
        if (N == 0) return 1;
        if (N == 1) return N;
        if (hmap.containsKey(N)) return hmap.get(N);
        long sum = 0;
        for (int value : x) {
            if (N >= value)
                sum += num_ways(N - value, x);
        }
        hmap.put(N, sum);
        return sum;
    }
}
