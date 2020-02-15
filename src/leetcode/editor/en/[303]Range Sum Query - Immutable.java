//Given an integer array nums, find the sum of the elements between indices i an
//d j (i ≤ j), inclusive. 
//
// Example: 
// 
//Given nums = [-2, 0, 3, -5, 2, -1]
//
//sumRange(0, 2) -> 1
//sumRange(2, 5) -> -1
//sumRange(0, 5) -> -3
// 
// 
//
// Note: 
// 
// You may assume that the array does not change. 
// There are many calls to sumRange function. 
// 
// Related Topics Dynamic Programming


//leetcode submit region begin(Prohibit modification and deletion)
class NumArray {
    int[] dp;

    public NumArray(int[] nums) {
        for (int i = 1; i < nums.length; i++) nums[i] += nums[i - 1];
        dp = nums;
    }
    
    public int sumRange(int i, int j) {
        if (i == 0) return dp[j];
        return dp[j] - dp[i - 1];
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(i,j);
 */
//leetcode submit region end(Prohibit modification and deletion)
