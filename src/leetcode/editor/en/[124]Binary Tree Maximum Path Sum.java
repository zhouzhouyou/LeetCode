//Given a non-empty binary tree, find the maximum path sum. 
//
// For this problem, a path is defined as any sequence of nodes from some starti
//ng node to any node in the tree along the parent-child connections. The path mus
//t contain at least one node and does not need to go through the root. 
//
// Example 1: 
//
// 
//Input: [1,2,3]
//
//       1
//      / \
//     2   3
//
//Output: 6
// 
//
// Example 2: 
//
// 
//Input: [-10,9,20,null,null,15,7]
//
//   -10
//   / \
//  9  20
//    /  \
//   15   7
//
//Output: 42
// 
// Related Topics Tree Depth-first Search


//leetcode submit region begin(Prohibit modification and deletion)
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
    private int max = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        getMax(root);
        return max;
    }

    private int getMax(TreeNode root) {
        if (root == null) return 0;
        int left = Math.max(getMax(root.left), 0);
        int right = Math.max(getMax(root.right), 0);
        max = Math.max(left + right + root.val, max);
        return Math.max(left, right) + root.val;
    }

//    public class TreeNode {
//        int val;
//        TreeNode left;
//        TreeNode right;
//
//        TreeNode(int x) {
//            val = x;
//        }
//    }
}
//leetcode submit region end(Prohibit modification and deletion)
