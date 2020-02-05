//Given two integers n and k, return all possible combinations of k numbers out 
//of 1 ... n. 
//
// Example: 
//
// 
//Input: n = 4, k = 2
//Output:
//[
//  [2,4],
//  [3,4],
//  [2,3],
//  [1,2],
//  [1,3],
//  [1,4],
//]
// 
// Related Topics Backtracking


import java.util.ArrayList;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> lists = new ArrayList<>();
        backtrack(lists, new ArrayList<>(), n, k, 1);
        return lists;
    }

    private void backtrack(List<List<Integer>> lists, List<Integer> integers, int n, int k, int start) {
        if (k == 0) {
            lists.add(new ArrayList<>(integers));
            return;
        }
        for (int i = start; i <= n - k + 1; i++) {
            integers.add(i);
            backtrack(lists, integers, n, k - 1, i + 1);
            integers.remove(integers.size() - 1);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
