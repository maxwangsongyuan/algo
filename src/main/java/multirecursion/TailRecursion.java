package multirecursion;

public class TailRecursion {

    public static long sum(long n) {
        if (n == 0) {
            return 0;
        }
        return n + sum(n - 1);
    }

    //tail recursion is a type of recursion
    // where the recursive call is the last thing in the function
    // this allows the compiler to optimize the function by
    // freeing up the stack frame of the function


    //avoid recursion, use iteration

    public static long sumTailRecursion(long n, long sum) {
        if (n == 1) {
            return 1 + sum;
        }
        return sumTailRecursion(n - 1, sum + n);
    }

    public static void main(String[] args) {
//        System.out.println(sum(100005)); //stackoverflow

        System.out.println(sumTailRecursion(100005, 0));
    }

}
