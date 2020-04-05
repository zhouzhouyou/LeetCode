//Sort a linked list in O(n log n) time using constant space complexity. 
//
// Example 1: 
//
// 
//Input: 4->2->1->3
//Output: 1->2->3->4
// 
//
// Example 2: 
//
// 
//Input: -1->5->3->4->0
//Output: -1->0->3->4->5 
// Related Topics Linked List Sort


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
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode mid = head, p = head.next;
        while (p != null && p.next != null) {
            mid = mid.next;
            p = p.next.next;
        }

        ListNode h1 = head, h2 = mid.next;
        mid.next = null;
        h1 = sortList(h1);
        h2 = sortList(h2);

        ListNode dummy = new ListNode(-1);
        p = dummy;
        while (h1 != null && h2 != null) {
            if (h1.val < h2.val) {
                p.next = h1;
                h1 = h1.next;
            } else {
                p.next = h2;
                h2 = h2.next;
            }
            p = p.next;
        }
        p.next = h1 != null ? h1 : h2;
        return dummy.next;
    }

//    public class ListNode {
//        int val;
//        ListNode next;
//        ListNode(int x) { val = x; }
//    }
}
//leetcode submit region end(Prohibit modification and deletion)
