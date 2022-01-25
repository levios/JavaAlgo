package google.codejam.y2021.r1a;

import java.io.*;
import java.util.*;

/**
 * Round 1A 2021 - Code Jam 2021
 * Prime Time (7pts, 13pts, 15pts)
 * You are given a deck of cards, and each card has a prime number written on it.
 * Multiple cards may have the same number.
 * Your goal is to divide the cards into two groups in such a way that the sum of the numbers in
 * the first group is equal to the product of the numbers in the second group.
 * Your score is the sum of the numbers in the first group,
 * or 0 if you cannot split the cards this way at all.
 * What is the maximum score you can achieve?
 *
 * 2 <= Pi <= 499, for all i.
 */
public class Prime_Time {
    // TODO: changes this to  >>>  false
    static final boolean debug = true; // false | true
    ///////////////////////////////////////////
    static final String FILENAME = "src/main/java/google/codejam/y2021/r1a/";
    static final String IN = FILENAME + "2.in";
    static final String OUT = FILENAME + "2.out";
    ///////////////////////////////////////////
    static int M;
    private static void solve() {
        M = in.nextInt(); // number of distinct prime numbers in your deck
        long res = 0;
        long sum = 0;
        Map<Integer, Long> map = new HashMap<>();
        for (int i = 0; i < M; i++) {
            // Ni cards with the prime Pi written on them.
            int P = in.nextInt();
            long N = in.nextLong();
            sum += (long) P * N;
            map.put(P,N);
        }

        // precompute primes until 499
        List<Integer> preCalcPrimes = primes(499L);

        // there are maximum 60 numbers in the product group
        // so their max sum is: 499 * 60 = 29940
        int max = 499 * 60;
        // iterate over every possible sum of the first group: [sum-499*60 ; sum]
        outer: for (long sumOfFirstGroup = Math.max(2, sum-max); sumOfFirstGroup <= sum; sumOfFirstGroup++) {
            // check the prime factors for each number
            Map<Integer, Long> factors = primeFactors(sumOfFirstGroup, preCalcPrimes);
            if (factors == null || factors.isEmpty()) continue;
            long tempSum = sum;
            for (Map.Entry<Integer, Long> factor : factors.entrySet()) {
                if (map.get(factor.getKey())==null || map.get(factor.getKey()) < factor.getValue()) {
                    continue outer;
                }
                // substract from sum
                tempSum -= (long) factor.getKey() * factor.getValue();
            }
            // check if the 2 sums are equal
            if (tempSum == sumOfFirstGroup) {
                res = Math.max(res, sumOfFirstGroup);
            }
        }
        print(res);
    }

    // precompute primes until until
    static List<Integer> primes(long until) {
        List<Integer> result = new LinkedList<>();
        outer: for (int i = 2; i <= until; i++) {
            for (int j = 2; j <= Math.sqrt(i); j++) {
                if (i % j == 0) continue outer;
            }
            result.add(i);
        }
        return result;
    }

    // prime factorization with precomputed primes only
    static Map<Integer, Long> primeFactors(long l, List<Integer> primes) {
        Map<Integer, Long> factors = new HashMap<>();
        for (int prime: primes) {
            while (l % prime == 0) {
                factors.putIfAbsent(prime, 0L);
                factors.computeIfPresent(prime, (k,v) -> v+1L);
                l /= prime;
            }
        }
        if (l != 1) return null;
        return factors;
    }

    private static void solve_for_test_sets_1_and_2() {
        M = in.nextInt(); // number of distinct prime numbers in your deck
        long res = 0;
        long sum = 0;
        Map<Long, Integer> map = new HashMap<>();
        List<Integer> primes = new LinkedList<>();
        for (int i = 0; i < M; i++) {
            // Ni cards with the prime Pi written on them.
            long P = in.nextLong();
            int N = in.nextInt();
            sum += P * N;
            map.put(P,N);
            for (int j = 0; j < N; j++) {
                primes.add((int)P);
            }
        }
        List<List<Integer>> result = new LinkedList<>();
        backtrack(result, new LinkedList<>(), primes, sum, 1, 0);
        for (List<Integer> list: result) {
            res = Math.max(res, list.stream().reduce(1, (a,b) -> a*b));
        }
        print(res);
    }

    static void backtrack(List<List<Integer>> result, List<Integer> current, List<Integer> nums, long diff,
                          int product, int start) {
        if (product == diff) {
            result.add(new ArrayList<>(current));
            return;
        }
        for (int i = start; i < nums.size(); i++) {
            // big idea: i > start
            if ((long) product * nums.get(i) > diff - nums.get(i)
                    || (i > start && nums.get(i).equals(nums.get(i - 1))) ) continue;
            current.add(nums.get(i));
            backtrack(result, current, nums, diff - nums.get(i), product * nums.get(i) , i+1);
            current.remove(current.size()-1);
        }
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

