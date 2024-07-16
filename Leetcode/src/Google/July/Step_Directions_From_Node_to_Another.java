package Google.July;

import java.util.*;

public class Step_Directions_From_Node_to_Another {

    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }

    public class Node {

        int val;
        String direction;


        public Node(int val, String direction) {
            this.val = val;
            this.direction = direction;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "val=" + val +
                    ", direction=" + direction +
                    '}';
        }
    }

    public String getDirections(TreeNode root, int startValue, int destValue) {

        HashMap<Integer, List<Node>> map = new HashMap<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()){

            TreeNode curr = queue.poll();

            if (curr.left!=null){
                map.putIfAbsent(curr.val,new ArrayList<>());
                map.putIfAbsent(curr.left.val,new ArrayList<>());

                map.get(curr.val).add(new Node(curr.left.val,"L"));
                map.get(curr.left.val).add(new Node(curr.val,"U"));
                queue.add(curr.left);
            }

            if (curr.right!=null){
                map.putIfAbsent(curr.val,new ArrayList<>());
                map.putIfAbsent(curr.right.val,new ArrayList<>());

                map.get(curr.val).add(new Node(curr.right.val,"R"));
                map.get(curr.right.val).add(new Node(curr.val,"U"));
                queue.add(curr.right);
            }
        }

        Queue<Node> queue1 = new LinkedList<>();
        HashSet<Integer> visited = new HashSet<>();
        queue1.add(new Node(startValue,""));
        while (!queue1.isEmpty()){

            Node curr = queue1.poll();
            visited.add(curr.val);

            if (curr.val==destValue){
                return curr.direction;
            }

            for (Node n:map.getOrDefault(curr.val,new ArrayList<>())){
                if (!visited.contains(n.val)){
                    queue1.add(new Node(n.val,curr.direction+n.direction));
                }
            }
        }

        return "";

    }

}
