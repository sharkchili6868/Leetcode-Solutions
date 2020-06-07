import java.util.Arrays;

public class Solution {

    public String encodeString(char[] a) {
        int slow = 0;
        int fast = 0;

        while (fast < a.length) {
            while (fast + 1 < a.length && a[fast] == a[fast + 1]) {
                fast++;
            }
            a[slow] = a[fast - 1];
            int chunk = fast - slow + 1;
            a[slow + 1] = (char) (chunk - '0');
            slow += 2;
            fast++;
        }
        return new String(a).substring(0, slow);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        char[] a = {'a', 'a', 'a', 'b', 'b', 'c'};
        System.out.println(solution.encodeString(a));
    }
}