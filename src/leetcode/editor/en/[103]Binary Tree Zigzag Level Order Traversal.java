//Given a binary tree, return the zigzag level order traversal of its nodes' val
//ues. (ie, from left to right, then right to left for the next level and alternat
//e between). 
//
// 
//For example: 
//Given binary tree [3,9,20,null,null,15,7], 
// 
//    3
//   / \
//  9  20
//    /  \
//   15   7
// 
// 
// 
//return its zigzag level order traversal as: 
// 
//[
//  [3],
//  [20,9],
//  [15,7]
//]
// 
// Related Topics Stack Tree Breadth-first Search


//leetcode submit region begin(Prohibit modification and deletion)

import java.util.LinkedList;
import java.util.List;

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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        LinkedList<LinkedList<Integer>> lists = new LinkedList<>();
        traversal(lists, root, 1);
        return new LinkedList<>(lists);
    }

    private void traversal(LinkedList<LinkedList<Integer>> lists, TreeNode root, int k) {
        if (root == null) return;
        if (lists.size() < k) lists.addLast(new LinkedList<>());
        if (k % 2 == 0) lists.get(k - 1).addFirst(root.val);
        else lists.get(k - 1).addLast(root.val);
        traversal(lists, root.left, k + 1);
        traversal(lists, root.right, k + 1);

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
