package math.leetcode.easy;

import java.util.ArrayList;
import java.util.List;

public class PrintAllDivisors {
    public List<Integer> divisors(int n){
        List<Integer> res = new ArrayList<>();

        for (int i = 1; i * i <= n; i++) {
            if (n % i == 0){
                res.add(i);

                if (i != n / i){
                    res.add(n / i);
                }
            }
        }

        return res;
        // Time: O(sqrt(n))
        // Space: O(1)
    }
}
