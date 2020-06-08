package Tree.P98_Validate_Binary_Search_Tree;

import _utils.TreeNode;

public class Solution {

    // time: avg O(n) worst O(N)
    // space: avg O(logN) worst O(N)
    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean isValidBST(TreeNode root, long left, long right) {
        if (root == null) {
            return true;
        } else if (root.val <= left || root.val >= right) {
            return false;
        }

        boolean leftRes = isValidBST(root.left, left, root.val);
        boolean rightRes = isValidBST(root.right, root.val, right);

        return leftRes && rightRes;
    }
}
