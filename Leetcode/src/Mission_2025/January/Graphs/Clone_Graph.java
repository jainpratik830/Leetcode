package Mission_2025.January.Graphs;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class Clone_Graph {

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
