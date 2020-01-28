//Given an array nums of n integers and an integer target, find three integers i
//n nums such that the sum is closest to target. Return the sum of the three integ
//ers. You may assume that each input would have exactly one solution. 
//
// Example: 
//
// 
//Given array nums = [-1, 2, 1, -4], and target = 1.
//
//The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
// 
// Related Topics Array Two Pointers


import java.util.Arrays;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int ans = Integer.MAX_VALUE;
        int highest = nums.length - 1;
        if (highest == 2) {
            return nums[0] + nums[1] + nums[2];
        }
        for (int i = 0; i < nums.length - 2; i++) {
            int x = nums[i];
            if (i != 0 && x == nums[i-1]) continue;
            int low = i + 1, high = highest;
            while (low < high) {
                int cp = x + nums[low] + nums[high] - target;
                if (cp == 0) return target;
                else {
                    if (Math.abs(cp) < Math.abs(ans)) ans = cp;
                    if (cp < 0) {
                        while (low < high && nums[low + 1] == nums[low]) low++;
                        low++;
                    } else {
                        while (low < high && nums[high - 1] == nums[high]) high--;
                        high--;
                    }
                }
            }
        }
        return ans + target;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
