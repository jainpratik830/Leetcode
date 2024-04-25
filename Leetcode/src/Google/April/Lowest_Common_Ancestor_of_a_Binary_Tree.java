package Google.April;

public class Lowest_Common_Ancestor_of_a_Binary_Tree {

    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }


    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        if (root == null){
            return null;
        }

        if (root==p || root==q){
            return root;
        }

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if (left!=null && right!=null){
            return root;
        }else {
            return left !=null ? left : right;
        }
    }

}
