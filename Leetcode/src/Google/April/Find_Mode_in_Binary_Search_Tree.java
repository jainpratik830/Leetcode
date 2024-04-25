package Google.April;

import java.util.*;

public class Find_Mode_in_Binary_Search_Tree {

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

    public int[] findMode(TreeNode root) {
        HashMap<Integer,Integer> map = new HashMap<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            TreeNode curr = queue.poll();
            map.put(curr.val,map.getOrDefault(curr.val,0)+1);
            if (curr.left!=null){
                queue.add(curr.left);
            }
            if (curr.right!=null){
                queue.add(curr.right);
            }
        }
        int max  = 0;
        for (int i: map.values()){
            max = Math.max(i,max);
        }
        int count = 0;
        List<Integer> list=  new ArrayList<>();
        for (int i:map.keySet()){
            if (map.get(i)==max){
                list.add(i);
            }
        }

        return list.stream().mapToInt(i -> i).toArray();
    }
}
