package Mission_2025.January.Trees;

public class Count_Good_Nodes_in_Binary_Tree {


    int count;

    public void countNodes(TreeNode curr,int max){

        if (curr==null){
            return;
        }

        if (curr.val>=max){
            count++;
        }

        countNodes(curr.left, Math.max(max,curr.val));
        countNodes(curr.right, Math.max(max,curr.val));

    }

    public int goodNodes(TreeNode root) {
        count=0;
        countNodes(root,Integer.MIN_VALUE);

        return count;
    }
}
