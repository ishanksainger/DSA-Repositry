class Solution {
    public boolean isValidSudoku(char[][] board) {
      // we are making this booleans to keep track of the number that we have already visited. and we mark them as true.
        boolean[][] rows = new boolean[9][10];
        boolean[][] columns = new boolean[9][10];
        boolean[][] boxes = new boolean[9][10];
        // now we visit each row and column
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                if (board[row][col] != '.') {
                  // here we get the board number of that particular row and column
                    int num = board[row][col] - '0';
                    // this formula is for 3 x 3 box as we have to check if the same number is in the box or not.
                    int boxIndex = (row / 3) * 3 + col / 3;
                    // this condiiton will checvk if any of the number is already true or you can say already visited. so we return false
                    if (rows[row][num] || columns[col][num] || boxes[boxIndex][num]) {
                        return false;
                    }
                    // else you keep marking the visiteed number as true in row colum and 3 x 3 matrix
                    rows[row][num] = true;
                    columns[col][num] = true;
                    boxes[boxIndex][num] = true;
                }
            }
        }
      // if none of them are visited then we return true
        return true;
    }
}
