package google.codejam.y2021.quali_5;

import scala.Int;

import java.io.*;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Cheating Detection (11pts, 20pts)
 * https://codingcompetitions.withgoogle.com/codejam/round/000000000043580a/00000000006d1155#analysis
 *
 *
 */
public class Solution {
    // TODO: changes this to  >>>  false
    static final boolean debug = true; // false | true
    ///////////////////////////////////////////
    static final String FILENAME = "src/main/java/google/codejam/y2021/quali_5/";
    static final String IN = FILENAME + "sample.in";
    static final String OUT = FILENAME + "out.out";
    static final String IMPOSSIBLE = "IMPOSSIBLE";
    ///////////////////////////////////////////
    static int P;
    private static void solve() {
        int res = 0;
        int sNum = 100;
        int qNum = 10000;
        String[] answers = new String[sNum];
        Map<Integer, Integer> students = new HashMap<>();
        Map<Integer, Integer> questions = new HashMap<>();
        for (int i = 0; i < sNum; i++) {
            answers[i] = in.next();
            students.computeIfAbsent(i, k -> 0);
            for (int j = 0; j < 10000; j++) {
                questions.computeIfAbsent(j, k -> 0);
                if (answers[i].charAt(j) == '1') {
                    students.computeIfPresent(i, (k,v) -> v + 1);
                    questions.computeIfPresent(j, (k,v) -> v + 1);
                }
            }
        }

        Map<Integer, Integer> swapped = students.entrySet().stream().collect(Collectors.toMap(Map.Entry::getValue, Map.Entry::getKey));


//        // decreasing order
//        Stream<Map.Entry<Integer, Integer>> sortedQuestions =
//                questions.entrySet().stream()
//                        .sorted(Collections.reverseOrder(Map.Entry.comparingByValue()));
//
//        // increasing order
//        Stream<Map.Entry<Integer, Integer>> sortedStudents =
//                students.entrySet().stream()
//                        .sorted(Map.Entry.comparingByValue()).collect(Collectors.toList());

//        System.out.println(">9000 " + count(map, v -> v > 9000)); // 1
//        System.out.println(">8000 " + count(map, v -> v > 8000)); // 17
//        System.out.println(">6666 " + count(map, v -> v > 6666)); // 35
//        System.out.println(">5000 " + count(map, v -> v > 5000)); // 56
//        System.out.println(">3000 " + count(map, v -> v > 3000)); // 74
//        System.out.println(">1000 " + count(map, v -> v > 1000)); // 100

        print(res);
    }

    static long count(Map<Integer, Integer> map, Predicate<Integer> p) {
        return map.values().stream().filter(p).count();
    }

    private static void print(Object s) {
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
        P = in.nextInt(); // percentage of test cases
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

