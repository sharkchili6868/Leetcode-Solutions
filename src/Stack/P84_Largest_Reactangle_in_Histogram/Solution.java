package Stack.P84_Largest_Reactangle_in_Histogram;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution {
    public int largestRectangleArea(int[] heights) {
        Deque<Integer> stack = new ArrayDeque<>();
        int maxArea = 0;
        int area = 0;
        int i;
        for(i = 0; i < heights.length;) {
            if (stack.isEmpty() || heights[stack.peek()] <= heights[i]) {
                stack.push(i);
                i++;
            } else {
                int top = stack.pop();
                if (stack.isEmpty()) {
                    area = heights[top] * i;
                } else {
                    area = heights[top] * (i - stack.peek() - 1);
                }
                maxArea = Math.max(maxArea, area);
            }
        }

        while(!stack.isEmpty()) {
            int top = stack.pop();
            if (stack.isEmpty()) {
                area = heights[top] * i;
            } else {
                area = heights[top] * (i - stack.peek() - 1);
            }
            maxArea = Math.max(maxArea, area);
        }
        return maxArea;
    }
}
