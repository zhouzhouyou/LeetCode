//Merge k sorted linked lists and return it as one sorted list. Analyze and desc
//ribe its complexity. 
//
// Example: 
//
// 
//Input:
//[
//  1->4->5,
//  1->3->4,
//  2->6
//]
//Output: 1->1->2->3->4->4->5->6
// 
// Related Topics Linked List Divide and Conquer Heap


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
    public ListNode mergeKLists(ListNode[] lists) {
        int length = lists.length;
        if (length == 0) return null;
        int interval = 1;
        while (interval < length) {
            for (int i = 0; i + interval < length; i += 2 * interval) {
                lists[i] = mergeTwoList(lists[i], lists[i+interval]);
            }
            interval *= 2;
        }
        return lists[0];
    }

    public ListNode mergeTwoList(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode rear = head;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                rear.next = l1;
                rear = rear.next;
                l1 = l1.next;
            } else {
                rear.next = l2;
                rear = rear.next;
                l2 = l2.next;
            }
        }
        if (l1 == null) rear.next = l2;
        else rear.next = l1;
        return head.next;
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
