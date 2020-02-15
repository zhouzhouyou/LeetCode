//Given a 2d grid map of '1's (land) and '0's (water), count the number of islan
//ds. An island is surrounded by water and is formed by connecting adjacent lands 
//horizontally or vertically. You may assume all four edges of the grid are all su
//rrounded by water. 
//
// Example 1: 
//
// 
//Input:
//11110
//11010
//11000
//00000
//
//Output: 1
// 
//
// Example 2: 
//
// 
//Input:
//11000
//11000
//00100
//00011
//
//Output: 3
// Related Topics Depth-first Search Breadth-first Search Union Find


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int numIslands(char[][] grid) {
        int row = grid.length;
        if (row == 0) return 0;
        int col = grid[0].length;
        if (col == 0) return 0;
        boolean[][] visited = new boolean[row][col];
        int count = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (visited[i][j]) continue;
                if (grid[i][j] == '0') {
                    visited[i][j] = true;
                    continue;
                }
                DFS(grid, visited, i, j);
                count++;
            }
        }
        return count;
    }

    private void DFS(char[][] grid, boolean[][] visited, int row, int col) {
        if (visited[row][col]) return;
        visited[row][col] = true;
        if (grid[row][col] == '0') return;
        if (col != grid[row].length - 1) DFS(grid, visited, row, col + 1);
        if (col != 0) DFS(grid, visited, row, col - 1);
        if (row != grid.length - 1) DFS(grid, visited, row + 1, col);
        if (row != 0) DFS(grid, visited, row - 1, col);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
