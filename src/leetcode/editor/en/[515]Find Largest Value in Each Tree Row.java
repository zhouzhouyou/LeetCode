//You need to find the largest value in each row of a binary tree. 
//
// Example: 
// 
//Input: 
//
//          1
//         / \
//        3   2
//       / \   \  
//      5   3   9 
//
//Output: [1, 3, 9]
// 
// 
// Related Topics Tree Depth-first Search Breadth-first Search


//leetcode submit region begin(Prohibit modification and deletion)

import java.util.ArrayList;
import java.util.List;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        traversal(list, root, 0);
        return list;
    }

    private void traversal(List<Integer> list, TreeNode root, int level) {
        if (root == null) return;
        if (list.size() == level) list.add(root.val);
        else list.set(level, Math.max(list.get(level), root.val));
        traversal(list, root.left, level + 1);
        traversal(list, root.right, level + 1);
    }

//    public class TreeNode {
//        int val;
//        TreeNode left;
//        TreeNode right;
//        TreeNode(int x) { val = x; }
//    }
}
//leetcode submit region end(Prohibit modification and deletion)
