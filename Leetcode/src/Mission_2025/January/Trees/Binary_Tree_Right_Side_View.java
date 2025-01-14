package Mission_2025.January.Trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Binary_Tree_Right_Side_View {

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if (root==null){
            return ans;
        }
        Queue<TreeNode> queue= new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            int size = queue.size();
            boolean done = false;
            for (int i=0;i<size;i++){
                TreeNode curr = queue.poll();
                if (!done) {
                    ans.add(curr.val);
                    done = true;
                }

                if (curr.right!=null){
                    queue.add(curr.right);
                }
                if (curr.left!=null){
                    queue.add(curr.left);
                }
            }
        }
        return ans;
    }

}
