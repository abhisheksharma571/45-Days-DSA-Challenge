// Given head which is a reference node to a singly-linked list. The value of each node in the linked list is either 0 or 1. The linked list holds the binary representation of a number.

// Return the decimal value of the number in the linked list.

// The most significant bit is at the head of the linked list.

class Solution {
    public int getDecimalValue(ListNode head) {
        int decimalValue = 0;
        ListNode current = head;
        while (current != null) {
            // Left shift the current decimal value and add the current node's value
            decimalValue = (decimalValue << 1) | current.val;
            current = current.next;
        }
        return decimalValue;
    }
}