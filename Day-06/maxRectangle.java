//Given a rows x cols binary matrix filled with 0's and 1's, find the largest rectangle containing only 1's and return its area.

import java.util.Stack;

class Solution {
    public static int maximalRectangle(char[][] matrix) {
        if (matrix.length == 0) return 0;

        int rows = matrix.length;
        int cols = matrix[0].length;
        int[] heights = new int[cols];
        int maxArea = 0;

        for (int i = 0; i < rows; i++) {
            // Update the histogram heights for the current row
            for (int j = 0; j < cols; j++) {
                if (matrix[i][j] == '1') {
                    heights[j]++;
                } else {
                    heights[j] = 0;
                }
            }
            // Calculate the maximum area for the current histogram
            maxArea = Math.max(maxArea, largestRectangleArea(heights));
        }

        return maxArea;
    }

    // Function to calculate the largest rectangle area in a histogram
    public static int largestRectangleArea(int[] heights){
        int n = heights.length;
        Stack<Integer> st = new Stack<>();
        int[] nse = new int[n];
        int[] pse = new int[n];
        //calculate nse[]
        st.push(n-1);    //index
        nse[n-1] = n;
        for(int i=n-2;i>=0;i--){
            while(st.size() > 0 && heights[st.peek()] >= heights[i]){
                st.pop();
            }
            if(st.size() == 0) nse[i] = n;
            else nse[i] = st.peek();
            st.push(i);
        }
        //emptying stack
        while(st.size() > 0) st.pop();
        //calculate pse[]
        st.push(0);
        pse[0] = -1;
        for(int i=1;i<=n-1;i++){
            while(st.size() > 0 && heights[st.peek()] >= heights[i]){
                st.pop();
            }
            if(st.size() == 0) pse[i] = -1;
            else pse[i] = st.peek();
            st.push(i);
        }
        //maximum area of rectangle
        int max = -1;
        for(int i=0;i<n;i++){
            int area = heights[i] * (nse[i] - pse[i] - 1);
            max = Math.max(max,area);
        }
        return max;
    }
}