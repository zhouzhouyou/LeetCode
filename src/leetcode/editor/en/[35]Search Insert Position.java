//Given a sorted array and a target value, return the index if the target is fou
//nd. If not, return the index where it would be if it were inserted in order. 
//
// You may assume no duplicates in the array. 
//
// Example 1: 
//
// 
//Input: [1,3,5,6], 5
//Output: 2
// 
//
// Example 2: 
//
// 
//Input: [1,3,5,6], 2
//Output: 1
// 
//
// Example 3: 
//
// 
//Input: [1,3,5,6], 7
//Output: 4
// 
//
// Example 4: 
//
// 
//Input: [1,3,5,6], 0
//Output: 0
// 
// Related Topics Array Binary Search


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int searchInsert(int[] nums, int target) {
        int low = 0, hi = nums.length - 1;
        int mid = 0, cp = 0;
        if (low > hi) return -1;
        if (nums[low] > target) return 0;
        if (nums[hi] < target) return nums.length;
        while (low <= hi) {
            mid = low + (hi - low) / 2;
            cp = Integer.compare(nums[mid], target);
            if (cp > 0) hi = mid - 1;
            else if (cp < 0) low = mid + 1;
            else return mid;
        }
        if (cp < 0) return mid + 1;
        return mid;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
