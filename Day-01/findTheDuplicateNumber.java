// Given an array of integers nums containing n + 1 integers where each integer is in the range [1, n] inclusive.
// There is only one repeated number in nums, return this repeated number.
// You must solve the problem without modifying the array nums and uses only constant extra space.

// Time Complexity: O(n)
// Space Complexity: O(1)

class Solution {
    public int findDuplicate(int[] nums) {
        int n = nums.length;
        for(int i=0;i<n;i++){
            int index = Math.abs(nums[i]);
            if(nums[index] < 0) return index;
            nums[index] = -nums[index];
        }
        return 0;
    }
}