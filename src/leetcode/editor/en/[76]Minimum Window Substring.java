//Given a string S and a string T, find the minimum window in S which will conta
//in all the characters in T in complexity O(n). 
//
// Example: 
//
// 
//Input: S = "ADOBECODEBANC", T = "ABC"
//Output: "BANC"
// 
//
// Note: 
//
// 
// If there is no such window in S that covers all characters in T, return the e
//mpty string "". 
// If there is such window, you are guaranteed that there will always be only on
//e unique minimum window in S. 
// 
// Related Topics Hash Table Two Pointers String Sliding Window


import java.util.HashMap;
import java.util.Map;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String minWindow(String s, String t) {
        if (s.length() == 0 || t.length() == 0) return "";
        Map<Character, Integer> dict = new HashMap<>();
        for (char x : t.toCharArray()) dict.put(x, dict.getOrDefault(x, 0) + 1);
        int[] flags = {Integer.MAX_VALUE, 0, 0};
        int left = 0, right = 0;

        Map<Character, Integer> window = new HashMap<>(dict);

        while (right <= s.length() && left <= right) {
            boolean flag = true;
            for (char target : dict.keySet()) {
                if (window.get(target) > 0) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                if (right - left < flags[0]) {
                    flags[0] = right - left + 1;
                    flags[1] = left; flags[2] = right;
                }
                char remove = s.charAt(left++);
                window.put(remove, window.get(remove) + 1);
            } else {
                if (right < s.length()) {
                    char x = s.charAt(right++);
                    window.put(x, window.getOrDefault(x, 0) - 1);
                }
                else break;
            }
        }
        return flags[0] == -1 ? "" : s.substring(flags[1], flags[2]);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
