package google.codejam.y2021.quali_3;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Reversort Engineering (7pts, 11pts)
 * https://codingcompetitions.withgoogle.com/codejam/round/000000000043580a/00000000006d12d7
 *
 * After i−1 iterations, the positions 1,2,…,i−1 of the list contain the i−1 smallest elements of L, in increasing order.
 * During the i-th iteration, the process reverses the sublist going from the i-th position to the current
 * position of the i-th minimum element.
 * That makes the i-th minimum element end up in the i-th position.
 * You are given a size N and a cost C. Find a list of N distinct integers between 1 and N such that the cost of
 * applying Reversort to it is exactly C, or say that there is no such list.
 */
public class Solution {
    // TODO: changes this to  >>>  false
    static final boolean debug = true; // false | true
    ///////////////////////////////////////////
    static final String FILENAME = "src/main/java/google/codejam/y2021/quali_3/";
    static final String IN = FILENAME + "sample.in";
    static final String OUT = FILENAME + "out.out";
    static final String IMPOSSIBLE = "IMPOSSIBLE";
    ///////////////////////////////////////////
    static int N,C;
    private static void solve() {
        N = in.nextInt(); // SIZE
        C = in.nextInt(); // COST

        if (C < N - 1 || C > ((1 + N) * N / 2 - 1)) {
            print(IMPOSSIBLE);
            return;
        }

        List<Pair> steps = new LinkedList<>();
        for (int i = 0; i < N-1; i++) {
            int diff = C - (N-1-i-1);
            int cost = Math.min(diff, N-i); // I have cost steps to take
            cost = Math.max(cost, 1); // I have cost steps to take
            steps.add(new Pair(i, i+cost-1));
            C -= cost;
        }

        // let's reverse play steps
        int[] temp = new int[N];
        for (int i = 0; i < N; i++)
            temp[i] = i+1;
        for (int i = steps.size()-1; i >= 0; i--) {
            Pair p = steps.get(i);
            reverse(temp, p.x, p.y);
        }

        print(temp);
    }

    static class Pair {
        public int x, y;
        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static void reverse(int[] L, int i, int j) {
        while (i < j) {
            int temp = L[i];
            L[i] = L[j];
            L[j] = temp;
            ++i;
            --j;
        }
    }

    private static void print(int[] i) {
        String s = Arrays.stream(i).mapToObj(String::valueOf).collect(Collectors.joining(" "));
        out.println(s); out.flush();
        if (debug)
            System.out.println(s);
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

