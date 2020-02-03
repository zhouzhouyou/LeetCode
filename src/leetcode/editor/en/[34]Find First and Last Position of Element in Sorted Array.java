//Given an array of integers nums sorted in ascending order, find the starting a
//nd ending position of a given target value. 
//
// Your algorithm's runtime complexity must be in the order of O(log n). 
//
// If the target is not found in the array, return [-1, -1]. 
//
// Example 1: 
//
// 
//Input: nums = [5,7,7,8,8,10], target = 8
//Output: [3,4] 
//
// Example 2: 
//
// 
//Input: nums = [5,7,7,8,8,10], target = 6
//Output: [-1,-1] 
// Related Topics Array Binary Search


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] searchRange(int[] nums, int target) {
        int low = 0, hi = nums.length - 1;
        int[] no = {-1, -1};
        if (low > hi || nums[low] > target || nums[hi] < target) return no;
        while (low <= hi) {
            int mid = low + (hi - low) / 2;
            int cp = Integer.compare(nums[mid], target);
            if (cp > 0) hi = mid - 1;
            else if (cp < 0) low = mid + 1;
            else {
                no[0] = mid; no[1] = mid;
                while (no[0] > 0 && nums[no[0] - 1] == target) no[0]--;
                while (no[1] < nums.length - 1 && nums[no[1] + 1] == target) no[1]++;
                return no;
            }
        }
        return no;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
