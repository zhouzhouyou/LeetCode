//Given an array of integers where 1 ≤ a[i] ≤ n (n = size of array), some elemen
//ts appear twice and others appear once. 
//
// Find all the elements of [1, n] inclusive that do not appear in this array. 
//
// Could you do it without extra space and in O(n) runtime? You may assume the r
//eturned list does not count as extra space. 
//
// Example:
// 
//Input:
//[4,3,2,7,8,2,3,1]
//
//Output:
//[5,6]
// 
// Related Topics Array


import java.util.LinkedList;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int val = Math.abs(nums[i]) - 1;
            if (nums[val] > 0) nums[val] = -nums[val];
        }
        List<Integer> list = new LinkedList<>();
        for (int i = 0; i < nums.length; i++) if (nums[i] > 0) list.add(i + 1);
        return list;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
