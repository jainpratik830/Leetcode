package Mission_2025.January.Trees;

public class Subtree_of_Another_Tree {

    public boolean isSameTree(TreeNode p, TreeNode q) {

        if(p==null && q==null){
            return true;
        }

        if(p==null || q==null){
            return false;
        }


        return (p.val==q.val && isSameTree(p.left,q.left) && isSameTree(p.right,q.right));
    }

    public boolean isSubtree(TreeNode root, TreeNode subRoot) {

        if (root==null){
            return false;
        }

        if ( root.val==subRoot.val){
            if (isSameTree(root,subRoot)){
                return true;
            }
        }

        return isSubtree(root.left,subRoot) || isSubtree(root.right,subRoot);

    }

}
