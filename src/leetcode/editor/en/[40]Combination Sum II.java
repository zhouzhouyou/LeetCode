//Given a collection of candidate numbers (candidates) and a target number (targ
//et), find all unique combinations in candidates where the candidate numbers sums
// to target. 
//
// Each number in candidates may only be used once in the combination. 
//
// Note: 
//
// 
// All numbers (including target) will be positive integers. 
// The solution set must not contain duplicate combinations. 
// 
//
// Example 1: 
//
// 
//Input: candidates = [10,1,2,7,6,1,5], target = 8,
//A solution set is:
//[
//  [1, 7],
//  [1, 2, 5],
//  [2, 6],
//  [1, 1, 6]
//]
// 
//
// Example 2: 
//
// 
//Input: candidates = [2,5,2,1,2], target = 5,
//A solution set is:
//[
//  [1,2,2],
//  [5]
//]
// 
// Related Topics Array Backtracking


import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> ans = new LinkedList<>();
        int hi = candidates.length - 1;
        while (hi >= 0) {
            int cp = Integer.compare(candidates[hi], target);
            if (cp > 0) hi--;
            else if (cp < 0) break;
            else {
                ans.add(Collections.singletonList(target));
                while (hi > 0 && candidates[hi - 1] == target) hi--;
                hi--;
                break;
            }
        }
        if (hi < 0) return ans;
        ans.addAll(combinationSum(candidates, target, 0, 0, hi));
        return ans;
    }

    public List<List<Integer>> combinationSum(int[] nums, int target, int start, int pre_sum, int hi) {
        List<List<Integer>> ans = new LinkedList<>();
        for (int i = start; i <= hi; i++) {
            int current = nums[i];
            if (i != start && nums[i - 1] == nums[i]) continue;
            int sum = pre_sum + current;
            if (sum > target) return ans;
            if (sum == target) {
                ans.add(Collections.singletonList(current));
                return ans;
            } else {
                List<List<Integer>> temp = combinationSum(nums, target, i + 1, sum, hi);
                for (List<Integer> list : temp) {
                    List<Integer> temp2 = new LinkedList<>();
                    temp2.add(current);
                    temp2.addAll(list);
                    ans.add(temp2);
                }
            }
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
