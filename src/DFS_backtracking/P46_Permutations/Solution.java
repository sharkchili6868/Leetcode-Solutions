package DFS_backtracking.P46_Permutations;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(res, nums, 0);
        return res;
    }

    private void dfs(List<List<Integer>> res, int[] nums, int curIdx) {

        if (curIdx == nums.length) {
            List<Integer> temp = new ArrayList<>();
            for(int num : nums) {
                temp.add(num);
            }
            res.add(new ArrayList<>(temp));
            return;
        }

        for(int i = curIdx; i < nums.length; i++) {
            swap(nums, curIdx, i);
            dfs(res, nums, curIdx + 1);
            swap(nums, curIdx, i);
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
