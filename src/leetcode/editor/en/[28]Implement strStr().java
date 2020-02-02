//Implement strStr(). 
//
// Return the index of the first occurrence of needle in haystack, or -1 if need
//le is not part of haystack. 
//
// Example 1: 
//
// 
//Input: haystack = "hello", needle = "ll"
//Output: 2
// 
//
// Example 2: 
//
// 
//Input: haystack = "aaaaa", needle = "bba"
//Output: -1
// 
//
// Clarification: 
//
// What should we return when needle is an empty string? This is a great questio
//n to ask during an interview. 
//
// For the purpose of this problem, we will return 0 when needle is an empty str
//ing. This is consistent to C's strstr() and Java's indexOf(). 
// Related Topics Two Pointers String


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int strStr(String haystack, String needle) {
        if (needle.length() == 0) return 0;
        int[] temp = buildArray(needle);
        char[] mainC = haystack.toCharArray();
        char[] subC = needle.toCharArray();
        int tp = 0;
        int pointer = 0;
        while (pointer < haystack.length()) {
            if (mainC[pointer] == subC[tp]) {
                if (tp == needle.length() - 1) return pointer - tp;
                pointer++; tp++;
                continue;
            }
            if (tp == 0) pointer++;
            else tp = temp[tp - 1];
        }
        return -1;
    }

    public int[] buildArray(String sub) {
        int l = sub.length();
        if (l == 0) return null;
        int[] a = new int[l];
        a[0] = 0;
        if (l == 1) return a;
        char[] chars = sub.toCharArray();
        int i = 0;
        for (int j = 1; j < l; j++) {
            while (true) {
                if (chars[j] == chars[i]) {
                    a[j] = i + 1;
                    i++;
                    break;
                } else if (i == 0) {
                    a[j] = 0;
                    break;
                } else i = a[i - 1];
            }
        }
        return a;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
