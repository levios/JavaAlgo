package leetcode.problems.medium;
import leetcode.problems.util.Node;

import java.util.*;

public class Clone_Graph_133 {

    public Node cloneGraph(Node node) {
        if (node == null) return null;
        return cloneGraph(node, new HashMap<>());
    }

    Node cloneGraph(Node node, Map<Integer, Node> map) {
        Node root = new Node(node.val);
        map.putIfAbsent(node.val, root);
        for (Node neighbor : node.neighbors) {
            if (!map.containsKey(neighbor.val)) {
                root.neighbors.add(cloneGraph(neighbor, map));
            } else {
                root.neighbors.add(map.get(neighbor.val));
            }
        }
        return root;
    }

    public static void main(String[] args) {
        Clone_Graph_133 x = new Clone_Graph_133();
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        n1.neighbors.add(n2);
        n2.neighbors.add(n1);
        Node nx = x.cloneGraph(n1);
        System.out.println("end.");
        //System.out.println(x.cloneGraph(n1));
    }


}
