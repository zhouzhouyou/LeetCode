//Given a binary tree, return the sum of values of its deepest leaves.
// 
// Example 1: 
//
// 
//
// 
//Input: root = [1,2,3,4,5,null,6,7,null,null,null,null,8]
//Output: 15
// 
//
// 
// Constraints: 
//
// 
// The number of nodes in the tree is between 1 and 10^4. 
// The value of nodes is between 1 and 100. 
// Related Topics Tree Depth-first Search


//leetcode submit region begin(Prohibit modification and deletion)

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    int level = 0;
    int sum = 0;

    public int deepestLeavesSum(TreeNode root) {
        helper(root, 1);
        return sum;
    }

    private void helper(TreeNode root, int k) {
        if (root == null) return;
        if (k > level) {
            level = k;
            sum = root.val;
        } else if (k == level) sum += root.val;
        helper(root.left, k + 1);
        helper(root.right, k + 1);
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
