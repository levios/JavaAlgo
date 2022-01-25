package leetcode.problems.medium;

/**
 * 134. Gas Station
 * https://leetcode.com/problems/gas-station/
 * Given two integer arrays gas and cost, return the starting gas station's index if you can travel around
 * the circuit once in the clockwise direction, otherwise return -1.
 * If there exists a solution, it is guaranteed to be unique
 *
 * TAGS: GREEDY
 */
public class Gas_station_134 {
    /**
     * this is a greedy algorithm.
     * @param gas
     * @param cost
     * @return
     */
    public int canCompleteCircuit(int[] gas, int[] cost) {
        // let's collect the cummulative difference of each capacity - cost
        int cumulativeDiff = 0;
        // at the beginning, the tank is empty
        int tank = 0;
        // let's initialize the starting index
        int last_index_with_overhead = -1;
        for (int i = 0; i < gas.length; i++) {
            int d = gas[i] - cost[i];
            if (d >= 0) {
                if (tank == 0) {
                    // if tank has previously been empty, this is a possible candidate for start index
                    last_index_with_overhead = i;
                }
            }
            tank = Math.max(0, tank + d);
            cumulativeDiff += d;
        }
        // if the cumulatve diff is negate, we surely cannot go a cycle
        if (cumulativeDiff < 0) {
            return -1 ;
        }
        return last_index_with_overhead;
    }

    public static void main(String[] args) {
        Gas_station_134 x = new Gas_station_134();
//        System.out.println(x.canCompleteCircuit(new int[]{1,2,3,4,5}, new int[]{3,4,5,1,2})); // 3
//        System.out.println(x.canCompleteCircuit(new int[]{2,3,4}, new int[]{3,4,3})); // -1
        System.out.println(x.canCompleteCircuit(new int[]{5,5,1,3,4}, new int[]{8,1,7,1,1})); // 3
    }
}
