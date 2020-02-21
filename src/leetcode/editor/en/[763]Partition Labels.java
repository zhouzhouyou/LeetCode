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
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<Integer> partitionLabels(String S) {
        List<int[]> base = new ArrayList<>();
        for (int i = 0; i < 26; i++) {
            String x = String.valueOf((char) ('a' + i));
            if (!S.contains(x)) continue;
            int first = S.indexOf(x), last = S.lastIndexOf(x);
            base.add(new int[]{first, last});
        }
        base.sort(Comparator.comparingInt(o -> o[0]));
        LinkedList<int[]> list = new LinkedList<>();
        base.forEach(array -> {
            if (list.isEmpty() || list.getLast()[1] < array[0]) list.addLast(array);
            else {
                list.getLast()[1] = Math.max(list.getLast()[1], array[1]);
            }
        });
        List<Integer> ans = new LinkedList<>();
        list.forEach(array -> ans.add(array[1] - array[0] + 1));
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
