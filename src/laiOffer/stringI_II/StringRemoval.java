package laiOffer.stringI_II;

import java.util.HashSet;
import java.util.Set;

public class StringRemoval {

    // problem 1
    // Given a string A and a set of characters B, remove all letter from B in A and return a new String

    public String removeChars(String A, char[] B) {
        char[] chars = A.toCharArray();
        Set<Character> set = new HashSet<>();
        for(char c : B) {
            set.add(c);
        }

        int slow = 0;
        int fast = 0;

        while(fast < A.length()) {
            if (set.contains(chars[fast])) {
                fast++;
            } else {
                swap(chars, slow, fast);
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
        StringRemoval stringRemoval = new StringRemoval();
        String input = "student";
        char[] chars = {'u', 'n'};
        System.out.println(stringRemoval.removeChars(input, chars));
    }
}
