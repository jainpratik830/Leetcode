package Google.May.CodingRound;

import java.util.*;

public class Distribute_Coins_in_Binary_Tree {

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

    int moves;

    public int traverse(TreeNode curr ){
        if (curr==null){
            return 0;
        }


        int left = traverse(curr.left);
        int right =traverse(curr.right);
        int coins = curr.val-1+left+right;
        moves+= Math.abs(coins);

        return coins;

    }

    public int distributeCoins(TreeNode root) {
        moves =0;

        traverse(root);
        return moves;
    }

}
