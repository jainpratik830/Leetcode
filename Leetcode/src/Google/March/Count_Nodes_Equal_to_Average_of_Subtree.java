package Google.March;

import java.util.HashMap;

public class Count_Nodes_Equal_to_Average_of_Subtree {

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

    HashMap<TreeNode,Integer> map = new HashMap<>();
    HashMap<TreeNode,Integer> countMap = new HashMap<>();
    public int averageOfSubtree(TreeNode root) {
        int ans =0;


        countSum(root);
        System.out.println(map);
        for (TreeNode t:map.keySet()){
            if (map.get(t)/countMap.get(t)==t.val){
                ans++;
            }
        }
        return ans;
    }

    public void countSum (TreeNode root){
        if (root==null){
            return;
        }
        countSum(root.left);
        countSum(root.right);
        countMap.put(root,1+countMap.getOrDefault(root.left,0)+countMap.getOrDefault(root.right,0));
        map.put(root,root.val+map.getOrDefault(root.left,0)+map.getOrDefault(root.right,0));
    }
}
