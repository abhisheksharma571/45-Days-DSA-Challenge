// You are given an n x n 2D matrix representing an image, rotate the image by 90 degrees (clockwise).

// You have to rotate the image in-place, which means you have to modify the input 2D matrix directly. DO NOT allocate another 2D matrix and do the rotation.

class Solution {
    public void transposeArrayInPlace(int arr[][], int r,int c){
        for(int i=0;i<r;i++){
            for(int j=0;j<i;j++){
                int temp = arr[i][j];
                arr[i][j] = arr[j][i];
                arr[j][i] = temp;
            }
        }
    }
    public void reverseArray(int arr[]){
        int i=0, j= arr.length -1;
        while(i<j){
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }
    }
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        transposeArrayInPlace(matrix,n,n);
        //reverse each row of transposed matrix
        for(int i=0;i<n;i++){
            reverseArray(matrix[i]);
        }
    }
}