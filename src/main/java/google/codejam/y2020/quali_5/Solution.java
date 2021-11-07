package google.codejam.y2020.quali_5;

import java.io.*;
import java.util.*;

public class Solution {
    // TODO: changes this to  >>>  false
    static final boolean debug = false; // false | true
    ///////////////////////////////////////////
    static final String FILENAME = "F:\\Documents\\GoogleCodeJam\\2020\\quali\\5\\";
    static final String IN = FILENAME + "sample.in";
    static final String OUT = FILENAME + "out.out";
    ///////////////////////////////////////////
    static int N,K;
    static int A,B,C;
    static int[][] example = null;
    private static void solve() {
        N = in.nextInt();
        K = in.nextInt();
        if (K == N+1 || K == N*N-1) {
            out.println("IMPOSSIBLE"); out.flush();
            if (debug)
                System.out.print("IMPOSSIBLE");
            return;
        }
        if (N == 2) {
            if(K == 3) {
                out.println("IMPOSSIBLE"); out.flush();
                if (debug)
                    System.out.print("IMPOSSIBLE");
                return;
            } else {
                example = getExample(N,K);
            }
        } else if (N == 3) {
            if (K != 3 && K != 6 && K != 9) {
                out.println("IMPOSSIBLE"); out.flush();
                if (debug)
                    System.out.print("IMPOSSIBLE");
                return;
            } else {
                example = getExample(N,K);
            }
        } else {
            example = new int[N][N];
            solveForAbove4(N, K);
        }
        out.println("POSSIBLE"); out.flush();
        if (debug)
            System.out.print("POSSIBLE");
        prettyPrint(example);
    }

    private static void solveForAbove4(int n, int k) {
        find_A_B_C(n, k);
        for (int i = 0; i < n - 2; i++) {
            example[i][i] = A;
        }
        example[n-2][n-2] = B;
        example[n-1][n-1] = C;

        if (B != A) {
            example[n-2][n-1] = A;
            example[n-1][n-2] = A;
        }

        List<Integer> alreadyDone = new LinkedList<>();
        alreadyDone.add(A);
        if(B != A) {
            maxBipartiteMatching(example, N, B);
            alreadyDone.add(B);
        }
        if(C != B) {
            maxBipartiteMatching(example, N, C);
            alreadyDone.add(C);
        }

        for (int i = 1; i <= n; i++) {
            if (alreadyDone.contains(i))
                continue;
            maxBipartiteMatching(example, N, i);
//            if (debug) {
//                prettyPrint(example);
//                System.out.println("------------------");
//            }
        }
    }

    private static void maxBipartiteMatching(int[][] bpGraph, int N, int k) {
        // An array to keep track of the applicants assigned to jobs.
        // The value of matchR[i] is the applicant number assigned to job i.
        // Value [-1] indicates nobody is assigned.
        int[] assigned = new int[N];

        int reserved = -1;
        for (int i = 0; i < N; i++) {
            assigned[i] = -1; // Initially all jobs are available
            for (int j = 0; j < N; j++) {
                if (bpGraph[i][j] == k) {
                    assigned[i] = j;
                    reserved = j;
                }
            }
        }

        // Count of jobs assigned to applicants
        for (int nodeFrom = 0; nodeFrom < N; nodeFrom++) {
            if (reserved == nodeFrom)
                continue;
            // Mark all jobs as not seen for next applicant.
            boolean[] seen = new boolean[N]; // default is 'false'
            if (reserved != -1)
                seen[reserved] = true;

            // Find if the applicant 'nodeFrom' can get a job
            bipartiteMatching(bpGraph, nodeFrom, seen, assigned, N);
        }
        // add the new assignments to the graph
        for (int i = 0; i < assigned.length; i++) {
            bpGraph[assigned[i]][i] = k;
        }
    }

    static boolean bipartiteMatching(int[][] bpGraph, int nodeFrom, boolean[] visited, int[] assigned, int N) {
        // Try every job one by one
        for (int nodeTo = 0; nodeTo < N; nodeTo++) {
            // If applicant 'nodeFrom' is interested in job 'nodeTo' and 'nodeTo' is not visited
            if (bpGraph[nodeFrom][nodeTo] == 0 && !visited[nodeTo]) {
                // Mark job as visited
                visited[nodeTo] = true;

                // If job 'nodeTo' is not assigned to an applicant OR previously assigned applicant
                // for job 'nodeTo' (which is matchR[nodeTo]) has an alternate job available.
                // Since nodeTo is marked as visited in the above line, matchR[nodeTo] in the following
                // recursive call will not get job 'nodeTo' again
                if (assigned[nodeTo] < 0 || bipartiteMatching(bpGraph, assigned[nodeTo], visited, assigned, N)) {
                    assigned[nodeTo] = nodeFrom;
                    return true;
                }
            }
        }
        return false;
    }

//    boolean bipartiteMatching(boolean[][] bpGraph, int u, boolean[] seen, int[] matchR, int N) {
//        // Try every job one by one
//        for (int v = 0; v < N; v++) {
//            // If applicant 'u' is interested in job 'v' and 'v' is not visited
//            if (bpGraph[u][v] && !seen[v]) {
//                // Mark v as visited
//                seen[v] = true;
//
//                // If job 'v' is not assigned to an applicant OR previously
//                // assigned applicant for job v (which is matchR[v]) has an alternate job available.
//                // Since v is marked as visited in the above line, matchR[v] in the following
//                // recursive call will not get job 'v' again
//                if (matchR[v] < 0 || bipartiteMatching(bpGraph, matchR[v], seen, matchR, N)) {
//                    matchR[v] = u;
//                    return true;
//                }
//            }
//        }
//        return false;
//    }

    // Returns maximum number of matching from M to N
//    int maxBipartiteMatching(boolean[][] bpGraph, int M, int N) {
//        // An array to keep track of the applicants assigned to jobs.
//        // The value of matchR[i] is the applicant number assigned to job i,
//        // the value -1 indicates nobody is assigned.
//        int[] matchR = new int[N];
//
//        // Initially all jobs are available
//        for (int i = 0; i < N; ++i)
//            matchR[i] = -1;
//
//        // Count of jobs assigned to applicants
//        int result = 0;
//        for (int u = 0; u < M; u++)
//        {
//            // Mark all jobs as not seen
//            // for next applicant.
//            boolean[] seen =new boolean[N] ;
//            for(int i = 0; i < N; ++i)
//                seen[i] = false;
//
//            // Find if the applicant 'u' can get a job
//            if (bipartiteMatching(bpGraph, u, seen, matchR, N))
//                result++;
//        }
//        return result;
//    }

    /**
     * @return false if this is impossible
     */
    private static void find_A_B_C(int n, int k) {
        if (n == k) {
            A = B = C = 1;
        } else if (n * n == k) {
            A = B = C = n;
        } else {
            outer: for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    if (j == i) continue;
                    for (int l = 1; l <= n; l++) {
                        if (i == l) continue;
                        if (i * (n-2) + j + l == k){
                            A = i;
                            B = j;
                            C = l;
                            break outer;
                        }
                    }
                }
            }
        }
    }

    static void prettyPrint(int[][] mx) {
        for (int[] ints : mx) {
            for (int j = 0; j < ints.length; j++) {
                out.print(ints[j]); out.flush();
                if (debug)
                    System.out.print(ints[j]);
                if (j < ints.length-1) {
                    out.print(" "); out.flush();
                    if (debug)
                        System.out.print(" ");
                }
            }
            out.println(); out.flush();
            if (debug)
                System.out.println();
        }
    }

    private static int[][] getExample(int n, int k) {
        if (n == 2) {
            if (k == 2) {
                return new int[][]{
                        {1, 2},
                        {2, 1}};
            } else if (k == 4) {
                return new int[][]{
                        {2, 1},
                        {1, 2}};
            }
        } else if (n == 3) {
            if (k == 3) {
                return new int[][] {
                        {1,2,3},
                        {3,1,2},
                        {2,3,1}};
            } else if (k == 6) {
                return new int[][] {
                        {2,3,1},
                        {1,2,3},
                        {3,1,2}};
            } else if (k == 9) {
                return new int[][] {
                        {3,1,2},
                        {2,3,1},
                        {1,2,3}};
            }
        }
        return null;
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
        out.close();
    }

    public static void main(String[] args) throws Exception {
        run();
//        if (debug)
//            System.in.read();
    }
}
