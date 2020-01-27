//Write a function to find the longest common prefix string amongst an array of 
//strings. 
//
// If there is no common prefix, return an empty string "". 
//
// Example 1: 
//
// 
//Input: ["flower","flow","flight"]
//Output: "fl"
// 
//
// Example 2: 
//
// 
//Input: ["dog","racecar","car"]
//Output: ""
//Explanation: There is no common prefix among the input strings.
// 
//
// Note: 
//
// All given inputs are in lowercase letters a-z. 
// Related Topics String


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) return "";
        String first = strs[0];
        if (strs.length == 1) return first;

        while (first.length() > 0) {
            boolean flag = false;
            for (String str : strs) {
                if (str.indexOf(first) != 0) {
                    flag = true;
                    break;
                }
            }
            if (!flag) return first;
            first = first.substring(0, first.length() - 1);
        }

        return "";
    }
}
//leetcode submit region end(Prohibit modification and deletion)
