package Google.May.Others;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Binary_Search_Tree_to_Greater_Sum_Tree {

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

  List<Integer> list ;
    int[] arr;
    int index;
  public void traverse(TreeNode root){

      if (root==null){
          return;
      }

      traverse(root.left);
      list.add(root.val);
      traverse(root.right);

  }

    public void traverse2(TreeNode root){

        if (root==null){
            return;
        }

        traverse(root.left);
        root.val=arr[index++];
        traverse(root.right);

    }

    public TreeNode bstToGst(TreeNode root) {
        if (root==null){
            return null;
        }
        list= new ArrayList<>();
        index = 0;
        traverse(root);
        arr = new int[list.size()];
        arr[list.size()-1]=list.get(list.size()-1);
        for (int i=list.size()-2;i>=0;i--){
            arr[i]=list.get(i)+arr[i+1];
        }
        System.out.println(Arrays.toString(arr));
        System.out.println(list);
        traverse2(root);


        return root;
    }
    
}
