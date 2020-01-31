//
//Given n pairs of parentheses, write a function to generate all combinations of
// well-formed parentheses.
// 
//
// 
//For example, given n = 3, a solution set is:
// 
// 
//[
//  "((()))",
//  "(()())",
//  "(())()",
//  "()(())",
//  "()()()"
//]
// Related Topics String Backtracking


import java.util.ArrayList;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
        generateParenthesis(list, "", 0, 0, n);
        return list;
    }

    public void generateParenthesis(List<String> list, String s, int open, int close, int n) {
        if (close == n) {
            list.add(s);
            return;
        }
        if (open < n) generateParenthesis(list, s + "(", open + 1, close, n);
        if (close < open) generateParenthesis(list, s + ")", open, close + 1, n);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
