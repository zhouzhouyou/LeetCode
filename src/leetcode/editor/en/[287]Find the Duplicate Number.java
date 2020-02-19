//Given an array nums containing n + 1 integers where each integer is between 1 
//and n (inclusive), prove that at least one duplicate number must exist. Assume t
//hat there is only one duplicate number, find the duplicate one. 
//
// Example 1: 
//
// 
//Input: [1,3,4,2,2]
//Output: 2
// 
//
// Example 2: 
//
// 
//Input: [3,1,3,4,2]
//Output: 3 
//
// Note: 
//
// 
// You must not modify the array (assume the array is read only). 
// You must use only constant, O(1) extra space. 
// Your runtime complexity should be less than O(n2). 
// There is only one duplicate number in the array, but it could be repeated mor
//e than once. 
// 
// Related Topics Array Two Pointers Binary Search


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int findDuplicate(int[] nums) {
        int walker = nums[0];
        int runner = nums[0];
        do {
            walker = nums[walker];
            runner = nums[nums[runner]];
        } while (walker != runner);

        runner = nums[0];
        while (runner != walker) {
            runner = nums[runner];
            walker = nums[walker];
        }
        return runner;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
