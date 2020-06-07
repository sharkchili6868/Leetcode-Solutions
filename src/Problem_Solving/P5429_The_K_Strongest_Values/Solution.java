package Problem_Solving.P5429_The_K_Strongest_Values;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution {
    public int[] getStrongest(int[] arr, int k) {
        Arrays.sort(arr);
        int n = arr.length - 1;
        int median = arr[(n - 1) / 2];

        PriorityQueue<Integer> heap = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if (Math.abs(o1 - median) > Math.abs(o2 - median)) {
                    return o1;
                } else if (Math.abs(o1 - median) == Math.abs(o2 - median) && arr[o1] > arr[o2]) {
                    return o1;
                } else if (Math.abs(o1 - median) == Math.abs(o2 - median) && arr[o1] > arr[o2]) {
                    return o2;
                }
                throw new IllegalArgumentException();
            }
        });

        for(int i = 0; i <= n; i++) {
            heap.offer(arr[i]);
            if (heap.size() > k) {
                heap.poll();
            }
        }

        int[] res = new int[heap.size()];
        int i = 0;
        while(!heap.isEmpty()) {
            res[i] = heap.poll();
            i++;
        }

        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] input = {-7,22,17,3};
        System.out.println(Arrays.toString(solution.getStrongest(input, 5)));
    }
}
