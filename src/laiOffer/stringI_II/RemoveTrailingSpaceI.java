package laiOffer.stringI_II;

public class RemoveTrailingSpaceI {
    public String removeSpace(String s) {
        char[] chars = s.toCharArray();
        int slow = 0;
        int fast = 0;
        int word_count = 0;
        while(true) {
            while(fast < s.length() && chars[fast] == '_') {
                fast++;
            }
            if (fast == s.length()) {
                break;
            }

            if (word_count > 0) {
                chars[slow] = '_';
                slow++;
            }
            while(fast < s.length() && chars[fast] != '_') {
                chars[slow] = chars[fast];
                slow++;
                fast++;
            }
            word_count++;
        }
        String newString = new String(chars);
        return newString.substring(0, slow);
    }

    public static void main(String[] args) {
        RemoveTrailingSpaceI removeTrailingSpaceI = new RemoveTrailingSpaceI();
        System.out.println(removeTrailingSpaceI.removeSpace("___abc__ed___ef__"));
    }
}

//"_ _ _ abc _ e _ d _ _ _ ef _ _ "
//             s
//                 f

