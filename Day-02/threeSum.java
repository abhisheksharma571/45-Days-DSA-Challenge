
// Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.

// Notice that the solution set must not contain duplicate triplets.

//Time Complexity: O(n^2), Space Complexity: O(n)

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length < 3) return result;

        Arrays.sort(nums); 

        for (int i = 0; i < nums.length - 2; i++) {  
            if (i > 0 && nums[i] == nums[i - 1]) continue;  // Avoid duplicates for the first element

            int left = i + 1;
            int right = nums.length - 1;

            while (left < right) {  
                int sum = nums[i] + nums[left] + nums[right];
                if (sum == 0) {
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    while (left < right && nums[left] == nums[left + 1]) left++;  // Avoid duplicates for the second element
                    while (left < right && nums[right] == nums[right - 1]) right--;  // Avoid duplicates for the third element
                    left++;
                    right--;
                } else if (sum < 0) {
                    left++;
                } else {
                    right--;
                }
            }
        }

        return result;
    }
}