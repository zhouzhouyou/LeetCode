//Given a column title as appear in an Excel sheet, return its corresponding col
//umn number. 
//
// For example: 
//
// 
//    A -> 1
//    B -> 2
//    C -> 3
//    ...
//    Z -> 26
//    AA -> 27
//    AB -> 28 
//    ...
// 
//
// Example 1: 
//
// 
//Input: "A"
//Output: 1
// 
//
// Example 2: 
//
// 
//Input: "AB"
//Output: 28
// 
//
// Example 3: 
//
// 
//Input: "ZY"
//Output: 701
// Related Topics Math


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int titleToNumber(String s) {
        int count = 0;
        int n = 1;
        for (int i = s.length() - 1; i >= 0; i--) {
            count += n * (s.charAt(i) - 'A' + 1);
            n *= 26;
        }
        return count;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
