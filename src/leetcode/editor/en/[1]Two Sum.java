package leetcode.editor.en;
//Given an array of integers, return indices of the two numbers such that they
//add up to a specific target.
//
// You may assume that each input would have exactly one solution, and you may
// not use the same element twice.
//
// Example: 
//
// 
//Given nums = [2, 7, 11, 15], target = 9,
//
//Because nums[0] + nums[1] = 2 + 7 = 9,
//return [0, 1].
// 
// Related Topics Array Hash Table


import java.util.HashMap;
import java.util.Map;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        int[] out = new int[2];
        for (int i = 0; i < nums.length; i++) {
            int x = nums[i];
            int y = target - x;
            Integer l = map.get(y);
            if (l != null) {
                out[0] = l;
                out[1] = i;
                return out;
            } else {
                map.put(x, i);
            }
        }
        return null;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
