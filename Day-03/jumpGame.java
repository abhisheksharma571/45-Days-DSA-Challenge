// You are given an integer array nums. You are initially positioned at the array's first index, and each element in the array represents your maximum jump length at that position.

// Return true if you can reach the last index, or false otherwise.

// Time complexity: O(n),  Space complexity: O(1)

class Solution {
    public boolean canJump(int[] nums) {
        int n = nums.length;
        int maxIndex = nums[0];
        int i = 0;
        while(maxIndex >= i){
            int jumpIndex = i + nums[i];
            maxIndex = Math.max(maxIndex, jumpIndex);
            if(maxIndex >= n-1) return true;
            i++;
        }
        return false;
    }
}