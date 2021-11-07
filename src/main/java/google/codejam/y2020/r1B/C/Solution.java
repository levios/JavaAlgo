package google.codejam.y2020.r1B.C;

import java.io.*;
import java.util.*;
import java.util.stream.*;

/**
 * Round 1B - Code Jam 2020
 * C.
 */
public class Solution {
    // TODO: changes this to  >>>  false
    static final boolean debug = true; // false | true
    ///////////////////////////////////////////
    static final String FILENAME = "F:\\Documents\\GoogleCodeJam\\2020\\r1b\\C\\";
    static final String IN = FILENAME + "sample.in";
    static final String OUT = FILENAME + "out.out";
    ///////////////////////////////////////////
    static int N;
    private static void solve() {
        N = in.nextInt();
        List<String> words = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            words.add(in.next());
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
