package Mission_2025.January.Trees;

public class Validate_Binary_Search_Tree {

    public boolean validate(TreeNode curr,long min,long max){
        if (curr==null){
            return true;
        }

        if (curr.val<=min || curr.val>= max){
            return false;
        }

        boolean left = validate(curr.left,min,curr.val);
        boolean right = validate(curr.right,curr.val,max);

        return left&&right;
    }

    public boolean isValidBST(TreeNode root) {
        return validate(root,Long.MIN_VALUE,Long.MAX_VALUE);
    }

}
