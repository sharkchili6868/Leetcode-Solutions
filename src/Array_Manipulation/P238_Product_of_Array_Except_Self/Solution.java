package Array_Manipulation.P238_Product_of_Array_Except_Self;

import java.util.Arrays;

public class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;

        int[] res = new int[n];
        res[0] = 1;

        int leftBuffer = 1;
        for (int i = 1; i < n; i++) {
            res[i] = leftBuffer * nums[i - 1];
            leftBuffer = res[i];
        }

        int rightBuffer = nums[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            res[i] = res[i] * rightBuffer;
            rightBuffer = rightBuffer * nums[i];
        }

        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println("Expected results: [24, 12, 8, 6]");
        System.out.println("Calculated Solution: " +
                Arrays.toString(solution.productExceptSelf(new int[]{1, 2, 3, 4})));
    }
}
