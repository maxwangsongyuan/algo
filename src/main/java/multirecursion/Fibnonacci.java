package multirecursion;

import java.util.Arrays;

//multirecursion is a type of recursion
// where a function calls itself more than once
public class Fibnonacci {

    public int fib(int n) {
        if (n == 0) {
            return 0;
        }

        if (n == 1) {
            return 1;
        }

        return fib(n - 1) + fib(n - 2);

        //0(1.618^n）
    }

//-----------------Memoization-----------------
    public static int fibMemoization(int n) {

        int[] memo = new int[n + 1];
        Arrays.fill(memo, -1);

        memo[0] = 0;
        memo[1] = 1;

        return fib2(n , memo);
        //0(n）
    }

    public static int fib2(int n, int[] memo) {
        if (memo[n] != -1) {
            return memo[n];
        }
        memo[n] = fib2(n - 1, memo) + fib2(n - 2, memo);
        return memo[n];

    }

    public static void main(String[] args) {
        Fibnonacci fibnonacci = new Fibnonacci();
        System.out.println(fibnonacci.fib(5));
    }

}
