//Given a collection of numbers that might contain duplicates, return all possib
//le unique permutations. 
//
// Example: 
//
// 
//Input: [1,1,2]
//Output:
//[
//  [1,1,2],
//  [1,2,1],
//  [2,1,1]
//]
// 
// Related Topics Backtracking


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> lists = new ArrayList<>();
        backtrack(lists, new ArrayList<>(), nums, new boolean[nums.length]);
        return lists;
    }

    private void backtrack(List<List<Integer>> lists, List<Integer> integers, int[] nums, boolean[] used) {
        if (integers.size() == nums.length) {
            lists.add(new ArrayList<>(integers));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            int current = nums[i];
            if (used[i] || i > 0 && nums[i - 1] == current && !used[i - 1]) continue;
            used[i] = true;
            integers.add(current);
            backtrack(lists, integers, nums, used);
            used[i] = false;
            integers.remove(integers.size() - 1);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
