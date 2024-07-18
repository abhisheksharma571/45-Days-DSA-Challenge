// Given a collection of numbers, nums, that might contain duplicates, return all possible unique permutations in any order.

//Time complexity: O(n * n!) Space complexity: O(n!)

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution {
    public void backtrack(int[] nums, int idx, List<List<Integer>> ans){
        int n = nums.length;
        if(idx==n-1){
            List<Integer> l = new ArrayList<>();
            for(int i=0;i<n;i++){
                l.add(nums[i]);
            }
            ans.add(l);
            return;
        }
        Set<Integer> used = new HashSet<>();
        for(int i=idx;i<n;i++){
            if(!used.contains(nums[i])){
                used.add(nums[i]);
                swap(i, idx, nums);
                backtrack(nums, idx + 1, ans);
                swap(i, idx, nums);  // backtrack
            }
        }
    }
    public static void swap(int i, int j, int[] nums){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(nums, 0, ans);
        return ans;
    }
}


    
   