package Tree.P103_BInary_Tree_Zigzag_Level_Order_Traversal;

import _utils.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        boolean isZigzag = false;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> temp = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode curNode = queue.poll();
                if (!isZigzag) {
                    temp.add(curNode.val);
                } else {
                    temp.add(0, curNode.val);
                }
                if (curNode.left != null) queue.offer(curNode.left);
                if (curNode.right != null) queue.offer(curNode.right);
            }
            res.add(temp);
            isZigzag = !isZigzag;
        }

        return res;
    }
}
