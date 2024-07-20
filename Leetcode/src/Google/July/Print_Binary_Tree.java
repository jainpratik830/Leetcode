package Google.July;

import java.util.ArrayList;
import java.util.List;

public class Print_Binary_Tree {

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

    public List<List<String>> printTree(TreeNode root) {
        List<List<String>> ans = new ArrayList<>();
        int height = calcHeight(root,0);
        int width = (int) (Math.pow(height,2)-1);
        dfs(root,ans,0,width,0,width);


        return ans;
    }

    private void dfs(TreeNode root,List<List<String>> ans,int l,int r,int level,int width){
        if (root!=null){
            if (level>=ans.size()){
                ans.add(new ArrayList<>());

                for (int i=0;i<width;i++){
                    ans.get(level).add("");
                }

            }

            int mid = (l+r)/2;

            ans.get(level).set(mid,String.valueOf(root.val));

            dfs(root.left,ans,l,mid,level+1,width);
            dfs(root.right,ans,mid,r,level+1,width);

        }
    }

    public int calcHeight(TreeNode node,int curr){
        if (node==null){
            return curr;
        }

        return Math.max(calcHeight(node.left,curr),calcHeight(node.right,curr))+1;
    }
}
