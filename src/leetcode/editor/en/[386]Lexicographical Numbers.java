//Given an integer n, return 1 - n in lexicographical order. 
//
// For example, given 13, return: [1,10,11,12,13,2,3,4,5,6,7,8,9]. 
//
// Please optimize your algorithm to use less time and space. The input size may
// be as large as 5,000,000. 
//


import java.util.ArrayList;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<Integer> lexicalOrder(int n) {
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i < 10; i++) {
            dfs(i, n, list);
        }
        return list;
    }

    private void dfs(int cur, int n, List<Integer> list) {
        if (cur > n) return;
        list.add(cur);
        cur *= 10;
        for (int i = 0; i < 10; i++) {
            if (cur + i > n) return;
            dfs(cur + i, n, list);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
