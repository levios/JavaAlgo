package leetcode.problems.easy;

/**
 * https://leetcode.com/problems/minimum-cost-to-move-chips-to-the-same-position/
 * 1217. Minimum Cost to Move Chips to The Same Position
 *
 * We have n chips, where the position of the ith chip is position[i].
 *
 * We need to move all the chips to the same position. In one step, we can change the position of the ith chip from position[i] to:
 *
 * position[i] + 2 or position[i] - 2 with cost = 0.
 * position[i] + 1 or position[i] - 1 with cost = 1.
 * Return the minimum cost needed to move all the chips to the same position.
 */
public class Min_Cost_Move_Chips_Same_Pos_1217 {

    public int minCostToMoveChips(int[] position) {
        int odd = 0;
        int even = 0;
        for (int j : position) {
            if (j % 2 == 0) {
                even++;
            } else {
                odd++;
            }
        }
        return Math.min(odd, even);
    }
}
