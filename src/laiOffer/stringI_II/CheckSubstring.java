package laiOffer.stringI_II;

public class CheckSubstring {
    public boolean checkSubstring(String a, String b) {
        int len = b.length();
        for(int i = 0; i < a.length() - len; i++) {
            if (a.substring(i, i + len).equals(b)) {
                return true;
            }
        }
        return false;
    }

    public boolean robinKarp(String a, String b) {
        int bCode = calculateHashCode(b);

        int start = 0;
        int end = b.length() - 1;
        int aCode = 0;
        while(start < b.length()) {
            aCode += (a.charAt(start) - 'a' + 1) * Math.pow(26, end);
            start++;
            end--;
        }

        if (aCode == bCode) {
            return true;
        }

        int i = 1;
        while(i < a.length() - b.length()) {
            aCode -= (a.charAt(i - 1) - 'a' + 1) * Math.pow(26, b.length() - 1);
            aCode *= 26;
            aCode += a.charAt(i + b.length()) - 'a';
            i++;

            if (aCode == bCode) {
                return true;
            }
        }

        return false;
    }

    private int calculateHashCode(String b) {
        int start = 0;
        int power = b.length() - 1;
        int bCode = 0;

        while(start < b.length()) {
            bCode += (b.charAt(start) - 'a' + 1) * Math.pow(26, power);
            start++;
            power--;
        }
        return bCode;
    }


    public static void main(String[] args) {
        CheckSubstring checkSubstring = new CheckSubstring();
        System.out.println(checkSubstring.checkSubstring("abcdef", "cd"));
        System.out.println(checkSubstring.robinKarp("abcdef", "cd"));
    }
}
