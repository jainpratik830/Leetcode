package Google.March;

import java.util.HashMap;

public class Height_of_Binary_Tree_After_Subtree_Removal_Queries {

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

    HashMap<Integer,Integer> dp;
    HashMap<Integer,Integer> lh;
    HashMap<Integer,Integer> rh;


    public int calcHeight(TreeNode curr){


        if (curr==null){
            return 0;
        }

        int l =calcHeight(curr.left);
        int r = calcHeight(curr.right);
        lh.put(curr.val,l);
        rh.put(curr.val,r);

        return 1+Math.max(l,r);
    }

    public void solve(TreeNode root,int currMax,int depth){

        if(root==null){
            return;
        }

        dp.put(root.val ,currMax);
        solve(root.left,Math.max(currMax,depth+rh.get(root.val)),depth+1);
        solve(root.right,Math.max(currMax,depth+lh.get(root.val)),depth+1);
    }

    public int[] treeQueries(TreeNode root, int[] queries) {
        lh = new HashMap<>();
        rh = new HashMap<>();
        dp = new HashMap<>();
        calcHeight(root);

        solve(root.left,rh.get(root.val),1);
        solve(root.right,lh.get(root.val),1);
        int n = queries.length;
        int[] ans = new int[queries.length];

        for (int i=0;i<n;i++){
            if (dp.containsKey(queries[i])){
                ans[i]= dp.get(queries[i]);
            }else{
                ans[i]= 0;
            }

        }
        // System.out.println(dp);
        return ans;
    }


}
