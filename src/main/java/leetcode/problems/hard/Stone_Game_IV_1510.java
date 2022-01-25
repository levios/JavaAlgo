package leetcode.problems.hard;

import java.util.*;

/**
 * 1510. Stone Game IV
 * https://leetcode.com/problems/stone-game-iv/
 * Alice and Bob take turns playing a game, with Alice starting first.
 * Initially, there are n stones in a pile. On each player's turn, that player makes a move consisting
 * of removing any non-zero square number of stones in the pile.
 * Also, if a player cannot make a move, he/she loses the game.
 * Given a positive integer n, return true if and only if Alice wins the game otherwise return false,
 * assuming both players play optimally.
 * 1 <= n <= 10^5
 *
 * TAGS: DYNAMIC PROGRAMMING
 */
public class Stone_Game_IV_1510 {
    public boolean winnerSquareGame(int n) {
        boolean[] dp = new boolean[n + 1];
        for (int i = 0; i < n + 1; i++) {
            for (int k = 1; k * k <= i; k++) {
                if (dp[i - k * k] == false) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        Stone_Game_IV_1510 x = new Stone_Game_IV_1510();
        System.out.println(x.winnerSquareGame(3)); // true
        System.out.println(x.winnerSquareGame(7)); // false
        System.out.println(x.winnerSquareGame(17)); // false
        System.out.println(x.winnerSquareGame(74497)); // false
    }
}
