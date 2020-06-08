package laiOffer.stringI_II;

public class StringReversal {

    public void reverseI(char[] a) {
        int i = 0;
        int j = a.length - 1;
        while(i <= j) {
            swap(a, i, j);
            i++;
            j--;
        }
    }

    public void reverseII(char[] a) {
        reverseII(a, 0, a.length - 1);
    }

    public void reverseII(char[] a, int left, int right) {
        if (left >= right) {
            return;
        }
        swap(a, left, right);
        reverseII(a, left + 1, right - 1);
    }

    private void swap(char[] a, int i, int j) {
        char temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static void main(String[] args) {
        StringReversal stringReversal = new StringReversal();
        char[] a = {'a', 'b', 'c', 'd'};
        stringReversal.reverseI(a);
        stringReversal.reverseII(a);
    }
}



