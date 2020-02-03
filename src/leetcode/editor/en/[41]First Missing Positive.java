//Given an unsorted integer array, find the smallest missing positive integer. 
//
// Example 1: 
//
// 
//Input: [1,2,0]
//Output: 3
// 
//
// Example 2: 
//
// 
//Input: [3,4,-1,1]
//Output: 2
// 
//
// Example 3: 
//
// 
//Input: [7,8,9,11,12]
//Output: 1
// 
//
// Note: 
//
// Your algorithm should run in O(n) time and uses constant extra space. 
// Related Topics Array


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int firstMissingPositive(int[] nums) {
        if (nums == null || nums.length == 0) return 1;
        for (int i = 0; i < nums.length; i++) {
            int current = nums[i];
            while (current >= 1 && current - 1 < nums.length && current != nums[current - 1]) {
                int temp = nums[current - 1];
                nums[current - 1] = current;
                current = temp;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1) return i + 1;
        }
        return nums.length + 1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
