package google.codejam.y2021.quali_3;

import combi.Permute;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Solution {
    // TODO: changes this to  >>>  false
    static final boolean debug = true; // false | true
    ///////////////////////////////////////////
    static final String FILENAME = "F:\\Documents\\GoogleCodeJam\\2021\\quali\\";
    static final String IN = FILENAME + "sample.in";
    static final String OUT = FILENAME + "out.out";
    static final String IMPOSSIBLE = "IMPOSSIBLE";
    ///////////////////////////////////////////
    static int N,C;
    static Map<Integer, List<int[]>> permutesByCost = new HashMap<>();
    private static void solve() {
        N = in.nextInt(); // SIZE
        C = in.nextInt(); // COST

        if (C < N - 1 || C > ((1 + N) * N / 2 - 1)) {
            print(IMPOSSIBLE);
            return;
        }

        if (!permutesByCost.containsKey(C)) {
            print(IMPOSSIBLE);
            return;
        }

        Optional<int[]> first = permutesByCost.get(C).stream().filter(array -> array.length == N).findFirst();
        if (first.isPresent()) {
            String result = Arrays.stream(first.get())
                    .mapToObj(String::valueOf)
                    .collect(Collectors.joining(" "));
            print(result);
        } else {
            print(IMPOSSIBLE);
            return;
        }
    }

    static void generate(int n) {
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = i + 1;
        }
        Permute p = new Permute(a);
        while (p.hasMore()) {
            int[] array = p.getNext();
            int count = algo(array);
            if (permutesByCost.containsKey(count)) {
                permutesByCost.get(count).add(array);
            } else {
                List<int[]> l = new LinkedList<>();
                l.add(array);
                permutesByCost.put(count, l);
            }
        }
    }

    static int algo(int[] array) {
        int sum = 0;
        for (int i = 0; i < array.length - 1; i++) {
            int j = min(array, i, array.length);
            sum += reverse(array, i, j);
        }
        return sum;
    }

    static int min(int[] array, int i, int N) {
        int value = Integer.MAX_VALUE;
        int pos = -1;
        for (int idx = i; idx < N; idx++) {
            if (array[idx] < value) {
                value = array[idx];
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

    static void init() {
        for (int i = 2; i <= 7; i++) {
            generate(i);
        }
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
        init();
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

