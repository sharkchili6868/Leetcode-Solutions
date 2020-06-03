package Stack.P1249_Minimum_Remove_To_Make_Valid_Parenthesi;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution {
    public String minRemoveToMakeValid(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }
        Deque<Integer> stack = new ArrayDeque<>();

        StringBuilder sb = new StringBuilder(s);
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else if (s.charAt(i) == ')') {
                if (!stack.isEmpty()) {
                    stack.pop();
                } else {
                    sb.setCharAt(i, '\n');
                }
            }
        }

        while (!stack.isEmpty()) {
            sb.setCharAt(stack.pop(), '\n');
        }

        return sb.toString().replaceAll("\n", "");
    }
}
