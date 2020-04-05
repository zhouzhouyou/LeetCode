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

        int len = 0;
        ListNode dummy = head;
        while (dummy != null) {
            len++;
            dummy = dummy.next;
        }

        dummy = new ListNode(0);
        dummy.next = head;

        for (int i = 1; i < len; i <<= 1) {
            ListNode pre = dummy;
            ListNode cur = dummy.next;
            while (cur != null) {
                ListNode left = cur;
                ListNode right = split(left, i);
                cur = split(right, i);
                pre.next = merge(left, right);
                while (pre.next != null) {
                    pre = pre.next;
                }
            }
        }

        return dummy.next;
    }

    private ListNode split(ListNode h, int step) {
        if (h == null) return null;
        for (int i = 1; h.next != null && i < step; i++) {
            h = h.next;
        }

        ListNode right = h.next;
        h.next = null;
        return right;
    }

    private ListNode merge(ListNode h1, ListNode h2) {
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;

        while (h1 != null && h2 != null) {
            if (h1.val < h2.val) {
                cur.next = h1;
                h1 = h1.next;
            } else {
                cur.next = h2;
                h2 = h2.next;
            }
            cur = cur.next;
        }
        if (h1 != null) {
            cur.next = h1;
        } else {
            cur.next = h2;
        }
        return dummy.next;
    }

//    public class ListNode {
//        int val;
//        ListNode next;
//        ListNode(int x) { val = x; }
//    }
}
//leetcode submit region end(Prohibit modification and deletion)
