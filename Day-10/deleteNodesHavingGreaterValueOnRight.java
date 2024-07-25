//Given a singly linked list, remove all the nodes in the list which have any node on their right whose value is greater. (Not just immediate Right , but entire List on the Right)

class Solution {
    public static Node reverseList(Node head) {
        Node prev = null;
        Node curr = head;
        while (curr != null) {
            Node next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
    Node compute(Node head) {
        //reverse the linked list
       Node reversedHead = reverseList(head);

        //Remove nodes with lesser values than the maximum seen so far
        Node curr = reversedHead;
        Node maxNode = reversedHead;
        while (curr != null && curr.next != null) {
            if (curr.next.data < maxNode.data) {
                curr.next = curr.next.next; // Remove the node
            } else {
                curr = curr.next;
                maxNode = curr; // Update the maximum node
            }
        }

        //Reverse the list again to restore the original order
        return reverseList(reversedHead);
    }
}