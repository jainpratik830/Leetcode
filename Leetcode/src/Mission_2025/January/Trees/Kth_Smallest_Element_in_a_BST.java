package Mission_2025.January.Trees;

public class Kth_Smallest_Element_in_a_BST {

    int curr= 0;
    int ans =0;

    public void solve(TreeNode root,int k){
        if (root==null){
            return;
        }

        solve(root.left,k);
        curr++;
        if (curr==k){
            ans = root.val;
            return;
        }
        solve(root.right,k);
    }

    public int kthSmallest(TreeNode root, int k) {

        solve(root,k);
        return ans;
    }


}
