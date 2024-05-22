package Google.May.Others;

import java.util.*;

public class Clone_Graph {

    class Node {
        public int val;
        public List<Node> neighbors;
        public Node() {
            val = 0;
            neighbors = new ArrayList<Node>();
        }
        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }
        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }



    public Node BFS(Node node){
        HashMap<Node,Node> map = new HashMap<>();
        Queue<Node> queue = new LinkedList<>();
        if(node != null) {
            map.put(node, new Node(node.val));
            queue.add(node);
        }
        while (!queue.isEmpty()){
            Node curr = queue.poll();
            if(!map.containsKey(curr)){
                map.put(curr,new Node(curr.val));
            }
            Node copy = map.get(curr);
            for (Node neigh:curr.neighbors){

                if (!map.containsKey(neigh)){
                    map.put(neigh,new Node(neigh.val));
                    queue.add(neigh);
                }
                copy.neighbors.add(map.get(neigh));
            }
        }
        // System.out.println(map);
        return map.get(node);

    }

    public Node cloneGraph(Node node) {
        return BFS(node);
    }

}
