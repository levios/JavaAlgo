package leetcode.problems.util;

public class DSU {
    int representative [];
    int size [];

    public DSU(int sz) {
        representative = new int[sz];
        size = new int[sz];

        for (int i = 0; i < sz; ++i) {
            // Initially each group is its own representative
            representative[i] = i;
            // Intialize the size of all groups to 1
            size[i] = 1;
        }
    }

    // Finds the representative of group x
    public int findRepresentative(int x) {
        if (x == representative[x]) {
            return x;
        }

        // This is path compression
        return representative[x] = findRepresentative(representative[x]);
    }

    // Unite the group that contains "a" with the group that contains "b"
    public void unionBySize(int a, int b) {
        int representativeA = findRepresentative(a);
        int representativeB = findRepresentative(b);

        // If nodes a and b already belong to the same group, do nothing.
        if (representativeA == representativeB) {
            return;
        }

        // Union by size: point the representative of the smaller
        // group to the representative of the larger group.
        if (size[representativeA] >= size[representativeB]) {
            size[representativeA] += size[representativeB];
            representative[representativeB] = representativeA;
        } else {
            size[representativeB] += size[representativeA];
            representative[representativeA] = representativeB;
        }
    }
}