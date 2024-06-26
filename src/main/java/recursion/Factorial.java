package recursion;

public class Factorial {

    public int f(int n) {
        if (n == 1) {
            return 1;
        }

        return n * f(n - 1);
    }

    public static void main(String[] args) {
        Factorial factorial = new Factorial();
        System.out.println(factorial.f(5));
    }
}
