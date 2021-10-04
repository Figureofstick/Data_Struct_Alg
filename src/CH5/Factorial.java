package CH5;

public class Factorial {
    public static int FactorialLoop(long n){
        int result = 1;
        if (n<1) return 1;
        for (long i = n; i>0; i--){
            result *= i;
        }
        return result;
    }
    public static long FactorialRecursion(long n){
        long result = 1;
        if (n < 1) return 1;
        return n * FactorialRecursion(n-1);
    }

    public static void main(String[] args){


        System.out.println(FactorialLoop(10));



    }
}
