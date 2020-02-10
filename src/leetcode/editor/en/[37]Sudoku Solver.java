//Write a program to solve a Sudoku puzzle by filling the empty cells. 
//
// A sudoku solution must satisfy all of the following rules: 
//
// 
// Each of the digits 1-9 must occur exactly once in each row. 
// Each of the digits 1-9 must occur exactly once in each column. 
// Each of the the digits 1-9 must occur exactly once in each of the 9 3x3 sub-b
//oxes of the grid. 
// 
//
// Empty cells are indicated by the character '.'. 
//
// 
//A sudoku puzzle... 
//
// 
//...and its solution numbers marked in red. 
//
// Note: 
//
// 
// The given board contain only digits 1-9 and the character '.'. 
// You may assume that the given Sudoku puzzle will have a single unique solutio
//n. 
// The given board size is always 9x9. 
// 
// Related Topics Hash Table Backtracking


import java.util.LinkedList;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    char[][] board;
    public void solveSudoku(char[][] board) {
        this.board = board;
        backtrack(0, 0);
    }

    private boolean backtrack(int row, int col) {
        if (col == 9) {
            row++; col = 0;
        }
        if (row == 9) return true;
        if (board[row][col] != '.') return backtrack(row, col + 1);
        for (char x : getValid(row, col)) {
            board[row][col] = x;
            if (backtrack(row, col + 1)) return true;
            board[row][col] = '.';
        }
        return false;
    }

    private List<Character> getValid(int row, int col) {
        char[] temp = {'1', '2', '3', '4', '5', '6', '7', '8', '9'};
        for (char[] chars : board) {
            char x = chars[col];
            if (x != '.') temp[x - '1'] = '.';
        }
        for (int i = 0; i < 9; i++) {
            char x = board[row][i];
            if (x != '.') temp[x - '1'] = '.';
        }
        int br = (row / 3) * 3;
        int bc = (col / 3) * 3;
        for (int i = br; i < br + 3; i++) {
            for (int j = bc; j < bc + 3; j++) {
                char x = board[i][j];
                if (x != '.') temp[x - '1'] = '.';
            }
        }
        List<Character> ans = new LinkedList<>();
        for (char x : temp) if (x != '.') ans.add(x);
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
