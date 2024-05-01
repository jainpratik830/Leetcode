package Google.May;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Delete_Nodes_And_Return_Forest {

    public TreeNode dfs(TreeNode node, HashSet<Integer> to_delete,List<TreeNode> ans){

        if (node==null){
            return null;
        }

        node.left = dfs(node.left,to_delete,ans);
        node.right  = dfs(node.right,to_delete,ans);

        if (to_delete.contains(node.val)){
            if (node.left!=null){
                ans.add(node.left);
            }

            if (node.right!=null){
                ans.add(node.right);
            }
            return null;
        }

        return node;
    }

    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        List<TreeNode> ans = new ArrayList<>();
        HashSet<Integer> list = new HashSet<>();
        for (int node : to_delete){
            list.add(node);
        }

        dfs(root,list,ans);
        if (list.contains(root.val)){
            return ans;
        }

        ans.add(root);
        return ans;
    }
    
    
}
