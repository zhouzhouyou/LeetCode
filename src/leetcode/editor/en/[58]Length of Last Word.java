//Given a string s consists of upper/lower-case alphabets and empty space charac
//ters ' ', return the length of last word (last word means the last appearing wor
//d if we loop from left to right) in the string. 
//
// If the last word does not exist, return 0. 
//
// Note: A word is defined as a maximal substring consisting of non-space charac
//ters only. 
//
// Example: 
//
// 
//Input: "Hello World"
//Output: 5
// 
//
// 
// Related Topics String


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int lengthOfLastWord(String s) {
        int count = 0;
        char[] ch = s.toCharArray();
        int index = s.length() - 1;
        for(int i = s.length() - 1; i >= 0; i--) {
            if(ch[i] == ' ' && index == i) {
                index--;
            } else if(ch[i] != ' ') {
                count++;
            } else
                break;
        }
        return count;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
