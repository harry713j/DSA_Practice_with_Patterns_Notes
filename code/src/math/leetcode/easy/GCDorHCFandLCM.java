package math.leetcode.easy;

public class GCDorHCFandLCM {

    public int gcdOrHcf(int a, int b){
        // Using Euclidean Algorithm: https://www.w3schools.com/dsa/dsa_ref_euclidean_algorithm.php

        while (a != 0 && b != 0){
            if (a > b){
                a = a % b;
                // in original algorithm a = a - b, but that will take much time, in the end we are getting the remainder
                // so we can use %
            } else {
                b = b % a;
            }
        }

        return a == 0 ? b : a;
        // Time: O(log(phi) min(a, b))
        // Space: O(1)
    }

    public int lcm(int a, int b){
        return Math.abs(a * b) / gcdOrHcf(a, b);
    }
}
