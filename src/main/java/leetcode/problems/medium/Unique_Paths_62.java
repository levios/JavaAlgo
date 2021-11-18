package leetcode.problems.medium;

import java.math.BigInteger;

public class Unique_Paths_62 {
    public int uniquePaths(int m, int n) {
        if (n == 1 && m == 1) return 1;
        int max = (m-1) + (n-1);
        int oneway = Math.min(m-1, n-1);

        int top = binomial(max, oneway).intValue();

        return top;
    }

    static BigInteger binomial(final int N, final int K) {
        BigInteger ret = BigInteger.ONE;
        for (int k = 0; k < K; k++) {
            ret = ret.multiply(BigInteger.valueOf(N-k))
                    .divide(BigInteger.valueOf(k+1));
        }
        return ret;
    }

    public static void main(String[] args) {
        Unique_Paths_62 app = new Unique_Paths_62();
        System.out.println(app.uniquePaths(7,3)); // 28
        System.out.println(app.uniquePaths(3,7)); // 28
        System.out.println(app.uniquePaths(3,3)); // 6
    }
}
