// According to Wikipedia's article: "The Game of Life, also known simply as Life, is a cellular automaton devised by the British mathematician John Horton Conway in 1970."

// The board is made up of an m x n grid of cells, where each cell has an initial state: live (represented by a 1) or dead (represented by a 0). Each cell interacts with its eight neighbors (horizontal, vertical, diagonal) using the following four rules (taken from the above Wikipedia article):

// Any live cell with fewer than two live neighbors dies as if caused by under-population.
// Any live cell with two or three live neighbors lives on to the next generation.
// Any live cell with more than three live neighbors dies, as if by over-population.
// Any dead cell with exactly three live neighbors becomes a live cell, as if by reproduction.
// The next state is created by applying the above rules simultaneously to every cell in the current state, where births and deaths occur simultaneously. Given the current state of the m x n grid board, return the next state


class Solution {
    public void gameOfLife(int[][] board) {
        int rows = board.length;
        int cols = board[0].length;
        // Directions array to help find neighbors
        int[][] directions = {
            {-1, -1}, {-1, 0}, {-1, 1},
            {0, -1},         {0, 1},
            {1, -1}, {1, 0}, {1, 1}
        };

        int[][] copy = new int[rows][cols];
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                copy[r][c] = board[r][c];
            }
        }

        for(int r=0;r<rows;r++){
            for(int c=0;c<cols;c++){
                //count live neighbours
                int liveNeighbours = 0;
                for(int[] direction : directions){
                    int nr = r+direction[0];
                    int nc = c+direction[1];
                    if(nr >= 0 && nr < rows && nc >= 0 && nc < cols && copy[nr][nc] == 1){
                        liveNeighbours++;
                    }
                }
                //apply the game of life rules
                if(copy[r][c] == 1){
                    if(liveNeighbours < 2 || liveNeighbours > 3){
                        board[r][c] = 0;  //dies
                    }
                } else {
                    if(liveNeighbours == 3){
                        board[r][c] = 1;  //becomes live
                    }
                }
            }
        }
    }
}