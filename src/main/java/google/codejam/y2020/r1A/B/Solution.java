package google.codejam.y2020.r1A.B;

import java.io.*;
import java.util.*;

/**
 * Round 1A 2020 - Code Jam 2020
 * B. Pascal Walk
 * (r, k) := k-th position from the left in the r-th row.
 * Pascal walk is a sequence of s positions (r1, k1), (r2, k2), ..., (rs, ks) in Pascal's triangle that
 * satisfy the following criteria:
 *  - r1 = 1 and k1 = 1 , i.e. starts from (1,1)
 *  - Each subsequent position must be within the triangle and adjacent (in one of the 6 possible directions)
 *      to the previous position.
 *  - No position may be repeated within the sequence.
 * Find any Pascal walk of S <= 500 positions such that the sum of the numbers in all of the positions it visits
 * is equal to N.
 */
public class Solution {
    // TODO: changes this to  >>>  false
    static final boolean debug = true; // false | true
    ///////////////////////////////////////////
    static final String FILENAME = "F:\\Documents\\GoogleCodeJam\\2020\\r1a\\2\\";
    static final String IN = FILENAME + "sample.in";
    static final String OUT = FILENAME + "out.out";
    ///////////////////////////////////////////
    static int N;
    private static void solve() {
        N = in.nextInt();
        int sum = 1;
        List<Tuple<Integer, Integer>> route = new LinkedList<>();
        route.add(new Tuple(1,1)); // (1,1) ->
        if (N == 1) {
            // do nothing
        } else if (N <= 1000) {
            // -> (2,2) -> (3,2) -> ... -> (?,2) -> (?,1) -> (?+1, 1) -> (?+2, 1) -> ...
            int counter = 1;
            while (firstNSum(counter) <= N-1) {
                ++counter;
            }
            for (int i = 1; i < counter; i++) {
                sum += i;
                route.add(new Tuple<>(i+1, 2));
            }
            int diff = N - sum;
            for (int i = 0; i < diff; i++) {
                route.add(new Tuple<>(counter + i, 1));
            }
        } else {
            // IDEA: the entries in the r-th row (counting starting from 1) sum to 2^(r-1).
            int N_30 = N-30; // N-30, because we might go down to row 30 in the worst case
            String binary = Integer.toString(N_30, 2);
            int occ = countOccurrences(binary, '0');
            int currentEnd = 0; // 0 = left, 1 = right
            int row = 1;
            // starting from 1, because 0 is already added to Route
            for (; row <= binary.length(); row++) {
                char c = reverse(binary).charAt(row-1);
                if (row == 1) continue;
                if (c == '1') {
                    for (int col = 1; col <= row; col++) {
                        if (currentEnd == 0)
                            route.add(new Tuple(row, col));
                        else
                            route.add(new Tuple(row, row-col+1));
                    }
                    currentEnd = currentEnd == 0 ? 1 : 0;
                } else {
                    if (currentEnd == 0)
                        route.add(new Tuple(row, 1));
                    else
                        route.add(new Tuple(row, row));
                }
            }
            // add 1's, but remember that we added 'occ' already
            for (int i = 0; i < 30-occ; i++) {
                if (currentEnd == 0)
                    route.add(new Tuple(row+i, 1));
                else
                    route.add(new Tuple(row+i, row+i));
            }
        }
        Map<Integer, int[]> sums = buildMaxSumPath(N);
        int ssum = 0;
        print("");
        for (Tuple<Integer, Integer> t: route) {
            ssum += (sums.get(t.x))[t.y-1];
            print(t.toString());
        }
        if (debug) {
            print("**SUM: " + ssum);
            assert ssum == N;
        }
    }

    /**
     * Used for debugging
     */
    private static Map<Integer, int[]> buildMaxSumPath(int n) {
        Map<Integer, int[]> m = new HashMap<>();
        if (n >= 1) {
            int[] row = new int[1];
            row[0] = 1;
            m.put(1, row);
        }
        if (n >= 2) {
            int[] row = new int[2];
            row[0] = 1;
            row[1] = 1;
            m.put(2, row);
        }
        for (int i = 3; i <= n; i++) {
            int[] prev = m.get(i-1);
            int[] row = new int[i];
            row[0] = 1;
            for (int k = 1; k < i-1 ; k++) {
                row[k] = prev[k-1] + prev[k];
            }
            row[i-1] = 1;
            m.put(i, row);
        }
        return m;
    }

    static int firstNSum(int n) {
        return n*(n+1) / 2;
    }

    static String reverse(String s) {
        return new StringBuilder(s).reverse().toString();
    }

    static int countOccurrences(String s, char ch) {
        int counter = 0;
        int index = s.indexOf(ch);
        while (index >= 0) {
            index = s.indexOf(ch, index + 1);
            counter++;
        }
        return counter;
    }

    private static void prettyPrint(Map<Integer, int[]> m) {
        for (int i = 1; ; i++) {
            int[] row = m.get(i);
            if (row == null)
                return;
            System.out.println(
                    String.join(" ", Arrays.stream(row)
                            .mapToObj(String::valueOf)
                            .toArray(String[]::new))
            );
        }
    }

    private static class Tuple<X, Y> {
        public final X x;
        public final Y y;
        Tuple(X x, Y y) {
            this.x = x;
            this.y = y;
        }
        @Override
        public String toString() {
            return x + " " + y;
        }
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
