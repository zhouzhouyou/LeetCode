//Given a string s, find the longest palindromic substring in s. You may assume 
//that the maximum length of s is 1000. 
//
// Example 1: 
//
// 
//Input: "babad"
//Output: "bab"
//Note: "aba" is also a valid answer.
// 
//
// Example 2: 
//
// 
//Input: "cbbd"
//Output: "bb"
// 
// Related Topics String Dynamic Programming


import java.util.Arrays;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();
        int idx = 0, maxLen = 0;
        StringBuffer sb = new StringBuffer();
        sb.append('^');
        for (int i = 0; i < n; ++i) {
            sb.append('#');
            sb.append(s.charAt(i));
        }
        sb.append("#$");
        n = 2 * n + 3;
        int right = 0, id_center = 0;
        //记录了最右侧到达了哪里，和原点位置
        int[] p = new int[n];
        Arrays.fill(p,0);
        for (int i = 1; i < n - 1; ++i) {
            p[i] = (right > i) ? Math.min(p[2 * id_center - i], right - i) : 0;
            //如果当前访问i超过了记录范围，那么就从0开始。
            //否则，选取i关于center的对称点,有i+x=2*center，或者right-i(对称点的最左端比center最左端小的情况)
            while (sb.charAt(i + 1 + p[i]) == sb.charAt(i - 1 - p[i])) ++p[i];
            if (i + p[i] > right) {
                //如果刷新了右端的话
                id_center = i; right = i + p[i];
            }
            if (p[i] > maxLen) {
                //如果刷新了最大值
                idx = i; maxLen = p[i];
            }
        }
        //左端
        idx = (idx - maxLen - 1) / 2;
        return s.substring(idx, idx + maxLen);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
