//Given an integer array nums, find the contiguous subarray within an array (con
//taining at least one number) which has the largest product. 
//
// Example 1: 
//
// 
//Input: [2,3,-2,4]
//Output: 6
//Explanation: [2,3] has the largest product 6.
// 
//
// Example 2: 
//
// 
//Input: [-2,0,-1]
//Output: 0
//Explanation: The result cannot be 2, because [-2,-1] is not a subarray. 
// Related Topics Array Dynamic Programming


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxProduct(int[] nums) {
        int len = nums.length;
        int max = nums[0];
        int[] maxDP = new int[len];
        maxDP[0] = max;
        int[] minDP = new int[len];
        minDP[0] = max;
        for (int i = 1; i < len; i++) {
            int cur = nums[i];
            if (cur >= 0) {
                maxDP[i] = Math.max(maxDP[i-1] * cur, cur);
                minDP[i] = Math.min(minDP[i-1] * cur, cur);
            } else {
                maxDP[i] = Math.max(minDP[i-1] * cur, cur);
                minDP[i] = Math.min(maxDP[i-1] * cur, cur);
            }
            max = Math.max(max, maxDP[i]);
        }
        return max;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
