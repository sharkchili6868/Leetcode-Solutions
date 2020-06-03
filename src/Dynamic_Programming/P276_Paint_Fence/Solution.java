package Dynamic_Programming.P276_Paint_Fence;

public class Solution {
    public int numWays(int n, int k) {
        int[] dp = new int[n + 1];
        dp[1] = k;

        int same = 0, diff = k;

        for(int i = 2; i <= n; i++) {
            same = diff;
            diff = dp[i - 1] * (k - 1);
            dp[i] = same + diff;
        }

        return dp[n];
    }
}
