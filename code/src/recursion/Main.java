package recursion;

public class Main {

    static int x = 0;

    static int sum(int n){

        if (n > 0){
            x++;
            return sum(n - 1) + x;
        }
        return 0;
    }

    static int power(int m, int n){
        if (n == 0){
            return 1;
        }

        if (n % 2 == 0){
            return power(m * m, n/2);
        }else {
            return m * power(m *m , (n - 1) / 2);
        }
    }

    static double pow = 1;
    static double fact = 1;

    // e^x = 1 + (x / 1) + (x ^ 2 / 2!) + (x ^ 3 / 3!) + .... + (x ^ n / n!)
    static double taylorSeries(int x, int n){
        double res;

        if (n == 0){
            return 1;
        }

        res = taylorSeries(x, n - 1);
        pow *= x;
        fact *= n;

        return res + (pow / fact);
    }
    // e^x = 1 + (x / 1) + (x ^ 2 / 2!) + (x ^ 3 / 3!) + .... + (x ^ n / n!)
    // e^x = 1 + x / 1 [ 1 + x / 2 [ 1 + x / 3 [ 1 + x / 4]]]
    static double taylorSeriesUsingHornerRuleIterative(int x, int n){
        double res = 1;

        for (; n > 0 ; n--){
            res = 1 + ((double) x / n) * res;
        }
        return res;
    }

    static double s = 1;

    static double taylorSeriesUsingHornerRuleRecursive(int x, int n){

        if (n == 0){
            return s;
        }

        s = 1 + ((double) x / n) * s;
        return taylorSeriesUsingHornerRuleRecursive(x, n - 1);
    }

    static int combination(int n, int r){
        if (r == 0 || n == r){
            return 1;
        }

        return combination(n - 1, r - 1) + combination(n - 1, r);
    }

    static void towerOfHanoi(int n, char A, char B, char C){
        if (n > 0){
            towerOfHanoi(n - 1, A, C, B);
            System.out.println("From " + A + " to " + C);
            towerOfHanoi(n - 1, B, A, C);
        }
    }

    static int fun(int n){
        int x = 1, k;
        if (n == 1) return x;

        for (k = 1; k < n; ++k){
            x = x + fun(k) * fun(n - k);
        }

        return x;
    }

    public static void main(String[] args) {

//        towerOfHanoi(4, 'a', 'b', 'c');
        int val = fun(5);
        System.out.println(val);
    }

    static int fibonacciIterative(int n){
        if (n <= 1){
            return n;
        }

        int first = 0, second = 1, third;

        for (int i = 0; i < n - 1; i++) {
            third = first + second;
            first = second;
            second = third;
        }

        return second;
    }

    static int fibonacciRecursive(int n){
        if (n <= 1)
            return n;

        return fibonacciRecursive(n - 2) + fibonacciRecursive(n - 1);
    }


    static int fibonacciMemoization(int n){
        int[] memo = new int[n + 1];

        for (int i = 0; i <= n ; i++) {
            memo[i] = -1;
        }

        return fibonacciHelper(n, memo);
    }

    static int fibonacciHelper(int n, int[] memo){
        if (n <= 1){
            memo[n] = n;
            return n;
        }

        if (memo[n - 2] == -1){
            memo[n - 2] = fibonacciHelper(n - 2, memo);
        }

        if (memo[n - 1] == -1){
            memo[n - 1] = fibonacciHelper(n - 1, memo);
        }

        memo[n] = memo[n - 2] + memo[n - 1];

        return memo[n - 2] + memo[n - 1];
    }
}
