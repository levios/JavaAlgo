package google.codejam.y2019.r1C.A;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Round 1C 2019 - Code Jam 2019
 * A. Robot Programming Strategy
 * R (for "Rock"), P (for "Paper"), or S (for "Scissors").
 * Each robot plays its program. Whenever reached the end of its program and needs its next move,
 * it returns to the start of its program.
 * The tournament is played in K rounds and has a single-elimination "bracket" structure.
 * There are N = 2^K robots in total, numbered 0 through N - 1.
 * Knowing all the other programs, is it possible to write a program that is guaranteed to win the tournament ?
 */
public class Solution {
    // TODO: changes this to  >>>  false
    static final boolean debug = true; // false | true
    ///////////////////////////////////////////
    static final String FILENAME = "F:\\Documents\\GoogleCodeJam\\2019\\r1c\\A\\";
    static final String IN = FILENAME + "sample.in";
    static final String OUT = FILENAME + "out.out";
    ///////////////////////////////////////////
    static int N; // number of adversaries (other robots) in the tournament
    static String answer = "IMPOSSIBLE"; // between 1 <= X <= 500 characters, guaranteed to win
    private static void solve() {
        N = in.nextInt();
        boolean impossible = false;
        Set<String> progs = new HashSet<>();
        for (int i = 0; i < N; i++) {
            progs.add(in.next());
        }

        List<Character> myProgram = new LinkedList<>();

        main:
        for (int i = 0; ; i++) {
            Set<Character> chars = new HashSet<>();
            for (String p: progs) {
                int pos = i % p.length();
                char current = p.charAt(pos);
                chars.add(current);
                if (chars.size() == 3) {
                    impossible = true;
                    break main;
                }
            }
            final int idx = i;
            if (chars.contains('P') && chars.contains('R')) {
                myProgram.add('P');
                progs.removeAll(
                        progs.stream().filter(p -> p.charAt(idx % p.length()) == 'R').collect(Collectors.toSet())
                );
            } else if (chars.contains('P') && chars.contains('S')) {
                myProgram.add('S');
                progs.removeAll(
                        progs.stream().filter(p -> p.charAt(idx % p.length()) == 'P').collect(Collectors.toSet())
                );
            } else if (chars.contains('S') && chars.contains('R')) {
                myProgram.add('R');
                progs.removeAll(
                        progs.stream().filter(p -> p.charAt(idx % p.length()) == 'S').collect(Collectors.toSet())
                );
            } else if (chars.contains('S')) {
                myProgram.add('R');
                break;
            } else if (chars.contains('P')) {
                myProgram.add('S');
                break;
            } else if (chars.contains('R')) {
                myProgram.add('P');
                break;
            }

            if (myProgram.size() > 500) {
                impossible = true;
                break;
            }
        }

        if (impossible) {
            answer = "IMPOSSIBLE";
        } else {
            StringBuilder sb = new StringBuilder();
            for (Character ch : myProgram)
                sb.append(ch);
            answer = sb.toString();
        }

        print(answer);
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
