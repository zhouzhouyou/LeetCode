//Given the root node of a binary search tree, return the sum of values of all n
//odes with value between L and R (inclusive). 
//
// The binary search tree is guaranteed to have unique values. 
//
// 
//
// 
// Example 1: 
//
// 
//Input: root = [10,5,15,3,7,null,18], L = 7, R = 15
//Output: 32
// 
//
// 
// Example 2: 
//
// 
//Input: root = [10,5,15,3,7,13,18,1,null,6], L = 6, R = 10
//Output: 23
// 
//
// 
//
// Note: 
//
// 
// The number of nodes in the tree is at most 10000. 
// The final answer is guaranteed to be less than 2^31. 
// 
// 
// Related Topics Tree Recursion


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
    int L, R;
    int sum = 0;

    public int rangeSumBST(TreeNode root, int L, int R) {
        this.L = L;
        this.R = R;
        rangeSum(root);
        return sum;
    }

    private void rangeSum(TreeNode root) {
        if (root == null) return;
        if (root.val < L) {
            rangeSum(root.right);
        } else if (root.val > R) {
            rangeSum(root.left);
        } else {
            sum += root.val;
            rangeSum(root.right);
            rangeSum(root.left);
        }
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
