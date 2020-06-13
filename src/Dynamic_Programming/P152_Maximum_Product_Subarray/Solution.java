package Dynamic_Programming.P152_Maximum_Product_Subarray;

public class Solution {
    public int maxProduct(int[] nums) {
        int max = nums[0];
        int min = nums[0];
        int finalMax = nums[0];

        for (int i = 1; i < nums.length; i++) {
            int temp = max;

            max = Math.max(Math.max(max * nums[i], min * nums[i]), nums[i]);
            min = Math.min(Math.min(temp * nums[i], min * nums[i]), nums[i]);

            if (max > finalMax) {
                finalMax = max;
            }
        }

        return finalMax;
    }
}
