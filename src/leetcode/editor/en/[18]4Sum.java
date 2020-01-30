//Given an array nums of n integers and an integer target, are there elements a,
// b, c, and d in nums such that a + b + c + d = target? Find all unique quadruple
//ts in the array which gives the sum of target. 
//
// Note: 
//
// The solution set must not contain duplicate quadruplets. 
//
// Example: 
//
// 
//Given array nums = [1, 0, -1, 0, -2, 2], and target = 0.
//
//A solution set is:
//[
//  [-1,  0, 0, 1],
//  [-2, -1, 1, 2],
//  [-2,  0, 0, 2]
//]
// 
// Related Topics Array Hash Table Two Pointers


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        return kSum(nums, target, 0, 4);
    }

    public List<List<Integer>> kSum(int[] nums, int target, int start, int k) {
        List<List<Integer>> ans = new ArrayList<>();
        if (k == 2) {
            int left = start, right = nums.length - 1;
            while (left < right) {
                int cp = Integer.compare(nums[left] + nums[right], target);
                if (cp == 0) {
                    ans.add(Arrays.asList(nums[left], nums[right]));
                    while (left < right && nums[left + 1] == nums[left]) left++;
                    while (left < right && nums[right - 1] == nums[right]) right--;
                    left++;
                    right--;
                } else if (cp < 0) {
                    while (left < right && nums[left + 1] == nums[left]) left++;
                    left++;
                } else {
                    while (left < right && nums[right - 1] == nums[right]) right--;
                    right--;
                }
            }
            return ans;
        } else {
            List<List<Integer>> temp = new ArrayList<>();
            for (int i = start; i < nums.length - k + 1; i++) {
                int current = nums[i];
                if (i != 0 && current == nums[i-1]  && i != start) continue;
                List<List<Integer>> temp2 = kSum(nums, target - current, i + 1, k - 1);
                temp2.forEach(list -> {
                    List<Integer> temp3 = new ArrayList<>();
                    temp3.add(current);
                    temp3.addAll(list);
                    temp.add(temp3);
                });
            }
            return temp;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
