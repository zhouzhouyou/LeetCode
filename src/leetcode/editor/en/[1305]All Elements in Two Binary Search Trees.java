//Given two binary search trees root1 and root2. 
//
// Return a list containing all the integers from both trees sorted in ascending
// order. 
//
// 
// Example 1: 
//
// 
//Input: root1 = [2,1,4], root2 = [1,0,3]
//Output: [0,1,1,2,3,4]
// 
//
// Example 2: 
//
// 
//Input: root1 = [0,-10,10], root2 = [5,1,7,0,2]
//Output: [-10,0,0,1,2,5,7,10]
// 
//
// Example 3: 
//
// 
//Input: root1 = [], root2 = [5,1,7,0,2]
//Output: [0,1,2,5,7]
// 
//
// Example 4: 
//
// 
//Input: root1 = [0,-10,10], root2 = []
//Output: [-10,0,10]
// 
//
// Example 5: 
//
// 
//Input: root1 = [1,null,8], root2 = [8,1]
//Output: [1,1,8,8]
// 
//
// 
// Constraints: 
//
// 
// Each tree has at most 5000 nodes. 
// Each node's value is between [-10^5, 10^5]. 
// 
// Related Topics Sort Tree


//leetcode submit region begin(Prohibit modification and deletion)

import java.util.ArrayList;
import java.util.Collections;
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
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        LinkedList<Integer> list1 = new LinkedList<>();
        LinkedList<Integer> list2 = new LinkedList<>();
        traversal(list1, root1);
        traversal(list2, root2);
        List<Integer> list = new LinkedList<>();
        while (!list1.isEmpty() && !list2.isEmpty()) {
            if (list1.getFirst() < list2.getFirst()) {
                list.add(list1.removeFirst());
            } else list.add(list2.removeFirst());
        }
        if (list1.isEmpty()) list.addAll(list2);
        else list.addAll(list1);
        return list;
    }

    private void traversal(List<Integer> list, TreeNode root) {
        if (root == null) return;
        traversal(list, root.left);
        list.add(root.val);
        traversal(list, root.right);
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
