package DFS_backtracking.P47_Permutations_II;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(res, nums, 0);
        return res;
    }

    private void dfs(List<List<Integer>> res, int[] nums, int curIdx) {

        if (curIdx == nums.length) {
            List<Integer> temp = new ArrayList<>();
            for (int num : nums) {
                temp.add(num);
            }
            res.add(new ArrayList<>(temp));
            return;
        }

        Set<Integer> duplicate = new HashSet<>();

        for (int i = curIdx; i < nums.length; i++) {
            if (!duplicate.contains(nums[i])) {
                duplicate.add(nums[i]);
                swap(nums, curIdx, i);
                dfs(res, nums, curIdx + 1);
                swap(nums, curIdx, i);
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
