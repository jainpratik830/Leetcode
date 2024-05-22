package Google.May.CodingRound;

public class Delete_Leaves_With_a_Given_Value {

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

    public TreeNode removeTreeNodes(int target,TreeNode curr){

        if (curr.left!=null){
            curr.left = removeTreeNodes(target,curr.left);
        }

        if (curr.right!=null){
            curr.right = removeTreeNodes(target,curr.right);
        }

        if (curr.val==target && curr.left==null && curr.right==null){
            return null;
        }

        return curr;

    }

    public TreeNode removeLeafNodes(TreeNode root, int target) {
        if(root==null){
            return root;
        }
        root = removeTreeNodes(target,root);
        return root;
    }

}
