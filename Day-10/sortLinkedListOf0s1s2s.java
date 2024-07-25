//Given a linked list of 0s, 1s and 2s, The task is to sort the linked list.
class Solution{

void ListNode sortList(ListNode head) {
        int count[] = {0, 0, 0}; 
        ListNode current = head;
        while (current != null) {
            count[current.val]++;
            current = current.next;
        }
        int i = 0;
        current = head;
        while (current != null) {
            if (count[i] == 0) i++;
            else {
                current.val = i;
               --count[i];
               current = current.next;
            }
        }
        return head;
    }                       
}