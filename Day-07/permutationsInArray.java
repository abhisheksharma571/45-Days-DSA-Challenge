//Given two arrays of equal size N and an integer K. The task is to check if after permuting both arrays, we get sum of their corresponding element greater than or equal to k i.e Ai + Bi >= K for all i (from 0 to N-1). Return true if possible, else false.

import java.util.Arrays;

class Solution {
    private void reverseArray(long[] array) {
        int left = 0;
        int right = array.length - 1;
        while (left < right) {
            long temp = array[left];
            array[left] = array[right];
            array[right] = temp;
            left++;
            right--;
        }
    }
    public boolean isPossible(long a[], long b[], int n, long k) {
    Arrays.sort(a);
    reverseArray(a);
    Arrays.sort(b);
        for(int i=0;i<n;i++){
            if(a[i] + b[i] < k) return false;
        }
        return true;
    }
}