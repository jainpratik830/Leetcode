package Google.March;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Print_Binary_Tree {

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

    public int calHeight(TreeNode root,int curr){
        if (root==null){
            return curr;
        }

        return Math.max(calHeight(root.left,curr+1),calHeight(root.right,curr+1));
    }

    int height;

    public void dfs(String[][] matrix, TreeNode curr ,int r,int c){
        if (curr==null){
            return;
        }

        if (curr.left!=null){
            int row = r+1;
            int col = c-((int) (Math.pow(2,(height-r-1))));
            matrix[row][col] = curr.left.val+"";
            dfs(matrix,curr.left,row,col);
        }
        if (curr.right!=null){
            int row = r+1;
            int col = c+((int) (Math.pow(2,(height-r-1))));
            matrix[row][col] = curr.right.val+"";
            dfs(matrix,curr.right,row,col);
        }

    }

    public List<List<String>> printTree(TreeNode root) {
        height = calHeight(root,0)-1;
        int m = height+1;
        int n = (int) (Math.pow(2,height+1)-1);

        System.out.println(height);
        List<List<String>> ans = new ArrayList<>();
        String[][] matrix = new String[m][n];
        for (String[] a:matrix){
            Arrays.fill(a,"");
        }

        int row =0;
        int col = (n-1)/2;
        matrix[row][col] = root.val+"";
        dfs(matrix,root,row,col);

        for (String[] a: matrix){
            ans.add(Arrays.asList(a));
        }
        return ans;
    }

}
