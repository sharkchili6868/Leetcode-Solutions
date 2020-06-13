package Dynamic_Programming.P91_Decode_Ways;

public class Solution {
    public int numDecodings(String s) {
        if (s.charAt(0) == '0') {
            return 0;
        }

        int n = s.length();
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            if (isValid(s.charAt(i - 1))) {
                dp[i] = dp[i - 1];
            }
            if (isValid(s.charAt(i - 2), s.charAt(i - 1))) {
                dp[i] += dp[i - 2];
            }
        }

        return dp[n];
    }

    private boolean isValid(char c) {
        return c - '0' != 0;
    }

    private boolean isValid(char c1, char c2) {
        int val = (c1 - '0') * 10 + (c2 - '0');
        return val >= 10 && val <= 26;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.numDecodings("226"));
    }
}
