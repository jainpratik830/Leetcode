package Google.July;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class Create_Binary_Tree_From_Descriptions {

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
 
    
        public TreeNode createBinaryTree(int[][] descriptions) {
            Set<Integer> visited= new HashSet<>();
            HashMap<Integer,TreeNode> map  = new HashMap<>();
            for (int[] i:descriptions){
                TreeNode parent,child;
                if (map.containsKey(i[0])){
                    parent = map.get(i[0]);


                }else {
                    parent = new TreeNode(i[0]);
                }

                if (map.containsKey(i[1])){
                    child= map.get(i[1]);
                }else {
                    child = new TreeNode(i[1]);
                }

                if (i[2]==1){
                    parent.left= child;
                }else {
                    parent.right=child;
                }
                map.put(i[0],parent);
                map.put(i[1],child);
                visited.add(i[1]);

            }

            for (int key:map.keySet()){
                if (!visited.contains(key)){
                    return map.get(key);
                }
            }
            return null;
        }
    
}
