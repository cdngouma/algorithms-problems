/**
 * https://leetcode.com/problems/string-to-integer-atoi/
 *
 * Implement atoi which converts a string to an integer.
 * 
 * The function first discards as many whitespace characters as necessary until the 
 * first non-whitespace character is found. Then, starting from this character, takes
 * an optional initial plus or minus sign followed by as many numerical digits as 
 * possible, and interprets them as a numerical value. 
 * 
 * The string can contain additional characters after those that form the integral 
 * number, which are ignored and have no effect on the behavior of this function.
 * 
 * If the first sequence of non-whitespace characters in str is not a valid integral 
 * number, or if no such sequence exists because either str is empty or it contains 
 * only whitespace characters, no conversion is performed.
 * 
 * If no valid conversion could be performed, a zero value is returned.
 */

class Solution {
    public int myAtoi(String str) {
        long num = 0;
        byte sign = 1;
        boolean flag = false; // sugnals beginning of valid sequence of characters (sign and digits)
		final byte ZERO_CHAR = 48;
		final byte NINE_CHAR = 57;
        
        for(int k=0; k < str.length(); k++) {
            char ch = str.charAt(k);
            if(!flag && ch == ' ') continue;
            else if(!flag && (ch == '-' || ch == '+')) {
                flag = true;
                sign = ch == '-' ? (byte)-1 : (byte)1;
            }
            else if(ch >= ZERO_CHAR && ch <= NINE_CHAR) {
                flag = true;
                num = num * 10 + ch - ZERO_CHAR;
                if(sign * num > Integer.MAX_VALUE) return Integer.MAX_VALUE;
                if(sign * num < Integer.MIN_VALUE) return Integer.MIN_VALUE;
            }
            else break;
        }
        
        return (int)num * sign;
    }   
}