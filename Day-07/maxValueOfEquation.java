// You are given an array points containing the coordinates of points on a 2D plane, sorted by the x-values, where points[i] = [xi, yi] such that xi < xj for all 1 <= i < j <= points.length. You are also given an integer k.

// Return the maximum value of the equation yi + yj + |xi - xj| where |xi - xj| <= k and 1 <= i < j <= points.length.

// It is guaranteed that there exists at least one pair of points that satisfy the constraint |xi - xj| <= k.

import java.util.PriorityQueue;

class Solution {
    public int findMaxValueOfEquation(int[][] points, int k) {
        //Priority Queue to keep track of max(yi + xi)
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> Integer.compare(b[0], a[0]));
        int maxValue = Integer.MIN_VALUE;

        for(int j=0;j<points.length;j++){
            int xj = points[j][0];
            int yj = points[j][1];

            //remove elements from heap where xi is out of range
            while(!pq.isEmpty() && xj - pq.peek()[1] > k){
                pq.poll();
            }
            //check the maximum value
            if(!pq.isEmpty()){
                maxValue = Math.max(maxValue, pq.peek()[0] + yj + xj);
            }
            //add curent element to heap
            pq.offer(new int[]{yj - xj, xj});
        }
        return maxValue;
    }
}