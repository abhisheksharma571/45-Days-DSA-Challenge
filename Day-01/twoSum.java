// Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
// You may assume that each input would have exactly one solution, and you may not use the same element twice.
// You can return the answer in any order

// Time Complexity: O(n)
// Space Complexity: O(n)

import java.util.HashMap;

class Solution {
    public int[] twoSum(int[] nums, int target) { 
        int[] result = new int[2];
        int n = nums.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0;i<n;i++){
            int complement = target - nums[i];
            if(map.containsKey(complement)){
                result[0] = map.get(complement);
                result[1] = i;
                return result;
            }
            map.put(nums[i], i);
        }
        return result;
    }
}