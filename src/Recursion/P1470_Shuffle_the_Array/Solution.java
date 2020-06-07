package Recursion.P1470_Shuffle_the_Array;

import java.util.Arrays;

public class Solution {
    public int[] shuffle(int[] nums, int n) {
        shuffle(nums, 0, 2 * n - 1);
        return nums;
    }

    private void shuffle(int[] nums, int left, int right) {
        if (right - left <= 1) {
            return;
        }
        int size = right - left + 1;
        int mid = left + size / 2;
        int leftMid = left + size / 4;
        int rightMid = left + size * 3 / 4;

        reverse(nums, leftMid, mid - 1);
        reverse(nums, mid, rightMid - 1);
        reverse(nums, leftMid, rightMid - 1);

        shuffle(nums, left, left + 2 * (leftMid - left) - 1);
        shuffle(nums, left + 2 * (leftMid - left), right);
    }

    private void reverse(int[] nums, int i, int j) {
        while(i <= j) {
            swap(nums, i++, j--);
        }
    }
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {2,5,1,3,4,7};
        int n = 3;
        System.out.println(Arrays.toString(solution.shuffle(nums, 3)));
    }
}
