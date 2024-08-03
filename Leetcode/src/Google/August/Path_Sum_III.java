package Google.August;

import java.util.HashMap;

public class Path_Sum_III {

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

    HashMap<Long,Integer> map;
    int ans;

    public int pathSum(TreeNode root, int targetSum) {
        map = new HashMap<>();
        ans=0;
        map.put(0L,1);
        helper(root,0,targetSum);
        return ans;
    }

    public void helper(TreeNode root,long sum,int target){

        if (root!=null){

            sum = sum+root.val;
            map.put(sum,map.getOrDefault(sum,0)+1);
            ans += map.getOrDefault(sum-target,0);

            helper(root.left,sum,target);
            helper(root.right,sum,target);

            map.put(sum,map.get(sum)-1);
        }

    }
    
}
