//Given a singly linked list L: L0→L1→…→Ln-1→Ln, 
//reorder it to: L0→Ln→L1→Ln-1→L2→Ln-2→… 
//
// You may not modify the values in the list's nodes, only nodes itself may be c
//hanged. 
//
// Example 1: 
//
// 
//Given 1->2->3->4, reorder it to 1->4->2->3. 
//
// Example 2: 
//
// 
//Given 1->2->3->4->5, reorder it to 1->5->2->4->3.
// 
// Related Topics Linked List


//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
//    public class ListNode {
//        int val;
//        ListNode next;
//        ListNode(int x) { val = x; }
//    }

    public void reorderList(ListNode head) {
        if(head == null) return;
        //快慢指针找中间节点

        ListNode fast = head.next;
        ListNode slow = head;

        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        //"废物"利用，将fast重新拿回来用，用于指向被截断的后半截链表
        fast = slow.next;
        slow.next = null;

        ListNode other = helper(fast);
        ListNode fake = new ListNode(0);
        ListNode rear = fake;
        while (head != null && other != null) {
            rear.next = head;
            head = head.next;
            rear = rear.next;
            rear.next = other;
            rear = rear.next;
            other = other.next;
        }

        if (head != null) rear.next = head;

        head = fake.next;
    }

    private ListNode helper(ListNode head) {
        ListNode next = null, pre = null;
        while (head != null) {
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
