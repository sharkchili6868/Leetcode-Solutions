package Tree.P776_Split_BST;

import _utils.TreeNode;

public class Solution {
    public TreeNode[] splitBST(TreeNode root, int V) {
        if (root == null) {
            return new TreeNode[]{null, null};
        } else if (root.val <= V) {
            TreeNode[] res = splitBST(root.right, V);
            root.right = res[0];
            res[0] = root;
            return res;
        } else {
            TreeNode[] res = splitBST(root.left, V);
            root.left = res[1];
            res[1] = root;
            return res;
        }
    }
}
