package Dynamic_Programming.P139_Word_Break;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution {

    // Time: O(N^2)
    // Space: O(N)
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> dict = new HashSet<>(wordDict);

        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;

        for (int j = 1; j <= s.length(); j++) {
            for (int i = j - 1; i >= 0; i--) {
                if (dp[i] && dict.contains(s.substring(i, j))) {
                    dp[j] = true;
                    break;
                }
            }
        }

        return dp[s.length()];
    }
}
