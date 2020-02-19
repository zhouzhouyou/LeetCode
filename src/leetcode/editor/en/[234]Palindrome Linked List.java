//Given a singly linked list, determine if it is a palindrome. 
//
// Example 1: 
//
// 
//Input: 1->2
//Output: false 
//
// Example 2: 
//
// 
//Input: 1->2->2->1
//Output: true 
//
// Follow up: 
//Could you do it in O(n) time and O(1) space? 
// Related Topics Linked List Two Pointers


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
    public boolean isPalindrome(ListNode head) {
        ListNode walker = head, runner = head;
        while (runner != null && runner.next != null) {
            walker = walker.next;
            runner = runner.next.next;
        }
        if (runner != null) walker = walker.next;
        walker = reverse(walker);
        runner = head;
        while (walker != null) {
            if (walker.val != runner.val) return false;
            walker = walker.next;
            runner = runner.next;
        }
        return true;
    }

    private ListNode reverse(ListNode head) {
        ListNode prev = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
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
