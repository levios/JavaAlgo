package google.codejam.y2019.r1C.C;

import java.io.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Scanner;
import java.util.Set;

/**
 * Round 1C - Code Jam 2019
 * C. Bacterial Tactics
 * matrix of unit cells with R rows and C columns
 */
public class Solution {
    // TODO: changes this to  >>>  false
    static final boolean debug = true; // false | true
    ///////////////////////////////////////////
    static final String FILENAME = "F:\\Documents\\GoogleCodeJam\\2019\\r1c\\C\\";
    static final String IN = FILENAME + "sample.in";
    static final String OUT = FILENAME + "out.out";
    ///////////////////////////////////////////
    static int R,C;
    private static void solve() {
        R = in.nextInt();
        C = in.nextInt();
        int[][] floor = new int[R][C];
        long Ssum = 0; // sum of dancer's skill levels
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                int dancer = in.nextInt();
                floor[i][j] = dancer;
                Ssum += dancer;
            }
        }

        print("");
    }

    private static void print(String s) {
        out.println(s); out.flush();
        if (debug) System.out.println(s);
    }

    private static Scanner in;
    private static PrintStream out;

    private static void run() throws Exception {
        if (debug) {
            in = new Scanner(new File(IN)); // new Scanner(Quali4.class.getResourceAsStream(IN));
            out = new PrintStream(new FileOutputStream(OUT));
        } else {
            in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
            out = System.out;
        }
        int t = in.nextInt();
        for (int i = 1; i <= t; i++) {
            out.print("Case #" + i + ": ");
            if (debug) System.out.print("Case #" + i + ": ");
            solve();
        }
        in.close();
        out.close();
    }

    public static void main(String[] args) throws Exception {
        run();
    }
}
