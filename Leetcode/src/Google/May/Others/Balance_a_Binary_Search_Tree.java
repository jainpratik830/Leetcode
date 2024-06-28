package Google.May.Others;

import java.util.ArrayList;
import java.util.List;

public class Balance_a_Binary_Search_Tree {

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

    List<Integer> inOrder;

    public void inOrderTraversal(TreeNode node){

        if (node==null){
            return;
        }

        inOrderTraversal(node.left);
        inOrder.add(node.val);
        inOrderTraversal(node.right);

    }

    public TreeNode balanceBSTHelper(TreeNode root,int start,int end){
        if (start>end){
            return null;
        }

        int mid = start + (end-start)/2;

        TreeNode leftTree=  balanceBSTHelper(root,start,mid-1);
        TreeNode rightTree = balanceBSTHelper(root,mid+1,end);

        return new TreeNode(inOrder.get(mid),leftTree,rightTree);


    }

    public TreeNode balanceBST(TreeNode root) {
        inOrder = new ArrayList<>();
        inOrderTraversal(root);

        return balanceBSTHelper(root,0, inOrder.size()-1);
    }
    
}
