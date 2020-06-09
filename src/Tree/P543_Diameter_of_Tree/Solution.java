package Tree.P543_Diameter_of_Tree;

import _utils.TreeNode;

public class Solution {
    int ans = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        dfs(root);
        return ans;
    }

    private int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = dfs(root.left);
        int right = dfs(root.right);

        ans = Math.max(ans, left + right);
        return Math.max(left, right) + 1;
    }
}
