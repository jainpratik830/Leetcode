package Google.June.DE_Shaw;

import java.util.HashSet;

public class Binary_Tree_Cameras {

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

    int ans;
    HashSet<TreeNode> covered;

    public int minCameraCover(TreeNode root) {
        covered=new HashSet<>();
        ans =0;
        covered.add(null);
        findCamers(root,null);

        return ans;
    }

    public void findCamers(TreeNode root,TreeNode par){

        if (root!=null){

            findCamers(root.left,root);
            findCamers(root.right,root);

            if  ( (par==null && !covered.contains(root)) || !covered.contains(root.left) || !covered.contains(root.right) ){
                ans++;
                covered.add(root);
                covered.add(par);
                covered.add(root.left);
                covered.add(root.right);
            }

        }

    }


//    Approach 2
    int camera = 0;
    public enum Camera { HAS_CAMERA, COVERED, TO_COVER};

    public int minCameraCover2(TreeNode root) {


        return cover(root)== Camera.TO_COVER ? ++camera : camera;
    }

    public Camera cover(TreeNode root) {

        if (root==null){
            return Camera.COVERED;
        }

        Camera l  = cover(root.left);
        Camera r  = cover(root.right);

        if (l==Camera.TO_COVER || r==Camera.TO_COVER){
            camera++;
            return Camera.HAS_CAMERA;
        }

        if (l==Camera.HAS_CAMERA || r==Camera.HAS_CAMERA){
            return Camera.COVERED;
        }

        return Camera.TO_COVER;

    }

    
}
