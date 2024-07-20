package Google.July;

import java.util.ArrayList;
import java.util.List;

public class Number_of_Good_Leaf_Nodes_Pairs {

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

    public int countPairs(TreeNode root, int distance) {
        List<String> paths = new ArrayList<>();
        DFS(root, new StringBuilder(), paths);
        int result = 0, n = paths.size();

        for(int i = 0; i < n - 1; i++)
        {
            for(int j = i + 1; j < n; j++)
            {
                int prefixLength = 0;
                for(int k = 0; k < Math.min(paths.get(i).length(), paths.get(j).length()); k++)
                {
                    if(paths.get(i).charAt(k) != paths.get(j).charAt(k)) break;
                    prefixLength++;
                }
                if(paths.get(i).length() + paths.get(j).length() - prefixLength * 2 <= distance) result++;
            }
        }

        return result;
    }

    private void DFS(TreeNode node, StringBuilder path, List<String> paths)
    {
        if(node.left == null && node.right == null)
        {
            paths.add(path.toString());
            return;
        }

        if(node.left != null)
        {
            DFS(node.left, path.append("L"), paths);
            path.deleteCharAt(path.length() - 1);
        }
        if(node.right != null)
        {
            DFS(node.right, path.append("R"), paths);
            path.deleteCharAt(path.length() - 1);
        }
    }
    
    
}
