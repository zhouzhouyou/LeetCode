//Given a non-empty 2D matrix matrix and an integer k, find the max sum of a rec
//tangle in the matrix such that its sum is no larger than k. 
//
// Example: 
//
// 
//Input: matrix = [[1,0,1],[0,-2,3]], k = 2
//Output: 2 
//Explanation: Because the sum of rectangle [[0, 1], [-2, 3]] is 2,
//             and 2 is the max number no larger than k (k = 2). 
//
// Note: 
//
// 
// The rectangle inside the matrix must have an area > 0. 
// What if the number of rows is much larger than the number of columns? 
// Related Topics Binary Search Dynamic Programming Queue


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxSumSubmatrix(int[][] matrix, int k) {
        int rows = matrix.length, cols = matrix[0].length, res = Integer.MIN_VALUE;
        for (int left = 0; left < cols; ++left) {
            int[] sum = new int[rows];
            for (int right = left; right < cols; ++right) {
                for (int r = 0; r < rows; ++r) {
                    sum[r] += matrix[r][right];
                }

                int max = sum[0], maxSoFar = 0;
                for (int s : sum) {
                    maxSoFar = Math.max(maxSoFar + s, s);
                    max = Math.max(max, maxSoFar);
                    if (max == k) return k;
                }
                if (max < k) res = Math.max(res, max);
                else {
                    for (int top = 1; top < rows; ++top) {
                        int currSum = 0;
                        for (int down = top; down < rows; ++down) {
                            currSum += sum[down];
                            if (currSum <= k) res = Math.max(res, currSum);
                        }
                    }
                }
                if (res == k) return res;
            }
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
