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


import java.util.TreeSet;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxSumSubmatrix(int[][] matrix, int k) {
        int rows = matrix.length, cols = rows > 0 ? matrix[0].length : 0;
        if (rows == 0 || cols == 0) return 0;
        int ans = Integer.MIN_VALUE;

        for (int left = 0; left < cols; left++) {
            int[] sums = new int[rows];
            for (int right = left; right < cols; right++) {
                for (int i = 0; i < rows; i++) sums[i] += matrix[i][right];

                TreeSet<Integer> set = new TreeSet<>();
                set.add(0);
                int curSum = 0;

                for (int sum : sums) {
                    curSum += sum;
                    //寻找curSum - num <= k (即某一段的值小于k)
                    Integer num = set.ceiling(curSum - k);
                    if (num != null) ans = Math.max(ans, curSum - num);
                    set.add(curSum);
                }
            }
        }

        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
