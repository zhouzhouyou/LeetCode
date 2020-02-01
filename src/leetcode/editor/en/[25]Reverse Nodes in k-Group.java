//Given a linked list, reverse the nodes of a linked list k at a time and return
// its modified list. 
//
// k is a positive integer and is less than or equal to the length of the linked
// list. If the number of nodes is not a multiple of k then left-out nodes in the 
//end should remain as it is. 
//
// 
// 
//
// Example: 
//
// Given this linked list: 1->2->3->4->5 
//
// For k = 2, you should return: 2->1->4->3->5 
//
// For k = 3, you should return: 3->2->1->4->5 
//
// Note: 
//
// 
// Only constant extra memory is allowed. 
// You may not alter the values in the list's nodes, only nodes itself may be ch
//anged. 
// 
// Related Topics Linked List


//leetcode submit region begin(Prohibit modification and deletion)

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode fake = new ListNode(0);
        fake.next = head;
        ListNode pre = fake;
        while (true) {
            ListNode p = pre.next;
            int count = 1;
            ListNode start = p, end = p;
            for (; count < k; count++) {
                if (p == null) break;
                p = p.next;
            }
            if (count != k) break;
            if (p == null) break;
            for (int i = 1; i < k; i++) {
                ListNode temp = end.next;
                end.next = temp.next;
                temp.next = start;
                start = temp;
                pre.next = temp;
            }
            pre = end;
        }
        return fake.next;
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
