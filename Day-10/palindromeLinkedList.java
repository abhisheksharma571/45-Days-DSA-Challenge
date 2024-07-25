//Given the head of a singly linked list, return true if it is a palindrome or false otherwise.

class Solution {
    private ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }
        //Find the middle of the linked list
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        //Reverse the second half of the linked list
        ListNode secondHalfStart = reverseList(slow);
        ListNode firstHalfStart = head;
        //Compare the first half and the reversed second half
        ListNode p1 = firstHalfStart;
        ListNode p2 = secondHalfStart;
        boolean palindrome = true;
        while (p2 != null) {
            if (p1.val != p2.val) {
                palindrome = false;
                break;
            }
            p1 = p1.next;
            p2 = p2.next;
        }
        return palindrome;
    }
}