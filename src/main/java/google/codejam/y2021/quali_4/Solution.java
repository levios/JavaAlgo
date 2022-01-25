package google.codejam.y2021.quali_4;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Median Sort (7pts, 11pts, 10pts)
 * https://codingcompetitions.withgoogle.com/codejam/round/000000000043580a/00000000006d1284
 *
 * INTERACTIVE
 *
 * You want to sort N distinct items, x1,x2,…,xN. Unfortunately, you do not have a way of comparing two of these items.
 * You only have a way to, given three of them, find out which one is the median, that is,
 * which one is neither the minimum nor the maximum among the three.
 * The program will have to find the order of T lists of N elements using at most Q median questions in total.
 */
public class Solution {
    // TODO: changes this to  >>>  false
    static final boolean debug = true; // false | true
    ///////////////////////////////////////////
    static final String FILENAME = "src/main/java/google/codejam/y2021/quali_4/";
    static final String IN = FILENAME + "sample.in";
    static final String OUT = FILENAME + "out.out";
    ///////////////////////////////////////////
    private static void solve(int n) {
        List<Integer> list = new ArrayList<>(n);

        int response = request(1, 2, 3);
        if (1 == response) {
            list.add(2);
            list.add(1);
            list.add(3);
        } else if (2==response) {
            list.add(1);
            list.add(2);
            list.add(3);
        } else {
            list.add(1);
            list.add(3);
            list.add(2);
        }

        for (int next = 4; next <= n; next++) {
            insert(list, 0, list.size()-1, next);
        }

        response = print(list.stream().mapToInt(Integer::intValue).toArray());
        if (response == -1) {
            // oops
            System.exit(-1);
        }
    }

    static void insert(List<Integer> list, int start, int end, int next) {
        int mid = (start + end) / 2;
        int fir = list.get(mid);
        int sec = list.get(mid+1);

        int response = request(fir, sec, next);
        if (response == next) {
            // we are good, we know the place
            list.add(mid+1, next);
        } else if (response == fir) {
            // --> go smaller
            if (end-start == 1) {
                list.add(start, next);
            } else {
                insert(list, start, mid, next);
            }
        } else {
            // --> go bigger
            if (end-start == 1) {
                list.add(end+1, next);
            } else {
                insert(list, mid, end, next);
            }
        }
    }

    static int request(int x, int y, int z) {
        String r = x + " " + y + " " + z;
        out.println(r); out.flush();
        if (debug) file(r);
        int response = in.nextInt();
        if (debug) file(response);
        if (response == -1) {
            System.exit(-1);
        }
        return response;
    }

    static void file(Object s) {
        out.println(s); out.flush();
    }

    private static int print(int[] i) {
        String s = Arrays.stream(i).mapToObj(String::valueOf).collect(Collectors.joining(" "));
        out.println(s); out.flush();
        if (debug) System.out.println(s);
        return in.nextInt();
    }

    private static Scanner in;
    private static PrintStream out;

    private static void run() throws Exception {
        if (debug) {
            //in = new Scanner(new File(IN));
            in = new Scanner(Solution.class.getResourceAsStream(IN));
            out = new PrintStream(new FileOutputStream(OUT));
        } else {
            in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
            out = System.out;
        }
        int t = in.nextInt();
        int n = in.nextInt();
        int q = in.nextInt();
        for (int i = 1; i <= t; i++) {
            solve(n);
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

