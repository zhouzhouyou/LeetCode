//Given an array of integers that is already sorted in ascending order, find two
// numbers such that they add up to a specific target number. 
//
// The function twoSum should return indices of the two numbers such that they a
//dd up to the target, where index1 must be less than index2. 
//
// Note: 
//
// 
// Your returned answers (both index1 and index2) are not zero-based. 
// You may assume that each input would have exactly one solution and you may no
//t use the same element twice. 
// 
//
// Example: 
//
// 
//Input: numbers = [2,7,11,15], target = 9
//Output: [1,2]
//Explanation: The sum of 2 and 7 is 9. Therefore index1 = 1, index2 = 2. 
// Related Topics Array Two Pointers Binary Search


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int left = 0, right = numbers.length - 1;
        int[] ans = new int[2];
        while (left < right) {
            int cp = Integer.compare(numbers[left] + numbers[right], target);
            if (cp > 0) right--;
            else if (cp < 0) left++;
            else {
                ans[0] = left + 1;
                ans[1] = right + 1;
                break;
            }
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
