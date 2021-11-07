package google.codejam.y2020.r1A.A;

import java.io.*;
import java.util.*;
import java.util.stream.*;

/**
 * Round 1A 2020 - Code Jam 2020
 * Pattern Matching
 * Pattern p matches a name m if there is a way of replacing every asterisk in p with a (possibly empty) string
 * to obtain m.
 * Notice that each asterisk may be replaced by a different string.
 * Given N patterns, can you find a single name of at most 104 letters that matches all those patterns at once,
 * or report that it cannot be done?
 */
public class Solution {
    // TODO: changes this to  >>>  false
    static final boolean debug = true; // false | true
    ///////////////////////////////////////////
    static final String FILENAME = "F:\\Documents\\GoogleCodeJam\\2020\\r1a\\1\\";
    static final String IN = FILENAME + "sample.in";
    static final String OUT = FILENAME + "out.out";
    ///////////////////////////////////////////
    static int N;
    static String answer = null;
    private static void solve() {
        N = in.nextInt();
        String startsWith = "";
        String endsWith = "";

        List<String> patterns = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            String pattern = in.next();
            patterns.add(pattern);
        }

        List<String> jokers = new LinkedList<>();
        for (String pattern: patterns) {

            List<String> splitPatterns = splitPattern(pattern);

            for (String p: splitPatterns) {
                if (p.startsWith("*") && p.endsWith("*")) { // JOKER
                    jokers.add(p);
                } else if (p.startsWith("*")) { // END pattern, e.g. "*XYZ"
                    String trimmed = p.substring(1);
                    if (isSuffix(endsWith, trimmed)) {
                        // do nothing: trimmed is suffix to endsWith
                    } else if (isSuffix(trimmed, endsWith)) {
                        // replace
                        endsWith = trimmed;
                    } else {
                        // impossible
                        print("*");
                        return;
                    }
                } else { // START pattern, e.g. "ABC*"
                    String trimmed = p.substring(0, p.length()-1);
                    if (isPrefix(startsWith, trimmed)) {
                        // good, do nothing
                    } else if (isPrefix(trimmed, startsWith)) {
                        // replace
                        startsWith = trimmed;
                    } else {
                        // impossible
                        print("*");
                        return;
                    }
                }
            }
        }

        // create final String
        answer = startsWith;
        for (String joker: jokers) {
            answer += joker;
        }
        answer += endsWith;
        answer = answer.replace("*", "");

        print(answer);
    }

    /**
     * Split the pattern into smaller sub-patterns.
     * e.g "AB*C" => ["AB*", "*C"]
     */
    static List<String> splitPattern(String pattern) {
        List<String> patterns = new LinkedList<>();
        pattern = pattern.replace("**", "*");
        String current = "";
        for (int i = 0; i < pattern.length(); i++) {
            current += pattern.charAt(i);
            if (pattern.charAt(i) == '*' && i > 0) {
                patterns.add(current);
                current = "*";
            }
        }
        if(current.length() > 1)
            patterns.add(current);
        return patterns;
    }

    /**
     * Checks if 'sub' is a prefix sub string to 'str' or not
     * e.g.
     * str="ABCD", sub="AB" => true
     * str="ACD", sub="AB" => false
     * @return true if yes
     */
    static boolean isPrefix(String str, String sub) {
        if(str.length() < sub.length()) return false;
        for (int i = 0; i < sub.length(); i++) {
            if (str.charAt(i) != sub.charAt(i))
                return false;
        }
        return true;
    }

    static boolean isSuffix(String str, String sub) {
        str = new StringBuilder(str).reverse().toString();
        sub = new StringBuilder(sub).reverse().toString();
        return isPrefix(str, sub);
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
            solve();
        }
        in.close();
        out.close();
    }

    public static void main(String[] args) throws Exception {
        run();
    }
}
