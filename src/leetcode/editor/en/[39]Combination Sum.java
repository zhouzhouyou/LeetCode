//Given a set of candidate numbers (candidates) (without duplicates) and a targe
//t number (target), find all unique combinations in candidates where the candidat
//e numbers sums to target. 
//
// The same repeated number may be chosen from candidates unlimited number of ti
//mes. 
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
//Input: candidates = [2,3,6,7], target = 7,
//A solution set is:
//[
//  [7],
//  [2,2,3]
//]
// 
//
// Example 2: 
//
// 
//Input: candidates = [2,3,5], target = 8,
//A solution set is:
//[
//  [2,2,2,2],
//  [2,3,3],
//  [3,5]
//]
// 
// Related Topics Array Backtracking


import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> ans = new LinkedList<>();
        int hi = candidates.length - 1;
        while (hi >= 0) {
            int cp = Integer.compare(candidates[hi], target);
            if (cp > 0) hi--;
            else if (cp < 0) break;
            else {
                ans.add(Collections.singletonList(target));
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
            int sum = pre_sum + current;
            if (sum > target) return ans;
            if (sum == target) {
                ans.add(Collections.singletonList(current));
                return ans;
            } else {
                List<List<Integer>> temp = combinationSum(nums, target, i, sum, hi);
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
