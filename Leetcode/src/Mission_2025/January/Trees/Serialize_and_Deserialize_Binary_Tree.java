package Mission_2025.January.Trees;

import java.util.*;

public class Serialize_and_Deserialize_Binary_Tree {

    public class Codec {


            // Encodes a tree to a single string.
            public String serialize(TreeNode root) {
                if (root == null) {
                    return "";
                }

                StringBuilder serial = new StringBuilder();
                Queue<TreeNode> queue = new LinkedList<>();
                queue.add(root);

                while (!queue.isEmpty()) {
                    TreeNode curr = queue.poll();
                    if (curr == null) {
                        serial.append("null,");
                    } else {
                        serial.append(curr.val).append(",");
                        queue.add(curr.left);
                        queue.add(curr.right);
                    }
                }

                return serial.toString();
            }

            // Decodes your encoded data to tree.
            public TreeNode deserialize(String data) {
                if (data.isEmpty()) {
                    return null;
                }

                String[] nodes = data.split(",");
                TreeNode root = new TreeNode(Integer.parseInt(nodes[0]));
                Queue<TreeNode> queue = new LinkedList<>();
                queue.add(root);

                int i = 1;
                while (!queue.isEmpty()) {
                    TreeNode curr = queue.poll();
                    if (!nodes[i].equals("null")) {
                        curr.left = new TreeNode(Integer.parseInt(nodes[i]));
                        queue.add(curr.left);
                    }
                    i++;

                    if (!nodes[i].equals("null")) {
                        curr.right = new TreeNode(Integer.parseInt(nodes[i]));
                        queue.add(curr.right);
                    }
                    i++;
                }

                return root;
            }

    }

}
