//Given a m x n binary matrix mat. In one step, you can choose one cell and flip
// it and all the four neighbours of it if they exist (Flip is changing 1 to 0 and
// 0 to 1). A pair of cells are called neighboors if they share one edge. 
//
// Return the minimum number of steps required to convert mat to a zero matrix o
//r -1 if you cannot. 
//
// Binary matrix is a matrix with all cells equal to 0 or 1 only. 
//
// Zero matrix is a matrix with all cells equal to 0. 
//
// 
// Example 1: 
//
// 
//Input: mat = [[0,0],[0,1]]
//Output: 3
//Explanation: One possible solution is to flip (1, 0) then (0, 1) and finally (
//1, 1) as shown.
// 
//
// Example 2: 
//
// 
//Input: mat = [[0]]
//Output: 0
//Explanation: Given matrix is a zero matrix. We don't need to change it.
// 
//
// Example 3: 
//
// 
//Input: mat = [[1,1,1],[1,0,1],[0,0,0]]
//Output: 6
// 
//
// Example 4: 
//
// 
//Input: mat = [[1,0,0],[1,0,0]]
//Output: -1
//Explanation: Given matrix can't be a zero matrix
// 
//
// 
// Constraints: 
//
// 
// m == mat.length 
// n == mat[0].length 
// 1 <= m <= 3 
// 1 <= n <= 3 
// mat[i][j] is 0 or 1. 
// 
// Related Topics Breadth-first Search


import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int minFlips(int[][] mat) {
        int rows = mat.length, cols = rows > 0 ? mat[0].length : 0;
        if (rows == 0 || cols == 0) return -1;
        int num = code(mat, rows, cols);
        int step = 0;
        if (num == 0) return 0;
        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> seen = new HashSet<>();
        seen.add(num);
        queue.add(num);
        while (!queue.isEmpty()) {
            step++;
            int size = queue.size();
            while (size-- > 0) {
                decode(mat, queue.poll(), rows, cols);
                for (int i = 0; i < rows; i++) {
                    for (int j = 0; j < cols; j++) {
                        flip(mat, i, j);
                        num = code(mat, rows, cols);
                        if (num == 0) return step;
                        if (!seen.contains(num)) {
                            seen.add(num);
                            queue.add(num);
                        }
                        flip(mat, i, j);
                    }
                }
            }
        }
        return -1;
    }

    private void flip(int[][] mat, int i, int j) {
        mat[i][j] = 1 - mat[i][j];
        if (i != mat.length - 1) mat[i+1][j] = 1 - mat[i+1][j];
        if (i != 0) mat[i-1][j] = 1 - mat[i-1][j];
        if (j != mat[i].length - 1) mat[i][j+1] = 1 - mat[i][j+1];
        if (j != 0) mat[i][j-1] = 1 - mat[i][j-1];
    }

    private int code(int[][] mat, int rows, int cols) {
        int num = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                num = 2 * num + mat[i][j];
            }
        }
        return num;
    }

    private void decode(int[][] mat, int num, int rows, int cols) {
        for (int i = rows - 1; i >= 0; i--) {
            for (int j = cols - 1; j >= 0; j--) {
                mat[i][j] = (num & 1);
                num >>= 1;
            }
        }
    }

}
//leetcode submit region end(Prohibit modification and deletion)
