package math.leetcode.easy;

public class CheckPrime {
    public boolean isPrime(int n){
        for (int i = 2; i * i <= n ; i++) {
            if (n % i == 0){
                return false;
            }
        }

        return true;
        // Time: O(sqrt(n))
        // Space" O(1)
    }
}
