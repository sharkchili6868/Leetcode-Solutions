package Dynamic_Programming.P518_Coin_Change_II;


public class Solution {
    // time complexity O(M * N ^ 2)
    public int Change(int amount, int[] coins) {
        int[][] dp = new int[coins.length + 1][amount + 1];
        dp[0][0] = 1;

        for(int i = 1; i <= coins.length; i++) {
            for(int j = 0; j <= amount; j++) {
                for(int k = 0; k * coins[i - 1] <= j; k++) {
                    dp[i][j] += dp[i - 1][j - k * coins[i - 1]];
                }
            }
        }

        return dp[coins.length][amount];
    }
}
