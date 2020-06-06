package Depth_First_Search.P241_Different_ways_of_add_Parenthesis;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    // Time: Catalan Tree
    // Space: Catalan Tree
    public List<Integer> diffWaysToCompute(String input) {
        return dfs(input, new HashMap<>());
    }

    private List<Integer> dfs(String input, Map<String, List<Integer>> map) {
        if (map.containsKey(input)) return map.get(input);

        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < input.length(); i++) {
            char curChar = input.charAt(i);
            if (curChar == '+' || curChar == '-' || curChar == '*') {
                String leftPart = input.substring(0, i);
                String rightPart = input.substring(i + 1);
                List<Integer> leftResult = dfs(leftPart, map);
                List<Integer> rightResult = dfs(rightPart, map);
                for (Integer left : leftResult) {
                    for (Integer right : rightResult) {
                        int curResult = 0;
                        switch (curChar) {
                            case '+':
                                curResult = left + right;
                                break;
                            case '-':
                                curResult = left - right;
                                break;
                            case '*':
                                curResult = left * right;
                                break;
                        }
                        result.add(curResult);
                    }
                }
            }
        }

        if (result.size() == 0) {
            result.add(Integer.parseInt(input));
        }

        map.put(input, result);
        return result;
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.diffWaysToCompute("2*3-4*5"));
    }
}
