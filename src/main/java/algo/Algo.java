package algo;

import java.math.BigDecimal;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class Algo {

    /**
     * Implement GREP function
     * function int[]/List grep(string haystack, string needle)
     * haystack = "aaabcdddbjbjbdjbdjabcdefghi"
     * needle = "abc"
     * [2,14]
     */

  static boolean isBalanced(String s) {
        if (s.length() % 2 == 1) return false;
        Deque<Character> q = new LinkedList<>();
        for (char c : s.toCharArray()) {
            if (c == '{' || c == '(') {
                q.add(c);
            } else {
                if (q.isEmpty()) return false;
                char l = q.removeLast();
                if (c == ')') {
                    if (l != '(') return false;
                } else {
                    if (l != '{') return false;
                }
            }
        }
        return q.isEmpty();
    }

    public static String decryptMessage(String encryptedMessage) {
        String[] ss = encryptedMessage.split(" ");
        Queue<String> res = new LinkedList<>();
        for (int i = ss.length-1; i >= 0; i--) {
            res.add(dec(ss[i]));
        }
        return String.join(" ", res);
    }

    static String dec(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if ((int)(c-48) >= 2 && (int)(c-48) <= 9) {
                for (int j = 1; j < (int)(c-48); j++) {
                    sb.append(s.charAt(i-1));
                }
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        //System.out.println(decryptMessage("ne1ds"));
        List<List<Long>> x = new LinkedList<>();
        List<Long> a= new LinkedList<>(), b= new LinkedList<>(), c = new LinkedList<>();
        a.add(4L);
        a.add(8L);
        x.add(a);
        a.add(15L);
        a.add(30L);
        x.add(a);
        a.add(25L);
        a.add(50L);
        x.add(a);
        System.out.println(nearlySimilarRectangles(x));
    }


    public static int filledOrders(List<Integer> order, int k) {
        // Write your code here
        Collections.sort(order);
        int sum = 0;
        for (int i = 0; i < order.size(); i++) {
            sum += order.get(i);
            if (sum > k) {
                return i;
            }
        }
        return order.size();
    }


    static long xx(List<List<Long>> sides) {
        java.util.concurrent.atomic.AtomicLong res = new java.util.concurrent.atomic.AtomicLong(0);
        Map<String, Long> m = new HashMap<>();
        for (List<Long> r1 : sides) {
            Long a = r1.get(0);
            Long b = r1.get(1);
            long gcd = gcd(a,b);
            a /= gcd;
            b /= gcd;
            String k = a + "-" + b;
            long count = m.getOrDefault(k, 0L);
            m.put(k, count+1);
        }

        m.forEach((key, value) -> {
            if (value > 1) {
                res.addAndGet(value * (value-1) / 2);
            }
        });

        return res.get();
    }

    static long gcd(long a, long b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    static long nearlySimilarRectangles(List<List<Long>> sides) {
        List<List<Long>> s1 = new LinkedList<>();
        List<List<Long>> s2 = new LinkedList<>();
        for (int i = 0; i < sides.size(); i++) {
            List<Long> r1 = sides.get(i);
            Long a = r1.get(0);
            Long b = r1.get(1);
            if (a < b) {
                s1.add(r1);
            } else {
                s2.add(r1);
            }
        }
        return x(s1) + x(s2);
    }

    static long x(List<List<Long>> sides) {
        int res = 0;
        for (int i = 0; i < sides.size() - 1; i++) {
            List<Long> r1 = sides.get(i);
            Long a = r1.get(0);
            Long b = r1.get(1);
            for (int j = i+1; j < sides.size(); j++) {
                List<Long> r2 = sides.get(j);
                Long c = r2.get(0);
                Long d = r2.get(1);
                if (a * d == b * c) {
                    res++;
                }
            }
        }
        return res;
    }

    int max = 0;
    public int largestComponentSize(int[] A) {
        boolean[] isPrime = new boolean[100001];
        Arrays.fill(isPrime, true);
        Set<Integer> primes = new HashSet<>();
        // all primes less than 100000
        for (int i = 2; i <= 100000; i++) {
            if (isPrime[i]) {
                primes.add(i);
                for (int j = 2; j * i <= 100000; j++) {
                    isPrime[j * i] = false;
                }
            }
        }
        int n = A.length;
        int[] counts = new int[n];
        int[] parents = new int[n];
        int[] primeToIndex = new int[100001];
        Arrays.fill(primeToIndex, -1);
        for (int i = 0; i < n; i++) {
            parents[i] = i;
            counts[i] = 1;
        }
        for (int i = 0; i < n; i++) {
            int a = A[i];
            for (int p : primes) {
                if (primes.contains(a)) { // Optimization
                    p = a;
                }
                if (a % p == 0) {
                    if (primeToIndex[p] > -1) {
                        union(parents, counts, primeToIndex[p], i);
                    }
                    primeToIndex[p] = i;
                    while (a % p == 0) {
                        a /= p;
                    }
                }
                if (a == 1) {
                    break;
                }
            }
        }
        return max;
    }
    private int find(int[] parents, int a) {
        if (parents[a] != a) {
            parents[a] = find(parents, parents[a]);
        }
        return parents[a];
    }
    private void union(int[] parents, int[] counts, int a, int b) {
        int root1 = find(parents, a), root2 = find(parents, b);
        if (root1 == root2) {
            return;
        }
        int count = counts[root2] + counts[root1];
        max = Math.max(count, max);
        parents[root1] = root2;
        counts[root2] = count;
    }
}
