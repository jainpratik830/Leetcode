package Google.May.Neetcode150;

public class Validate_Binary_Search_Tree {

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

    public boolean isValid(TreeNode curr,long max,long min){

        if (curr==null){
            return true;
        }

        if (curr.val>=max || curr.val<=min){
            return false;
        }

        return isValid(curr.left, curr.val,min) && isValid(curr.right,max,curr.val);

    }

    public boolean isValidBST(TreeNode root) {
        return isValid(root,Long.MAX_VALUE,Long.MIN_VALUE);
    }
}
