package leetcode.problems.hard;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

/**
 * Constraints:
    m == grid.length
    n == grid[i].length
    1 <= m, n <= 20
    1 <= m * n <= 20
    -1 <= grid[i][j] <= 2
    There is exactly one starting cell and one ending cell.
 *
 * tags: GRAPH ; DFS ; BACKTRACK ; BACKTRACKING
 */
public class Unique_Paths_III_980 {

    static int PATHS;
    static int CELL_LEFT;
    static int m,n;
    static int startX, startY;
    public int uniquePathsIII(int[][] grid) {
        PATHS = 0;
        CELL_LEFT = 1;
        m = grid.length;
        n = grid[0].length;
        init(grid, m, n);

        dfs(grid, startX, startY);

        return PATHS;
    }

    void dfs(int[][] grid, int x, int y) {
        // invalid case
        if (x < 0 || y < 0 || x >= m || y >= n || grid[x][y] < 0) {
            return;
        }
        // exit condition
        if (grid[x][y] == 2) {
            if (CELL_LEFT == 0) {
                PATHS += 1;
            }
            return;
        }

        CELL_LEFT--;
        grid[x][y] = -2; // visited

        dfs(grid, x-1, y);
        dfs(grid, x+1, y);
        dfs(grid, x, y-1);
        dfs(grid, x, y+1);

        // backtrack
        grid[x][y] = 0;
        CELL_LEFT++;
    }

    void init(int[][] grid, int m, int n) {
        for (int x = 0; x < m; x++) {
            for (int y = 0; y < n; y++) {
                if (grid[x][y] == 0)
                    CELL_LEFT++;
                if (grid[x][y] == 1) {
                    startX = x;
                    startY = y;
                }
            }
        }
    }

    public static void main(String[] args) {
        Unique_Paths_III_980 app = new Unique_Paths_III_980();
        System.out.println(app.uniquePathsIII(new int[][]{{1,0,0,0},{0,0,0,0},{0,0,2,-1}}));// 2
        System.out.println(app.uniquePathsIII(new int[][]{{1,0,0,0},{0,0,0,0},{0,0,0,2}})); // 4
        System.out.println(app.uniquePathsIII(new int[][]{{0,1},{2,0}}));                   // 0
    }


    /// spaghetti -- BUT WORKING

    public int uniquePathsIII_(int[][] grid) {
        PATHS = 0;
        CELL_LEFT = 1;
        m = grid.length;
        n = grid[0].length;
        Pair root = init0(grid, m, n);

        dfs(grid, root);

        return PATHS;
    }

    void dfs(int[][] grid, Pair root) {
        // exit condition
        if (grid[root.x][root.y] == 2) {
            if (CELL_LEFT == 0) {
                PATHS += 1;
            }
            return;
        }

        CELL_LEFT--;
        grid[root.x][root.y] = 3; // visited

        for (Pair neighbor : neighbors(root, m, n)){
            if (grid[neighbor.x][neighbor.y] == 0 || grid[neighbor.x][neighbor.y] == 2) {
                dfs(grid, neighbor);
            }
        }

        // backtrack
        grid[root.x][root.y] = 0;
        CELL_LEFT++;
    }

    Pair init0(int[][] grid, int m, int n) {
        Pair root = null;
        for (int x = 0; x < m; x++) {
            for (int y = 0; y < n; y++) {
                if (grid[x][y] == 0)
                    CELL_LEFT++;
                if (grid[x][y] == 1) {
                    root = new Pair(x,y);
                }
            }
        }
        return root;
    }

    List<Pair> neighbors(Pair node, int m, int n) {
        List<Pair> ne = new LinkedList<>();
        if (node.x-1 >= 0)
            ne.add(new Pair(node.x-1, node.y));
        if (node.x+1 < m)
            ne.add(new Pair(node.x+1, node.y));
        if (node.y-1 >= 0 )
            ne.add(new Pair(node.x, node.y-1));
        if (node.y+1 < n)
            ne.add(new Pair(node.x, node.y+1));
        return ne;
    }

    static class Pair {
        int x, y;
        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Pair pair = (Pair) o;
            return x == pair.x && y == pair.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }

}
