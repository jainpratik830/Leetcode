package Google.July;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class Find_Duplicate_Subtrees {

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

  HashMap<String,Integer> map;
    List<TreeNode> ans;
    
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        map = new HashMap<>();
        ans=new ArrayList<>();

        traverse(root);

        return ans;
    }

    public String traverse(TreeNode curr){

        if (curr==null){
            return "";
        }

        String representation  = "("+traverse(curr.left)+")"+curr.val+"("+traverse(curr.right)+")";

        map.put(representation,map.getOrDefault(representation,0)+1);
        if (map.get(representation)==2){
            ans.add(curr);
        }

        return representation;

    }
}
