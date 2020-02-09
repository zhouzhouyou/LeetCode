//Write an efficient algorithm that searches for a value in an m x n matrix. Thi
//s matrix has the following properties: 
//
// 
// Integers in each row are sorted from left to right. 
// The first integer of each row is greater than the last integer of the previou
//s row. 
// 
//
// Example 1: 
//
// 
//Input:
//matrix = [
//  [1,   3,  5,  7],
//  [10, 11, 16, 20],
//  [23, 30, 34, 50]
//]
//target = 3
//Output: true
// 
//
// Example 2: 
//
// 
//Input:
//matrix = [
//  [1,   3,  5,  7],
//  [10, 11, 16, 20],
//  [23, 30, 34, 50]
//]
//target = 13
//Output: false 
// Related Topics Array Binary Search


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int row = matrix.length;
        if (row == 0) return false;
        int col = matrix[0].length;
        if (col == 0) return false;
        int top = 0, down = row - 1;
        int horizon = 0 ,vertical = (top + down) / 2;;
        while (top < down) {
            int cp = Integer.compare(matrix[vertical][0], target);
            if (cp < 0) {
                if (matrix[vertical+1][0] > target) break;
                if (top == vertical) top++;
                else top = vertical;
            }
            else if (cp > 0) down = vertical - 1;
            else return true;
            vertical = (top + down) / 2;
        }
        int[] range = matrix[vertical];
        int left = 0, right = col - 1;
        while (left <= right) {
            horizon = (left + right) / 2;
            int cp = Integer.compare(range[horizon], target);
            if (cp < 0) left = horizon + 1;
            else if (cp > 0) right = horizon - 1;
            else return true;
        }
        return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
