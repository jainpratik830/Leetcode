package Mission_2025.January.Trees;

import java.util.HashMap;

public class Construct_Binary_Tree_from_Inorder_and_Postorder_Traversal {

    HashMap<Integer,Integer> map;
    int postIndex;

    public TreeNode dfs(int[] postOrder,int l,int r){

        if (l>r){
            return null;
        }

        int val = postOrder[postIndex--];
        TreeNode root = new TreeNode(val);
        int mid = map.get(val);
        root.right = dfs(postOrder,mid+1,r);
        root.left=dfs(postOrder,l,mid-1);

        return root;
    }

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        map=new HashMap<>();
        postIndex = postorder.length-1;
        for (int i=0;i<inorder.length;i++){
            map.put(inorder[i],i);
        }

        return dfs(postorder,0,inorder.length-1);
    }

}
