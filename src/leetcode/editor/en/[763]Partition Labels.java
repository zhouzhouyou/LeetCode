//
//A string S of lowercase letters is given. We want to partition this string int
//o as many parts as possible so that each letter appears in at most one part, and
// return a list of integers representing the size of these parts.
// 
//
// Example 1: 
// 
//Input: S = "ababcbacadefegdehijhklij"
//Output: [9,7,8]
//Explanation:
//The partition is "ababcbaca", "defegde", "hijhklij".
//This is a partition so that each letter appears in at most one part.
//A partition like "ababcbacadefegde", "hijhklij" is incorrect, because it split
//s S into less parts.
// 
// 
//
// Note: 
// S will have length in range [1, 500]. 
// S will consist of lowercase letters ('a' to 'z') only. 
// Related Topics Two Pointers Greedy


import java.util.ArrayList;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<Integer> partitionLabels(String S) {
        int[] last = new int[26];
        for (int i = 0; i < S.length(); ++i)
            last[S.charAt(i) - 'a'] = i;

        int j = 0, anchor = 0;
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < S.length(); ++i) {
            //j 记录着出现过的最大值，如果当前i等于j，意味着这之前没有任何字母的范围超过了i
            j = Math.max(j, last[S.charAt(i) - 'a']);
            if (i == j) {
                ans.add(i - anchor + 1);
                anchor = i + 1;
            }
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
