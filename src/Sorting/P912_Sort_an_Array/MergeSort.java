package Sorting.P912_Sort_an_Array;

import com.sun.scenario.effect.Merge;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeSort {

    // Time partition -> O(n) merge O(nlogn)
    // totdal O(n) + O(nlogn) = O(nlogn)
    // Space O(n)
    public int[] sortArray(int[] nums) {
        List<Integer> sol = mergeSort(nums, 0, nums.length - 1);
        return sol.stream().mapToInt(i->i).toArray();
    }

    private List<Integer> mergeSort(int[] nums, int left, int right) {
        List<Integer> sol = new ArrayList<>();
        if (left == right) {
            sol.add(nums[left]);
            return sol;
        }

        int mid = left + (right - left) / 2;
        List<Integer> left_sol = mergeSort(nums, left, mid);
        List<Integer> right_sol = mergeSort(nums, mid + 1, right);
        sol = merge(left_sol, right_sol);
        return sol;
    }

    private List<Integer> merge(List<Integer> left, List<Integer> right) {
        List<Integer> sol = new ArrayList<>();
        int i = 0, j = 0;
        int m = left.size(), n = right.size();
        while(i < m && j < n) {
            if (left.get(i) == right.get(j)) {
                sol.add(left.get(i));
                sol.add(right.get(j));
                i++;
                j++;
            } else if (left.get(i) < right.get(j)) {
                sol.add(left.get(i));
                i++;
            } else {
                sol.add(right.get(j));
                j++;
            }
        }

        if (i < m) {
            while(i < m) {
                sol.add(left.get(i));
                i++;
            }
        } else if (j < n) {
            while(j < n) {
                sol.add(right.get(j));
                j++;
            }
        }

        return sol;
    }

    public static void main(String[] args) {
        MergeSort mergeSort = new MergeSort();
        int[] input = {2, 6, 5, 0, 8, 7, 1, 3};
        System.out.println(Arrays.toString(mergeSort.sortArray(input)));
    }
}
