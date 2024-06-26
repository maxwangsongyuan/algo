package recursion;

public class ReversePrintString {

    public void reverse(String s) {
        helper(s, 0);
    }


    public void helper(String s, int i) {
        if (i == s.length()) {
            return;
        }

        helper(s, i + 1);
        System.out.println(s.charAt(i));
    }

    public static void main(String[] args) {
        ReversePrintString reversePrintString = new ReversePrintString();
        reversePrintString.reverse("hello");
    }
}
