package Sorting.P912_Sort_an_Array;

import java.util.Arrays;

public class QuickSort {
    public int[] sortArray(int[] nums) {
        quickSort(nums, 0, nums.length - 1);
        return nums;
    }

    private void quickSort(int[] nums, int left, int right) {
        if (left >= right) return;
        int idx = partition(nums, left, right);

        partition(nums, left, idx - 1);
        partition(nums, idx + 1, right);

    }

    private int partition(int[] nums, int left, int right) {
        int i = left;
        int idx = left;
        int pivot = nums[right];
        while (idx <= right - 1) {
            if (nums[idx] < pivot) {
                swap(nums, i++, idx++);
            } else {
                idx++;
            }
        }
        swap(nums, i, right);
        return i;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        QuickSort quickSort = new QuickSort();
        int[] input = {2, 6, 5, 0, 8, 7, 1, 3};
//        int[] input = {2,1,0};
        System.out.println(Arrays.toString(quickSort.sortArray(input)));
    }
}
//              p;
//      i
//2 1 0 5 8 7 6 3;
//    j