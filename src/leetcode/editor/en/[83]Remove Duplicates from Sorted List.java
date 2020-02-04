//Given a sorted linked list, delete all duplicates such that each element appea
//r only once. 
//
// Example 1: 
//
// 
//Input: 1->1->2
//Output: 1->2
// 
//
// Example 2: 
//
// 
//Input: 1->1->2->3->3
//Output: 1->2->3
// 
// Related Topics Linked List


//leetcode submit region begin(Prohibit modification and deletion)

import java.util.List;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode node = head;
        while (node != null) {
            int val = node.val;
            ListNode temp = node.next;
            while (temp != null) {
                if (temp.val == val) temp = temp.next;
                else break;
            }
            node.next = temp;
            node = node.next;
        }
        return head;
    }

//    public class ListNode {
//        int val;
//        ListNode next;
//
//        ListNode(int x) {
//            val = x;
//        }
//    }
}
//leetcode submit region end(Prohibit modification and deletion)
