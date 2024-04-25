package Google.April;

import java.util.LinkedList;
import java.util.Queue;

public class Sum_Root_to_Leaf_Numbers {

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

    public class Pair {

        TreeNode node;
        int val;
        Pair(TreeNode node,int val){
            this.val= val;
            this.node=node;
        }

    }

    public int sumNumbers(TreeNode root) {
        int ans = 0;

        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(root,root.val));

        while (!queue.isEmpty()){
            Pair curr = queue.poll();
            TreeNode currNode = curr.node;
            if (currNode.left==null && currNode.right==null){
                ans+= curr.val;
            }else {
                if (currNode.left!=null){
                    queue.add(new Pair(currNode.left, curr.val*10+currNode.left.val));
                }
                if (currNode.right!=null){
                    queue.add(new Pair(currNode.right, curr.val*10+currNode.right.val));
                }
            }


        }
        return ans;
    }
}
