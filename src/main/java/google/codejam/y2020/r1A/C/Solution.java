package google.codejam.y2020.r1A.C;

import java.io.*;
import java.util.*;

/**
 * Round 1A 2020 - Code Jam 2020
 * C. Square Dance
 *  Dance floor with R rows and C columns, consisting of unit square cells;
 *  R * C competitors;
 * compass neighbor of competitor x: y such that y shares a row or column with x,
 * and there are no competitors standing in cells between x and y.
 * Between rounds i and i+1, if a competitor 'd' had at least 1 compass neighbor during round i, and d's skill level
 * is strictly less than the average skill level of all of d's compass neighbors, 'd' is eliminated.
 *
 * Given the skill levels of the dancers on the floor for the 1st round, what is the interest level of the competition?
 */
public class Solution {
    // TODO: changes this to  >>>  false
    static final boolean debug = true; // false | true
    ///////////////////////////////////////////
    static final String FILENAME = "F:\\Documents\\GoogleCodeJam\\2020\\r1a\\C\\";
    static final String IN = FILENAME + "sample.in";
    static final String OUT = FILENAME + "out.out";
    ///////////////////////////////////////////
    static int R,C;
    private static void solve() {
        R = in.nextInt();
        C = in.nextInt();
        int[][] floor = new int[R][C];
        long Ssum = 0; // sum of dancer's skill levels
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                int dancer = in.nextInt();
                floor[i][j] = dancer;
                Ssum += dancer;
            }
        }

        // interest level
        long iLevel = Ssum;

        if (R * C > 1) {
            while (true) { // rounds
                // row , col , skill
                Set<T3<Integer, Integer, Integer>> toRemove = new HashSet<>();
                for (int i = 0; i < R; i++) {
                    for (int j = 0; j < C; j++) {
                        int dancer = floor[i][j];
                        if (dancer > 0) { // dancer is alive
                            double sum = 0.0;
                            int counter = 0;
                            for (int k = i-1; k >= 0; k--) { // NORTH
                                if (floor[k][j] != 0) {
                                    sum += floor[k][j];
                                    counter++;
                                    break;
                                }
                            }
                            for (int k = i+1; k < R; k++) { // SOUTH
                                if (floor[k][j] != 0) {
                                    sum += floor[k][j];
                                    counter++;
                                    break;
                                }
                            }
                            for (int k = j+1; k < C; k++) { //  EAST
                                if (floor[i][k] != 0) {
                                    sum += floor[i][k];
                                    counter++;
                                    break;
                                }
                            }
                            for (int k = j-1; k >= 0; k--) { //  WEST
                                if (floor[i][k] != 0) {
                                    sum += floor[i][k];
                                    counter++;
                                    break;
                                }
                            }
                            
                            double avg = sum / counter;
                            if (dancer < avg) { // remove dancer
                                toRemove.add(new T3<>(i, j, dancer));
                            }  
                        } 
                    }
                }

                if (toRemove.isEmpty())
                    break;

                for (T3<Integer, Integer, Integer> remove: toRemove) {
                    Ssum -= remove._3;
                    floor[remove._1][remove._2] = 0;
                }

                iLevel += Ssum;
            }
        }

        print("" + iLevel);
    }




    static class T3<X, Y, Z> {
        public final X _1;
        public final Y _2;
        public final Z _3;
        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            T3<?, ?, ?> t3 = (T3<?, ?, ?>) o;
            return Objects.equals(_1, t3._1) &&
                    Objects.equals(_2, t3._2) &&
                    Objects.equals(_3, t3._3);
        }
        @Override
        public int hashCode() { return Objects.hash(_1, _2, _3); }
        T3(X _1, Y _2, Z _3) {
            this._1 = _1;
            this._2 = _2;
            this._3 = _3;
        }
        @Override
        public String toString() {
            return _1 + " " + _2 + " " + _3;
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
