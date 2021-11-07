package google.codejam.y2019.r1A.B;

import java.io.*;
import java.util.*;

/**
 * !!!! INTERACTIVE !!!!
 * Round 1A - Code Jam 2019
 * B. Golf Gophers
 * 1 <= Number of Gophers <= M
 * Minigolf course: small windmill on each 18 holes
 * The i-th windmill has 2 <= Bi <= 18 blades, which are numbered from 0 to Bi-1, clockwise. Blade 0 is pointing down.
 * Each night, before going to sleep, we can choose the number of blades on each of the 18 windmills
 * Every night, all of the gophers, each of them chooses one of the windmills independently and uniformly at random
 * and rotates it counterclockwise by one blade.
 * N nights. Figure out G, the number of gophers
 */
public class Solution {
    // TODO: changes this to  >>>  false
    static final boolean debug = true; // false | true
    ///////////////////////////////////////////
    static final String FILENAME = "F:\\Documents\\GoogleCodeJam\\2019\\r1a\\B\\";
    static final String IN = FILENAME + "sample.in";
    static final String OUT = FILENAME + "out.out";
    ///////////////////////////////////////////
    static int[] primes = new int[] {2,3,5,7,11,13,17}; // All 7 prime numbers until 18
    static void solve(int n, int m) { // m: maximum num of gophers ( > 0 )
        // up to N + 1 exchanges
        int answer = 0;

        int[] remainders = new int[7];
        
        for (int i = 0; i < 7; i++) {
            // output: one line with 18 integers between 2 and 18, inclusive; the i-th of these represents the
            // number of blades you want the i-th windmill to have on that night.
            int curr = primes[i];
            int[] req = new int[18];
            Arrays.fill(req, curr);
            
            // response: one line with 18 integers; the i-th of these represents the number on the downward-pointing
            // blade of the i-th windmill in the morning
            int[] resp = request(req);

            int sum = 0;
            for (int r: resp) {
                sum += r;
            }
            remainders[i] = sum % curr;
        }
        
        int first = remainders[6];
        if (first < 1)
            first += primes[6];

        int increase = primes[6];

        for (int i = first; i <= m; i+=increase) {
            boolean found = true;
            for (int j = 0; j < 7; j++) {
                if (i % primes[j] != remainders[j]) {
                    found=false;
                    break;
                }
            }
            if (found) {
                answer = i;
                break;
            }
        }

        // final output: one integer: your guess for G, the number of gophers
        answer(answer);
    }

    static void answer(int answer) {
        out.println("" + answer); out.flush();
        if (debug) file("Answer: " + answer);
        int first = in.nextInt();
        if (first == -1) {
            if (debug) file("Fail: " + first);
            System.exit(-1);
        } else if (first == 1) {
            if (debug) file("Successful: " + first);
        }
    }

    static String join(int[] arr, String sep) {
        String[] sarr = Arrays.stream(arr).mapToObj(String::valueOf).toArray(String[]::new);
        return String.join(sep, sarr);
    }

    static int[] request(int[] req) {
        String r = join(req, " ");
        out.println(r); out.flush();
        if (debug) file(r);
        int first = in.nextInt();
        if (first == -1) {
            System.exit(-1);
        }
        int[] response = new int[18];
        response[0] = first;
        for (int i = 1; i < 18; i++) {
            response[i] = in.nextInt();
        }
        if (debug) file(join(response, " "));
        return response;
    }

    static void file(String s) {
        file.println(s); file.flush();
    }

    private static Scanner in;
    private static PrintStream out;
    private static PrintStream file;
    private static void run() throws Exception {
        in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        out = System.out;
        if (debug) file = new PrintStream(new FileOutputStream(OUT));
        int t = in.nextInt();
        int n = in.nextInt(); // number of nights allowed per test case
        int m = in.nextInt(); // maximum number of gophers
        if (debug) file("T, N, M: " + t + " " + n + " " + m);
        for (int i = 1; i <= t; i++) {
            solve(n, m);
        }
        in.close();
        out.close();
        if (debug) file.close();
    }

    public static void main(String[] args) throws Exception {
        run();
    }
}
