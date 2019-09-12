/**
 * https://leetcode.com/problems/remove-duplicates-from-sorted-array-ii/
 *
 * Given a sorted array nums, remove the duplicates in-place such that 
 * duplicates appeared at most twice and return the new length.
 *
 * Do not allocate extra space for another array, you must do this by 
 * modifying the input array in-place with O(1) extra memory.
 */

class Solution {
    public int removeDuplicates(int[] nums) {
        if(nums.length < 1) return 0;
        
        int b = -1;
        int seen = 0;
        int target = nums[0];
        
        for(int i=0; i < nums.length; i++) {
            // check if number was already seen
            if(nums[i] == target && seen < 2) {
                int temp = nums[i];
                nums[i] = nums[b+1];
                nums[b+1] = temp;
                seen++;
                b++;
            }
            // if not seen yet
            else if(nums[i] != target){
                target = nums[i];
                b++;
                int temp = nums[i];
                nums[i] = nums[b];
                nums[b] = temp;
                seen = 1;
            }
        }       
        return b+1;
    }    
}