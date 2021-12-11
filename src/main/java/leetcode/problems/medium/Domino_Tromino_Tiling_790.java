package leetcode.problems.medium;


/**
 * https://leetcode.com/problems/domino-and-tromino-tiling/
 * 790. Domino and Tromino Tiling
 *
 * You have two types of tiles: a 2 x 1 domino shape and a tromino shape. You may rotate these shapes.
 * Given an integer n, return the number of ways to tile an 2 x n board.
 * Since the answer may be very large, return it modulo 10^9 + 7.
 */
class Domino_Tromino_Tiling_790 {

    /*
    we need to first find out maximum how many standing 2x1 pieces can be ? => max n
    the rest of the shapes will be either 2 1x2 pieces on top of each other
    OR 2 L pieces folded into each other
    OR a shifted structure: shifted structure can be 2 x 3...n
       +---  ----  ... ----  |
       |  ----  ----  ... ---+



     */

    int result = 0;

    public int numTilings(int n) {

        return result;
    }

    public static void main(String[] args) {
        Domino_Tromino_Tiling_790 s = new Domino_Tromino_Tiling_790();
        System.out.println(s.numTilings(3));
    }
}