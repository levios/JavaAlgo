package google.codejam.y2021.quali_2;

import java.io.*;
import java.util.Scanner;

public class Solution {
    // TODO: changes this to  >>>  false
    static final boolean debug = true; // false | true
    ///////////////////////////////////////////
    static final String FILENAME = "F:\\Documents\\GoogleCodeJam\\2021\\quali\\";
    static final String IN = FILENAME + "sample.in";
    static final String OUT = FILENAME + "out.out";
    ///////////////////////////////////////////
    static int X,Y;
    static String S = null;
    private static void solve() {
        X = in.nextInt();
        Y = in.nextInt();
        S = in.next();

        String S2  = "";
        while (true) {
            S2 = S.replace("CC", "C")
                    .replace("JJ", "J")
                    .replace("??", "?")
                    .replace("C?", "C")
                    .replace("J?", "J")
                    .replace("?C", "C")
                    .replace("?J", "J");
            if (S.length() == S2.length()) {
                break;
            }
            S = S2;
        }


//        StringBuilder sb = new StringBuilder(S.substring(0,1));
//        // int j = 1;
//        int i = 0;
//        while(i < S.length() - 1) {
//            if (S.charAt(i) == S.charAt(i + 1)) {
//                // sb.append(S.charAt(i));
//            } else {
//                sb.append(S.charAt(i+1));
//            }
//            i++;
//        }
//        //print(sb.toString());
//        S = sb.toString();
//
//        sb = new StringBuilder();
//        i = 0;
//        while(i < S.length() - 2) {
//            String sub = S.substring(i, i+3);
//            if (sub.equals("C?C") || sub.equals("?C?")) {
//                sb.append("C");
//                i += 2;
//            } else if (sub.equals("J?J") || sub.equals("?J?")) {
//                sb.append("J");
//                i += 2;
//            } else if (sub.equals("C?J")) {
//                sb.append("CJ");
//                i += 2;
//            } else if (sub.equals("J?C")) {
//                sb.append("JC");
//                i += 2;
//            } else if (i + 2 < S.length() - 1) {
//                sb.append(S.charAt(i));
//                i++;
//            } else {
//                sb.append(sub);
//                i++;
//            }
//        }

        //print(S2);
        print("" + sum(S2));
    }

    static long sum(String s) {
        long sum  = 0;
        for (int i = 0; i < s.length() - 1; i++) {
            if (s.substring(i,i+2).equals("CJ")) {
                sum += X;
            } else if (s.substring(i,i+2).equals("JC")) {
                sum += Y;
            }
        }
        return sum;
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

