// Given an array nums with n objects colored red, white, or blue, sort them in-place so that objects of the same color are adjacent, with the colors in the order red, white, and blue.
// We will use the integers 0, 1, and 2 to represent the color red, white, and blue, respectively.
// You must solve this problem without using the library's sort function.

// Time Complexity: O(n)
// Space Complexity: O(1)

class Solution {
    public void swap(int[] nums, int x, int y){
        int temp = nums[x];
        nums[x] = nums[y];
        nums[y] = temp;
    }
    public void sortColors(int[] nums) {
        int low = 0, mid = 0, high = nums.length-1;
        while(mid <= high){
            if(nums[mid] == 0){
                swap(nums, mid, low);
                mid++;
                low++;
            } else if (nums[mid] == 1) mid++;
            else {
                swap(nums, mid, high);
                high--;
            }
        }
    }
}