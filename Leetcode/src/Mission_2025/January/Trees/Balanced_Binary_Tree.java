package Mission_2025.January.Trees;

import java.util.HashMap;

public class Balanced_Binary_Tree {

    public boolean isBalanced(TreeNode root) {

        return height(root)!=-1;

    }

    public int height(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = height(root.left);
        if(left==-1){
            return -1;
        }

        int right = height(root.right);
        if(right==-1){
            return -1;
        }

        int curr = Math.abs(left-right);
        if (curr>1){
            return -1;
        }
        return 1+Math.max(left,right);
    }

}
