package laiOffer.stringI_II;

import java.util.HashMap;
import java.util.Map;

public class slidingWindow1 {
    // longest substring without repeating characters
    public int longestSubstring(String s) {
        int left = 0;
        int right = 1;
        int max = 1;
        Map<Character, Integer> map = new HashMap<>();
        map.put(s.charAt(0), 1);

        while (right < s.length()) {
            if (!map.containsKey(s.charAt(right))) {
                map.put(s.charAt(right++), 1);
                max = Math.max(max, right - left);
            }
            else {
                int prevOccurrence = map.get(s.charAt(right++));
                while(left <= prevOccurrence) {
                    map.remove(s.charAt(left));
                    left++;
                }
            }
        }

        return max;
    }

    public static void main(String[] args) {
        slidingWindow1 slidingWindow1 = new slidingWindow1();
        System.out.println(slidingWindow1.longestSubstring("abcabcbb"));
    }
}
