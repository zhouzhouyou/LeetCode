//Given a matrix of m x n elements (m rows, n columns), return all elements of t
//he matrix in spiral order. 
//
// Example 1: 
//
// 
//Input:
//[
// [ 1, 2, 3 ],
// [ 4, 5, 6 ],
// [ 7, 8, 9 ]
//]
//Output: [1,2,3,6,9,8,7,4,5]
// 
//
// Example 2: 
// 
//Input:
//[
//  [1, 2, 3, 4],
//  [5, 6, 7, 8],
//  [9,10,11,12]
//]
//Output: [1,2,3,4,8,12,11,10,9,5,6,7]
// Related Topics Array


import java.util.ArrayList;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        if (matrix == null || matrix.length == 0) return res;
        int n = matrix.length, m = matrix[0].length;
        int up = 0,  down = n - 1;
        int left = 0, right = m - 1;
        int product = n * m;
        while (res.size() < product) {
            for (int j = left; j <= right && res.size() < product; j++)
                res.add(matrix[up][j]);

            for (int i = up + 1; i <= down - 1 && res.size() < product; i++)
                res.add(matrix[i][right]);

            for (int j = right; j >= left && res.size() < product; j--)
                res.add(matrix[down][j]);

            for (int i = down - 1; i >= up + 1 && res.size() < product; i--)
                res.add(matrix[i][left]);

            left++; right--; up++; down--;
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
