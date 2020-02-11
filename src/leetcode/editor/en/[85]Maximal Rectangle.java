//Given a 2D binary matrix filled with 0's and 1's, find the largest rectangle c
//ontaining only 1's and return its area. 
//
// Example: 
//
// 
//Input:
//[
//  ["1","0","1","0","0"],
//  ["1","0","1","1","1"],
//  ["1","1","1","1","1"],
//  ["1","0","0","1","0"]
//]
//Output: 6
// 
// Related Topics Array Hash Table Dynamic Programming Stack


import java.util.Stack;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maximalRectangle(char[][] matrix) {
        int rLen = matrix.length, cLen = rLen == 0 ? 0 : matrix[0].length, max = 0;
        int[] h = new int[cLen+1];

        for (char[] chars : matrix) {
            Stack<Integer> s = new Stack<>();
            s.push(-1);
            for (int i = 0; i <= cLen; i++) {
                if (i < cLen && chars[i] == '1')
                    h[i] += 1;
                else h[i] = 0;

                while (s.peek() != -1 && h[i] < h[s.peek()]) {
                    max = Math.max(max, h[s.pop()] * (i - s.peek() - 1));
                }
                s.push(i);
            }
        }
        return max;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
