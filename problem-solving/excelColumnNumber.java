/**
 * https://www.interviewbit.com/problems/excel-column-number/
 * Given a column title as appears in an Excel sheet, return its corresponding column number.
 */

public class Solution {
    public int titleToNumber(String A) {
        final int A_ASCII_VAL = 65;
        int pow = 1;
        int column = 0;
        
        for(int i = A.length()-1; i >= 0; i--) {
            column += pow * (A.charAt(i) - A_ASCII_VAL + 1);
            pow *= 26;
        }
        return column;
    }
}
