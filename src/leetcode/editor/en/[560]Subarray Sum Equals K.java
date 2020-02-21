//Given an array of integers and an integer k, you need to find the total number
// of continuous subarrays whose sum equals to k. 
//
// Example 1: 
// 
//Input:nums = [1,1,1], k = 2
//Output: 2
// 
// 
//
// Note: 
// 
// The length of the array is in range [1, 20,000]. 
// The range of numbers in the array is [-1000, 1000] and the range of the integ
//er k is [-1e7, 1e7]. 
// 
// 
// Related Topics Array Hash Table


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int subarraySum(int[] nums, int k) {
        int count = 0;
        for (int start = 0; start < nums.length; start++) {
            int sum = 0;
            for (int end = start; end < nums.length; end++) {
                sum += nums[end];
                if (sum == k) count++;
            }
        }
        return count;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
