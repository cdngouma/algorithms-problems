/**
 * https://www.interviewbit.com/problems/longest-increasing-subsequence/
 * 
 * Find the longest increasing subsequence of a given array of integers, A.
 * In other words, find a subsequence of array in which the subsequence’s elements are in strictly increasing order, and in which the subsequence is as long as possible.
 * This subsequence is not necessarily contiguous, or unique.
 * In this case, we only care about the length of the longest increasing subsequence.
 */
 
public class Solution {
    // DO NOT MODIFY THE ARGUMENTS WITH "final" PREFIX. IT IS READ ONLY
    public int lis(final int[] A) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int max = 0;
        for(int i = A.length-1; i >= 0; i--) {
            int tmpMax = 0;
            for(int j = i+1; j < A.length; j++) {
                int len = 0;
                if(A[j] > A[i] && map.containsKey(j)) {
                    len = len + map.get(j);
                    tmpMax = Math.max(tmpMax, len);
                }
            }
            tmpMax = tmpMax + 1;
            map.put(i, tmpMax);
            max = Math.max(tmpMax, max);
        }
        
        return max;
    }
}
