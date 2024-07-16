// Given an integer array nums, move all 0's to the end of it while maintaining the relative order of the non-zero elements.
// Note that you must do this in-place without making a copy of the array.

// Time Complexity: O(n)
// Space Complexity: O(1)

class Solution {
    public void moveZeroes(int[] nums) {
        int n = nums.length;
        if (nums == null || n == 0) {
            return;
        }
        int index = 0; 

        //move all non-zero elements to the beginning of the array
        for (int i = 0; i < n; i++) {
            if (nums[i] != 0) {
                nums[index] = nums[i];
                index++;
            }
        }

        //fill the rest of the array with zeros
        for (int i = index; i < n; i++) {
            nums[i] = 0;
        }
    }
}