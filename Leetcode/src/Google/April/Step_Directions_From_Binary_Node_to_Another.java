package Google.April;

import java.util.*;

public class Step_Directions_From_Binary_Node_to_Another {

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

    public String getDirections(TreeNode root, int startValue, int destValue) {
        Queue<TreeNode> queue= new LinkedList<>();

        HashMap<Integer, List<List<String>>> map = new HashMap<>();

        queue.add(root);

        while (!queue.isEmpty()){
            TreeNode curr = queue.poll();

            if (curr.left!=null){
                map.putIfAbsent(curr.val,new ArrayList<>());
                List<String> arr = new ArrayList<>();
                arr.add(curr.left.val+"");
                arr.add("L");
                map.get(curr.val).add(arr);

                map.putIfAbsent(curr.left.val,new ArrayList<>());
                arr = new ArrayList<>();
                arr.add(curr.val+"");
                arr.add("U");
                map.get(curr.left.val).add(arr);

                queue.add(curr.left);
            }

            if (curr.right!=null){
                map.putIfAbsent(curr.val,new ArrayList<>());
                List<String> arr = new ArrayList<>();
                arr.add(curr.right.val+"");
                arr.add("R");
                map.get(curr.val).add(arr);

                map.putIfAbsent(curr.right.val,new ArrayList<>());
                arr = new ArrayList<>();
                arr.add(curr.val+"");
                arr.add("U");
                map.get(curr.right.val).add(arr);

                queue.add(curr.right);
            }
        }
        System.out.println(queue);
        Queue<List<String>> queue2= new LinkedList<>();
        List<String> arr = new ArrayList<>();
        arr.add(startValue+"");
        arr.add("");
        queue2.add(arr);
        HashSet<Integer> visited= new HashSet<>();

        while (!queue2.isEmpty()){

            List<String> curr = queue2.poll();
            int curr_val = Integer.parseInt(curr.get(0));

            if (curr_val==destValue){
               return curr.get(1);
            }

            if (visited.contains(curr_val)){
                continue;
            }

            visited.add(curr_val);

            for (List<String> list:map.get(curr_val)){
                if (!visited.contains(Integer.parseInt(list.get(0)))){
                    List<String> arr2 = new ArrayList<>();
                    arr2.add(list.get(0));
                    arr2.add(curr.get(1)+list.get(1));
                    queue2.add(arr2);
//                    visited.add(Integer.parseInt(list.get(0)));
                }
            }
        }

        return "";

    }
}
