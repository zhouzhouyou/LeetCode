//Return the root node of a binary search tree that matches the given preorder t
//raversal. 
//
// (Recall that a binary search tree is a binary tree where for every node, any 
//descendant of node.left has a value < node.val, and any descendant of node.right
// has a value > node.val. Also recall that a preorder traversal displays the valu
//e of the node first, then traverses node.left, then traverses node.right.) 
//
// 
//
// Example 1: 
//
// 
//Input: [8,5,1,7,10,12]
//Output: [8,5,10,1,7,null,12]
//
// 
//
// 
//
// Note: 
//
// 
// 1 <= preorder.length <= 100 
// The values of preorder are distinct. 
// 
// Related Topics Tree


//leetcode submit region begin(Prohibit modification and deletion)

import java.util.Arrays;

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
    public TreeNode bstFromPreorder(int[] preorder) {
        return helper(preorder, 0, preorder.length - 1);
    }

    private TreeNode helper(int[] order, int start, int end) {
        if (start >= order.length || end >= order.length || end < start) return null;
        if (start == end) return new TreeNode(order[start]);
        TreeNode root = new TreeNode(order[start]);
        Integer flag = null;
        for (int i = start + 1; i <= end; i++) {
            if (order[i] > order[start]) {
                flag = i;
                break;
            }
        }
        if (flag != null) {
            root.left = helper(order, start + 1, flag - 1);
            root.right = helper(order, flag, end);
        } else root.left = helper(order, start + 1, end);
        return root;
    }

//    public class TreeNode {
//        int val;
//        TreeNode left;
//        TreeNode right;
//        TreeNode(int x) { val = x; }
//    }
}
//leetcode submit region end(Prohibit modification and deletion)
