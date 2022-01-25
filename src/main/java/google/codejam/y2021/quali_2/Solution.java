package google.codejam.y2021.quali_2;

import java.io.*;
import java.util.Scanner;

/**
 *
 * Moons and Umbrellas (5pts, 11pts, 1pts)
 * Each time CJ appears => must pay X.
 * Each time JC appears => must pay Y.
 * The empty spaces he still has could be filled strategically, to minimize the copyright expenses.
 * For example, if CJ?CC? represents the current state.
 * Given the costs X and Y and a string representing the current state, how much does he need
 * to pay in copyrights if he finishes in a way that minimizes that cost?
 *
 * 1 <= the length of S <= 1000
 * T2:
 * 100 <= X <= 100
 * 100 <= Y <= 100
 * T3:
 * −100 <= X <= 100
 * −100 <= Y <= 100
 *
 */
public class Solution {
    // TODO: changes this to  >>>  false
    static final boolean debug = true; // false | true
    ///////////////////////////////////////////
    static final String FILENAME = "src/main/java/google/codejam/y2021/quali_2/";
    static final String IN = FILENAME + "2.in";
    static final String OUT = FILENAME + "2.out";
    ///////////////////////////////////////////
    static int X,Y;

    private static void solve() {
        X = in.nextInt(); // CJ
        Y = in.nextInt(); // JC
        String S = in.next();
        int n = S.length();

        int[][] dp = new int[n+1][2];
        dp[0][0] = dp[0][1] = 0;

        for (int i = 1; i <= n; i++) {
            for (int c = 0; c < 2; c++) { // c:
                if (c == 0 && S.charAt(i-1) == 'J') continue;
                if (c == 1 && S.charAt(i-1) == 'C') continue;
                for (int d = 0; d < 2; d++) { // d:
                    int cost = 0;
                    if (i > 1){
                        if (d == 0 && c == 1) cost += X;
                        if (d == 1 && c == 0) cost += Y;
                    }
                    dp[i][c] = Math.min(dp[i][c], dp[i-1][d] + cost);
                }
            }
        }

        print("" + Math.min(dp[n][0], dp[n][1]));
    }

    private static void print(String s) {
        out.println(s); out.flush();
        if (debug)
            System.out.println(s);
    }

    private static Scanner in;
    private static PrintStream out;

    private static void run() throws Exception {
        if (debug) {
            in = new Scanner(new File(IN));
            // in = new Scanner(Quali4.class.getResourceAsStream(IN));
            out = new PrintStream(new FileOutputStream(OUT));
        } else {
            in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
            out = System.out;
        }
        int t = in.nextInt();
        for (int i = 1; i <= t; i++) {
            out.print("Case #" + i + ": ");
            solve();
        }
        in.close();
        out.close();
    }

    public static void main(String[] args) throws Exception {
        run();
//        if (debug)
//            System.in.read();
    }
}

