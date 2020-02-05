//Given a 2D board and a word, find if the word exists in the grid. 
//
// The word can be constructed from letters of sequentially adjacent cell, where
// "adjacent" cells are those horizontally or vertically neighboring. The same let
//ter cell may not be used more than once. 
//
// Example: 
//
// 
//board =
//[
//  ['A','B','C','E'],
//  ['S','F','C','S'],
//  ['A','D','E','E']
//]
//
//Given word = "ABCCED", return true.
//Given word = "SEE", return true.
//Given word = "ABCB", return false.
// 
// Related Topics Array Backtracking


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean exist(char[][] board, String word) {
        if (word == null || word.length() == 0) return false;
        for (int i = 0; i < board.length; i++) {
            char[] chars = board[i];
            for (int j = 0; j < chars.length; j++) {
                if (chars[j] == word.charAt(0)) {
                    boolean[][] used = new boolean[board.length][chars.length];
                    used[i][j] = true;
                    if (dfs(new StringBuilder(), board, i, j, word, used)) return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(StringBuilder sb, char[][] board, int row, int col, String word, boolean[][] used) {
        sb.append(board[row][col]);
        used[row][col] = true;
        if (sb.length() == word.length()) {
            return sb.toString().equals(word);
        }
        char cs = word.charAt(sb.length());
        if (row > 0 && cs == board[row - 1][col] && !used[row - 1][col]) {
            if (dfs(sb, board, row - 1, col, word, used)) return true;
        }
        if (row < board.length - 1  && cs == board[row + 1][col] && !used[row + 1][col]) {
            if (dfs(sb, board, row + 1, col, word, used)) return true;
        }
        if (col > 0 && cs == board[row][col - 1] && !used[row][col - 1]) {
            if (dfs(sb, board, row, col - 1, word, used)) return true;
        }
        if (col < board[0].length - 1 && cs == board[row][col + 1] && !used[row][col + 1]) {
            if (dfs(sb, board, row, col + 1, word, used)) return true;
        }
        used[row][col] = false;
        sb.delete(sb.length() - 1, sb.length());
        return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
