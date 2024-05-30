package Google.May.Others;

import java.util.HashMap;

public class Maximum_Width_of_Binary_Tree {


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

  int maxWidth;
    HashMap<Integer,Integer> map;

    public void dfs(TreeNode curr,int currIndex,int depth){

        if (curr==null){
            return;
        }

        if (!map.containsKey(depth)){
            map.put(depth,currIndex);
        }

        int first = map.get(depth);
        maxWidth =Math.max(maxWidth,currIndex-first+1);

        dfs(curr.left,2*currIndex,depth+1);
        dfs(curr.right,2*currIndex+1,depth+1);
    }

    public int widthOfBinaryTree(TreeNode root) {
        maxWidth= 0;
        map= new HashMap<>();

        dfs(root,0,0);

        return maxWidth;
    }

}
