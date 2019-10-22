/**
 * https://www.interviewbit.com/problems/power-of-2/
 * Find if Given number is power of 2 or not.
 * More specifically, find if given number can be expressed as 2^k where k >= 1.
 */

import java.math.BigInteger;

public class Solution {
    public int power(String A) {
        final BigInteger TWO = new BigInteger("2");
        BigInteger num = new BigInteger(A);
        if(num.compareTo(BigInteger.ONE) <= 0) return 0;
        
        while(num.compareTo(BigInteger.ONE) > 0) {
            BigInteger mod = num.mod(TWO);
        //    System.out.println(num.toString() + " % " + TWO.toString() + " == " + mod.toString());
            if(mod.compareTo(BigInteger.ZERO) != 0) {
                return 0;
            }
            num = num.divide(TWO);
        }
        return 1;
    }
}
