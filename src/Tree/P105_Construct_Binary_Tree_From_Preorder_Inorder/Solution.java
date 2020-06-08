package Tree.P105_Construct_Binary_Tree_From_Preorder_Inorder;

import _utils.TreeNode;

public class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTree(0, 0, preorder.length - 1, preorder, inorder);
    }

    private TreeNode buildTree(int preIndex, int inStart, int inEnd, int[] preorder, int[] inorder) {
        if (preIndex >= preorder.length || inStart > inEnd) {
            return null;
        }

        TreeNode root = new TreeNode(preorder[preIndex]);
        int rootIndex = 0;
        for(int i = 0; i < inorder.length; i++) {
            if (inorder[i] == root.val) {
                rootIndex = i;
                break;
            }
        }

        root.left = buildTree(preIndex + 1, inStart, rootIndex - 1, preorder, inorder);
        root.right = buildTree(preIndex + inEnd - inStart + 1, rootIndex + 1, inEnd, preorder, inorder);

        return root;
    }
}
