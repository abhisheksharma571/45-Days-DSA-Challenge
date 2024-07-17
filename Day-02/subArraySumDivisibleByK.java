// Given an integer array nums and an integer k, return the number of non-empty subarrays that have a sum divisible by k.

// A subarray is a contiguous part of an array.


//Time complexity: O(n), Space complexity: O(k).
class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        //HashMap<Integer, Integer> map = new HashMap<>();
        int map[] = new int[k];
        //map.put(0,1);
        map[0] = 1;
        int sum = 0;
        int res = 0;
        for(int i=0;i<nums.length;i++){
            sum += nums[i];
            int mod = sum%k;
            //convert negative remainder into positive
            if(mod<0) mod = mod%k + k;
            //if(map.containsKey(mod)) res += map.get(mod);
            res += map[mod];
            //map.put(mod, map.get(getOrDefault(mod, 0) + 1));
            map[mod]++;
        }
        return res;
    }
}
