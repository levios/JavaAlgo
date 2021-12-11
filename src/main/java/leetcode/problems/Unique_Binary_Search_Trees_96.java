package leetcode.problems;

import combi.Permute;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * https://leetcode.com/problems/unique-binary-search-trees
 * https://leetcode.com/problems/unique-binary-search-trees/discuss/31666/DP-Solution-in-6-lines-with-explanation.-F(i-n)-G(i-1)-*-G(n-i)
 *
 * Constraints:
 *      1 <= n <= 19
 *
 * Tags: binary tree, recursive, dp, dynamic programming
 */
public class Unique_Binary_Search_Trees_96 {

    /**
     * the subsequence 1…(i-1) on its left side would lay on the left branch of the root,
     * and similarly the right subsequence (i+1)…n lay on the right branch of the root
     *
     * G(n): the number of unique BST for a sequence of length n.
     * F(i, n): the number of unique BST, where the number i is the root of BST, and the sequence ranges from 1 to n.
     *
     * G(0) = 1
     * G(1) = 1
     * G(n) = F(1,n) + F(2,n) + ... + F(n,n)
     * F(i, n) = G(i-1) * G(n-i)    1 <= i <= n
     * G(n) = G(0) * G(n-1) + G(1) * G(n-2) + ... + G(n-1) * G(0)
     */
    public int numTrees(int n) {
        int[] G = new int[n+1];
        G[0] = G[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                G[i] += G[j] * G[i-1-j];
            }
        }
        return G[n];
    }

    public int numTrees0(int n) {
        List<Integer> a = IntStream.range(1, n+1).boxed().collect(Collectors.toList());
        List<BinTree> trees = new LinkedList<>();
        for (List<Integer> perm : new Permute<>(a)) {
            BinTree bt = BinTree.from(perm);
            boolean uniq = true;
            for (BinTree tree: trees) {
                if (BinTree.isSame(bt, tree)) {
                    uniq = false;
                    break;
                }
            }
            if (uniq) {
                trees.add(bt);
            }
        }
        return trees.size();
    }

    static class BinTree {
        BinTree l; // left
        BinTree r; // right
        int value;
        BinTree(int value) {
            this.value = value;
        }
        BinTree(int value, BinTree l, BinTree r) {
            this.l = l;
            this.r = r;
            this.value = value;
        }
        static BinTree from(List<Integer> l) {
            BinTree root = new BinTree(l.get(0));
            for (int i=1; i<l.size(); i++) {
                BinTree b = new BinTree(l.get(i));
                // pointer
                BinTree p = root;
                while (true) {
                    if (b.value < p.value) {
                        if (p.l == null) {
                            p.l = b;
                            break;
                        }
                        p = p.l;
                    } else {
                        if (p.r == null) {
                            p.r = b;
                            break;
                        }
                        p = p.r;
                    }
                }
            }
            return root;
        }
        static boolean isSame(BinTree one, BinTree other) {
            if (one == null && other == null) {
                return true;
            } else if (one != null && other != null) {
                return (one.value == other.value) && isSame(one.l, other.l) && isSame(one.r, other.r);
            }
            return false;
        }
    }

    public static void main(String[] args) {
        Unique_Binary_Search_Trees_96 app = new Unique_Binary_Search_Trees_96();
        System.out.println(app.numTrees(3)); // 5
    }
}
