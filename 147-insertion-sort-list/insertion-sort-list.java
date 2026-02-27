class Solution {
    public ListNode insertionSortList(ListNode head) {

        ListNode dummy = new ListNode(0); // sorted list head

        ListNode curr = head;

        while (curr != null) {

            ListNode next = curr.next;

            // find position to insert
            ListNode prev = dummy;

            while (prev.next != null && prev.next.val < curr.val) {
                prev = prev.next;
            }

            // insert curr between prev and prev.next
            curr.next = prev.next;
            prev.next = curr;

            curr = next;
        }

        return dummy.next;
    }
}