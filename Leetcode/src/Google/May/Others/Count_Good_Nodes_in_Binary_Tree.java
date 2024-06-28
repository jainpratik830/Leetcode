package Google.May.Others;

public class Count_Good_Nodes_in_Binary_Tree {

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

  int count;

  public void countNodes(TreeNode curr,int max){

      if (curr==null){
          return;
      }

      if (curr.val>=max){
          count++;
      }

      countNodes(curr.left,Math.max(curr.val,max));
      countNodes(curr.right,Math.max(curr.val,max));
  }
    
    public int goodNodes(TreeNode root) {


        count =0;
        countNodes(root,Integer.MIN_VALUE);

        return count;
    }

}
