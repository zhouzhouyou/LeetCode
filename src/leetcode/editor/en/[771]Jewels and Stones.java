//You're given strings J representing the types of stones that are jewels, and S
// representing the stones you have. Each character in S is a type of stone you ha
//ve. You want to know how many of the stones you have are also jewels. 
//
// The letters in J are guaranteed distinct, and all characters in J and S are l
//etters. Letters are case sensitive, so "a" is considered a different type of sto
//ne from "A". 
//
// Example 1: 
//
// 
//Input: J = "aA", S = "aAAbbbb"
//Output: 3
// 
//
// Example 2: 
//
// 
//Input: J = "z", S = "ZZ"
//Output: 0
// 
//
// Note: 
//
// 
// S and J will consist of letters and have length at most 50. 
// The characters in J are distinct. 
// 
// Related Topics Hash Table


import java.util.HashMap;
import java.util.Map;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int numJewelsInStones(String J, String S) {
        int count = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < J.length(); i++) map.put(J.charAt(i), 0);
        for (int i = 0; i < S.length(); i++) if (map.containsKey(S.charAt(i))) count++;
        return count;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
