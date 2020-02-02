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


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String longestPalindrome(String s) {
        StringBuilder builder = new StringBuilder("~|");
        for (char x : s.toCharArray()) {
            builder.append(x).append('|');
        }
        String str = builder.toString();
        int[] array = new int[str.length()];
        int max = 0;
        for (int i = 0; i < str.length(); i++) {
            array[i] = getLength(str, i);
        }
        for (int i = 0; i < str.length(); i++) {
            if (array[i] > array[max]) max = i;
        }
        int left = (max - array[max]) / 2;
        int right = left + array[max] - 1;
        return s.substring(left, right);
    }

    public int getLength(String s, int l) {
        int length = s.length();
        int ans = 1;
        if (l == 0 || l == length - 1) return 1;
        int i = l - 1, j = l + 1;
        while (i >= 0 && j < length) {
            if (s.charAt(i--) != s.charAt(j++)) break;
            ans++;
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
