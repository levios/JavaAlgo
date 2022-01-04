package leetcode.problems.easy;

/**
 * 997. Find the Town Judge
 * https://leetcode.com/problems/find-the-town-judge/
 * Return the label of the town judge if the town judge exists and can be identified, or return -1 otherwise.
 */
public class Find_Town_Judge_997 {
    public int findJudge(int n, int[][] trust) {
        // home many people person i trusts
        int[] trustBy = new int[n];
        // how many people trusts person i
        int[] trusted = new int[n];
        for (int i = 0; i < trust.length; i++) {
            trustBy[trust[i][0]-1]++;
            trusted[trust[i][1]-1]++;
        }
        int found = -2;
        for (int i = 0; i < n; i++) {
            if (trustBy[i] == 0 && trusted[i] == n-1) {
                if (found >= 0) {
                    return -1;
                } else {
                    found = i;
                }
            }
        }
        return found+1;
    }
    public static void main(String[] args) {
        Find_Town_Judge_997 x = new Find_Town_Judge_997();
        System.out.println(x.findJudge(2, new int[][]{{1,2}}));
    }
}
