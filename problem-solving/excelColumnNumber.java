/**
 * https://www.interviewbit.com/problems/excel-column-number/
 * Given a column title as appears in an Excel sheet, return its corresponding column number.
 */

public class Solution {
    public int titleToNumber(String A) {
        int k = 0;
        int column = 0;
        
        while(k < A.length()) {
            column += (A.charAt(A.length() - 1 - k) - 65 + 1) * Math.pow(26, k);
            k++;
        }
        return column;
    }
}
