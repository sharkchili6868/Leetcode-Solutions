package Tree.P114_Flatten_Binary_Tree_to_Linked_List;

import _utils.TreeNode;

public class Solution {
    private TreeNode prev = null;
    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }
        flatten(root.right);
        flatten(root.left);

        root.right = prev;
        root.left = null;
        prev = root;
    }
}
