package google.codejam.y2021.quali;

import java.io.*;
import java.util.*;

public class Solution {
    // TODO: changes this to  >>>  false
    static final boolean debug = true; // false | true
    ///////////////////////////////////////////
    static final String FILENAME = "F:\\Documents\\GoogleCodeJam\\2021\\quali\\";
    static final String IN = FILENAME + "sample.in";
    static final String OUT = FILENAME + "out.out";
    ///////////////////////////////////////////
    static int N,K;
    static int[] L = null;
    private static void solve() {
        N = in.nextInt();
        L = new int[N];
        int sum = 0;
        for (int i = 0; i < N; i++) {
            L[i] = in.nextInt();
        }
        for (int i = 0; i < N - 1; i++) {
            int j = min(L, i, N);
            sum += reverse(L, i, j);
        }
        print("" + sum);
    }

    static int min(int[] array, int i, int N) {
        int value = Integer.MAX_VALUE;
        int pos = -1;
        for (int idx = i; idx < N; idx++) {
            if (L[idx] < value) {
                value = L[idx];
                pos = idx;
            }
        }
        return pos;
    }

    static int reverse(int[] L, int i, int j) {
        int placeholder_i = i;
        int placeholder_j = j;
        while (i < j) {
            int temp = L[i];
            L[i] = L[j];
            L[j] = temp;
            ++i;
            --j;
        }
        return placeholder_j - placeholder_i + 1;
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

