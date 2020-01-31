//Merge two sorted linked lists and return it as a new list. The new list should
// be made by splicing together the nodes of the first two lists. 
//
// Example:
// 
//Input: 1->2->4, 1->3->4
//Output: 1->1->2->3->4->4
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
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
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


}

//class ListNode {
//    int val;
//    ListNode next;
//
//    ListNode(int x) {
//        val = x;
//    }
//}
//leetcode submit region end(Prohibit modification and deletion)
