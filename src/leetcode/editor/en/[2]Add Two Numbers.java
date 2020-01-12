package leetcode.editor.en;
//You are given two non-empty linked lists representing two non-negative integer
//s. The digits are stored in reverse order and each of their nodes contain a sing
//le digit. Add the two numbers and return it as a linked list. 
//
// You may assume the two numbers do not contain any leading zero, except the
// number 0 itself.
//
// Example: 
//
// 
//Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
//Output: 7 -> 0 -> 8
//Explanation: 342 + 465 = 807.
// 
// Related Topics Linked List Math


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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode out = new ListNode(0);
        ListNode p = out;

        while (l1 != null && l2 != null) {
            p.next = new ListNode(l1.val + l2.val);
            l1 = l1.next;
            l2 = l2.next;
            p = p.next;
        }

        if (l1 == null) {
            p.next = l2;
        } else {
            p.next = l1;
        }

        p = out;
        while (p != null) {
            if (p.val >= 10) {
                p.val = p.val - 10;
                if (p.next == null) {
                    p.next = new ListNode(1);
                } else {
                    p.next.val += 1;
                }
            }
            p = p.next;
        }
        return out.next;
    }

//    private class ListNode {
//        int val;
//        ListNode next;
//
//        ListNode(int x) {
//            val = x;
//        }
//    }
}
//leetcode submit region end(Prohibit modification and deletion)
