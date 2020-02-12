//Given a non-negative integer numRows, generate the first numRows of Pascal's t
//riangle. 
//
// 
//In Pascal's triangle, each number is the sum of the two numbers directly above
// it. 
//
// Example: 
//
// 
//Input: 5
//Output:
//[
//     [1],
//    [1,1],
//   [1,2,1],
//  [1,3,3,1],
// [1,4,6,4,1]
//]
// 
// Related Topics Array


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> lists = new ArrayList<>();
        if (numRows == 0) return lists;
        lists.add(Collections.singletonList(1));
        for (int i = 1; i < numRows; i++) {
            List<Integer> curLine = new ArrayList<>();
            curLine.add(1);
            List<Integer> preLine = lists.get(i - 1);
            for (int j = 1; j < i; j++) curLine.add(preLine.get(j - 1) + preLine.get(j));
            curLine.add(1);
            lists.add(curLine);
        }
        return lists;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
