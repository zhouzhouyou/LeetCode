//Given n non-negative integers representing an elevation map where the width of
// each bar is 1, compute how much water it is able to trap after raining. 
//
// 
//The above elevation map is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. In 
//this case, 6 units of rain water (blue section) are being trapped. Thanks Marcos
// for contributing this image! 
//
// Example: 
//
// 
//Input: [0,1,0,2,1,0,1,3,2,1,2,1]
//Output: 6 
// Related Topics Array Two Pointers Stack


import java.util.Stack;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int trap(int[] height) {
        int total = 0;
        int length = height.length;
        if (length < 3) return total;
        //单调栈
        Stack<Integer> stack = new Stack<>();
        int i = 0;
        while (i < length) {
            int current = height[i];
            if (stack.isEmpty() || current < height[stack.peek()]) {
                //current如果比栈顶底的话
                stack.push(i++);
            } else {
                int t = stack.peek();
                stack.pop();
                if (stack.isEmpty()) continue;
                total += (Math.min(current, height[stack.peek()]) - height[t]) * (i - stack.peek() - 1);
            }
        }
        return total;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
