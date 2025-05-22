package bitManipulation.tuf;

public class XOROfNumbersWithInRange {
    public int xorOfNumbersOneToN(int n){
        // brute-force
        int ans = 0;

        for (int i = 1; i <= n; i++) {
            ans ^= i;
        }
        return ans;
        // time: O(n)
        // space: O(1)
    }

    public int xorOfNumbersOneToNTwo(int n){
        // optimal:
        /*
        * n = 1, ans = 0^1 = 1
        * n = 2, ans = 1^2 = 3
        * n = 3, ans = 1^2^3 = 0
        * n = 4, ans = 1^2^3^4 = 4
        *
        * n = 5, ans = 1^2^3^4^5 = 1
        * n = 6, ans = 1^2^3^4^5^6 = 7
        * n = 7, ans = 1^2^3^4^5^6^7 = 0
        * n = 8, ans = 1^2^3^4^5^6^7^8 = 8
        *
        * n = 9, ans = 1^2^3^4^5^6^7^8^9 = 1
        * n = 10, ans = 1^2^3^4^5^6^7^8^9^10 = 11
        * n = 11, ans = 1^2^3^4^5^6^7^8^9^10^11 = 0
        * n = 12, ans = 1^2^3^4^5^6^7^8^9^10^11^12 = 12
        *
        * If we observe the pattern, for n%4 == 1 ans = 1, for n%4 == 2 ans = n+1, n%4==3 ans = 0 and n%4==0 ans = n
        * */

        if (n % 4 == 1){
            return 1;
        } else if (n % 4 == 2){
            return n + 1;
        } else if (n % 4 == 3){
            return 0;
        } else {
            return n;
        }
        // time: O(1)
        // space: O(1)
    }

    // From Range L to R (L < R)
    public int xorOfNumbersLtoR(int L, int R){
        // brute-force
        int ans = 0;

        for (int i = L; i <= R; i++) {
            ans ^= i;
        }
        return ans;
        // time: O(R-L+1)
        // space: O(1)
    }

    public int xorOfNumbersLtoRTwo(int L, int R){
        // optimal: calculate the XOR 1 to L-1 and 1 to R and XOR the both result will be the answer
        // e.g: L=4, R=7 , ans = 4^5^6^7
        // XOR 1 to L-1 = 1^2^3
        // XOR 1 to R = 1^2^3^4^5^6^7
        // if XOR the result = (1^2^3) ^ (1^2^3^4^5^6^7), same number will be canceled
        //                   = 4^5^6^7 our desired ans

        int xor1;

        if (L-1 % 4 == 1){
            xor1 = 1;
        } else if (L-1 % 4 == 2){
            xor1 =  L-1 + 1;
        } else if (L-1 % 4 == 3){
            xor1 = 0;
        } else {
            xor1 = L-1;
        }

        int xor2;

        if (R % 4 == 1){
            xor2 = 1;
        } else if (R % 4 == 2){
            xor2 =  R + 1;
        } else if (R % 4 == 3){
            xor2 = 0;
        } else {
            xor2 = R;
        }

        return xor1 ^ xor2;
        // time: O(1)
        // space: O(1)
    }

    public static void main(String[] args) {

    }
}
