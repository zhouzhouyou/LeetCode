//Given a positive integer, return its corresponding column title as appear in a
//n Excel sheet. 
//
// For example: 
//
// 
//    1 -> A
//    2 -> B
//    3 -> C
//    ...
//    26 -> Z
//    27 -> AA
//    28 -> AB 
//    ...
// 
//
// Example 1: 
//
// 
//Input: 1
//Output: "A"
// 
//
// Example 2: 
//
// 
//Input: 28
//Output: "AB"
// 
//
// Example 3: 
//
// 
//Input: 701
//Output: "ZY"
// Related Topics Math


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String convertToTitle(int n) {
        StringBuilder sb = new StringBuilder();
        while (n > 0) {
            int i = n % 26;
            if (i != 0) {
                sb.insert(0, (char) ('A' + i - 1));
                n /= 26;
            }
            else {
                sb.insert(0, 'Z');
                n /= 26;
                n--;
            }
        }
        return sb.toString();
    }
}
//leetcode submit region end(Prohibit modification and deletion)
