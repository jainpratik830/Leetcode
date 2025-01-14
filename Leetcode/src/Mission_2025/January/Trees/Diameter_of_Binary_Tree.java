package Mission_2025.January.Trees;

public class Diameter_of_Binary_Tree {

    int ans;
    public int maxLen(TreeNode root){
        if (root==null){
            return 0;
        }
        int left = maxLen(root.left);
        int right = maxLen(root.right);

        if (1+left+right>ans){
            ans=1+left+right;
        }

        return 1+Math.max(left,right);
    }

    public int diameterOfBinaryTree(TreeNode root) {
        ans = Integer.MIN_VALUE;
        maxLen(root);
        return ans-1;
    }


}
