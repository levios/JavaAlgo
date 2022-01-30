package algo;

import java.math.BigDecimal;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class Algo {
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

//    public int findMaximumXOR(int[] nums) {
//      int bits = -1;
//      List<Integer> highest = new LinkedList<>();
//      for (int n : nums) {
//          if (Integer.highestOneBit(n) > bits) {
//              highest.clear();
//              highest.add(n);
//              bits=Integer.highestOneBit(n);
//          } else if (Integer.highestOneBit(n) == bits) {
//              highest.add(n);
//          }
//      }
//        for (int h : highest) {
//            int i = Integer.highestOneBit(Integer.valueOf(h << 1));
//
//        }
//    }

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
