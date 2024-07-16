package Google.July;

import java.util.*;

public class All_Nodes_Distance_K_in_Binary_Tree {

    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }

    HashMap<TreeNode,TreeNode> map;
    public void traverse(TreeNode curr,TreeNode parent){
        if (curr==null){
            return;
        }

        map.put(curr,parent);
        traverse(curr.left,curr);
        traverse(curr.right,curr);
    }

    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        List<Integer> ans = new ArrayList<>();
        map = new HashMap<>();
        traverse(root,null);
        Set<TreeNode> visited = new HashSet<>();
        visited.add(target);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(target);
        int curr =k;
        while (!queue.isEmpty() && curr!=0){
            int size = queue.size();
            for (int i=0;i<size;i++){
                TreeNode currNode =queue.poll();
                if (map.get(currNode)!=null && !visited.contains(map.get(currNode))){
                    queue.add(map.get(currNode));
                    visited.add(map.get(currNode));
                }
                if (currNode.left!=null && !visited.contains(currNode.left)){
                    queue.add(currNode.left);
                    visited.add(currNode.left);
                }
                if (currNode.right!=null && !visited.contains(currNode.right)){
                    queue.add(currNode.right);
                    visited.add(currNode.right);
                }
            }
            curr--;
        }

        if (!queue.isEmpty()){
            int size = queue.size();
            for (int i=0;i<size;i++){
                ans.add(queue.poll().val);
            }
        }

        return ans;
    }

}
