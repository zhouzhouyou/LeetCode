//Given a collection of integers that might contain duplicates, nums, return all
// possible subsets (the power set). 
//
// Note: The solution set must not contain duplicate subsets. 
//
// Example: 
//
// 
//Input: [1,2,2]
//Output:
//[
//  [2],
//  [1],
//  [1,2,2],
//  [2,2],
//  [1,2],
//  []
//]
// 
// Related Topics Array Backtracking


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> lists = new ArrayList<>();
        backtrack(lists, new ArrayList<>(), nums, 0);
        return lists;
    }

    private void backtrack(List<List<Integer>> lists, List<Integer> tempList, int[] nums, int start) {
        lists.add(new ArrayList<>(tempList));
        for (int i = start; i < nums.length; i++) {
            int current = nums[i];
            if (i > start && current == nums[i-1]) continue;
            tempList.add(current);
            backtrack(lists, tempList, nums, i + 1);
            tempList.remove(tempList.size() - 1);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
