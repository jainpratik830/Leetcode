package Mission_2025.January.Trees;

public class Binary_Tree_Maximum_Path_Sum {


    int ans;

    public int dfs(TreeNode root){
        if (root==null){
            return 0;
        }

        int left = dfs(root.left);
        int right = dfs(root.right);

        if (root.val+left+right>ans){
            ans = root.val+left+right;
        }

        return Math.max(root.val+Math.max(left,right),0);
    }
    public int maxPathSum(TreeNode root) {
        ans = Integer.MIN_VALUE;
        dfs(root);
        return ans;
    }

}
