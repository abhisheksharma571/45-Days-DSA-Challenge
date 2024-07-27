// You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order, and each of their nodes contains a single digit. Add the two numbers and return the sum as a linked list.

// You may assume the two numbers do not contain any leading zero, except the number 0 itself.


class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = new ListNode();
        ListNode head = result;
        int carry = 0;
        while (l1 != null || l2 != null) {
            int x = (l1 != null) ? l1.val : 0;
            int y = (l2 != null) ? l2.val : 0;
            int sum = x + y + carry; 

            carry = sum / 10; 
            result.next = new ListNode(sum % 10); 

            result = result.next; 
            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next; 
        }
        if (carry > 0) {
            result.next = new ListNode(carry); // Add remaining carry as a new node
        }
        return head.next;
    }
}