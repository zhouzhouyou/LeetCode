//Given two strings s and t, determine if they are isomorphic. 
//
// Two strings are isomorphic if the characters in s can be replaced to get t. 
//
// All occurrences of a character must be replaced with another character while 
//preserving the order of characters. No two characters may map to the same charac
//ter but a character may map to itself. 
//
// Example 1: 
//
// 
//Input: s = "egg", t = "add"
//Output: true
// 
//
// Example 2: 
//
// 
//Input: s = "foo", t = "bar"
//Output: false 
//
// Example 3: 
//
// 
//Input: s = "paper", t = "title"
//Output: true 
//
// Note: 
//You may assume both s and t have the same length. 
// Related Topics Hash Table


import java.util.HashMap;
import java.util.List;
import java.util.Map;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isIsomorphic(String s, String t) {
        Map<Character, Integer> sf = new HashMap<>();
        Map<Character, Integer> tf = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            sf.putIfAbsent(s.charAt(i), sf.size());
            tf.putIfAbsent(t.charAt(i), tf.size());
            if (!sf.get(s.charAt(i)).equals(tf.get(t.charAt(i)))) return false;
        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
