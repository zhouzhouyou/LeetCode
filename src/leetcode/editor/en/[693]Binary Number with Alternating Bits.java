//Given a positive integer, check whether it has alternating bits: namely, if tw
//o adjacent bits will always have different values. 
//
// Example 1: 
// 
//Input: 5
//Output: True
//Explanation:
//The binary representation of 5 is: 101
// 
// 
//
// Example 2: 
// 
//Input: 7
//Output: False
//Explanation:
//The binary representation of 7 is: 111.
// 
// 
//
// Example 3: 
// 
//Input: 11
//Output: False
//Explanation:
//The binary representation of 11 is: 1011.
// 
// 
//
// Example 4: 
// 
//Input: 10
//Output: True
//Explanation:
//The binary representation of 10 is: 1010.
// 
// Related Topics Bit Manipulation


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean hasAlternatingBits(int n) {
        int cur = n % 2;
        n /= 2;
        while (n > 0) {
            if (cur == n % 2) return false;
            cur = n % 2;
            n /= 2;
        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
