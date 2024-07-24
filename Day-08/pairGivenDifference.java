//Given an array arr[] of size n and an integer x, return 1 if there exists a pair of elements in the array whose absolute difference is x, otherwise, return -1.

import java.util.HashSet;

class Solution {
    public int findPair(int n, int x, int[] arr) {
        HashSet<Integer> set = new HashSet<>();
        
        for (int num : arr) {
            if (set.contains(num - x) || set.contains(num + x)) {
                return 1;
            }
            set.add(num);
        }
        
        return -1;
    }
}