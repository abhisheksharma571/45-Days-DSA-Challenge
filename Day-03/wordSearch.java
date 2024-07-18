// Given an m x n grid of characters board and a string word, return true if word exists in the grid.

// The word can be constructed from letters of sequentially adjacent cells, where adjacent cells are horizontally or vertically neighboring. The same letter cell may not be used more than once.
// Time complexity: O(m * n * 4^L),  Space complexity: O(L)

class Solution {
    public boolean search(int i, int j, int m, int n, char[][] board, String word, int k){
        if(k == word.length()) return true;
        if(i < 0 || j < 0 || i == m || j == n || board[i][j] != word.charAt(k)) return false;
        char ch = board[i][j];
        board[i][j] = '#';
        boolean opt1 = search(i+1, j, m, n, board, word, k+1);  // down
        boolean opt2 = search(i, j+1, m, n, board, word, k+1);  //right
        boolean opt3 = search(i-1, j, m, n, board, word, k+1);   //up
        boolean opt4 = search(i, j-1, m, n, board, word, k+1);   //left
        board[i][j] = ch;
        return opt1 || opt2 || opt3 || opt4;

    }
    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(board[i][j] == word.charAt(0)){
                    if(search(i, j, m, n, board, word, 0)) return true;
                }
            }
        }
        return false;
    }
}