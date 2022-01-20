package google.codejam.y2021.r1a;

import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Round 1A 2021 - Code Jam 2021
 * Append Sort (12pts, 14pts)
 * We have a list of integers X1,X2,...,XN. We would like them to be in strictly increasing order,
 * but unfortunately, we cannot reorder them. This means that usual sorting algorithms will not work.
 * Our only option is to change them by appending digits 0 through 9 to their right (in base 10).
 * For example, if one of the integers is 10, you can turn it into 100 or 109 with a single append
 * operation, or into 1034 with two operations (as seen in the image below).
 * Given the current list, what is the minimum number of single digit append operations that are
 * necessary for the list to be in strictly increasing order?
 */
public class Append_Sort {
    // TODO: changes this to  >>>  false
    static final boolean debug = true; // false | true
    ///////////////////////////////////////////
    static final String FILENAME = "src/main/java/google/codejam/y2021/r1a/";
    static final String IN = FILENAME + "1.in";
    static final String OUT = FILENAME + "1.out";
    ///////////////////////////////////////////
    static int N;
    private static void solve() {
        N = in.nextInt();
        StringBuilder prev = null;
        StringBuilder curr;
        int counter = 0;
        for (int i = 0; i < N; i++) {
            curr = new StringBuilder(in.next());
            int currLen = curr.length();
            if (prev != null && prev.length() >= curr.length()) {
                // at this point X[i] is smaller than X[i-1]
                int diff = prev.length() - currLen;
                // we need to add EITHER lenDiff OR lenDiff+1 digits at the end.
                // if curr is smaller than start of prev, then we need to add lenDiff+1 digits
                if (!prev.toString().startsWith(curr.toString())) {
                    for (int j = 0; j < currLen; j++) {
                        if (curr.charAt(j) > prev.charAt(j)) {
                            // we need to add lenDiff ZEROs
                            for (int k = 0; k < diff; k++) {
                                curr.append("0");
                            }
                            counter += diff;
                            break;
                        } else if (curr.charAt(j) < prev.charAt(j)) {
                            // we need to add lenDiff+1 ZEROs
                            for (int k = 0; k < diff + 1; k++) {
                                curr.append("0");
                            }
                            counter += diff + 1;
                            break;
                        }
                    }
                } else {// prev starts with curr
                    // check if there are only 9's. If not, we can do that with only lenDiff digits
                    boolean onlyNines = true;
                    for (int j = prev.length()-1; j>=currLen; j--) { // iterate backwards
                        if (!onlyNines) {
                            // we are in COPY mode
                            curr.insert(currLen, prev.charAt(j));
                        } else if (prev.charAt(j) != '9') {
                            // this is the FIRST non-9 character, so increase it
                            curr.insert(currLen, prev.charAt(j) - '0' + 1);
                            // we also enter into COPY mode from now on
                            onlyNines = false;
                        } else {
                            // we are yet only hitting 9's straight
                            curr.insert(currLen, "0");
                        }
                    }
                    if (onlyNines) {
                        // only 9's were found => we need to add an additional 1 ZERO
                        curr.append("0");
                        counter += diff + 1;
                    } else {
                        counter += diff;
                    }
                }
            }
            // finally set prev
            prev = curr;
        }

        print(counter);
    }

    private static void print(Object s) {
        out.println(s);
        if (debug) System.out.println(s);
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
        out.flush();
        out.close();
    }

    public static void main(String[] args) throws Exception {
        run();
//        if (debug)
//            System.in.read();
    }
}

