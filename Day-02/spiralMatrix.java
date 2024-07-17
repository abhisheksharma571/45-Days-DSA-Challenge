//Given an m x n matrix, return all elements of the matrix in spiral order.

//Time Complexity: O(m * n)
//Space Complexity: O(m * n)

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int r = matrix.length;
        int c = matrix[0].length;
        List<Integer> result = new ArrayList<>();
        int topRow=0, bottomRow=r-1, leftCol=0, rightCol=c-1;
        int totalElements = 0;
        while (totalElements< r*c){
            //top row--> leftCol to rightCol
            for(int j=leftCol;j<=rightCol && totalElements< r*c;j++){
                result.add(matrix[topRow][j]);
                totalElements++;
            }
            topRow++;
            //right columns--> topRow to bottomRow
            for(int i=topRow;i<=bottomRow && totalElements< r*c;i++){
                result.add(matrix[i][rightCol]);
                totalElements++;
            }
            rightCol--;
            //bottomRow--> rightCol to leftCol
            for(int j=rightCol;j>=leftCol && totalElements< r*c;j--){
                result.add(matrix[bottomRow][j]);
                totalElements++;
            }
            bottomRow--;
            //left columns--> bottomRow to topRow
            for(int i=bottomRow;i>=topRow && totalElements< r*c;i--){
                result.add(matrix[i][leftCol]);
                totalElements++;
            }
            leftCol++;
        }
        return result;
    }
}