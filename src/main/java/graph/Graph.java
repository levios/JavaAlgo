package graph;
/**
 *
 */
public class Graph {
    private boolean[][] g;
    private static Graph graph;
    private Graph(int N) {
        g = new boolean[N][N];
    }
    public static Graph create(int N) {
        if (graph == null)
            graph = new Graph(N);
        return graph;
    }
    public Graph add(int i, int j) {
        g[i][j] = true;
        return this;
    }
    public boolean[][] getEdges() {
        return g;
    }
}
