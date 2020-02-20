//Given an array nums of n integers where n > 1, return an array output such tha
//t output[i] is equal to the product of all the elements of nums except nums[i]. 
//
//
// Example: 
//
// 
//Input:  [1,2,3,4]
//Output: [24,12,8,6]
// 
//
// Note: Please solve it without division and in O(n). 
//
// Follow up: 
//Could you solve it with constant space complexity? (The output array does not 
//count as extra space for the purpose of space complexity analysis.) 
// Related Topics Array


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] productExceptSelf(int[] nums) {
        int len = nums.length;
        int[] L = new int[len];
        int[] R = new int[len];

        L[0] = 1;
        for (int i = 1; i < len; i++) L[i] = nums[i - 1] * L[i - 1];

        R[len-1] = 1;
        for (int i = len - 2; i >= 0; i--) R[i] = nums[i + 1] * R[i + 1];

        for (int i = 0; i < len; i++) L[i] *= R[i];
        return L;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
