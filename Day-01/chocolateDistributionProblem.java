// Given an array A[ ] of positive integers of size N, where each value represents the number of chocolates in a packet. Each packet can have a variable number of chocolates. There are M students, the task is to distribute chocolate packets among M students such that :
// 1. Each student gets exactly one packet.
// 2. The difference between maximum number of chocolates given to a student and minimum number of chocolates given to a student is minimum.

// Time Complexity: O(n log n)
// Space Complexity: O(1)

import java.util.ArrayList;
import java.util.Collections;

class Solution
{
    public long findMinDiff (ArrayList<Integer> a, int n, int m)
    {
        Collections.sort(a);
        int minDiff = Integer.MAX_VALUE;
        for(int i=0;i<a.size()-(m-1);i++){
            int minimum = a.get(i+m-1) - a.get(i);
            minDiff = Math.min(minDiff, minimum);
            
        }
        return minDiff;
    }
}