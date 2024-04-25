package Google.March;

import java.util.ArrayList;
import java.util.List;

public class Delete_Nodes_And_Return_Forest {

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

    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        List<TreeNode> ans = new ArrayList<>();

        if(!deleteNode(root,to_delete,ans)){
            ans.add(root);
        }
        // deleteNode(root,to_delete,ans);
        return ans;
    }

    public boolean deleteNode(TreeNode curr,int[] to_delete,List<TreeNode> ans ){
        if (curr==null){
            return false;
        }
        boolean present = false;
        for (int i:to_delete){
            if (i==curr.val){
                present = true;
                if (curr.left!=null){
                    if(!deleteNode(curr.left,to_delete,ans)){
                        ans.add(curr.left);
                        // curr.left=null;

                    }


                    curr.left=null;
                }
                if (curr.right!=null){

                    if(!deleteNode(curr.right,to_delete,ans)){
                        ans.add(curr.right);
                        // curr.right=null;
                    }

                    curr.right=null;
                }
            }
        }

        if(present){

            return true;

        }else{
            if(deleteNode(curr.left,to_delete,ans)){
                curr.left=null;
            }
            if(deleteNode(curr.right,to_delete,ans)){
                curr.right=null;
            }
        }
        return false;


    }

}
