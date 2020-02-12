//Given inorder and postorder traversal of a tree, construct the binary tree. 
//
// Note: 
//You may assume that duplicates do not exist in the tree. 
//
// For example, given 
//
// 
//inorder = [9,3,15,20,7]
//postorder = [9,15,7,20,3] 
//
// Return the following binary tree: 
//
// 
//    3
//   / \
//  9  20
//    /  \
//   15   7
// 
// Related Topics Array Tree Depth-first Search


//leetcode submit region begin(Prohibit modification and deletion)

import java.util.HashMap;
import java.util.Map;

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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) map.put(inorder[i], i);
        return buildTree(postorder, map, 0, postorder.length - 1, 0, inorder.length - 1);
    }

    private TreeNode buildTree(int[] postOrder, Map<Integer, Integer> inOrder, int postStart, int postEnd, int inStart, int inEnd) {
        if (postEnd < postStart || inEnd < inStart) return null;
        TreeNode root = new TreeNode(postOrder[postEnd]);
        int rootIndex = inOrder.get(root.val);
        int numsLeft = rootIndex - inStart;

        root.left = buildTree(postOrder, inOrder, postStart, postStart + numsLeft - 1, inStart, rootIndex - 1);
        root.right = buildTree(postOrder, inOrder, postStart + numsLeft, postEnd - 1, rootIndex + 1, inEnd);
        return root;
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
