// You are given the heads of two sorted linked lists list1 and list2.

// Merge the two lists into one sorted list. The list should be made by splicing together the nodes of the first two lists.

// Return the head of the merged linked list.

class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode t1 = list1;
        ListNode t2 = list2;
        ListNode h = new ListNode(4);
        ListNode t = h;
        while(t1!=null && t2!=null){
            if(t1.val<t2.val){
                t.next = t1;
                t = t1;
                t1 = t1.next;
            } else {
                t.next = t2;
                t = t2;
                t2 = t2.next;
            }
        }
        if(t1==null){
            t.next = t2;
        } else {
            t.next = t1;
        }
        return h.next;
    }
}