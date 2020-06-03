package Dynamic_Programming.P53_Maximum_SubArray;

public class Solution {
    public int maxSubArray(int[] nums) {
        int max = nums[0];
        for(int i = 1; i < nums.length; i++) {
            if (nums[i - 1] >= 0) {
                nums[i] += nums[i - 1];
            }
            max = Math.max(nums[i], max);
        }

        return max;
    }
}
