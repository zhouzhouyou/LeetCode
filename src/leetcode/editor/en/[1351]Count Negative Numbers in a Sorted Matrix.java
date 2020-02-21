//Given a m * n matrix grid which is sorted in non-increasing order both row-wis
//e and column-wise. 
//
// Return the number of negative numbers in grid. 
//
// 
// Example 1: 
//
// 
//Input: grid = [[4,3,2,-1],[3,2,1,-1],[1,1,-1,-2],[-1,-1,-2,-3]]
//Output: 8
//Explanation: There are 8 negatives number in the matrix.
// 
//
// Example 2: 
//
// 
//Input: grid = [[3,2],[1,0]]
//Output: 0
// 
//
// Example 3: 
//
// 
//Input: grid = [[1,-1],[-1,-1]]
//Output: 3
// 
//
// Example 4: 
//
// 
//Input: grid = [[-1]]
//Output: 1
// 
//
// 
// Constraints: 
//
// 
// m == grid.length 
// n == grid[i].length 
// 1 <= m, n <= 100 
// -100 <= grid[i][j] <= 100 
// Related Topics Array Binary Search


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int countNegatives(int[][] grid) {
        int rows = grid.length, cols = rows > 0 ? grid[0].length : 0;
        int row = 0, col = cols - 1;
        int count = 0;
        while (row < rows && col >= 0) {
            if (grid[row][col] < 0) {
                col--;
                count += rows - row;
            } else {
                row++;
            }
        }
        return count;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
