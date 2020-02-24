//We run a preorder depth first search on the root of a binary tree. 
//
// At each node in this traversal, we output D dashes (where D is the depth of t
//his node), then we output the value of this node. (If the depth of a node is D, 
//the depth of its immediate child is D+1. The depth of the root node is 0.) 
//
// If a node has only one child, that child is guaranteed to be the left child. 
//
//
// Given the output S of this traversal, recover the tree and return its root. 
//
// 
//
// Example 1: 
//
// 
//
// 
//Input: "1-2--3--4-5--6--7"
//Output: [1,2,5,3,4,6,7]
// 
//
// 
// Example 2: 
//
// 
//
// 
//Input: "1-2--3---4-5--6---7"
//Output: [1,2,5,3,null,6,null,4,null,7] 
// 
//
// 
// 
//
// 
// Example 3: 
//
// 
//
// 
//Input: "1-401--349---90--88"
//Output: [1,401,null,349,88,90]
// 
// 
//
// 
//
// Note: 
//
// 
// The number of nodes in the original tree is between 1 and 1000. 
// Each node will have a value between 1 and 10^9. 
// 
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
    private int nodeStart = 0;
    private int current = 0;

    public TreeNode recoverFromPreorder(String S) {
        if (S == null || S.length() == 0) return null;
        return recover(S);
    }

    private TreeNode recover(String s) {
        int nodeEnd = nodeStart;
        while (nodeEnd < s.length() && s.charAt(nodeEnd) != '-') nodeEnd++;
        TreeNode root = new TreeNode(Integer.parseInt(s.substring(nodeStart, nodeEnd)));
        if (nodeEnd == s.length()) {
            current = 0;
            return root;
        }
        int temp = 0;
        while (s.charAt(nodeEnd) == '-') {
            temp++;
            nodeEnd++;
        }
        nodeStart = nodeEnd;
        int cp = Integer.compare(temp, current);
        current = temp;
        if (cp > 0) {
            root.left = recover(s);
            if (current == temp)
                root.right = recover(s);
        }
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
