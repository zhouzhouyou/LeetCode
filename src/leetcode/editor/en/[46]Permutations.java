//Given a collection of distinct integers, return all possible permutations. 
//
// Example: 
//
// 
//Input: [1,2,3]
//Output:
//[
//  [1,2,3],
//  [1,3,2],
//  [2,1,3],
//  [2,3,1],
//  [3,1,2],
//  [3,2,1]
//]
// 
// Related Topics Backtracking


import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> permute(int[] nums) {
        if (nums.length == 0) {
            return new LinkedList<>();
        }
        return backtrack(nums);
    }

    public List<List<Integer>> backtrack(int[] nums) {
        List<List<Integer>> lists = new LinkedList<>();
        if (nums.length == 1) {
            lists.add(Collections.singletonList(nums[0]));
            return lists;
        }
        for (int i = 0; i < nums.length; i++) {
            int current = nums[i];
            int[] integers = new int[nums.length - 1];
            System.arraycopy(nums, 0, integers, 0, i);
            for (int j = i + 1; j < nums.length; j++) integers[j - 1] = nums[j];
            List<List<Integer>> temp = backtrack(integers);
            for (List<Integer> list : temp) {
                List<Integer> tempList = new LinkedList<>();
                tempList.add(current);
                tempList.addAll(list);
                lists.add(tempList);
            }
        }
        return lists;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
