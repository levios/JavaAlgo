package leetcode.problems.util;

public class UnionFind {
    int[] parent;
    int[] weight;

    public UnionFind(int num) {
        parent = new int[num];
        weight = new int[num];

        for(int i =  0; i < num; i++) {
            parent[i] = i;
            weight[i] = 1;
        }
    }

    public void union(int a, int  b) {
        int rootA = root(a);
        int rootB = root(b);

        if (rootA == rootB) {
            return;
        }

        if (weight[rootA] > weight[rootB]) {
            parent[rootB] = rootA;
            weight[rootA] += weight[rootB];
        } else {
            parent[rootA] = rootB;
            weight[rootB] += weight[rootA];
        }
    }

    public int root(int a) {
        if (parent[a] == a) {
            return a;
        }

        parent[a] = root(parent[a]);
        return parent[a];
    }
}