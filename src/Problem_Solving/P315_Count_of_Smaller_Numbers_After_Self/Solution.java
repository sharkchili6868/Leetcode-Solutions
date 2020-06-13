package Problem_Solving.P315_Count_of_Smaller_Numbers_After_Self;

import java.util.ArrayList;
import java.util.List;

class Solution {

    private static class TreeNode {
        int val;
        int leftSubTree;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }
    public List<Integer> countSmaller(int[] nums) {
        TreeNode root = null;
        int[] res = new int[nums.length];
        for(int i = nums.length - 1; i >= 0; i--) {
            root = helper(root, i, res, 0, nums);
        }

        List<Integer> result = new ArrayList<>();
        for(int num : res) result.add(num);

        return result;
    }

    private TreeNode helper(TreeNode root, int curIndex, int[] res, int smallerNumCount, int[] nums) {
        if (root == null) {
            root = new TreeNode(nums[curIndex]);
            res[curIndex] = smallerNumCount;
        }
        else if (root.val <= nums[curIndex]) {
            if (root.val == nums[curIndex]) {
                root.right = helper(root.right, curIndex, res, smallerNumCount + root.leftSubTree, nums);
            }
            else if (root.val < nums[curIndex]) {
                root.right = helper(root.right, curIndex, res, smallerNumCount + root.leftSubTree + 1, nums);
            }
        } else {
            root.leftSubTree++;
            root.left = helper(root.left, curIndex, res, smallerNumCount, nums);
        }
        return root;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] input = {5,2,6,1};
        System.out.println(solution.countSmaller(input));
    }
}
