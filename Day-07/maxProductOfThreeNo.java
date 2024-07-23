import java.util.Arrays;
//Given an integer array nums, find three numbers whose product is maximum and return the maximum product.
class Solution {
    public int maximumProduct(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        // The maximum product can be the product of the three largest numbers or the product of the two smallest numbers (which can be negative) and the largest number
        int product1 = nums[n-1] * nums[n-2] * nums[n-3];
        int product2 = nums[0] * nums[1] * nums[n-1];
        return Math.max(product1, product2);
    }
}