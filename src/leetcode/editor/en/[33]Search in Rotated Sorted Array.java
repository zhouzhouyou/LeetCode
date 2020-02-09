//Suppose an array sorted in ascending order is rotated at some pivot unknown to
// you beforehand. 
//
// (i.e., [0,1,2,4,5,6,7] might become [4,5,6,7,0,1,2]). 
//
// You are given a target value to search. If found in the array return its inde
//x, otherwise return -1. 
//
// You may assume no duplicate exists in the array. 
//
// Your algorithm's runtime complexity must be in the order of O(log n). 
//
// Example 1: 
//
// 
//Input: nums = [4,5,6,7,0,1,2], target = 0
//Output: 4
// 
//
// Example 2: 
//
// 
//Input: nums = [4,5,6,7,0,1,2], target = 3
//Output: -1 
// Related Topics Array Binary Search


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int search(int[] nums, int target) {
        int low = 0, high = nums.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            int cp = Integer.compare(nums[mid], target);
            if (cp == 0) return mid;
            //判断左侧有序还是右侧有序
            if (nums[mid] >= nums[low]) {
                //左侧有序的前提下，如果nums[mid] > target而且target >= nums[low]，说明target就在[low, mid)中
                //否则，如果nums[mid] < target，说明target肯定在[mid+1, high]中
                //如果nums[mid] > target，但是target < nums[low]，说明左侧过大，需要去右侧找
                if (cp > 0 && target >= nums[low]) high = mid - 1;
                else low = mid + 1;
            } else {
                if (cp < 0 && target <= nums[high]) low = mid + 1;
                else high = mid - 1;
            }
        }
        return -1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
