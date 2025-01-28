package Mission_2025.January.Trees;

import java.util.HashMap;

public class Construct_Binary_Tree_from_Preorder_and_Inorder_Traversal {

    int preIndex= 0;

    public TreeNode dfs(int[] preOrder, int l, int r, HashMap<Integer,Integer> map){

        if (l>r){
            return null;
        }

        int val = preOrder[preIndex++];
        TreeNode root = new TreeNode(val);
        int mid = map.get(val);
        root.left= dfs(preOrder,l,mid-1,map);
        root.right = dfs(preOrder,mid+1,r,map);

        return root;
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        HashMap<Integer,Integer> map=new HashMap<>();
        for (int i=0;i<inorder.length;i++){
            map.put(inorder[i],i);
        }

        return dfs(preorder,0,inorder.length-1,map);
    }

}
