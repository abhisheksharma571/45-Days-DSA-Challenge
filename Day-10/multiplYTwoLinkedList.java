// Given elements as nodes of the two singly linked lists. The task is to multiply these two linked lists, say L1 and L2.

// Note: The output could be large take modulo 10^9+7.


class Solution {
    public static long linkedListToNumber(Node head, int MOD) {
        long num = 0;
        while (head != null) {
            num = (num * 10 + head.data) % MOD;
            head = head.next;
        }
        return num;
    }
    public long multiplyTwoLists(Node first, Node second) {
        int MOD = 1000000007;
        long num1 = linkedListToNumber(first, MOD);
        long num2 = linkedListToNumber(second, MOD);
        return (num1 * num2) % MOD;
    }
}