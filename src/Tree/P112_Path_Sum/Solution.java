package Tree.P112_Path_Sum;

import _utils.TreeNode;

public class Solution {

    // Time O(n) Space O(log(n)) Best Case O(n) Worst Case
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) return false;
        if (root.val == sum && root.left == null && root.right == null) return true;
        sum -= root.val;

        boolean left = hasPathSum(root.left, sum);
        boolean right = hasPathSum(root.right, sum);

        return left || right;
    }
}
