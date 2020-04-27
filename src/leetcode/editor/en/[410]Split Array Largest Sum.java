//Given an array which consists of non-negative integers and an integer m, you c
//an split the array into m non-empty continuous subarrays. Write an algorithm to 
//minimize the largest sum among these m subarrays.
// 
//
// Note: 
//If n is the length of array, assume the following constraints are satisfied:
// 
// 1 ≤ n ≤ 1000 
// 1 ≤ m ≤ min(50, n) 
// 
// 
//
// Examples: 
// 
//Input:
//nums = [7,2,5,10,8]
//m = 2
//
//Output:
//18
//
//Explanation:
//There are four ways to split nums into two subarrays.
//The best way is to split it into [7,2,5] and [10,8],
//where the largest sum among the two subarrays is only 18.
// 
// Related Topics Binary Search Dynamic Programming


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int splitArray(int[] nums, int m) {
        int left = Integer.MIN_VALUE, right = 0;
        for (int x : nums) {
            right += x;
            left = Math.max(left, x);
        }
        while (left < right) {
            int mid = left + (right - left) / 2;
            int need = 1, cur = 0;
            for (int x : nums) {
                if (cur + x > mid) {
                    need++;
                    cur = 0;
                }
                cur += x;
            }
            if (need > m) left = mid + 1;
            else right = mid;
        }
        return left;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
