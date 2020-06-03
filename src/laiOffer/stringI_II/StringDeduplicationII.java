package laiOffer.stringI_II;

import java.util.ArrayDeque;
import java.util.Deque;

public class StringDeduplicationII {
    public String removeDuplication(String s) {

        // Solution 1: Using stack
//        char[] chars = s.toCharArray();
//        Deque<Character> stack = new ArrayDeque<>();
//
//        int i = 0;
//        while (i < s.length()) {
//            if (!stack.isEmpty() && stack.peek() == chars[i]) {
//                while(!stack.isEmpty() && stack.peek() == chars[i]) {
//                    i++;
//                }
//                stack.poll();
//            } else {
//                stack.push(chars[i]);
//                i++;
//            }
//        }

        // Solution 2: Using Two Pointers to Simulate Stack

        char[] chars = s.toCharArray();

        int slow = 1;
        int fast = 2;

        while(fast < s.length()) {
            if (chars[slow] == chars[fast]) {
                while(chars[slow] == chars[fast]) {
                    fast++;
                }
                if (slow > 0) {
                    slow--;
                }
            } else {
                chars[slow] = chars[fast];
                slow++;
                fast++;
            }
        }

        String newString = new String(chars);
        return newString.substring(0, slow);
    }

    private void swap(char[] chars, int i, int j) {
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
    }

    public static void main(String[] args) {
        StringDeduplicationII stringDeduplicationII = new StringDeduplicationII();
        System.out.println(stringDeduplicationII.removeDuplication("abbbbazw"));
    }
}

// a b b b b a z w
// s
//             f
