//Given n non-negative integers representing the histogram's bar height where th
//e width of each bar is 1, find the area of largest rectangle in the histogram. 
//
// 
//
// 
//Above is a histogram where width of each bar is 1, given height = [2,1,5,6,2,3
//]. 
//
// 
//
// 
//The largest rectangle is shown in the shaded area, which has area = 10 unit. 
//
// 
//
// Example: 
//
// 
//Input: [2,1,5,6,2,3]
//Output: 10
// 
// Related Topics Array Stack


import java.util.Stack;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        int max = 0;
        for (int i = 0; i <= heights.length; i++) {
            int cur = (i == heights.length ? 0 : heights[i]);
            if (stack.isEmpty() || cur >= heights[stack.peek()]) {
                stack.push(i);
            } else {
                int top = stack.pop();
                max = Math.max(max, heights[top] * (stack.isEmpty() ? i : i - 1 - stack.peek()));
                i--;
            }
        }
        return max;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
