//Given a 2D grid of size m x n and an integer k. You need to shift the grid k t
//imes. 
//
// In one shift operation: 
//
// 
// Element at grid[i][j] moves to grid[i][j + 1]. 
// Element at grid[i][n - 1] moves to grid[i + 1][0]. 
// Element at grid[m - 1][n - 1] moves to grid[0][0]. 
// 
//
// Return the 2D grid after applying shift operation k times. 
//
// 
// Example 1: 
//
// 
//Input: grid = [[1,2,3],[4,5,6],[7,8,9]], k = 1
//Output: [[9,1,2],[3,4,5],[6,7,8]]
// 
//
// Example 2: 
//
// 
//Input: grid = [[3,8,1,9],[19,7,2,5],[4,6,11,10],[12,0,21,13]], k = 4
//Output: [[12,0,21,13],[3,8,1,9],[19,7,2,5],[4,6,11,10]]
// 
//
// Example 3: 
//
// 
//Input: grid = [[1,2,3],[4,5,6],[7,8,9]], k = 9
//Output: [[1,2,3],[4,5,6],[7,8,9]]
// 
//
// 
// Constraints: 
//
// 
// m == grid.length 
// n == grid[i].length 
// 1 <= m <= 50 
// 1 <= n <= 50 
// -1000 <= grid[i][j] <= 1000 
// 0 <= k <= 100 
// 
// Related Topics Array


import java.util.LinkedList;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        int rows = grid.length, cols = rows > 0 ? grid[0].length : 0;
        List<List<Integer>> lists = new LinkedList<>();
        if (rows == 0 || cols == 0) return lists;
        k %= (rows * cols);
        int row = rows - 1 - k/cols, col = cols - k%cols;
        for (int i = 0; i < rows; i++) {
            List<Integer> list = new LinkedList<>();
            for (int j = 0; j < cols; j++) {
                if (col == cols) {
                    row++;
                    col = 0;
                    if (row == rows) row = 0;
                }
                list.add(grid[row][col]);
                col++;
            }
            lists.add(list);
        }
        return lists;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
