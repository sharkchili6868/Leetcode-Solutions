package DFS_backtracking.P113_Path_Sum_II;

import _utils.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    // Time: Avg O(N) Worst O(N)
    // Space: Avg O(logN) Worst O(N)
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        dfs(root, res, new ArrayList<>(), sum);
        return res;
    }

    private void dfs(TreeNode root, List<List<Integer>> res, List<Integer> temp, int sum) {
        if (root == null) {
            return;
        }

        temp.add(root.val);
        sum -= root.val;
        if (root.left == null && root.right == null && sum == 0) {
            res.add(new ArrayList<>(temp));
            temp.remove(temp.size() - 1);
            return;
        } else {
            dfs(root.left, res, temp, sum);
            dfs(root.right, res, temp, sum);
            temp.remove(temp.size() - 1);
        }
    }
}
