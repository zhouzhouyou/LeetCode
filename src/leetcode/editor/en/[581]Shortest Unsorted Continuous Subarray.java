//Given an integer array, you need to find one continuous subarray that if you o
//nly sort this subarray in ascending order, then the whole array will be sorted i
//n ascending order, too. 
//
// You need to find the shortest such subarray and output its length. 
//
// Example 1: 
// 
//Input: [2, 6, 4, 8, 10, 9, 15]
//Output: 5
//Explanation: You need to sort [6, 4, 8, 10, 9] in ascending order to make the 
//whole array sorted in ascending order.
// 
// 
//
// Note: 
// 
// Then length of the input array is in range [1, 10,000]. 
// The input array may contain duplicates, so ascending order here means <=. 
// 
// Related Topics Array


import java.util.Arrays;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int findUnsortedSubarray(int[] nums) {
        int len = nums.length;
        int[] temp = Arrays.copyOf(nums, len);
        Arrays.sort(temp);
        int left = 0, right = len - 1;
        while (left < len && temp[left] == nums[left]) left++;
        while (right >= 0 && temp[right] == nums[right]) right--;
        if (left > right) return 0;
        return right - left + 1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
