/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = new ListNode();
        ListNode head = result;
        while (l1 != null || l2 != null) {
            if (l1 != null && l2 != null) {
                result.next = new ListNode(l1.val + l2.val);
                l1 = l1.next;
                l2 = l2.next;
            } else if (l1 != null) {
                result.next = new ListNode(l1.val);
                l1 = l1.next;
            } else {
                result.next = new ListNode(l2.val);
                l2 = l2.next;
            }
            result = result.next;
        }
        
        ListNode ptr = head;
        int carry = 0;
        
        while (ptr != null) {
            if (carry > 0) {
                int total = ptr.val + carry;
                ptr.val += carry;
                carry = total - ptr.val;
            }
            
            if (ptr.val > 9) {
                carry += ptr.val / 10;
                ptr.val %= 10;
            }
            
            if (ptr.next == null && carry > 0) {
                ptr.next = new ListNode(carry - 1);
            }
            
            ptr = ptr.next;
        }
        
        return head.next;
    }
}
