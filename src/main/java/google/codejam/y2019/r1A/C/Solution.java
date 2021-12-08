package google.codejam.y2019.r1A.C;

import combi.Permute;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Round 1A - Code Jam 2019
 * C. Alien Rhyme
 * Each word in the alien language has an accent on exactly one position (letter) in the word; the part of the word
 * starting from the accented letter is called the accent-suffix.
 * Two words are said to rhyme if their accent-suffixes are equal.
 * Given: list of N words, do not know which is the accented letter for each word.
 * Discard 0 or more words, assign accented letters to the remaining words, and then arrange those words into pairs
 * such that each word rhymes only with the other word in its pair, and with none of the words in other pairs.
 * You want to know the largest number of words that can be arranged into pairs in this way.
 * (the same word can have different accentuations in different test cases)
 */
public class Solution {
    // TODO: changes this to  >>>  false
    static final boolean debug = true; // false | true
    ///////////////////////////////////////////
    static final String FILENAME = "F:\\Documents\\GoogleCodeJam\\2019\\r1a\\C\\";
    static final String IN = FILENAME + "sample.in";
    static final String OUT = FILENAME + "out.out";
    ///////////////////////////////////////////
    static int N;
    private static void solve() {
        N = in.nextInt();
        List<String> words = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            words.add(reverse(in.next()));
        }
        //words.sort(Comparator.comparing());
        int upperLimit = (N%2==0) ? N : N-1;
        inPairs = 0;
        Set<String> used = new HashSet<>(upperLimit/2);

        sssss(words, "", used);

        assert !debug || inPairs <= upperLimit;

        print("" + inPairs);
    }

    static int inPairs = 0;
    static List<String> sssss(List<String> words, String prevSub, Set<String> used) {
        List<String> pairs = new ArrayList<>();
        while (1 < words.size()) {
            String word = words.get(0);
            for (int j = word.length(); j>0; j--) {
                String sub = word.substring(0, j);
                if (!used.contains(sub)) {
                    List<String> matched = words.stream().filter(w -> w.startsWith(sub))
                            .sorted()
                            .collect(Collectors.toList());
                    if (matched.size() == 1) {
                        continue;
                    } else if (matched.size() == 2) {
                        // only this and 1 other matched
                        words.removeAll(matched);
                        pairs.addAll(matched);//.stream().map(p -> prevSub + p).collect(Collectors.toList()));
                        used.add(prevSub + sub);
                        inPairs += 2;
                        break;
                    } else {
                        // pick 1 random
                        final int jj = j;
                        List<String> shortened = matched.stream()
                                .map(w -> w.substring(jj))
                                .collect(Collectors.toList());
                        List<String> found = sssss(shortened, prevSub + sub, used).stream()
                                .map(p -> sub + p).collect(Collectors.toList());
                        found.forEach(w -> words.remove(w));
                        pairs.addAll(found);
                        if (!found.contains(word) && matched.size() - found.size() > 1) {
                            found.forEach(matched::remove);
                            Comparator<String> byLength = Comparator.comparingInt(String::length);
                            // backtracking ??
                            String first = matched.stream().filter(w -> !w.equals(word)).findFirst().get();//min(byLength).get();
                            words.remove(first);
                            used.add(prevSub + sub);
                            pairs.add(first);
                            pairs.add(word);
                            inPairs += 2;
                            break;
                        }
                    }
                }
            }

            words.remove(word);
        }
        return pairs;
    }

    private static List<String> getPrefixes(T2<String, String> t2) {
        String smaller = t2._1.length() > t2._2.length() ? t2._2 : t2._1;
        List<String> subs = new LinkedList<>();
        for (int j = 1; j<smaller.length(); j++) {
            String sub = t2._1.substring(0, j);
            if (t2._2.startsWith(sub)) {
                subs.add(sub);
            } else {
                break;
            }
        }
        return subs;
    }

    static class T2<X, Y> {
        public final X _1;
        public final Y _2;
        T2(X _1, Y _2) {
            this._1 = _1;
            this._2 = _2;
        }
        @Override
        public String toString() {
            return _1 + " " + _2;
        }
    }

    static String reverse(String s) {
        return new StringBuilder(s).reverse().toString();
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
