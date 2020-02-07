//Given a positive integer n, generate a square matrix filled with elements from
// 1 to n2 in spiral order. 
//
// Example: 
//
// 
//Input: 3
//Output:
//[
// [ 1, 2, 3 ],
// [ 8, 9, 4 ],
// [ 7, 6, 5 ]
//]
// 
// Related Topics Array


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[][] generateMatrix(int n) {
        int[][] ans = new int[n][n];
        int rowStart = 0, rowEnd = n - 1;
        int colStart = 0, colEnd = n - 1;
        int count = 0;
        int product = n * n;
        while (count < product) {
            for (int i = colStart; i <= colEnd && count < product; i++) {
                ans[rowStart][i] = ++count;
            }

            for (int i = rowStart + 1; i <= rowEnd - 1 && count < product; i++) {
                ans[i][colEnd] = ++count;
            }

            for (int i = colEnd; i >= colStart && count < product; i--) {
                ans[rowEnd][i] = ++count;
            }

            for (int i = rowEnd - 1; i >= rowStart + 1 && count < product; i--) {
                ans[i][colStart] = ++count;
            }

            rowStart++; rowEnd--; colStart++; colEnd--;
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
