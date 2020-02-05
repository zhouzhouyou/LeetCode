//Given a string containing digits from 2-9 inclusive, return all possible lette
//r combinations that the number could represent. 
//
// A mapping of digit to letters (just like on the telephone buttons) is given b
//elow. Note that 1 does not map to any letters. 
//
// 
//
// Example: 
//
// 
//Input: "23"
//Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
// 
//
// Note: 
//
// Although the above answer is in lexicographical order, your answer could be i
//n any order you want. 
// Related Topics String Backtracking


import java.util.*;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> result = new LinkedList<>();
        if(digits==null || digits.length()==0) return result;
        Map<Integer,String> mapping = new HashMap<>();
        mapping.put(2,"abc");
        mapping.put(3,"def");
        mapping.put(4,"ghi");
        mapping.put(5,"jkl");
        mapping.put(6,"mno");
        mapping.put(7,"pqrs");
        mapping.put(8,"tuv");
        mapping.put(9,"wxyz");

        populateLetterCombinations(digits, mapping, new StringBuilder(),0, result);
        return result;
    }


    private void populateLetterCombinations(String digits, Map<Integer,String> mapping, StringBuilder temp, int index, List<String> result){
        if(temp.length() == digits.length()){
            //如果长度一样了，说明到了末尾，那么就把temp变为String存入
            result.add(temp.toString());
            return;
        }
        String letters = mapping.get(digits.charAt(index)-'0');
        for(int i=0;i<letters.length();i++){
            temp.append(letters.charAt(i));
            populateLetterCombinations(digits, mapping, temp, index+1, result);
            //这一步已经到了最后，于是回退一步
            temp.deleteCharAt(temp.length()-1);
        }
    }

    private void backtrack(List<String> list, StringBuilder sb, char[][] map, String digits, int start) {
        if (start == digits.length()) {
            list.add(sb.toString());
            return;
        }

        char[] chars = map[digits.charAt(start) - '2'];
        for (char x : chars) {
            sb.append(x);
            backtrack(list, sb, map, digits, start + 1);
            sb.delete(sb.length() - 1, sb.length());
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
