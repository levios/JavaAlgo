package google.codejam.y2021.r1a;

import java.io.*;
import java.util.*;

/**
 * Round 1A 2021 - Code Jam 2021
 *
 * Hacked Exam (8pts, 6pts, 25pts)
 *
 * 1 <= T <= 2021
 *
 * T1: 1<=N<=2 , 1<=Q<=10
 * T2: 1<=N<=2 , 1<=Q<=40
 * T3: 1<=N<=3 , 1<=Q<=120
 */
public class Hacked_Exam_3 {
    // TODO: changes this to  >>>  false
    static final boolean debug = true; // false | true
    ///////////////////////////////////////////
    static final String FILENAME = "src/main/java/google/codejam/y2021/r1a/";
    static final String IN = FILENAME + "3.in";
    static final String OUT = FILENAME + "3.out";
    ///////////////////////////////////////////
    static int N, Q;
    private static void solve() {
        N = in.nextInt();   // number of students
        Q = in.nextInt();   // number of questions
        //List<String> answers = new ArrayList<>(N);
        //List<Integer> scores = new ArrayList<>(N);
        int correct = -1;
        String max = null;
        for (int i = 0; i < N; i++) {
            String a = in.next();
            int s = in.nextInt();

            if (correct < s) {
                max = a;
                correct = s;
            }
            if (correct < Q-s) {
                max = invert(a);
                correct = Q-s;
            }

            if (correct == Q) {
                // let it run to end
                for (int j = i+1; j < N; j++) {
                    in.next();
                    in.nextInt();
                }
                break;
            }

//            answers.add(a);
//            scores.add(s);
        }
        print(max + " " + asFraction(correct,1));
    }
    static String invert(String a) {
        StringBuilder sb = new StringBuilder();
        for (char c: a.toCharArray()) {
            sb.append(c == 'T' ? 'F' : 'T');
        }
        return sb.toString();
    }
    static String asFraction(long a, long b) {
        long gcd = gcd(a, b);
        return (a / gcd) + "/" + (b / gcd);
    }
    static long gcd(long a, long b) {
        return b == 0 ? a : gcd(b, a % b);
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

