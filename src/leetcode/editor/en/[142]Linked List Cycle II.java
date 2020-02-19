//Given a linked list, return the node where the cycle begins. If there is no cy
//cle, return null. 
//
// To represent a cycle in the given linked list, we use an integer pos which re
//presents the position (0-indexed) in the linked list where tail connects to. If 
//pos is -1, then there is no cycle in the linked list. 
//
// Note: Do not modify the linked list. 
//
// 
//
// Example 1: 
//
// 
//Input: head = [3,2,0,-4], pos = 1
//Output: tail connects to node index 1
//Explanation: There is a cycle in the linked list, where tail connects to the s
//econd node.
// 
//
// 
//
// Example 2: 
//
// 
//Input: head = [1,2], pos = 0
//Output: tail connects to node index 0
//Explanation: There is a cycle in the linked list, where tail connects to the f
//irst node.
// 
//
// 
//
// Example 3: 
//
// 
//Input: head = [1], pos = -1
//Output: no cycle
//Explanation: There is no cycle in the linked list.
// 
//
// 
//
// 
//
// Follow-up: 
//Can you solve it without using extra space? 
// Related Topics Linked List Two Pointers


//leetcode submit region begin(Prohibit modification and deletion)

/**
 * Definition for singly-linked list.
 * class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) {
 * val = x;
 * next = null;
 * }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        /*
         * 我们假设整个圈的周长为C。在Walker和Runner相遇时，Walker走了K，Runner走了2K.
         * 其中Walker走的K包括head到圈圈起点的距离A，和进入圈圈后前进了的距离B。
         * 所有 A + B = K，同时 A + B + (C - B) + B = 2K，所以 C=K=A+B
         * 此时我们让起点再出发一个Walker，让新Walker和旧Walker同时前进。
         * 在前进了A后，旧Walker也会到达圈圈起点。因为旧Walker已经前进B，又C=A+B
         */
        ListNode walker = head;
        ListNode runner = walker;
        while (runner != null && runner.next != null) {
            walker = walker.next;
            runner = runner.next.next;
            if (walker == runner) {
                ListNode walker2 = head;
                while (walker != walker2) {
                    walker = walker.next;
                    walker2 = walker2.next;
                }
                return walker;
            }
        }
        return null;
    }

//    class ListNode {
//        int val;
//        ListNode next;
//
//        ListNode(int x) {
//            val = x;
//            next = null;
//        }
//    }
}
//leetcode submit region end(Prohibit modification and deletion)
