package graph;

public class Main {

    public static void main(String[] args) {
        int[][] graph = {
            { 0, 4, 0, 0, 0, 0, 0, 8, 0 },
            { 4, 0, 8, 0, 0, 0, 0, 11, 0 },
            { 0, 8, 0, 7, 0, 4, 0, 0, 2 },
            { 0, 0, 7, 0, 9, 14, 0, 0, 0 },
            { 0, 0, 0, 9, 0, 10, 0, 0, 0 },
            { 0, 0, 4, 14, 10, 0, 2, 0, 0 },
            { 0, 0, 0, 0, 0, 2, 0, 1, 6 },
            { 8, 11, 0, 0, 0, 0, 1, 0, 7 },
            { 0, 0, 2, 0, 0, 0, 6, 7, 0 }
        };

        // Dijkstra
//        var d = GraphAlgo.dijkstra(graph, 0);
//        var res = Arrays.stream(d).boxed().map(String::valueOf).collect(Collectors.joining(", "));

//        var g2 = Graph.create(3).add(0,1).add(1,2).add(2,0);
//        var res = GraphAlgo.isCyclicGraph(3, g2.getEdges());

//        var n5 = new Node(5);
//        n5.left = new Node(3);
//        n5.right = new Node(7);
//        n5.right.left = new Node(6);
//        n5.left.left = new Node(1);
//        var n3 = new Node(3);
//        n3.left = new Node(1);
//        n3.right = new Node(6);
//        n3.right.left = new Node(5);
//        n3.right.right = new Node(7);
//        var l1 = new LinkedList<Integer>();
//        n5.inorder(l1);
//        var isSame = Node.isSameInOrder(n3, l1);

        Node n5 = new Node<>("*");
        n5.left = new Node<>("+");
        n5.right = new Node<>("-");
        n5.right.left = new Node<>("3");
        n5.right.right = new Node<>("4");
        n5.left.left = new Node<>("1");
        n5.left.right = new Node<>("2");


        Node n = Node.polishNotation("12+34-*");
        n.syntaxTree();
//        System.out.println("Result: " +  );
    }
}
