class Solution {
    public ListNode rotateRight(ListNode head, int k) {

        // Edge cases
        if (head == null || head.next == null || k == 0) {
            return head;
        }

        // Find length and tail
        int length = 1;
        ListNode tail = head;

        while (tail.next != null) {
            tail = tail.next;
            length++;
        }

        // Reduce k
        k = k % length;
        if (k == 0) {
            return head;
        }

        // Make circular
        tail.next = head;

        // Find new tail: (length - k - 1) steps
        int stepsToNewTail = length - k - 1;
        ListNode newTail = head;

        for (int i = 0; i < stepsToNewTail; i++) {
            newTail = newTail.next;
        }

        // Set new head and break circle
        ListNode newHead = newTail.next;
        newTail.next = null;

        return newHead;
    }
}
