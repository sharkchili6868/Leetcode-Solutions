package laiOffer.stringI_II;

public class StringDeduplicationI {
    public String removeDuplication(String s) {
        char[] chars = s.toCharArray();

        int slow = 0;
        int fast = 1;

        while(fast < s.length()) {
            if (chars[slow] == chars[fast]) {
                fast++;
                slow++;
            } else {
                if ((slow - 1) >= 0 && chars[fast] != chars[slow - 1]) {
                    swap(chars, slow, fast);
                    slow++;
                    fast++;
                } else {
                    fast++;
                }
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
        StringDeduplicationI stringDeduplicationI = new StringDeduplicationI();
        System.out.println(stringDeduplicationI.removeDuplication("aabbbb__cccc"));
    }
}

// a b _ c a _ b c
//         s
//               f
