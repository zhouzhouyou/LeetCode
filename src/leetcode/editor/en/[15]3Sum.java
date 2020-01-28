//Given an array nums of n integers, are there elements a, b, c in nums such tha
//t a + b + c = 0? Find all unique triplets in the array which gives the sum of ze
//ro. 
//
// Note: 
//
// The solution set must not contain duplicate triplets. 
//
// Example: 
//
// 
//Given array nums = [-1, 0, 1, 2, -1, -4],
//
//A solution set is:
//[
//  [-1, 0, 1],
//  [-1, -1, 2]
//]
// Related Topics Array Two Pointers


import java.util.*;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> lists = new ArrayList<>();
        int highest = nums.length - 1;
        for (int i = 0; i < nums.length - 2; i++) {
            int left = nums[i];
            if (i != 0 && left == nums[i-1]) continue;
            int low = i + 1, high = highest, sum = - left;
            while (low < high) {
                int cp = Integer.compare(nums[low] + nums[high], sum);
                if (cp == 0) {
                    lists.add(Arrays.asList(left, nums[low], nums[high]));
                    while (low < high && nums[low + 1] == nums[low]) low++;
                    while (low < high && nums[high - 1] == nums[high]) high--;
                    low++;
                    high--;
                } else if (cp < 0) {
                    while (low < high && nums[low + 1] == nums[low]) low++;
                    low++;
                } else {
                    while (low < high && nums[high - 1] == nums[high]) high--;
                    high--;
                }
            }
        }
        return lists;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
