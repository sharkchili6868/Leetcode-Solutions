package Sorting.P912_Sort_an_Array;

public class SelectionSort {
    public int[] sortArray(int[] nums) {
       for(int i = 0; i < nums.length - 1; i++) {
           int globalMin = nums[i];
           for(int j = i + 1; j < nums.length; j++) {
               if (nums[j] < globalMin) {
                   globalMin = nums[j];
                   swap(nums, i, j);
               }
           }
       }

       return nums;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
