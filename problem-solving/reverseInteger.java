/**
 * https://leetcode.com/problems/reverse-integer/
 *
 * Given a 32-bit signed integer, reverse digits of an integer.
 */

class Solution {
    public int reverse(int x) {
        long revNum = 0;
        
        while(x != 0) {
            revNum = revNum * 10 + x % 10;
            x /= 10;
            
            if(revNum > Integer.MAX_VALUE || revNum < Integer.MIN_VALUE)  return 0;
        }
        
        return (int)revNum;
    }
}