//Given an integer n, return the number of trailing zeroes in n!. 
//
// Example 1: 
//
// 
//Input: 3
//Output: 0
//Explanation: 3! = 6, no trailing zero. 
//
// Example 2: 
//
// 
//Input: 5
//Output: 1
//Explanation: 5! = 120, one trailing zero. 
//
// Note: Your solution should be in logarithmic time complexity. 
// Related Topics Math


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int trailingZeroes(int n) {
        int a = 0;
        while (n > 4) {
            n /= 5;
            a += n;
        }
        return a;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
